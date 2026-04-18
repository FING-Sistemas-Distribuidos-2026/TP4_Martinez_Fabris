import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class RequestClient {
    public static void main(String[] args) {
        String serverIp = args.length > 0 ? args[0] : "127.0.0.1";
        int port = args.length > 1 ? Integer.parseInt(args[1]) : 5555;
        String message = args.length > 2 ? args[2] : "Hello from Java client";

        String endpoint = "tcp://" + serverIp + ":" + port;

        try (ZContext context = new ZContext()) {
            ZMQ.Socket socket = context.createSocket(SocketType.REQ);
            socket.connect(endpoint);

            System.out.println("Connected to " + endpoint);
            System.out.println("Sending: " + message);
            socket.send(message);

            String reply = socket.recvStr();
            System.out.println("Received: " + reply);
        }
    }
}
