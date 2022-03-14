package me.henry.transfer;

import java.io.File;

public class TransferController {
    public static void main(String[] args) {
        if(!(args.length == 3 && args[0].equalsIgnoreCase("send")) || !(args.length == 2 && args[0].equalsIgnoreCase("receive"))) {
            System.out.println("Incorrect program arguments.");
            System.exit(5);
        }
        if(args[0].equalsIgnoreCase("send")) { // args [action, file location, ip]
            Client.send(args[2], new File(args[1]));
        } else if(args[0].equalsIgnoreCase("receive")) { // args [action, file location]
            Server.receive(new File(args[1]));
        }
    }
}
