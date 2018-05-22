import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * The main class of the program.
 * @author Jacob Salzberg
 */
public class HelloTcpCli {
    /**
     * Address
     */
    public static final String ADDRESS = "127.0.0.1";

    /**
     * Port #
     */
    public static final int PORT = 4006;

    /**
     * The message
     */
    public static final String SEND = "CLIENT";

    /**
     * The entry point of the program.
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Bonjour serveur, je prends un cafe.");
        Socket s = new Socket(ADDRESS, PORT);

        // Sending data
        OutputStream os = s.getOutputStream();
        PrintWriter pw = new PrintWriter(os, true);

        // Receiving data
        InputStream is = s.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String receive = "Message not received";

        while (true) {
            // Sending
            pw.println(SEND);
            pw.flush();

            // Receiving
            String maybeNull = br.readLine();
            receive = (maybeNull == null) ? "Message not received" : maybeNull;
            System.out.println(receive);
        }
    }
}
