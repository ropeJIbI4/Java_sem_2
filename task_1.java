// Реализуйте алгоритм сортировки пузырьком числового массива,
// результат после каждой итерации запишите в лог-файл.

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task_1 {
    public static void bubleSorted(int[] arr) {
        for (int i = arr.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    logger.log(Level.INFO, "Элемент " + arr[j] + " переносим с позиции " + j + " на позицию " + (j +1));
                    int temp = arr[j];
                    arr[j] = arr[j +1];
                    arr[j +1] = temp;
                }
            }
        }

    }
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    static Logger logger = Logger.getLogger(task_1.class.getName());
    
    
    public static void main(String[] args) {
        try {
        String pathProject = System.getProperty("user.dir");
        String pathFail = pathProject.concat("/SEM 2/task_1.log");
        
        Handler fileHandler = new FileHandler(pathFail, true);
        SimpleFormatter sFormat = new SimpleFormatter();
        fileHandler.setFormatter(sFormat);
        logger.addHandler(fileHandler);
        } catch (SecurityException | IOException e) {
            System.out.print("Error");
        }

        int[] data = { 6, 8, 3, 123, 5, 4, 1, 9 };
        bubleSorted(data);
        printArr(data);
    }
   
}
