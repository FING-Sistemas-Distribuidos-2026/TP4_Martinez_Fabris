# TP4_Martinez_Fabris

Request-Reply with ZeroMQ:
- Server in Python (REP)
- Client in Java (REQ)

## Python server

```bash
cd /home/runner/work/TP4_Martinez_Fabris/TP4_Martinez_Fabris/server
python3 -m pip install -r requirements.txt
python3 server.py --bind-ip 0.0.0.0 --port 5555
```

## Java client

```bash
cd /home/runner/work/TP4_Martinez_Fabris/TP4_Martinez_Fabris/client
mvn -q compile
mvn -q exec:java -Dexec.args="<SERVER_IP> 5555 \"Hello from Java client\""
```

Replace `<SERVER_IP>` with the machine IP where the Python server is running.
