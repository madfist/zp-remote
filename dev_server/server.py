import select
import socket
import sys
import os
import threading

SOCKET_LIST = []
RECV_BUFFER = 4096
PORT = 4769

def get_local_ip():
    return [(s.connect(('8.8.8.8', 53)), s.getsockname()[0], s.close()) for s in [socket.socket(socket.AF_INET, socket.SOCK_DGRAM)]][0][1]

class PositionUpdater(object):
    def __init__(self, pos):
        self.pos = pos
        self.updater = None

    def get(self):
        return self.pos

    def set(self, pos):
        self.pos = pos

    def inc(self):
        self.pos = self.pos + 1000

    def run(self):
        print('pos', self.pos/1000)
        self.updater = threading.Timer(1, self.run)
        self.inc()
        self.updater.start()

    def stop(self):
        self.updater.cancel()

def chat_server(host, port):
    playstate = "0"
    fullscreenstate = "0"
    filename = "Some file.mkv"
    duration = 13245000
    position = PositionUpdater(0)
    stop = False
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    server_socket.bind((host, port))
    server_socket.listen(10)

    SOCKET_LIST.append(server_socket)

    print("Server: %s:%s" % (host, port))

    while not stop:
        ready_to_read,ready_to_write,in_error = select.select(SOCKET_LIST,[],[],0)

        for sock in ready_to_read:
            # a new connection request recieved
            if sock == server_socket:
                sockfd, addr = server_socket.accept()
                SOCKET_LIST.append(sockfd)

                print("[%s:%s] connected" % addr)
                sockfd.send(b'0000 Python ZoomPlayer emulator\r\n0001 1.0\r\n')
                sockfd.send(b'1800 %s\r\n1000 %s\r\n' % (filename.encode('utf-8'), playstate.encode('utf-8')))

            # a message from a client, not a new connection
            else:
                try:
                    data = sock.recv(RECV_BUFFER)
                    if data:
                        data_str = data.decode('utf-8').strip()
                        print("[%s:%s]" % addr, data_str)
                        if data_str == 'server_stop':
                            stop = True
                            break
                        # ZP functions
                        if data_str.startswith(("5100", "5110", "5120", "5130")):
                            sock.send(data)
                            # Play / Pause
                            if 'fnPlay' in data_str:
                                if playstate == "0":
                                    playstate = "3"
                                    sock.send(b'1000 3\r\n')
                                    position.run()
                                else:
                                    playstate = "0"
                                    sock.send(b'1000 0\r\n')
                                    position.stop()
                            # Stop
                            elif 'fnStop' in data_str:
                                playstate = "0"
                                sock.send(b'1000 0\r\n')
                                position.stop()
                                position.set(0)
                            elif 'exSeekTo' in data_str:
                                position.set(int(data_str.split(',')[1])*1000)
                        # Fullscreen
                        elif data_str.startswith('1010'):
                            if fullscreenstate == "0":
                                fullscreenstate = "1"
                                sock.send(b'1010 1\r\n')
                            else:
                                fullscreenstate = "0"
                                sock.send(b'1010 0\r\n')
                        # Filename
                        elif data_str.startswith('1800'):
                            sock.send(b'1800 %s\r\n' % filename)
                        # Duration
                        elif data_str.startswith('1110'):
                            sock.send(b'1110 %i\r\n' % duration)
                        # Position
                        elif data_str.startswith('1120'):
                            sock.send(b'1120 %i\r\n' % position.get())
                        else:
                            broadcast(server_socket, sock, data)
                    else:
                        if sock in SOCKET_LIST:
                            SOCKET_LIST.remove(sock)

                        print("[%s:%s] (no data) disconnected" % addr)

                except Exception as e:
                    print("[%s:%s] disconnected" % addr, str(e))
                    continue

    server_socket.close()

# broadcast chat messages to all connected clients
def broadcast (server_socket, sock, message):
    for socket in SOCKET_LIST:
        # send the message only to peer
        if socket != server_socket and socket != sock :
            try :
                socket.send(message)
            except :
                # broken socket connection
                socket.close()
                # broken socket, remove it
                if socket in SOCKET_LIST:
                    SOCKET_LIST.remove(socket)

def main():
    if len(sys.argv) > 1:
        port = int(sys.argv[1])
    else:
        port = PORT
    sys.exit(chat_server(get_local_ip(), port))

if __name__ == '__main__':
    main()