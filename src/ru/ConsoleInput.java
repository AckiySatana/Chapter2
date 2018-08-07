package ru;
import java.util.*;

public class ConsoleInput implements Input{
    Scanner in = new Scanner(System.in);
    public  String ask(String quest){
        System.out.println(quest);
        return in.nextLine();
    }
}
