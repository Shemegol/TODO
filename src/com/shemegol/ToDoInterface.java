package com.shemegol;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ToDoInterface {

    private static Scanner scanner = new Scanner(System.in).useDelimiter("[\r\n]+");
    private static SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    private static StorageOfTasks storageOfTasks = new StorageOfTasks();


    public static void main(String[] args) {
        format.setLenient(false);
        System.out.println("***********************\n" +
                "**Список задач v.a.01**\n" +
                "***********************\n");
        StorageOfTasks storageOfTasks = new StorageOfTasks();
        storageOfTasks.addTask(new Task("Первая задача"));
        printTasks();
        label:
        while (true) {
            System.out.println("Введите команду:");
            String command = scanner.nextLine();
            switch (command) {
                case "add":
                    System.out.println("Введите описание задачи:");
                    storageOfTasks.addTask(new Task(scanner.nextLine()));
                    System.out.println("Задача добавлена\n");
                    break;
                case "finish":
                    finishTask();
                    break;
                case "show":
                    printTasks();
                    break;
                case "help":
                    printCommands();
                    break;
                case "exit":
                    break label;
                default:
                    System.out.println("\"help\" - Вывести список команд");
                    break;
            }
        }
        scanner.close();
        System.out.println("Выход");
    }

    private static void printTasks() {
        if (storageOfTasks.getSize() == 0) {
            System.out.println("У Вас нет текущих задач");
        } else {
            System.out.println("Вашы задачи:");
            for (int i = 0; i < storageOfTasks.getSize(); i++) {
                int n = i + 1;
                System.out.println(n + ". " + storageOfTasks.getTask(i).toString());
            }
        }
        System.out.println("");
    }

    private static void printCommands() {
        System.out.println("Список команд:");
        System.out.println("\"show\" - Показать текущие задачи");
        System.out.println("\"add\" - Добавить новую задачу");
        //System.out.println("\"addd\" - Добавить новую задачу с датой выполнения");
        System.out.println("\"finish\" - Завершить задачу задачу");
        System.out.println("\"help\" - Вывести список команд");
        System.out.println("\"exit\" - Выход из программы\n");
    }

    private static void finishTask() {
        if (storageOfTasks.getSize() == 0) {
            System.out.println("У Вас нет текущих задач\n");
        } else {
            System.out.println("Введите номер задачи для завешения");
            try {
                String n = scanner.nextLine();
                System.out.println("Задача \"" + storageOfTasks.getTask(Integer.parseInt(n) - 1) + "\" завершена\n");
                storageOfTasks.removeTask(Integer.parseInt(n) - 1);
            } catch (NumberFormatException nfe) {
                System.out.println("Ошибка ввода номера задачи\n");
            } catch (IndexOutOfBoundsException iobe) {
                System.out.println("Задачи с таким номером не существует\n");
            }
        }
    }
}

