import java.util.Scanner;
public class Main {

    public static int[][] sozdanieLabirinta(){
        System.out.println("Выберите способ ввода лабиринта:");
        System.out.println("1) Рандомный; 2) Настраиваемый");
        int vibor;
        Scanner scanner = new Scanner(System.in);
        vibor = scanner.nextInt();
        int mSizeCol = 0;
        int mSizeRow = 0;
        if(vibor == 1){
            int min = 5;
            int max = 40;
            mSizeCol = (int) (Math.random() * (max - min + 1) + min);
            mSizeRow = (int) (Math.random() * (max - min + 1) + min);

        } else if (vibor == 2) {
            System.out.print("Введите колонны - ");
            mSizeCol = scanner.nextInt();
            System.out.print("Введите строки - ");
            mSizeRow = scanner.nextInt();

        } else {


        }
        int[][] labirint = new int[mSizeCol][mSizeRow];
        System.out.println(labirint.length + " " + labirint[0].length);
        return labirint;
    }

    public static int[][] initialization(){
        int[][] initializationArray = sozdanieLabirinta();

        int lenght = initializationArray.length;
        int lenght2 = initializationArray[0].length;

        for(int i = 0; i < lenght; i++){
            for(int k = 0; k < lenght2; k++){
                initializationArray[i][k] = 1;
                System.out.print(initializationArray[i][k] + " ");
            }
            System.out.println("");
        }
        for(int i = 0; i < lenght2; i++){
            initializationArray[0][i] = 0;
            for(int k = 0; k < lenght; k++){
                initializationArray[k][lenght2 - 1] = 0;
            }
        }
        System.out.println("==========================");
        return initializationArray;

    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[][] endArray = initialization();
        int pers = 5;
        int moveX = 0;
        int moveY = 0;
        char wasd;

        System.out.println("Выберите способ прохождения лабиринта: авто/самостоятельно");
        int viborAvtoManual = scanner.nextInt();
        for(int i = 0; i < endArray.length; i++){
            for(int k = 0; k < endArray[0].length; k++){
                System.out.print(endArray[i][k] + " ");
            }
            System.out.println("");
        }
        if(viborAvtoManual == 1){
            while (endArray[endArray.length - 1][endArray[0].length - 1] != pers) {

                for (int i = 0; i < endArray.length; i++) {
                    for (int k = 0; k < endArray[0].length; k++) {
                        System.out.print(endArray[i][k] + " ");
                    }
                    System.out.println("");
                }

                if (moveX + 1 > endArray[0].length - 1 || endArray[moveY][moveX + 1] == 1) {
                    if (moveY + 1 > endArray.length || endArray[moveY + 1][moveX] == 1) {
                        if (moveX - 1 < 0 || endArray[moveY][moveX - 1] == 1) {
                            if (moveY - 1 < 0 || endArray[moveY - 1][moveX - 1] == 1) {

                            } else {
                                endArray[moveY][moveX] = 0;
                                moveY = moveY - 1;
                                endArray[moveY][moveX] = pers;
                                continue;
                            }
                        } else {
                            endArray[moveY][moveX] = 0;
                            moveX = moveX - 1;
                            endArray[moveY][moveX] = pers;
                            continue;
                        }
                    } else {
                        endArray[moveY][moveX] = 0;
                        moveY = moveY + 1;
                        endArray[moveY][moveX] = pers;
                        continue;
                    }
                } else {
                    endArray[moveY][moveX] = 0;
                    moveX = moveX + 1;
                    endArray[moveY][moveX] = pers;
                    continue;
                }

            }

        } else if(viborAvtoManual == 2) {
            while (endArray[endArray.length - 1][endArray[0].length - 1] != pers) {
                wasd = scanner.next().charAt(0);

                switch (wasd) {
                    case 'a': {
                        if (moveX - 1 < 0 || endArray[moveY][moveX - 1] == 1) {
                            System.out.println("Тут стена");
                            break;
                        } else {
                            endArray[moveY][moveX] = 0;
                            moveX = moveX - 1;
                            break;
                        }
                    }
                    case 's': {
                        if (moveY + 1 > endArray.length || endArray[moveY + 1][moveX] == 1) {
                            System.out.println("Тут стена");
                            break;
                        } else {
                            endArray[moveY][moveX] = 0;
                            moveY = moveY + 1;
                            break;
                        }
                    }
                    case 'd': {
                        if (moveX + 1 > endArray[0].length - 1 || endArray[moveY][moveX + 1] == 1) {
                            System.out.println("Тут стена");
                            break;
                        } else {
                            endArray[moveY][moveX] = 0;
                            moveX = moveX + 1;
                            break;
                        }
                    }
                    case 'w': {
                        if (moveY - 1 < 0 || endArray[moveY - 1][moveX - 1] == 1) {
                            System.out.println("Тут стена");
                            break;
                        } else {
                            endArray[moveY][moveX] = 0;
                            moveY = moveY - 1;
                            break;
                        }
                    }
                }
                endArray[moveY][moveX] = pers;
                for (int i = 0; i < endArray.length; i++) {
                    for (int k = 0; k < endArray[0].length; k++) {
                        System.out.print(endArray[i][k] + " ");
                    }
                    System.out.println("");
                }

            }
        }

        System.out.println("Ты прошел лабиринт!");
        System.out.println("-->");
        for (int i = 0; i < endArray.length; i++) {
            for (int k = 0; k < endArray[0].length; k++) {
                System.out.print(endArray[i][k] + " ");
            }
            System.out.println("");
        }

    }
}