package server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.security.MessageDigest;

/**
 *
 * Duy Pham 30038701 EchoThread class
 *
 */
public class EchoThread extends Thread {

    private String adminUsername = "JMCadmin";
    private String adminPassword = "nimda";
    private String hashedAdminPassword;

    protected Socket socket;

    public EchoThread(Socket clientSocket) {
        this.socket = clientSocket;
    }

    public void run() {
        InputStream inp = null;
        BufferedReader brinp = null;
        DataOutputStream out = null;
        try {
            inp = socket.getInputStream();
            brinp = new BufferedReader(new InputStreamReader(inp));
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            return;
        }

        try {
            String inLine = brinp.readLine(); // read a line from client
            //spliting input
            String[] input = inLine.split(",");
            //hashing password
            hashedAdminPassword = hashPassword(adminPassword);
            input[1] = hashPassword(input[1]);
            if (input[0].equals(adminUsername) && input[1].equals(hashedAdminPassword)) {
                String outLine = "Welcome Admin!";
                out.writeBytes(outLine); // send a message to client
                out.write(13); // carriage return
                out.write(10); // line feed
                out.flush();
            } else {
                String outLine = "Wrong username or password!";
                out.writeBytes(outLine); // send a message to client
                out.write(13); // carriage return
                out.write(10); // line feed
                out.flush();
            }
        } catch (IOException e) {
            
        }
    }
    
    //standard SHA-256 hash method
    private String hashPassword(String passString) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(passString.getBytes());
            String hashString = new String(hash);
            return hashString;
        } catch (Exception e) {
            System.err.println("Exception occurred" + e);
            return null;
        }
    }

}
