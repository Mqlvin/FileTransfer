package me.henry.transfer;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        File save = new File(System.getProperty("user.dir"));
        System.out.println(save);
        System.out.println(save.getParent() + save);
    }
}
