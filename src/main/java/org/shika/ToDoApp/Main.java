package org.shika.ToDoApp;

import org.progcoa.pbjavautils.Console.Console;
import org.progcoa.pbjavautils.Data.Files.YamlObject;

public class Main {

    public static YamlObject data;

    public static void main(String[] args) {
        data = new YamlObject("data.yml", Main.class);

        Console.WriteLine("Run Todo App!");

        //**********[Main Method]**********


        //*********************************

        Console.WriteLine("ShutDown Todo App...");
        data.Save();
    }
}
