package org.shika.ToDoApp;

import org.progcoa.pbjavautils.Console.Console;
import org.shika.ToDoApp.Data.Data;
import org.shika.ToDoApp.Data.TodoData;

public class Main {

    public static Data data;

    public static void main(String[] args) {
        data = new Data("data.yml", Main.class);

        Console.WriteLine("Run Todo App!");

        //**********[Main Method]**********
        String input = Console.ReadLine();

        while (!input.equals("!stop")) {
            if (!"".equals(input)){
                switch (input) {
                    case "list": {
                        for (Object obj : data.getMap().keySet()){
                            String str = (String) obj;

                            Console.WriteLine("[" + str + "] " + "期限: " + data.get(str).getTerm() + " 完了: " + data.get(str).isCompletion());
                        }
                        break;
                    }

                    case "add": {
                        //add
                        Console.WriteLine("新しいTodoを追加します");
                        Console.WriteLine(" ");

                        TodoData todo = new TodoData();

                        Console.WriteLine("名前を入力してください");
                        todo.setDisplayName(Console.ReadLine());

                        Console.WriteLine("このTODOの詳細を入力してください");
                        todo.setDescription(Console.ReadLine());

                        Console.WriteLine("このTODOの期限を入力してください");
                        todo.setTerm(Console.ReadLine());

                        Console.WriteLine("保存します...");

                        data.set(todo.getDisplayName(), todo);
                        break;
                    }

                    case "delete": {
                        //delete
                        Console.WriteLine("削除する項目の名前を入力してください");

                        for (Object obj : data.getMap().keySet()){
                            String str = (String) obj;

                            Console.WriteLine("[" + str + "] " + "詳細: " + data.get(str).getDescription());
                        }

                        String message = Console.ReadLine();
                        if (message == null) return;
                        data.getMap().remove(message);

                        Console.WriteLine(message + "を削除しました");
                        break;
                    }

                    case "complete": {
                        Console.WriteLine("完了した項目を入力してください");
                        for (Object obj : data.getMap().keySet()){
                            String str = (String) obj;

                            Console.WriteLine("[" + str + "] " + "期限: " + data.get(str).getTerm() + " 完了: " + data.get(str).isCompletion());
                        }

                        String message = Console.ReadLine();
                        if (message == null) return;
                        TodoData todo = data.get(message);

                        todo.setCompletion(!todo.isCompletion());

                        Console.WriteLine(message + "を完了させました");
                    }

                    case "edit": {
                        Console.WriteLine("編集する項目を入力してください");
                        for (Object obj : data.getMap().keySet()){
                            String str = (String) obj;

                            Console.WriteLine("[" + str + "] " + "期限: " + data.get(str).getTerm() + " 完了: " + data.get(str).isCompletion());
                        }

                        String message = Console.ReadLine();
                        if (message == null) return;
                        TodoData todo = data.get(message);

                        Console.WriteLine("このTODOの詳細を入力してください");
                        todo.setDescription(Console.ReadLine());

                        Console.WriteLine("このTODOの期限を入力してください");
                        todo.setTerm(Console.ReadLine());

                        Console.WriteLine("保存します...");

                        data.set(todo.getDisplayName(), todo);

                        break;
                    }

                    default: {
                        Console.WriteLine("引数が正しくありません");
                        break;
                    }
                }
            }

            data.Save();
            input = Console.ReadLine();
        }
        //*********************************

        data.Save();
        Console.WriteLine("ShutDown Todo App...");
    }
}
