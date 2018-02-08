package ru.academit.maslenkin.csv;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Александр on 03.02.2018.
 */

public class Main {
    private static void replaceTag(char character, PrintWriter printWriter) {
        switch (character) {
            case '<':
                printWriter.print("&lt;");
                break;
            case '>':
                printWriter.print("&gt;");
                break;
            case '&':
                printWriter.print("&amp;");
                break;
            default:
                printWriter.print(character);
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 2) {
            System.out.println("Должно быть два аргумента: входной файл и файл с результатом");
            return;
        }
        try (PrintWriter printWriter = new PrintWriter(args[1]);
             Scanner scanner = new Scanner(new FileInputStream(args[0]))) {
            //noinspection SpellCheckingInspection
            printWriter.println("<!DOCTYPE html>");
            printWriter.println("<html lang=\"ru-RU\">");
            printWriter.println("<head>");
            printWriter.println("<meta charset=\"UTF-8\">");
            printWriter.print("<title> CSV </title>");
            printWriter.println("</head>");
            printWriter.println("<body>");
            printWriter.println("<p> Результирующая таблица </p> ");
            //noinspection SpellCheckingInspection
            printWriter.println("<table border=\"1\" cellspacing=\"0\" align=\"left\">");
            while (scanner.hasNextLine()) {
                printWriter.print("<tr>");
                printWriter.print("<td>");
                String string = scanner.nextLine();
                for (int i = 0; i < string.length(); i++) {
                    char character = string.charAt(i);
                    if (character == '"') {
                        boolean isQuotes = true;
                        ++i;
                        while (isQuotes) {
                            if (i == string.length() - 1) {
                                printWriter.print("</td></tr>");
                                isQuotes = false;
                            } else if (string.charAt(i) == '"' && string.charAt(i + 1) == '"') {
                                printWriter.print(string.charAt(i + 1));
                                i = i + 2;
                            } else if (string.charAt(i) != '"') {
                                while (string.charAt(i) != '"') {
                                    replaceTag(string.charAt(i), printWriter);
                                    ++i;
                                    if (i == string.length()) {
                                        printWriter.print("<br/>");
                                        string = scanner.nextLine();
                                        i = 0;
                                    }
                                }
                            } else {
                                isQuotes = false;
                            }
                        }
                    } else if (character == ',') {
                        printWriter.print("</td><td>");
                        if (i == string.length() - 1) {
                            printWriter.print("</td></tr>");
                        }
                    } else {
                        while (string.charAt(i) != ',') {
                            replaceTag(string.charAt(i), printWriter);
                            if (i == string.length() - 1) {
                                printWriter.print("</td></tr>");
                                break;
                            } else if (string.charAt(i + 1) == ',' && i != string.length() - 1) {
                                break;
                            }
                            ++i;
                        }
                    }
                }
            }
            printWriter.println("</table>");
            printWriter.println("</body>");
            printWriter.println("</html>");
        }
    }
}



