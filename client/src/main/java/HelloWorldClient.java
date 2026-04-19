import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class HelloWorldClient {
    public static void main(String[] args) {
        try (ZContext context = new ZContext()) {

            // Socket to talk to clients
            ZMQ.Socket socket = context.createSocket(SocketType.REQ);

            socket.connect("tcp://10.66.0.118:5555");

            while (!Thread.currentThread().isInterrupted()) {

                // Send a response
                String response = "Hello";
                socket.send(response.getBytes(ZMQ.CHARSET), 0);

                // Block until a message is received
                byte[] reply = socket.recv(0);

                // Print the message
                System.out.println("Received: " + new String(reply, ZMQ.CHARSET));

            }
        }
    }
}
