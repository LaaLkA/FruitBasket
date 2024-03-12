package core;

import java.io.IOException;
import java.util.Scanner;

public class UserView {
    static DataOperations dataOperations = new DataOperations();
    static FileProcessor fileOperations = new FileProcessor("input.txt");

    public static void menu() throws IOException {
        while (true) {

            String[] data = fileOperations.read();

            System.out.println("Меню\n" +
                    "1 - Посмотреть слова в файле;\n" +
                    "2 - Показать количество слов в файле:\n" +
                    "3 - Показать самое длинное слово;\n" +
                    "4 - Показать самое частовстречаемое слово;\n" +
                    "5 - Добавить слово;\n" +
                    "0 - Выход.");
            int action = Integer.parseInt(prompt("Выберите нужный пунтк\n" +
                    "(Введите цифру, которая соответсует пункту)"));

            if (action == 0) {
                System.out.println("Программа завершена");
                break;
            }

            switch (action) {
                case 1:
                    dataOperations.dataView(data);
                    break;
                case 2:
                    dataOperations.totalNumberOfWords(data);
                    break;
                case 3:
                    dataOperations.LongestWord(data);
                    break;
                case 4:
                    dataOperations.mostRepeatedWord(data);
                    break;
                case 5:
                    String newWord = prompt("Введите слово для добавление: ");
                    fileOperations.write(dataOperations.addWord(data, newWord));
                    break;
                default:
                    System.err.println("Неверно выбран пункт!");
                    break;
            }
        }

    }

    public static String prompt(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
