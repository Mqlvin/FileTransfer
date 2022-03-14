package me.henry.transfer;

import java.io.*;
import java.net.Socket;

public class Client {
    private static DataOutputStream output = null;
    private static DataInputStream input = null;

    public static void send(String ip, File file) {
        try(Socket socket = new Socket(ip, 4049)) {
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

            int bytes;
            FileInputStream fis = new FileInputStream(file);
            output.writeLong(file.length());

            byte[] buffer = new byte[4096];
            while((bytes = fis.read(buffer)) != -1) {
                output.write(buffer, 0, bytes);
                output.flush();
            }
            fis.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
