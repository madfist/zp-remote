import socketserver
import sys
import os

HOST, PORT = "localhost", 4769

class ZpRequestHandler(socketserver.StreamRequestHandler):
    def handle(self):
        self.data = self.rfile.readline().strip()
        self.wfile.write(self.data)

def main():
    print('Echo server')
    server = socketserver.TCPServer((HOST, PORT), ZpRequestHandler)
    server.serve_forever()

if __name__ == '__main__':
    main()