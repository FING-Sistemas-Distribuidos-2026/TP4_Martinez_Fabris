#!/usr/bin/env python3
import argparse

import zmq


def main() -> None:
    parser = argparse.ArgumentParser(description="ZeroMQ REP server")
    parser.add_argument("--bind-ip", default="0.0.0.0", help="IP address to bind")
    parser.add_argument("--port", type=int, default=5555, help="Port to bind")
    args = parser.parse_args()

    context = zmq.Context()
    socket = context.socket(zmq.REP)
    endpoint = f"tcp://{args.bind_ip}:{args.port}"
    socket.bind(endpoint)

    print(f"Server listening on {endpoint}")
    try:
        while True:
            message = socket.recv_string()
            print(f"Received: {message}")
            socket.send_string(f"Reply from Python server: {message}")
    except KeyboardInterrupt:
        print("Shutting down server")
    finally:
        socket.close(0)
        context.term()


if __name__ == "__main__":
    main()
