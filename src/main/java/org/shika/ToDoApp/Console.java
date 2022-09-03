package org.shika.ToDoApp;

import java.util.Scanner;

public class Console {

    public static void WriteLine(Object message){
        System.out.println(message);
    }

    public static String ReadLine(){
        return new Scanner(System.in).nextLine();
    }
}
