// Дана json строка (сохранить в файл и читать из файла) 
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
// {"фамилия":"Петрова", "оценка":"4","предмет":"Информатика"},
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class task_4 {
    static void calc(int num_1, int num_2, String sign) {
        switch (sign) {
            case ("+"):
                System.out.printf("%d + %d = %d", num_1, num_2, num_1 + num_2);
                logger.log(Level.INFO, "Результат операции: " + (num_1 + num_2));
                break;
            case ("-"):
                System.out.printf("%d - %d = %d", num_1, num_2, num_1 - num_2);
                logger.log(Level.INFO, "Результат операции: " + (num_1 - num_2));
                break;
            case ("*"):
                System.out.printf("%d * %d = %d", num_1, num_2, num_1 * num_2);
                logger.log(Level.INFO, "Результат операции: " + (num_1 * num_2));
                break;
            case ("/"):
                if (num_2 == 0) {
                    System.out.println("Ошибка!");
                    break;
                }
                float a = num_1;
                float b = num_2;
                // Double res = (Double)num_1 / (Double)num_2;
                System.out.printf("%.1f / %.1f = %.2f", a, b, a / b);
                logger.log(Level.INFO, "Результат операции: " + (a / b));
                break;

        }
    }

    static Logger logger = Logger.getLogger(task_4.class.getName());

    public static void main(String[] args) {

        try {
            String pathProject = System.getProperty("user.dir");
            String pathFail = pathProject.concat("/homework_2/task_4.log");

            Handler fileHandler = new FileHandler(pathFail, true);
            SimpleFormatter sFormat = new SimpleFormatter();
            fileHandler.setFormatter(sFormat);
            logger.addHandler(fileHandler);
        } catch (SecurityException | IOException e) {
            logger.log(Level.WARNING, "Exception: ", e);
        }

        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int a = iScanner.nextInt();
        logger.log(Level.INFO, "Ввод первого числа " + a);
        System.out.print(
        "Введите + для сложения\nВведите - для вычитания\nВведите * для умножения\nВведите / для деления\n");
        String choice = iScanner.next();
        logger.log(Level.INFO, "Ввод операции " + choice);
        System.out.println("Введите второе число: ");
        int b = iScanner.nextInt();
        logger.log(Level.INFO, "Ввод второго числа " + b);
        iScanner.close();
        calc(a, b, choice);

    }
}
