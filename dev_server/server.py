import socketserver
import socket
import sys
import os

PORT = 4769

class ZpRequestHandler(socketserver.StreamRequestHandler):
    def setup(self):
        print('start')
        self.listening = True
        socketserver.StreamRequestHandler.setup(self)
    def handle(self):
        while self.rfile.readable():
            self.data = self.rfile.readline().strip()
            if len(self.data) == 0:
                break;
            print(self.data)
            self.wfile.write(self.data)
    def finish(self):
        socketserver.StreamRequestHandler.finish(self)
        print('exit')
        self.listening = False


def get_local_ip():
    return [(s.connect(('8.8.8.8', 53)), s.getsockname()[0], s.close()) for s in [socket.socket(socket.AF_INET, socket.SOCK_DGRAM)]][0][1]

def main():
    print('Echo server')
    if len(sys.argv) > 1:
        port = int(sys.argv[1])
    else:
        port = PORT
    server = socketserver.TCPServer((get_local_ip(), port), ZpRequestHandler)
    server.serve_forever()
    server.server_close()

if __name__ == '__main__':
    main()