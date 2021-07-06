package Pervii;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Task20_2new {
    public static void main(String[] args) {
        printShips1();
    }
    public static void checkIfItsNumber(String[] lineSplit1, String[] lineSplit2, String[] lineSplit3, String[] lineSplit4, int x) {
        if (x == 4) {
            Integer.parseInt(lineSplit1[0]);
            Integer.parseInt(lineSplit1[1]);
            Integer.parseInt(lineSplit2[0]);
            Integer.parseInt(lineSplit2[1]);
            Integer.parseInt(lineSplit3[0]);
            Integer.parseInt(lineSplit3[1]);
            Integer.parseInt(lineSplit4[0]);
            Integer.parseInt(lineSplit4[1]);
        }
        if (x == 3) {
            Integer.parseInt(lineSplit1[0]);
            Integer.parseInt(lineSplit1[1]);
            Integer.parseInt(lineSplit2[0]);
            Integer.parseInt(lineSplit2[1]);
            Integer.parseInt(lineSplit3[0]);
            Integer.parseInt(lineSplit3[1]);
        }
        if (x == 2) {
            Integer.parseInt(lineSplit1[0]);
            Integer.parseInt(lineSplit1[1]);
            Integer.parseInt(lineSplit2[0]);
            Integer.parseInt(lineSplit2[1]);
        }
        if (x == 1) {
            Integer.parseInt(lineSplit1[0]);
            Integer.parseInt(lineSplit1[1]);
        }
    }
    public static void printShips1() {
        int q1 = 1;
        int w1;

        //----режим ввода кораблей----
        /*while (true) {
            System.out.println("Введи 1 чтобы АВТО,\nВведи 0 чтобы РУЧНОЙ:");
            Scanner scanner1 = new Scanner(System.in);
            try {
                q1 = scanner1.nextInt();
                if (q1 != 1 && q1 != 0)
                    throw new InputMismatchException();
                break;
            } catch (InputMismatchException e){
                System.out.println("Неверный ввод!");
                continue;
            }
        }*/


        //----первый игрок----
        w1 = 1;
        Field01 field01 = new Field01();
        if (true) {
            //----Четырехпалубный 4.1----
            if (true) {

                //----Печатаем текст для Четырухпалубного(+начало)----------------
                if (true) {
                    System.out.println();
                    System.out.println();
                    System.out.println("*********(Начало игры!)*********");
                    System.out.println("*********(Player 1!)*********\n");
                    System.out.println("Начнем расставлять корабли на поле PLAYER 1. Другой игрок не смотрит!");
                    System.out.println("Введите координаты первого Четырехпалубного корабля, где i-строка и j-столбец: \n(формат: i,j; i,j; i,j; i,j)");
                    field01.polePrint();
                }

                //----первый Четырехпалубный--------------------------------------
                while (true) {

                    //----сканирую и превращаю в коорд.-------------------------------
                    File file4 = new File("src/Pervii/helper4");
                    File fil4 = new File("src/Pervii/helpe4");
                    try {
                        Scanner scanner = null;
                        if (q1 == 1) {
                            if (w1 == 1) {
                                scanner = new Scanner(file4);
                            }
                            if (w1 == 2) {
                                scanner = new Scanner(fil4);
                            }
                        } else {
                            scanner = new Scanner(System.in);
                        }
                        String numInserted = scanner.nextLine();
                        String[] linesToSplit = numInserted.split(";");

                        //проверяю на соответствие кол. координат-------------------------
                        if (linesToSplit.length == 4) {

                            //разделяю на запятые---------------------------------------------
                            String[] coordinate1 = linesToSplit[0].split(",");
                            String[] coordinate2 = linesToSplit[1].split(",");
                            String[] coordinate3 = linesToSplit[2].split(",");
                            String[] coordinate4 = linesToSplit[3].split(",");

                            //проверяю если это вoобще числа----------------------------------
                            try {
                                checkIfItsNumber(coordinate1, coordinate2, coordinate3, coordinate4, 4);
                            } catch (NumberFormatException e) {
                                System.out.println("Невенрый ввод, несоответствующий числам");
                                continue;
                            }

                            //заменяю на нормальные переменные-------------------------------
                            int co1i = Integer.parseInt(coordinate1[0]);
                            int co1j = Integer.parseInt(coordinate1[1]);
                            int co2i = Integer.parseInt(coordinate2[0]);
                            int co2j = Integer.parseInt(coordinate2[1]);
                            int co3i = Integer.parseInt(coordinate3[0]);
                            int co3j = Integer.parseInt(coordinate3[1]);
                            int co4i = Integer.parseInt(coordinate4[0]);
                            int co4j = Integer.parseInt(coordinate4[1]);

                            //проверка на равномерность--------------------------------------
                            try {
                                if (
                                        ((co1i == co2i && co1i == co3i && co1i == co4i) &&
                                                (co2j < co1j && co2j != co1j - 1) ||
                                                (co2j > co1j && co2j != co1j + 1) ||

                                                (co3j < co2j && co3j != co2j - 1) ||
                                                (co3j > co2j && co3j != co2j + 1) ||

                                                (co4j < co3j && co4j != co3j - 1) ||
                                                (co4j > co3j && co4j != co3j + 1)
                                        ) ||

                                        ((co1j == co2j && co1j == co3j && co1j == co4j) &&
                                                (co2i < co1i && co2i != co1i - 1) ||
                                                (co2i > co1i && co2i != co1i + 1) ||

                                                (co3i < co2i && co3i != co2i - 1) ||
                                                (co3i > co2i && co3i != co2i + 1) ||

                                                (co4i < co3i && co4i != co3i - 1) ||
                                                (co4i > co3i && co4i != co3i + 1)
                                        ) ||

                                        !(co1i == co2i && co1i == co3i && co1i == co4i) &&
                                        !(co1j == co2j && co1j == co3j && co1j == co4j)
                                ) {
                                    throw new IOException();
                                }
                            } catch (IOException e) {
                                System.out.println("Корабль не соответствует привилам последовательного размещения палуб");
                                continue;
                            }

                            //рисую первый корабль в POlE и TWODEKS--------------------------
                            if (field01.checkPole(co1i, co1j) && field01.checkPole(co2i, co2j) &&
                                    field01.checkPole(co3i, co3j) && field01.checkPole(co4i, co4j)) {

                                //рисуем корабли в "pole"
                                field01.setPoleXY_pole(co1i, co1j);
                                field01.setPoleXY_pole(co2i, co2j);
                                field01.setPoleXY_pole(co3i, co3j);
                                field01.setPoleXY_pole(co4i, co4j);


                                //рисуем ориол в "twodecks"
                                field01.setOriolXY_twodecks(co1i, co1j);
                                field01.setOriolXY_twodecks(co2i, co2j);
                                field01.setOriolXY_twodecks(co3i, co3j);
                                field01.setOriolXY_twodecks(co4i, co4j);
                                //рисуем поле в "twodecks"
                                field01.setPoleXY_twodecks(co1i, co1j);
                                field01.setPoleXY_twodecks(co2i, co2j);
                                field01.setPoleXY_twodecks(co3i, co3j);
                                field01.setPoleXY_twodecks(co4i, co4j);

                                break;
                            } else {
                                System.out.println("Вы пытаетесь разместить корабль на месте уже существующего");
                                continue;
                            }
                        } else {
                            System.out.println("Вы превысили допустимое, либо уменьшили колличество палуб, во время ввода");
                            continue;
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("блок континуе");
                        continue;
                    }
                }
            }


            //----Трехпалубный 3.1-------
            if (true) {

                //----Печатаем текст для Трехпалубного(+начало)-------------------
                if (true) {
                    System.out.println();
                    System.out.println("Введите координаты первого Трехпалубного корабля, где i-строка и j-столбец: \n(формат: i,j; i,j; i,j)");
                    field01.polePrint();
                }

                //----первый Трехпалубный-----------------------------------------
                while (true) {

                    //----сканирую и превращаю в коорд.-------------------------------
                    File file3_1 = new File("src/Pervii/helper3_1");
                    File fil3_1 = new File("src/Pervii/helpe3_1");
                    try {
                        Scanner scanner = null;
                        if (q1 == 1) {
                            if (w1 == 1) {
                                scanner = new Scanner(file3_1);
                            }
                            if (w1 == 2) {
                                scanner = new Scanner(fil3_1);
                            }
                        } else {
                            scanner = new Scanner(System.in);
                        }
                        String numInserted = scanner.nextLine();
                        String[] linesToSplit = numInserted.split(";");

                        //проверяю на соответствие кол. координат-------------------------
                        if (linesToSplit.length == 3) {

                            //разделяю на запятые---------------------------------------------
                            String[] coordinate1 = linesToSplit[0].split(",");
                            String[] coordinate2 = linesToSplit[1].split(",");
                            String[] coordinate3 = linesToSplit[2].split(",");

                            //проверяю если это вoобще числа----------------------------------
                            try {
                                checkIfItsNumber(coordinate1, coordinate2, coordinate3, coordinate3, 3);
                            } catch (NumberFormatException e) {
                                System.out.println("Невенрый ввод, несоответствующий числам");
                                continue;
                            }

                            //заменяю на нормальные переменные-------------------------------
                            int co1i = Integer.parseInt(coordinate1[0]);
                            int co1j = Integer.parseInt(coordinate1[1]);
                            int co2i = Integer.parseInt(coordinate2[0]);
                            int co2j = Integer.parseInt(coordinate2[1]);
                            int co3i = Integer.parseInt(coordinate3[0]);
                            int co3j = Integer.parseInt(coordinate3[1]);

                            //проверка на равномерность--------------------------------------
                            try {
                                if (
                                        ((co1i == co2i && co1i == co3i) &&
                                                (co2j < co1j && co2j != co1j - 1) ||
                                                (co2j > co1j && co2j != co1j + 1) ||

                                                (co3j < co2j && co3j != co2j - 1) ||
                                                (co3j > co2j && co3j != co2j + 1)
                                        ) ||

                                        ((co1j == co2j && co1j == co3j) &&
                                                (co2i < co1i && co2i != co1i - 1) ||
                                                (co2i > co1i && co2i != co1i + 1) ||

                                                (co3i < co2i && co3i != co2i - 1) ||
                                                (co3i > co2i && co3i != co2i + 1)
                                        ) ||

                                        !(co1i == co2i && co1i == co3i) &&
                                        !(co1j == co2j && co1j == co3j)
                                ) {
                                    throw new IOException();
                                }
                            } catch (IOException e) {
                                System.out.println("Корабль не соответствует привилам последовательного размещения палуб");
                                continue;
                            }

                            //рисую первый корабль в POlE и TWODEKS--------------------------
                            if (field01.checkPole(co1i, co1j) && field01.checkPole(co2i, co2j) &&
                                    field01.checkPole(co3i, co3j)) {

                                //рисуем корабли в "pole"
                                field01.setPoleXY_pole(co1i, co1j);
                                field01.setPoleXY_pole(co2i, co2j);
                                field01.setPoleXY_pole(co3i, co3j);


                                //рисуем ориол в "twodecks"
                                field01.setOriolXY_twodecks(co1i, co1j);
                                field01.setOriolXY_twodecks(co2i, co2j);
                                field01.setOriolXY_twodecks(co3i, co3j);
                                //рисуем поле в "twodecks"
                                field01.setPoleXY_twodecks(co1i, co1j);
                                field01.setPoleXY_twodecks(co2i, co2j);
                                field01.setPoleXY_twodecks(co3i, co3j);

                                break;
                            } else {
                                System.out.println("Вы пытаетесь разместить корабль на месте уже существующего");
                                continue;
                            }
                        } else {
                            System.out.println("Вы превысили допустимое, либо уменьшили колличество палуб, во время ввода");
                            continue;
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("блок континуе");
                        continue;
                    }
                }
            }

            //----Трехпалубный 3.2-------
            if (true) {

                //----Печатаем текст для Трехпалубного(+начало)-------------------
                if (true) {
                    System.out.println();
                    System.out.println("Введите координаты второго Трехпалубного корабля, где i-строка и j-столбец: \n(формат: i,j; i,j; i,j)");
                    field01.polePrint();
                }

                //----второй Трехпалубный-----------------------------------------
                while (true) {

                    //----сканирую и превращаю в коорд.-------------------------------
                    File file3_2 = new File("src/Pervii/helper3_2");
                    File fil3_2 = new File("src/Pervii/helpe3_2");
                    try {
                        Scanner scanner = null;
                        if (q1 == 1) {
                            if (w1 == 1) {
                                scanner = new Scanner(file3_2);
                            }
                            if (w1 == 2) {
                                scanner = new Scanner(fil3_2);
                            }
                        } else {
                            scanner = new Scanner(System.in);
                        }
                        String numInserted = scanner.nextLine();
                        String[] linesToSplit = numInserted.split(";");

                        //проверяю на соответствие кол. координат-------------------------
                        if (linesToSplit.length == 3) {

                            //разделяю на запятые---------------------------------------------
                            String[] coordinate1 = linesToSplit[0].split(",");
                            String[] coordinate2 = linesToSplit[1].split(",");
                            String[] coordinate3 = linesToSplit[2].split(",");

                            //проверяю если это вoобще числа----------------------------------
                            try {
                                checkIfItsNumber(coordinate1, coordinate2, coordinate3, coordinate3, 3);
                            } catch (NumberFormatException e) {
                                System.out.println("Невенрый ввод, несоответствующий числам");
                                continue;
                            }

                            //заменяю на нормальные переменные-------------------------------
                            int co1i = Integer.parseInt(coordinate1[0]);
                            int co1j = Integer.parseInt(coordinate1[1]);
                            int co2i = Integer.parseInt(coordinate2[0]);
                            int co2j = Integer.parseInt(coordinate2[1]);
                            int co3i = Integer.parseInt(coordinate3[0]);
                            int co3j = Integer.parseInt(coordinate3[1]);

                            //проверка на равномерность--------------------------------------
                            try {
                                if (
                                        ((co1i == co2i && co1i == co3i) &&
                                                (co2j < co1j && co2j != co1j - 1) ||
                                                (co2j > co1j && co2j != co1j + 1) ||

                                                (co3j < co2j && co3j != co2j - 1) ||
                                                (co3j > co2j && co3j != co2j + 1)
                                        ) ||

                                        ((co1j == co2j && co1j == co3j) &&
                                                (co2i < co1i && co2i != co1i - 1) ||
                                                (co2i > co1i && co2i != co1i + 1) ||

                                                (co3i < co2i && co3i != co2i - 1) ||
                                                (co3i > co2i && co3i != co2i + 1)
                                        ) ||

                                        !(co1i == co2i && co1i == co3i) &&
                                        !(co1j == co2j && co1j == co3j)
                                ) {
                                    throw new IOException();
                                }
                            } catch (IOException e) {
                                System.out.println("Корабль не соответствует привилам последовательного размещения палуб");
                                continue;
                            }

                            //рисую первый корабль в POlE и TWODEKS--------------------------
                            if (field01.checkPole(co1i, co1j) && field01.checkPole(co2i, co2j) &&
                                    field01.checkPole(co3i, co3j)) {

                                //рисуем корабли в "pole"
                                field01.setPoleXY_pole(co1i, co1j);
                                field01.setPoleXY_pole(co2i, co2j);
                                field01.setPoleXY_pole(co3i, co3j);


                                //рисуем ориол в "twodecks"
                                field01.setOriolXY_twodecks(co1i, co1j);
                                field01.setOriolXY_twodecks(co2i, co2j);
                                field01.setOriolXY_twodecks(co3i, co3j);
                                //рисуем поле в "twodecks"
                                field01.setPoleXY_twodecks(co1i, co1j);
                                field01.setPoleXY_twodecks(co2i, co2j);
                                field01.setPoleXY_twodecks(co3i, co3j);

                                break;
                            } else {
                                System.out.println("Вы пытаетесь разместить корабль на месте уже существующего");
                                continue;
                            }
                        } else {
                            System.out.println("Вы превысили допустимое, либо уменьшили колличество палуб, во время ввода");
                            continue;
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("блок континуе");
                        continue;
                    }
                }
            }


            //----Двухпалубный 2.1-------
            if (true) {

                //----Печатаем текст для Двухпалубного(+начало)-------------------
                if (true) {
                    System.out.println();
                    System.out.println("Введите координаты первого Двухпалубного корабля, где i-строка и j-столбец: \n(формат: i,j; i,j)");
                    field01.polePrint();
                }

                //----первый Двухпалубный-----------------------------------------
                while (true) {

                    //----сканирую и превращаю в коорд.-------------------------------
                    File file2_1 = new File("src/Pervii/helper2_1");
                    File fil2_1 = new File("src/Pervii/helpe2_1");
                    try {
                        Scanner scanner = null;
                        if (q1 == 1) {
                            if (w1 == 1) {
                                scanner = new Scanner(file2_1);
                            }
                            if (w1 == 2) {
                                scanner = new Scanner(fil2_1);
                            }
                        } else {
                            scanner = new Scanner(System.in);
                        }
                        String numInserted = scanner.nextLine();
                        String[] linesToSplit = numInserted.split(";");

                        //проверяю на соответствие кол. координат-------------------------
                        if (linesToSplit.length == 2) {

                            //разделяю на запятые---------------------------------------------
                            String[] coordinate1 = linesToSplit[0].split(",");
                            String[] coordinate2 = linesToSplit[1].split(",");

                            //проверяю если это вoобще числа----------------------------------
                            try {
                                checkIfItsNumber(coordinate1, coordinate2, coordinate2, coordinate2, 2);
                            } catch (NumberFormatException e) {
                                System.out.println("Невенрый ввод, несоответствующий числам");
                                continue;
                            }

                            //заменяю на нормальные переменные-------------------------------
                            int co1i = Integer.parseInt(coordinate1[0]);
                            int co1j = Integer.parseInt(coordinate1[1]);
                            int co2i = Integer.parseInt(coordinate2[0]);
                            int co2j = Integer.parseInt(coordinate2[1]);

                            //проверка на равномерность--------------------------------------
                            try {
                                if (
                                        ((co1i == co2i) &&
                                                (co2j < co1j && co2j != co1j - 1) ||
                                                (co2j > co1j && co2j != co1j + 1)
                                        ) ||

                                        ((co1j == co2j) &&
                                                (co2i < co1i && co2i != co1i - 1) ||
                                                (co2i > co1i && co2i != co1i + 1)
                                        ) ||

                                        !(co1i == co2i) &&
                                        !(co1j == co2j)
                                ) {
                                    throw new IOException();
                                }
                            } catch (IOException e) {
                                System.out.println("Корабль не соответствует привилам последовательного размещения палуб");
                                continue;
                            }

                            //рисую первый корабль в POlE и TWODEKS--------------------------
                            if (field01.checkPole(co1i, co1j) && field01.checkPole(co2i, co2j)) {

                                //рисуем корабли в "pole"
                                field01.setPoleXY_pole(co1i, co1j);
                                field01.setPoleXY_pole(co2i, co2j);


                                //рисуем ориол в "twodecks"
                                field01.setOriolXY_twodecks(co1i, co1j);
                                field01.setOriolXY_twodecks(co2i, co2j);
                                //рисуем поле в "twodecks"
                                field01.setPoleXY_twodecks(co1i, co1j);
                                field01.setPoleXY_twodecks(co2i, co2j);

                                break;
                            } else {
                                System.out.println("Вы пытаетесь разместить корабль на месте уже существующего");
                                continue;
                            }
                        } else {
                            System.out.println("Вы превысили допустимое, либо уменьшили колличество палуб, во время ввода");
                            continue;
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("блок континуе");
                        continue;
                    }
                }
            }

            //----Двухпалубный 2.2-------
            if (true) {

                //----Печатаем текст для Двухпалубного(+начало)-------------------
                if (true) {
                    System.out.println();
                    System.out.println("Введите координаты второго Двухпалубного корабля, где i-строка и j-столбец: \n(формат: i,j; i,j)");
                    field01.polePrint();
                }

                //----второй Двухпалубный-----------------------------------------
                while (true) {

                    //----сканирую и превращаю в коорд.-------------------------------
                    File file2_2 = new File("src/Pervii/helper2_2");
                    File fil2_2 = new File("src/Pervii/helpe2_2");
                    try {
                        Scanner scanner = null;
                        if (q1 == 1) {
                            if (w1 == 1) {
                                scanner = new Scanner(file2_2);
                            }
                            if (w1 == 2) {
                                scanner = new Scanner(fil2_2);
                            }
                        } else {
                            scanner = new Scanner(System.in);
                        }
                        String numInserted = scanner.nextLine();
                        String[] linesToSplit = numInserted.split(";");

                        //проверяю на соответствие кол. координат-------------------------
                        if (linesToSplit.length == 2) {

                            //разделяю на запятые---------------------------------------------
                            String[] coordinate1 = linesToSplit[0].split(",");
                            String[] coordinate2 = linesToSplit[1].split(",");

                            //проверяю если это вoобще числа----------------------------------
                            try {
                                checkIfItsNumber(coordinate1, coordinate2, coordinate2, coordinate2, 2);
                            } catch (NumberFormatException e) {
                                System.out.println("Невенрый ввод, несоответствующий числам");
                                continue;
                            }

                            //заменяю на нормальные переменные-------------------------------
                            int co1i = Integer.parseInt(coordinate1[0]);
                            int co1j = Integer.parseInt(coordinate1[1]);
                            int co2i = Integer.parseInt(coordinate2[0]);
                            int co2j = Integer.parseInt(coordinate2[1]);

                            //проверка на равномерность--------------------------------------
                            try {
                                if (
                                        ((co1i == co2i) &&
                                                (co2j < co1j && co2j != co1j - 1) ||
                                                (co2j > co1j && co2j != co1j + 1)
                                        ) ||

                                        ((co1j == co2j) &&
                                                (co2i < co1i && co2i != co1i - 1) ||
                                                (co2i > co1i && co2i != co1i + 1)
                                        ) ||

                                        !(co1i == co2i) &&
                                        !(co1j == co2j)
                                ) {
                                    throw new IOException();
                                }
                            } catch (IOException e) {
                                System.out.println("Корабль не соответствует привилам последовательного размещения палуб");
                                continue;
                            }

                            //рисую первый корабль в POlE и TWODEKS--------------------------
                            if (field01.checkPole(co1i, co1j) && field01.checkPole(co2i, co2j)) {

                                //рисуем корабли в "pole"
                                field01.setPoleXY_pole(co1i, co1j);
                                field01.setPoleXY_pole(co2i, co2j);


                                //рисуем ориол в "twodecks"
                                field01.setOriolXY_twodecks(co1i, co1j);
                                field01.setOriolXY_twodecks(co2i, co2j);
                                //рисуем поле в "twodecks"
                                field01.setPoleXY_twodecks(co1i, co1j);
                                field01.setPoleXY_twodecks(co2i, co2j);

                                break;
                            } else {
                                System.out.println("Вы пытаетесь разместить корабль на месте уже существующего");
                                continue;
                            }
                        } else {
                            System.out.println("Вы превысили допустимое, либо уменьшили колличество палуб, во время ввода");
                            continue;
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("блок континуе");
                        continue;
                    }
                }
            }

            //----Двухпалубный 2.3-------
            if (true) {

                //----Печатаем текст для Двухпалубного(+начало)-------------------
                if (true) {
                    System.out.println();
                    System.out.println("Введите координаты третьего Двухпалубного корабля, где i-строка и j-столбец: \n(формат: i,j; i,j)");
                    field01.polePrint();
                }

                //----третий Двухпалубный-----------------------------------------
                while (true) {

                    //----сканирую и превращаю в коорд.-------------------------------
                    File file2_3 = new File("src/Pervii/helper2_3");
                    File fil2_3 = new File("src/Pervii/helpe2_3");
                    try {
                        Scanner scanner = null;
                        if (q1 == 1) {
                            if (w1 == 1) {
                                scanner = new Scanner(file2_3);
                            }
                            if (w1 == 2) {
                                scanner = new Scanner(fil2_3);
                            }
                        } else {
                            scanner = new Scanner(System.in);
                        }
                        String numInserted = scanner.nextLine();
                        String[] linesToSplit = numInserted.split(";");

                        //проверяю на соответствие кол. координат-------------------------
                        if (linesToSplit.length == 2) {

                            //разделяю на запятые---------------------------------------------
                            String[] coordinate1 = linesToSplit[0].split(",");
                            String[] coordinate2 = linesToSplit[1].split(",");

                            //проверяю если это вoобще числа----------------------------------
                            try {
                                checkIfItsNumber(coordinate1, coordinate2, coordinate2, coordinate2, 2);
                            } catch (NumberFormatException e) {
                                System.out.println("Невенрый ввод, несоответствующий числам");
                                continue;
                            }

                            //заменяю на нормальные переменные-------------------------------
                            int co1i = Integer.parseInt(coordinate1[0]);
                            int co1j = Integer.parseInt(coordinate1[1]);
                            int co2i = Integer.parseInt(coordinate2[0]);
                            int co2j = Integer.parseInt(coordinate2[1]);

                            //проверка на равномерность--------------------------------------
                            try {
                                if (
                                        ((co1i == co2i) &&
                                                (co2j < co1j && co2j != co1j - 1) ||
                                                (co2j > co1j && co2j != co1j + 1)
                                        ) ||

                                        ((co1j == co2j) &&
                                                (co2i < co1i && co2i != co1i - 1) ||
                                                (co2i > co1i && co2i != co1i + 1)
                                        ) ||

                                        !(co1i == co2i) &&
                                        !(co1j == co2j)
                                ) {
                                    throw new IOException();
                                }
                            } catch (IOException e) {
                                System.out.println("Корабль не соответствует привилам последовательного размещения палуб");
                                continue;
                            }

                            //рисую первый корабль в POlE и TWODEKS--------------------------
                            if (field01.checkPole(co1i, co1j) && field01.checkPole(co2i, co2j)) {

                                //рисуем корабли в "pole"
                                field01.setPoleXY_pole(co1i, co1j);
                                field01.setPoleXY_pole(co2i, co2j);


                                //рисуем ориол в "twodecks"
                                field01.setOriolXY_twodecks(co1i, co1j);
                                field01.setOriolXY_twodecks(co2i, co2j);
                                //рисуем поле в "twodecks"
                                field01.setPoleXY_twodecks(co1i, co1j);
                                field01.setPoleXY_twodecks(co2i, co2j);

                                break;
                            } else {
                                System.out.println("Вы пытаетесь разместить корабль на месте уже существующего");
                                continue;
                            }
                        } else {
                            System.out.println("Вы превысили допустимое, либо уменьшили колличество палуб, во время ввода");
                            continue;
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("блок континуе");
                        continue;
                    }
                }
            }


            //----Однопалубный 1.1-------
            if (true) {

                //----Печатаем текст для Однопалубного(+начало)-------------------
                if (true) {
                    System.out.println();
                    System.out.println("Введите координаты первого Однопалубного корабля, где i-строка и j-столбец: \n(формат: i,j)");
                    field01.polePrint();
                }

                //----первый Двухпалубный-----------------------------------------
                while (true) {

                    //----сканирую и превращаю в коорд.-------------------------------
                    File file1_1 = new File("src/Pervii/helper1_1");
                    File fil1_1 = new File("src/Pervii/helpe1_1");
                    try {
                        Scanner scanner = null;
                        if (q1 == 1) {
                            if (w1 == 1) {
                                scanner = new Scanner(file1_1);
                            }
                            if (w1 == 2) {
                                scanner = new Scanner(fil1_1);
                            }
                        } else {
                            scanner = new Scanner(System.in);
                        }
                        String numInserted = scanner.nextLine();
                        String[] linesToSplit = numInserted.split(";");

                        //проверяю на соответствие кол. координат-------------------------
                        if (linesToSplit.length == 1) {

                            //разделяю на запятые---------------------------------------------
                            String[] coordinate1 = linesToSplit[0].split(",");

                            //проверяю если это вoобще числа----------------------------------
                            try {
                                checkIfItsNumber(coordinate1, coordinate1, coordinate1, coordinate1, 1);
                            } catch (NumberFormatException e) {
                                System.out.println("Невенрый ввод, несоответствующий числам");
                                continue;
                            }

                            //заменяю на нормальные переменные-------------------------------
                            int co1i = Integer.parseInt(coordinate1[0]);
                            int co1j = Integer.parseInt(coordinate1[1]);

                            //рисую первый корабль в POlE и TWODEKS--------------------------
                            if (field01.checkPole(co1i, co1j)) {

                                //рисуем корабли в "pole"
                                field01.setPoleXY_pole(co1i, co1j);


                                //рисуем ориол в "twodecks"
                                field01.setOriolXY_twodecks(co1i, co1j);
                                //рисуем поле в "twodecks"
                                field01.setPoleXY_twodecks(co1i, co1j);

                                break;
                            } else {
                                System.out.println("Вы пытаетесь разместить корабль на месте уже существующего");
                                continue;
                            }
                        } else {
                            System.out.println("Вы превысили допустимое, либо уменьшили колличество палуб, во время ввода");
                            continue;
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("блок континуе");
                        continue;
                    }
                }
            }

            //----Однопалубный 1.2-------
            if (true) {

                //----Печатаем текст для Однопалубного(+начало)-------------------
                if (true) {
                    System.out.println();
                    System.out.println("Введите координаты второго Однопалубного корабля, где i-строка и j-столбец: \n(формат: i,j)");
                    field01.polePrint();
                }

                //----второй Однопалубный-----------------------------------------
                while (true) {

                    //----сканирую и превращаю в коорд.-------------------------------
                    File file1_2 = new File("src/Pervii/helper1_2");
                    File fil1_2 = new File("src/Pervii/helpe1_2");
                    try {
                        Scanner scanner = null;
                        if (q1 == 1) {
                            if (w1 == 1) {
                                scanner = new Scanner(file1_2);
                            }
                            if (w1 == 2) {
                                scanner = new Scanner(fil1_2);
                            }
                        } else {
                            scanner = new Scanner(System.in);
                        }
                        String numInserted = scanner.nextLine();
                        String[] linesToSplit = numInserted.split(";");

                        //проверяю на соответствие кол. координат-------------------------
                        if (linesToSplit.length == 1) {

                            //разделяю на запятые---------------------------------------------
                            String[] coordinate1 = linesToSplit[0].split(",");

                            //проверяю если это вoобще числа----------------------------------
                            try {
                                checkIfItsNumber(coordinate1, coordinate1, coordinate1, coordinate1, 1);
                            } catch (NumberFormatException e) {
                                System.out.println("Невенрый ввод, несоответствующий числам");
                                continue;
                            }

                            //заменяю на нормальные переменные-------------------------------
                            int co1i = Integer.parseInt(coordinate1[0]);
                            int co1j = Integer.parseInt(coordinate1[1]);

                            //рисую первый корабль в POlE и TWODEKS--------------------------
                            if (field01.checkPole(co1i, co1j)) {

                                //рисуем корабли в "pole"
                                field01.setPoleXY_pole(co1i, co1j);


                                //рисуем ориол в "twodecks"
                                field01.setOriolXY_twodecks(co1i, co1j);
                                //рисуем поле в "twodecks"
                                field01.setPoleXY_twodecks(co1i, co1j);

                                break;
                            } else {
                                System.out.println("Вы пытаетесь разместить корабль на месте уже существующего");
                                continue;
                            }
                        } else {
                            System.out.println("Вы превысили допустимое, либо уменьшили колличество палуб, во время ввода");
                            continue;
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("блок континуе");
                        continue;
                    }
                }
            }

            //----Однопалубный 1.3-------
            if (true) {

                //----Печатаем текст для Однопалубного(+начало)-------------------
                if (true) {
                    System.out.println();
                    System.out.println("Введите координаты третьего Однопалубного корабля, где i-строка и j-столбец: \n(формат: i,j)");
                    field01.polePrint();
                }

                //----третий Однопалубный-----------------------------------------
                while (true) {

                    //----сканирую и превращаю в коорд.-------------------------------
                    File file1_3 = new File("src/Pervii/helper1_3");
                    File fil1_3 = new File("src/Pervii/helpe1_3");
                    try {
                        Scanner scanner = null;
                        if (q1 == 1) {
                            if (w1 == 1) {
                                scanner = new Scanner(file1_3);
                            }
                            if (w1 == 2) {
                                scanner = new Scanner(fil1_3);
                            }
                        } else {
                            scanner = new Scanner(System.in);
                        }
                        String numInserted = scanner.nextLine();
                        String[] linesToSplit = numInserted.split(";");

                        //проверяю на соответствие кол. координат-------------------------
                        if (linesToSplit.length == 1) {

                            //разделяю на запятые---------------------------------------------
                            String[] coordinate1 = linesToSplit[0].split(",");

                            //проверяю если это вoобще числа----------------------------------
                            try {
                                checkIfItsNumber(coordinate1, coordinate1, coordinate1, coordinate1, 1);
                            } catch (NumberFormatException e) {
                                System.out.println("Невенрый ввод, несоответствующий числам");
                                continue;
                            }

                            //заменяю на нормальные переменные-------------------------------
                            int co1i = Integer.parseInt(coordinate1[0]);
                            int co1j = Integer.parseInt(coordinate1[1]);

                            //рисую первый корабль в POlE и TWODEKS--------------------------
                            if (field01.checkPole(co1i, co1j)) {

                                //рисуем корабли в "pole"
                                field01.setPoleXY_pole(co1i, co1j);


                                //рисуем ориол в "twodecks"
                                field01.setOriolXY_twodecks(co1i, co1j);
                                //рисуем поле в "twodecks"
                                field01.setPoleXY_twodecks(co1i, co1j);

                                break;
                            } else {
                                System.out.println("Вы пытаетесь разместить корабль на месте уже существующего");
                                continue;
                            }
                        } else {
                            System.out.println("Вы превысили допустимое, либо уменьшили колличество палуб, во время ввода");
                            continue;
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("блок континуе");
                        continue;
                    }
                }
            }

            //----Однопалубный 1.4-------
            if (true) {

                //----Печатаем текст для Однопалубного(+начало)-------------------
                if (true) {
                    System.out.println();
                    System.out.println("Введите координаты четвертого Однопалубного корабля, где i-строка и j-столбец: \n(формат: i,j)");
                    field01.polePrint();
                }

                //----четвертый Однопалубный-----------------------------------------
                while (true) {

                    //----сканирую и превращаю в коорд.-------------------------------
                    File file1_4 = new File("src/Pervii/helper1_4");
                    File fil1_4 = new File("src/Pervii/helpe1_4");
                    try {
                        Scanner scanner = null;
                        if (q1 == 1) {
                            if (w1 == 1) {
                                scanner = new Scanner(file1_4);
                            }
                            if (w1 == 2) {
                                scanner = new Scanner(fil1_4);
                            }
                        } else {
                            scanner = new Scanner(System.in);
                        }
                        String numInserted = scanner.nextLine();
                        String[] linesToSplit = numInserted.split(";");

                        //проверяю на соответствие кол. координат-------------------------
                        if (linesToSplit.length == 1) {

                            //разделяю на запятые---------------------------------------------
                            String[] coordinate1 = linesToSplit[0].split(",");

                            //проверяю если это вoобще числа----------------------------------
                            try {
                                checkIfItsNumber(coordinate1, coordinate1, coordinate1, coordinate1, 1);
                            } catch (NumberFormatException e) {
                                System.out.println("Невенрый ввод, несоответствующий числам");
                                continue;
                            }

                            //заменяю на нормальные переменные-------------------------------
                            int co1i = Integer.parseInt(coordinate1[0]);
                            int co1j = Integer.parseInt(coordinate1[1]);

                            //рисую первый корабль в POlE и TWODEKS--------------------------
                            if (field01.checkPole(co1i, co1j)) {

                                //рисуем корабли в "pole"
                                field01.setPoleXY_pole(co1i, co1j);


                                //рисуем ориол в "twodecks"
                                field01.setOriolXY_twodecks(co1i, co1j);
                                //рисуем поле в "twodecks"
                                field01.setPoleXY_twodecks(co1i, co1j);

                                break;
                            } else {
                                System.out.println("Вы пытаетесь разместить корабль на месте уже существующего");
                                continue;
                            }
                        } else {
                            System.out.println("Вы превысили допустимое, либо уменьшили колличество палуб, во время ввода");
                            continue;
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("блок континуе");
                        continue;
                    }
                }
            }
        }

        //----второй игрок----
        w1 = 2;
        Field01 field02 = new Field01();
        if (true) {
            //----Четырехпалубный 4.1----
            if (true) {

                //----Печатаем текст для Четырухпалубного(+начало)----------------
                if (true) {
                    System.out.println();
                    System.out.println();
                    System.out.println("*********(Player 2!)*********\n");
                    System.out.println("Начнем расставлять корабли на поле PLAYER 2. Другой игрок не смотрит!");
                    System.out.println("Введите координаты первого Четырехпалубного корабля, где i-строка и j-столбец: \n(формат: i,j; i,j; i,j; i,j)");
                    field02.polePrint();
                }

                //----первый Четырехпалубный--------------------------------------
                while (true) {

                    //----сканирую и превращаю в коорд.-------------------------------
                    File file4 = new File("src/Pervii/helper4");
                    File fil4 = new File("src/Pervii/helpe4");
                    try {
                        Scanner scanner = null;
                        if (q1 == 1) {
                            if (w1 == 1) {
                                scanner = new Scanner(file4);
                            }
                            if (w1 == 2) {
                                scanner = new Scanner(fil4);
                            }
                        } else {
                            scanner = new Scanner(System.in);
                        }
                        String numInserted = scanner.nextLine();
                        String[] linesToSplit = numInserted.split(";");

                        //проверяю на соответствие кол. координат-------------------------
                        if (linesToSplit.length == 4) {

                            //разделяю на запятые---------------------------------------------
                            String[] coordinate1 = linesToSplit[0].split(",");
                            String[] coordinate2 = linesToSplit[1].split(",");
                            String[] coordinate3 = linesToSplit[2].split(",");
                            String[] coordinate4 = linesToSplit[3].split(",");

                            //проверяю если это вoобще числа----------------------------------
                            try {
                                checkIfItsNumber(coordinate1, coordinate2, coordinate3, coordinate4, 4);
                            } catch (NumberFormatException e) {
                                System.out.println("Невенрый ввод, несоответствующий числам");
                                continue;
                            }

                            //заменяю на нормальные переменные-------------------------------
                            int co1i = Integer.parseInt(coordinate1[0]);
                            int co1j = Integer.parseInt(coordinate1[1]);
                            int co2i = Integer.parseInt(coordinate2[0]);
                            int co2j = Integer.parseInt(coordinate2[1]);
                            int co3i = Integer.parseInt(coordinate3[0]);
                            int co3j = Integer.parseInt(coordinate3[1]);
                            int co4i = Integer.parseInt(coordinate4[0]);
                            int co4j = Integer.parseInt(coordinate4[1]);

                            //проверка на равномерность--------------------------------------
                            try {
                                if (
                                        ((co1i == co2i && co1i == co3i && co1i == co4i) &&
                                                (co2j < co1j && co2j != co1j - 1) ||
                                                (co2j > co1j && co2j != co1j + 1) ||

                                                (co3j < co2j && co3j != co2j - 1) ||
                                                (co3j > co2j && co3j != co2j + 1) ||

                                                (co4j < co3j && co4j != co3j - 1) ||
                                                (co4j > co3j && co4j != co3j + 1)
                                        ) ||

                                                ((co1j == co2j && co1j == co3j && co1j == co4j) &&
                                                        (co2i < co1i && co2i != co1i - 1) ||
                                                        (co2i > co1i && co2i != co1i + 1) ||

                                                        (co3i < co2i && co3i != co2i - 1) ||
                                                        (co3i > co2i && co3i != co2i + 1) ||

                                                        (co4i < co3i && co4i != co3i - 1) ||
                                                        (co4i > co3i && co4i != co3i + 1)
                                                ) ||

                                                !(co1i == co2i && co1i == co3i && co1i == co4i) &&
                                                        !(co1j == co2j && co1j == co3j && co1j == co4j)
                                ) {
                                    throw new IOException();
                                }
                            } catch (IOException e) {
                                System.out.println("Корабль не соответствует привилам последовательного размещения палуб");
                                continue;
                            }

                            //рисую первый корабль в POlE и TWODEKS--------------------------
                            if (field02.checkPole(co1i, co1j) && field02.checkPole(co2i, co2j) &&
                                    field02.checkPole(co3i, co3j) && field02.checkPole(co4i, co4j)) {

                                //рисуем корабли в "pole"
                                field02.setPoleXY_pole(co1i, co1j);
                                field02.setPoleXY_pole(co2i, co2j);
                                field02.setPoleXY_pole(co3i, co3j);
                                field02.setPoleXY_pole(co4i, co4j);


                                //рисуем ориол в "twodecks"
                                field02.setOriolXY_twodecks(co1i, co1j);
                                field02.setOriolXY_twodecks(co2i, co2j);
                                field02.setOriolXY_twodecks(co3i, co3j);
                                field02.setOriolXY_twodecks(co4i, co4j);
                                //рисуем поле в "twodecks"
                                field02.setPoleXY_twodecks(co1i, co1j);
                                field02.setPoleXY_twodecks(co2i, co2j);
                                field02.setPoleXY_twodecks(co3i, co3j);
                                field02.setPoleXY_twodecks(co4i, co4j);

                                break;
                            } else {
                                System.out.println("Вы пытаетесь разместить корабль на месте уже существующего");
                                continue;
                            }
                        } else {
                            System.out.println("Вы превысили допустимое, либо уменьшили колличество палуб, во время ввода");
                            continue;
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("блок континуе");
                        continue;
                    }
                }
            }


            //----Трехпалубный 3.1-------
            if (true) {

                //----Печатаем текст для Трехпалубного(+начало)-------------------
                if (true) {
                    System.out.println();
                    System.out.println("Введите координаты первого Трехпалубного корабля, где i-строка и j-столбец: \n(формат: i,j; i,j; i,j)");
                    field02.polePrint();
                }

                //----первый Трехпалубный-----------------------------------------
                while (true) {

                    //----сканирую и превращаю в коорд.-------------------------------
                    File file3_1 = new File("src/Pervii/helper3_1");
                    File fil3_1 = new File("src/Pervii/helpe3_1");
                    try {
                        Scanner scanner = null;
                        if (q1 == 1) {
                            if (w1 == 1) {
                                scanner = new Scanner(file3_1);
                            }
                            if (w1 == 2) {
                                scanner = new Scanner(fil3_1);
                            }
                        } else {
                            scanner = new Scanner(System.in);
                        }
                        String numInserted = scanner.nextLine();
                        String[] linesToSplit = numInserted.split(";");

                        //проверяю на соответствие кол. координат-------------------------
                        if (linesToSplit.length == 3) {

                            //разделяю на запятые---------------------------------------------
                            String[] coordinate1 = linesToSplit[0].split(",");
                            String[] coordinate2 = linesToSplit[1].split(",");
                            String[] coordinate3 = linesToSplit[2].split(",");

                            //проверяю если это вoобще числа----------------------------------
                            try {
                                checkIfItsNumber(coordinate1, coordinate2, coordinate3, coordinate3, 3);
                            } catch (NumberFormatException e) {
                                System.out.println("Невенрый ввод, несоответствующий числам");
                                continue;
                            }

                            //заменяю на нормальные переменные-------------------------------
                            int co1i = Integer.parseInt(coordinate1[0]);
                            int co1j = Integer.parseInt(coordinate1[1]);
                            int co2i = Integer.parseInt(coordinate2[0]);
                            int co2j = Integer.parseInt(coordinate2[1]);
                            int co3i = Integer.parseInt(coordinate3[0]);
                            int co3j = Integer.parseInt(coordinate3[1]);

                            //проверка на равномерность--------------------------------------
                            try {
                                if (
                                        ((co1i == co2i && co1i == co3i) &&
                                                (co2j < co1j && co2j != co1j - 1) ||
                                                (co2j > co1j && co2j != co1j + 1) ||

                                                (co3j < co2j && co3j != co2j - 1) ||
                                                (co3j > co2j && co3j != co2j + 1)
                                        ) ||

                                                ((co1j == co2j && co1j == co3j) &&
                                                        (co2i < co1i && co2i != co1i - 1) ||
                                                        (co2i > co1i && co2i != co1i + 1) ||

                                                        (co3i < co2i && co3i != co2i - 1) ||
                                                        (co3i > co2i && co3i != co2i + 1)
                                                ) ||

                                                !(co1i == co2i && co1i == co3i) &&
                                                        !(co1j == co2j && co1j == co3j)
                                ) {
                                    throw new IOException();
                                }
                            } catch (IOException e) {
                                System.out.println("Корабль не соответствует привилам последовательного размещения палуб");
                                continue;
                            }

                            //рисую первый корабль в POlE и TWODEKS--------------------------
                            if (field02.checkPole(co1i, co1j) && field02.checkPole(co2i, co2j) &&
                                    field02.checkPole(co3i, co3j)) {

                                //рисуем корабли в "pole"
                                field02.setPoleXY_pole(co1i, co1j);
                                field02.setPoleXY_pole(co2i, co2j);
                                field02.setPoleXY_pole(co3i, co3j);


                                //рисуем ориол в "twodecks"
                                field02.setOriolXY_twodecks(co1i, co1j);
                                field02.setOriolXY_twodecks(co2i, co2j);
                                field02.setOriolXY_twodecks(co3i, co3j);
                                //рисуем поле в "twodecks"
                                field02.setPoleXY_twodecks(co1i, co1j);
                                field02.setPoleXY_twodecks(co2i, co2j);
                                field02.setPoleXY_twodecks(co3i, co3j);

                                break;
                            } else {
                                System.out.println("Вы пытаетесь разместить корабль на месте уже существующего");
                                continue;
                            }
                        } else {
                            System.out.println("Вы превысили допустимое, либо уменьшили колличество палуб, во время ввода");
                            continue;
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("блок континуе");
                        continue;
                    }
                }
            }

            //----Трехпалубный 3.2-------
            if (true) {

                //----Печатаем текст для Трехпалубного(+начало)-------------------
                if (true) {
                    System.out.println();
                    System.out.println("Введите координаты второго Трехпалубного корабля, где i-строка и j-столбец: \n(формат: i,j; i,j; i,j)");
                    field02.polePrint();
                }

                //----второй Трехпалубный-----------------------------------------
                while (true) {

                    //----сканирую и превращаю в коорд.-------------------------------
                    File file3_2 = new File("src/Pervii/helper3_2");
                    File fil3_2 = new File("src/Pervii/helpe3_2");
                    try {
                        Scanner scanner = null;
                        if (q1 == 1) {
                            if (w1 == 1) {
                                scanner = new Scanner(file3_2);
                            }
                            if (w1 == 2) {
                                scanner = new Scanner(fil3_2);
                            }
                        } else {
                            scanner = new Scanner(System.in);
                        }
                        String numInserted = scanner.nextLine();
                        String[] linesToSplit = numInserted.split(";");

                        //проверяю на соответствие кол. координат-------------------------
                        if (linesToSplit.length == 3) {

                            //разделяю на запятые---------------------------------------------
                            String[] coordinate1 = linesToSplit[0].split(",");
                            String[] coordinate2 = linesToSplit[1].split(",");
                            String[] coordinate3 = linesToSplit[2].split(",");

                            //проверяю если это вoобще числа----------------------------------
                            try {
                                checkIfItsNumber(coordinate1, coordinate2, coordinate3, coordinate3, 3);
                            } catch (NumberFormatException e) {
                                System.out.println("Невенрый ввод, несоответствующий числам");
                                continue;
                            }

                            //заменяю на нормальные переменные-------------------------------
                            int co1i = Integer.parseInt(coordinate1[0]);
                            int co1j = Integer.parseInt(coordinate1[1]);
                            int co2i = Integer.parseInt(coordinate2[0]);
                            int co2j = Integer.parseInt(coordinate2[1]);
                            int co3i = Integer.parseInt(coordinate3[0]);
                            int co3j = Integer.parseInt(coordinate3[1]);

                            //проверка на равномерность--------------------------------------
                            try {
                                if (
                                        ((co1i == co2i && co1i == co3i) &&
                                                (co2j < co1j && co2j != co1j - 1) ||
                                                (co2j > co1j && co2j != co1j + 1) ||

                                                (co3j < co2j && co3j != co2j - 1) ||
                                                (co3j > co2j && co3j != co2j + 1)
                                        ) ||

                                                ((co1j == co2j && co1j == co3j) &&
                                                        (co2i < co1i && co2i != co1i - 1) ||
                                                        (co2i > co1i && co2i != co1i + 1) ||

                                                        (co3i < co2i && co3i != co2i - 1) ||
                                                        (co3i > co2i && co3i != co2i + 1)
                                                ) ||

                                                !(co1i == co2i && co1i == co3i) &&
                                                        !(co1j == co2j && co1j == co3j)
                                ) {
                                    throw new IOException();
                                }
                            } catch (IOException e) {
                                System.out.println("Корабль не соответствует привилам последовательного размещения палуб");
                                continue;
                            }

                            //рисую первый корабль в POlE и TWODEKS--------------------------
                            if (field02.checkPole(co1i, co1j) && field02.checkPole(co2i, co2j) &&
                                    field02.checkPole(co3i, co3j)) {

                                //рисуем корабли в "pole"
                                field02.setPoleXY_pole(co1i, co1j);
                                field02.setPoleXY_pole(co2i, co2j);
                                field02.setPoleXY_pole(co3i, co3j);


                                //рисуем ориол в "twodecks"
                                field02.setOriolXY_twodecks(co1i, co1j);
                                field02.setOriolXY_twodecks(co2i, co2j);
                                field02.setOriolXY_twodecks(co3i, co3j);
                                //рисуем поле в "twodecks"
                                field02.setPoleXY_twodecks(co1i, co1j);
                                field02.setPoleXY_twodecks(co2i, co2j);
                                field02.setPoleXY_twodecks(co3i, co3j);

                                break;
                            } else {
                                System.out.println("Вы пытаетесь разместить корабль на месте уже существующего");
                                continue;
                            }
                        } else {
                            System.out.println("Вы превысили допустимое, либо уменьшили колличество палуб, во время ввода");
                            continue;
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("блок континуе");
                        continue;
                    }
                }
            }


            //----Двухпалубный 2.1-------
            if (true) {

                //----Печатаем текст для Двухпалубного(+начало)-------------------
                if (true) {
                    System.out.println();
                    System.out.println("Введите координаты первого Двухпалубного корабля, где i-строка и j-столбец: \n(формат: i,j; i,j)");
                    field02.polePrint();
                }

                //----первый Двухпалубный-----------------------------------------
                while (true) {

                    //----сканирую и превращаю в коорд.-------------------------------
                    File file2_1 = new File("src/Pervii/helper2_1");
                    File fil2_1 = new File("src/Pervii/helpe2_1");
                    try {
                        Scanner scanner = null;
                        if (q1 == 1) {
                            if (w1 == 1) {
                                scanner = new Scanner(file2_1);
                            }
                            if (w1 == 2) {
                                scanner = new Scanner(fil2_1);
                            }
                        } else {
                            scanner = new Scanner(System.in);
                        }
                        String numInserted = scanner.nextLine();
                        String[] linesToSplit = numInserted.split(";");

                        //проверяю на соответствие кол. координат-------------------------
                        if (linesToSplit.length == 2) {

                            //разделяю на запятые---------------------------------------------
                            String[] coordinate1 = linesToSplit[0].split(",");
                            String[] coordinate2 = linesToSplit[1].split(",");

                            //проверяю если это вoобще числа----------------------------------
                            try {
                                checkIfItsNumber(coordinate1, coordinate2, coordinate2, coordinate2, 2);
                            } catch (NumberFormatException e) {
                                System.out.println("Невенрый ввод, несоответствующий числам");
                                continue;
                            }

                            //заменяю на нормальные переменные-------------------------------
                            int co1i = Integer.parseInt(coordinate1[0]);
                            int co1j = Integer.parseInt(coordinate1[1]);
                            int co2i = Integer.parseInt(coordinate2[0]);
                            int co2j = Integer.parseInt(coordinate2[1]);

                            //проверка на равномерность--------------------------------------
                            try {
                                if (
                                        ((co1i == co2i) &&
                                                (co2j < co1j && co2j != co1j - 1) ||
                                                (co2j > co1j && co2j != co1j + 1)
                                        ) ||

                                                ((co1j == co2j) &&
                                                        (co2i < co1i && co2i != co1i - 1) ||
                                                        (co2i > co1i && co2i != co1i + 1)
                                                ) ||

                                                !(co1i == co2i) &&
                                                        !(co1j == co2j)
                                ) {
                                    throw new IOException();
                                }
                            } catch (IOException e) {
                                System.out.println("Корабль не соответствует привилам последовательного размещения палуб");
                                continue;
                            }

                            //рисую первый корабль в POlE и TWODEKS--------------------------
                            if (field02.checkPole(co1i, co1j) && field02.checkPole(co2i, co2j)) {

                                //рисуем корабли в "pole"
                                field02.setPoleXY_pole(co1i, co1j);
                                field02.setPoleXY_pole(co2i, co2j);


                                //рисуем ориол в "twodecks"
                                field02.setOriolXY_twodecks(co1i, co1j);
                                field02.setOriolXY_twodecks(co2i, co2j);
                                //рисуем поле в "twodecks"
                                field02.setPoleXY_twodecks(co1i, co1j);
                                field02.setPoleXY_twodecks(co2i, co2j);

                                break;
                            } else {
                                System.out.println("Вы пытаетесь разместить корабль на месте уже существующего");
                                continue;
                            }
                        } else {
                            System.out.println("Вы превысили допустимое, либо уменьшили колличество палуб, во время ввода");
                            continue;
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("блок континуе");
                        continue;
                    }
                }
            }

            //----Двухпалубный 2.2-------
            if (true) {

                //----Печатаем текст для Двухпалубного(+начало)-------------------
                if (true) {
                    System.out.println();
                    System.out.println("Введите координаты второго Двухпалубного корабля, где i-строка и j-столбец: \n(формат: i,j; i,j)");
                    field02.polePrint();
                }

                //----второй Двухпалубный-----------------------------------------
                while (true) {

                    //----сканирую и превращаю в коорд.-------------------------------
                    File file2_2 = new File("src/Pervii/helper2_2");
                    File fil2_2 = new File("src/Pervii/helpe2_2");
                    try {
                        Scanner scanner = null;
                        if (q1 == 1) {
                            if (w1 == 1) {
                                scanner = new Scanner(file2_2);
                            }
                            if (w1 == 2) {
                                scanner = new Scanner(fil2_2);
                            }
                        } else {
                            scanner = new Scanner(System.in);
                        }
                        String numInserted = scanner.nextLine();
                        String[] linesToSplit = numInserted.split(";");

                        //проверяю на соответствие кол. координат-------------------------
                        if (linesToSplit.length == 2) {

                            //разделяю на запятые---------------------------------------------
                            String[] coordinate1 = linesToSplit[0].split(",");
                            String[] coordinate2 = linesToSplit[1].split(",");

                            //проверяю если это вoобще числа----------------------------------
                            try {
                                checkIfItsNumber(coordinate1, coordinate2, coordinate2, coordinate2, 2);
                            } catch (NumberFormatException e) {
                                System.out.println("Невенрый ввод, несоответствующий числам");
                                continue;
                            }

                            //заменяю на нормальные переменные-------------------------------
                            int co1i = Integer.parseInt(coordinate1[0]);
                            int co1j = Integer.parseInt(coordinate1[1]);
                            int co2i = Integer.parseInt(coordinate2[0]);
                            int co2j = Integer.parseInt(coordinate2[1]);

                            //проверка на равномерность--------------------------------------
                            try {
                                if (
                                        ((co1i == co2i) &&
                                                (co2j < co1j && co2j != co1j - 1) ||
                                                (co2j > co1j && co2j != co1j + 1)
                                        ) ||

                                                ((co1j == co2j) &&
                                                        (co2i < co1i && co2i != co1i - 1) ||
                                                        (co2i > co1i && co2i != co1i + 1)
                                                ) ||

                                                !(co1i == co2i) &&
                                                        !(co1j == co2j)
                                ) {
                                    throw new IOException();
                                }
                            } catch (IOException e) {
                                System.out.println("Корабль не соответствует привилам последовательного размещения палуб");
                                continue;
                            }

                            //рисую первый корабль в POlE и TWODEKS--------------------------
                            if (field02.checkPole(co1i, co1j) && field02.checkPole(co2i, co2j)) {

                                //рисуем корабли в "pole"
                                field02.setPoleXY_pole(co1i, co1j);
                                field02.setPoleXY_pole(co2i, co2j);


                                //рисуем ориол в "twodecks"
                                field02.setOriolXY_twodecks(co1i, co1j);
                                field02.setOriolXY_twodecks(co2i, co2j);
                                //рисуем поле в "twodecks"
                                field02.setPoleXY_twodecks(co1i, co1j);
                                field02.setPoleXY_twodecks(co2i, co2j);

                                break;
                            } else {
                                System.out.println("Вы пытаетесь разместить корабль на месте уже существующего");
                                continue;
                            }
                        } else {
                            System.out.println("Вы превысили допустимое, либо уменьшили колличество палуб, во время ввода");
                            continue;
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("блок континуе");
                        continue;
                    }
                }
            }

            //----Двухпалубный 2.3-------
            if (true) {

                //----Печатаем текст для Двухпалубного(+начало)-------------------
                if (true) {
                    System.out.println();
                    System.out.println("Введите координаты третьего Двухпалубного корабля, где i-строка и j-столбец: \n(формат: i,j; i,j)");
                    field02.polePrint();
                }

                //----третий Двухпалубный-----------------------------------------
                while (true) {

                    //----сканирую и превращаю в коорд.-------------------------------
                    File file2_3 = new File("src/Pervii/helper2_3");
                    File fil2_3 = new File("src/Pervii/helpe2_3");
                    try {
                        Scanner scanner = null;
                        if (q1 == 1) {
                            if (w1 == 1) {
                                scanner = new Scanner(file2_3);
                            }
                            if (w1 == 2) {
                                scanner = new Scanner(fil2_3);
                            }
                        } else {
                            scanner = new Scanner(System.in);
                        }
                        String numInserted = scanner.nextLine();
                        String[] linesToSplit = numInserted.split(";");

                        //проверяю на соответствие кол. координат-------------------------
                        if (linesToSplit.length == 2) {

                            //разделяю на запятые---------------------------------------------
                            String[] coordinate1 = linesToSplit[0].split(",");
                            String[] coordinate2 = linesToSplit[1].split(",");

                            //проверяю если это вoобще числа----------------------------------
                            try {
                                checkIfItsNumber(coordinate1, coordinate2, coordinate2, coordinate2, 2);
                            } catch (NumberFormatException e) {
                                System.out.println("Невенрый ввод, несоответствующий числам");
                                continue;
                            }

                            //заменяю на нормальные переменные-------------------------------
                            int co1i = Integer.parseInt(coordinate1[0]);
                            int co1j = Integer.parseInt(coordinate1[1]);
                            int co2i = Integer.parseInt(coordinate2[0]);
                            int co2j = Integer.parseInt(coordinate2[1]);

                            //проверка на равномерность--------------------------------------
                            try {
                                if (
                                        ((co1i == co2i) &&
                                                (co2j < co1j && co2j != co1j - 1) ||
                                                (co2j > co1j && co2j != co1j + 1)
                                        ) ||

                                                ((co1j == co2j) &&
                                                        (co2i < co1i && co2i != co1i - 1) ||
                                                        (co2i > co1i && co2i != co1i + 1)
                                                ) ||

                                                !(co1i == co2i) &&
                                                        !(co1j == co2j)
                                ) {
                                    throw new IOException();
                                }
                            } catch (IOException e) {
                                System.out.println("Корабль не соответствует привилам последовательного размещения палуб");
                                continue;
                            }

                            //рисую первый корабль в POlE и TWODEKS--------------------------
                            if (field02.checkPole(co1i, co1j) && field02.checkPole(co2i, co2j)) {

                                //рисуем корабли в "pole"
                                field02.setPoleXY_pole(co1i, co1j);
                                field02.setPoleXY_pole(co2i, co2j);


                                //рисуем ориол в "twodecks"
                                field02.setOriolXY_twodecks(co1i, co1j);
                                field02.setOriolXY_twodecks(co2i, co2j);
                                //рисуем поле в "twodecks"
                                field02.setPoleXY_twodecks(co1i, co1j);
                                field02.setPoleXY_twodecks(co2i, co2j);

                                break;
                            } else {
                                System.out.println("Вы пытаетесь разместить корабль на месте уже существующего");
                                continue;
                            }
                        } else {
                            System.out.println("Вы превысили допустимое, либо уменьшили колличество палуб, во время ввода");
                            continue;
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("блок континуе");
                        continue;
                    }
                }
            }


            //----Однопалубный 1.1-------
            if (true) {

                //----Печатаем текст для Однопалубного(+начало)-------------------
                if (true) {
                    System.out.println();
                    System.out.println("Введите координаты первого Однопалубного корабля, где i-строка и j-столбец: \n(формат: i,j)");
                    field02.polePrint();
                }

                //----первый Двухпалубный-----------------------------------------
                while (true) {

                    //----сканирую и превращаю в коорд.-------------------------------
                    File file1_1 = new File("src/Pervii/helper1_1");
                    File fil1_1 = new File("src/Pervii/helpe1_1");
                    try {
                        Scanner scanner = null;
                        if (q1 == 1) {
                            if (w1 == 1) {
                                scanner = new Scanner(file1_1);
                            }
                            if (w1 == 2) {
                                scanner = new Scanner(fil1_1);
                            }
                        } else {
                            scanner = new Scanner(System.in);
                        }
                        String numInserted = scanner.nextLine();
                        String[] linesToSplit = numInserted.split(";");

                        //проверяю на соответствие кол. координат-------------------------
                        if (linesToSplit.length == 1) {

                            //разделяю на запятые---------------------------------------------
                            String[] coordinate1 = linesToSplit[0].split(",");

                            //проверяю если это вoобще числа----------------------------------
                            try {
                                checkIfItsNumber(coordinate1, coordinate1, coordinate1, coordinate1, 1);
                            } catch (NumberFormatException e) {
                                System.out.println("Невенрый ввод, несоответствующий числам");
                                continue;
                            }

                            //заменяю на нормальные переменные-------------------------------
                            int co1i = Integer.parseInt(coordinate1[0]);
                            int co1j = Integer.parseInt(coordinate1[1]);

                            //рисую первый корабль в POlE и TWODEKS--------------------------
                            if (field02.checkPole(co1i, co1j)) {

                                //рисуем корабли в "pole"
                                field02.setPoleXY_pole(co1i, co1j);


                                //рисуем ориол в "twodecks"
                                field02.setOriolXY_twodecks(co1i, co1j);
                                //рисуем поле в "twodecks"
                                field02.setPoleXY_twodecks(co1i, co1j);

                                break;
                            } else {
                                System.out.println("Вы пытаетесь разместить корабль на месте уже существующего");
                                continue;
                            }
                        } else {
                            System.out.println("Вы превысили допустимое, либо уменьшили колличество палуб, во время ввода");
                            continue;
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("блок континуе");
                        continue;
                    }
                }
            }

            //----Однопалубный 1.2-------
            if (true) {

                //----Печатаем текст для Однопалубного(+начало)-------------------
                if (true) {
                    System.out.println();
                    System.out.println("Введите координаты второго Однопалубного корабля, где i-строка и j-столбец: \n(формат: i,j)");
                    field02.polePrint();
                }

                //----второй Однопалубный-----------------------------------------
                while (true) {

                    //----сканирую и превращаю в коорд.-------------------------------
                    File file1_2 = new File("src/Pervii/helper1_2");
                    File fil1_2 = new File("src/Pervii/helpe1_2");
                    try {
                        Scanner scanner = null;
                        if (q1 == 1) {
                            if (w1 == 1) {
                                scanner = new Scanner(file1_2);
                            }
                            if (w1 == 2) {
                                scanner = new Scanner(fil1_2);
                            }
                        } else {
                            scanner = new Scanner(System.in);
                        }
                        String numInserted = scanner.nextLine();
                        String[] linesToSplit = numInserted.split(";");

                        //проверяю на соответствие кол. координат-------------------------
                        if (linesToSplit.length == 1) {

                            //разделяю на запятые---------------------------------------------
                            String[] coordinate1 = linesToSplit[0].split(",");

                            //проверяю если это вoобще числа----------------------------------
                            try {
                                checkIfItsNumber(coordinate1, coordinate1, coordinate1, coordinate1, 1);
                            } catch (NumberFormatException e) {
                                System.out.println("Невенрый ввод, несоответствующий числам");
                                continue;
                            }

                            //заменяю на нормальные переменные-------------------------------
                            int co1i = Integer.parseInt(coordinate1[0]);
                            int co1j = Integer.parseInt(coordinate1[1]);

                            //рисую первый корабль в POlE и TWODEKS--------------------------
                            if (field02.checkPole(co1i, co1j)) {

                                //рисуем корабли в "pole"
                                field02.setPoleXY_pole(co1i, co1j);


                                //рисуем ориол в "twodecks"
                                field02.setOriolXY_twodecks(co1i, co1j);
                                //рисуем поле в "twodecks"
                                field02.setPoleXY_twodecks(co1i, co1j);

                                break;
                            } else {
                                System.out.println("Вы пытаетесь разместить корабль на месте уже существующего");
                                continue;
                            }
                        } else {
                            System.out.println("Вы превысили допустимое, либо уменьшили колличество палуб, во время ввода");
                            continue;
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("блок континуе");
                        continue;
                    }
                }
            }

            //----Однопалубный 1.3-------
            if (true) {

                //----Печатаем текст для Однопалубного(+начало)-------------------
                if (true) {
                    System.out.println();
                    System.out.println("Введите координаты третьего Однопалубного корабля, где i-строка и j-столбец: \n(формат: i,j)");
                    field02.polePrint();
                }

                //----третий Однопалубный-----------------------------------------
                while (true) {

                    //----сканирую и превращаю в коорд.-------------------------------
                    File file1_3 = new File("src/Pervii/helper1_3");
                    File fil1_3 = new File("src/Pervii/helpe1_3");
                    try {
                        Scanner scanner = null;
                        if (q1 == 1) {
                            if (w1 == 1) {
                                scanner = new Scanner(file1_3);
                            }
                            if (w1 == 2) {
                                scanner = new Scanner(fil1_3);
                            }
                        } else {
                            scanner = new Scanner(System.in);
                        }
                        String numInserted = scanner.nextLine();
                        String[] linesToSplit = numInserted.split(";");

                        //проверяю на соответствие кол. координат-------------------------
                        if (linesToSplit.length == 1) {

                            //разделяю на запятые---------------------------------------------
                            String[] coordinate1 = linesToSplit[0].split(",");

                            //проверяю если это вoобще числа----------------------------------
                            try {
                                checkIfItsNumber(coordinate1, coordinate1, coordinate1, coordinate1, 1);
                            } catch (NumberFormatException e) {
                                System.out.println("Невенрый ввод, несоответствующий числам");
                                continue;
                            }

                            //заменяю на нормальные переменные-------------------------------
                            int co1i = Integer.parseInt(coordinate1[0]);
                            int co1j = Integer.parseInt(coordinate1[1]);

                            //рисую первый корабль в POlE и TWODEKS--------------------------
                            if (field02.checkPole(co1i, co1j)) {

                                //рисуем корабли в "pole"
                                field02.setPoleXY_pole(co1i, co1j);


                                //рисуем ориол в "twodecks"
                                field02.setOriolXY_twodecks(co1i, co1j);
                                //рисуем поле в "twodecks"
                                field02.setPoleXY_twodecks(co1i, co1j);

                                break;
                            } else {
                                System.out.println("Вы пытаетесь разместить корабль на месте уже существующего");
                                continue;
                            }
                        } else {
                            System.out.println("Вы превысили допустимое, либо уменьшили колличество палуб, во время ввода");
                            continue;
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("блок континуе");
                        continue;
                    }
                }
            }

            //----Однопалубный 1.4-------
            if (true) {

                //----Печатаем текст для Однопалубного(+начало)-------------------
                if (true) {
                    System.out.println();
                    System.out.println("Введите координаты четвертого Однопалубного корабля, где i-строка и j-столбец: \n(формат: i,j)");
                    field02.polePrint();
                }

                //----четвертый Однопалубный-----------------------------------------
                while (true) {

                    //----сканирую и превращаю в коорд.-------------------------------
                    File file1_4 = new File("src/Pervii/helper1_4");
                    File fil1_4 = new File("src/Pervii/helpe1_4");
                    try {
                        Scanner scanner = null;
                        if (q1 == 1) {
                            if (w1 == 1) {
                                scanner = new Scanner(file1_4);
                            }
                            if (w1 == 2) {
                                scanner = new Scanner(fil1_4);
                            }
                        } else {
                            scanner = new Scanner(System.in);
                        }
                        String numInserted = scanner.nextLine();
                        String[] linesToSplit = numInserted.split(";");

                        //проверяю на соответствие кол. координат-------------------------
                        if (linesToSplit.length == 1) {

                            //разделяю на запятые---------------------------------------------
                            String[] coordinate1 = linesToSplit[0].split(",");

                            //проверяю если это вoобще числа----------------------------------
                            try {
                                checkIfItsNumber(coordinate1, coordinate1, coordinate1, coordinate1, 1);
                            } catch (NumberFormatException e) {
                                System.out.println("Невенрый ввод, несоответствующий числам");
                                continue;
                            }

                            //заменяю на нормальные переменные-------------------------------
                            int co1i = Integer.parseInt(coordinate1[0]);
                            int co1j = Integer.parseInt(coordinate1[1]);

                            //рисую первый корабль в POlE и TWODEKS--------------------------
                            if (field02.checkPole(co1i, co1j)) {

                                //рисуем корабли в "pole"
                                field02.setPoleXY_pole(co1i, co1j);


                                //рисуем ориол в "twodecks"
                                field02.setOriolXY_twodecks(co1i, co1j);
                                //рисуем поле в "twodecks"
                                field02.setPoleXY_twodecks(co1i, co1j);

                                break;
                            } else {
                                System.out.println("Вы пытаетесь разместить корабль на месте уже существующего");
                                continue;
                            }
                        } else {
                            System.out.println("Вы превысили допустимое, либо уменьшили колличество палуб, во время ввода");
                            continue;
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("блок континуе");
                        continue;
                    }
                }
            }
        }



        //---- стираем консоль----
        if (true) {
            for (int i = 0; i < 30; i++) {
                System.out.println();
            }
        }



        //----бой----
        if (true) {
            //----текст----
            System.out.println();
            System.out.println(" ********НАЧНЕМ БОЙ*******");

            //----атака----
            for (int i = 0; i < 4; i++ ) {
                field02.attack("PLAYER 1");
                field01.attack("PLAYER 2");
            }
        }



        //для однопалубного не работает - если ввел лишь одно число


        //показать
        /*//----Конец------------------
        //----Player1
        System.out.println();
        System.out.println("Корабли Player1");
        field01.polePrint();
        //field01.twoDecksPrint();

        //----Player2

        System.out.println();
        System.out.println("Корабли Player2");
        field02.polePrint();
        //field02.twoDecksPrint();
        System.out.println("идеально Максимка");*/
    }
}