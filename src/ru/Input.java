package ru;
import java.util.Scanner;

public class Input {
    public String ask(String st){
        System.out.println(st);
        Scanner in = new Scanner(System.in);
        return in.next();

    }
}
