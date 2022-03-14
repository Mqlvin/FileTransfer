package me.henry.transfer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static DataOutputStream output = null;
    private static DataInputStream input = null;

    public static void receive(File file) {
        try(ServerSocket serverSocket = new ServerSocket(4049)) {
            System.out.println("Listening to port: 4049");
            Socket client = serverSocket.accept();

            input = new DataInputStream(client.getInputStream());
            output = new DataOutputStream(client.getOutputStream());

            int bytes = 0;

            File save = new File(new File(System.getProperty("user.dir")) + "/" + file.getName());
            FileOutputStream fos = new FileOutputStream(file.getName());

            long size = input.readLong();
            byte[] buffer = new byte[4096];

            while(size > 0 && (bytes = input.read(buffer, 0, (int) Math.min(buffer.length, size))) != -1) {
                fos.write(buffer, 0, bytes);
                size -= bytes;
            }

            fos.close();

            save.renameTo(new File(file.getPath()));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
