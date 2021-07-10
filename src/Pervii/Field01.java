package Pervii;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Field01 {
    private String[][] pole = new String[12][12];
    private String[][] oriol = new String[12][12];
    private String[][] twoDecks = new String [12][12];
    private String[][] killView = new String [12][12];

    //asheep---
    private final ArrayList<Integer[]> asheep4 = new ArrayList<>();
    private final ArrayList<Integer[]> asheep3_1 = new ArrayList<>();
    private final ArrayList<Integer[]> asheep3_2 = new ArrayList<>();

    private final ArrayList<Integer[]> asheep2_1 = new ArrayList<>();
    private final ArrayList<Integer[]> asheep2_2 = new ArrayList<>();
    private final ArrayList<Integer[]> asheep2_3 = new ArrayList<>();

    private final ArrayList<Integer[]> asheep1_1 = new ArrayList<>();
    private final ArrayList<Integer[]> asheep1_2 = new ArrayList<>();
    private final ArrayList<Integer[]> asheep1_3 = new ArrayList<>();
    private final ArrayList<Integer[]> asheep1_4 = new ArrayList<>();

    //aasheep---(ориол)
    private final ArrayList<Integer[]> aasheep4 = new ArrayList<>();
    private final ArrayList<Integer[]> aasheep3_1 = new ArrayList<>();
    private final ArrayList<Integer[]> aasheep3_2 = new ArrayList<>();

    private final ArrayList<Integer[]> aasheep2_1 = new ArrayList<>();
    private final ArrayList<Integer[]> aasheep2_2 = new ArrayList<>();
    private final ArrayList<Integer[]> aasheep2_3 = new ArrayList<>();

    private final ArrayList<Integer[]> aasheep1_1 = new ArrayList<>();
    private final ArrayList<Integer[]> aasheep1_2 = new ArrayList<>();
    private final ArrayList<Integer[]> aasheep1_3 = new ArrayList<>();
    private final ArrayList<Integer[]> aasheep1_4 = new ArrayList<>();
    private int counter;

    public Field01(){
        this.pole[0][0] = "    ";
        for (int i = 0; i < 12; i++) {
            this.pole[0][i] = String.valueOf(i - 1) + "  ";
        }
        for (int i = 0; i < 12; i++) {
            if (i < 11) {
                this.pole[i][0] = " " + String.valueOf(i - 1) + "  ";
            }else this.pole[i][0] = String.valueOf(i - 1) + "  ";
        }
        for (int i = 1; i < 12; i++) {
            for (int j = 1; j < 12; j++) {
                this.pole[i][j] = "_  ";
            }
        }
        this.pole[0][0] = "    ";

        //---------------------------------------------------------------

        this.oriol[0][0] = "    ";
        for (int i = 0; i < 12; i++) {
            this.oriol[0][i] = String.valueOf(i - 1) + "  ";
        }
        for (int i = 0; i < 12; i++) {
            if (i < 11) {
                this.oriol[i][0] = " " + String.valueOf(i - 1) + "  ";
            }else this.oriol[i][0] = String.valueOf(i - 1) + "  ";
        }
        for (int i = 1; i < 12; i++) {
            for (int j = 1; j < 12; j++) {
                this.oriol[i][j] = "_  ";
            }
        }
        this.oriol[0][0] = "    ";

        //---------------------------------------------------------------

        this.twoDecks[0][0] = "    ";

        this.twoDecks[0][0] = "    ";
        for (int i = 0; i < 12; i++) {
            this.twoDecks[0][i] = String.valueOf(i - 1) + "  ";
        }
        for (int i = 0; i < 12; i++) {
            if (i < 11) {
                this.twoDecks[i][0] = " " + String.valueOf(i - 1) + "  ";
            }else this.twoDecks[i][0] = String.valueOf(i - 1) + "  ";
        }
        for (int i = 1; i < 12; i++) {
            for (int j = 1; j < 12; j++) {
                this.twoDecks[i][j] = "_  ";
            }
        }
        this.twoDecks[0][0] = "    ";

        //---------------------------------------------------------------

        this.killView[0][0] = "    ";

        this.killView[0][0] = "    ";
        for (int i = 0; i < 12; i++) {
            this.killView[0][i] = String.valueOf(i - 1) + "  ";
        }
        for (int i = 0; i < 12; i++) {
            if (i < 11) {
                this.killView[i][0] = " " + String.valueOf(i - 1) + "  ";
            }else this.killView[i][0] = String.valueOf(i - 1) + "  ";
        }
        for (int i = 1; i < 12; i++) {
            for (int j = 1; j < 12; j++) {
                this.killView[i][j] = "_  ";
            }
        }
        this.killView[0][0] = "    ";
    }

    //переписанные методы-----------------------------------------------------
    //рисую все поля POlE, ORIOL и TWODEKS
    public boolean drawPoleAndTwoDecks(ArrayList<Integer[]> listPeredacha) {
        if (listPeredacha.size() == 4) {
            if (this.checkPole(listPeredacha.get(0)[0], listPeredacha.get(0)[1]) && this.checkPole(listPeredacha.get(1)[0], listPeredacha.get(1)[1]) &&
                    this.checkPole(listPeredacha.get(2)[0], listPeredacha.get(2)[1]) && this.checkPole(listPeredacha.get(3)[0], listPeredacha.get(3)[1])) {

                //рисуем корабли в "pole"
                for (int i = 0; i < listPeredacha.size(); i++) {
                    this.setPoleXY_pole(listPeredacha.get(i)[0], listPeredacha.get(i)[1]);
                }
                //рисуем ориол в "twodecks"
                for (int i = 0; i < listPeredacha.size(); i++) {
                    this.setOriolXY_twodecks(listPeredacha.get(i)[0], listPeredacha.get(i)[1]);
                }
                //рисуем поле в "twodecks"
                for (int i = 0; i < listPeredacha.size(); i++) {
                    this.setPoleXY_twodecks(listPeredacha.get(i)[0], listPeredacha.get(i)[1]);
                }

                return true;
            } else return false;
        }
        if (listPeredacha.size() == 3) {
            if (this.checkPole(listPeredacha.get(0)[0], listPeredacha.get(0)[1]) && this.checkPole(listPeredacha.get(1)[0], listPeredacha.get(1)[1]) &&
                    this.checkPole(listPeredacha.get(2)[0], listPeredacha.get(2)[1])) {

                //рисуем корабли в "pole"
                for (int i = 0; i < listPeredacha.size(); i++) {
                    this.setPoleXY_pole(listPeredacha.get(i)[0], listPeredacha.get(i)[1]);
                }
                //рисуем ориол в "twodecks"
                for (int i = 0; i < listPeredacha.size(); i++) {
                    this.setOriolXY_twodecks(listPeredacha.get(i)[0], listPeredacha.get(i)[1]);
                }
                //рисуем поле в "twodecks"
                for (int i = 0; i < listPeredacha.size(); i++) {
                    this.setPoleXY_twodecks(listPeredacha.get(i)[0], listPeredacha.get(i)[1]);
                }

                return true;
            } else return false;
        }
        if (listPeredacha.size() == 2) {
            if (this.checkPole(listPeredacha.get(0)[0], listPeredacha.get(0)[1]) && this.checkPole(listPeredacha.get(1)[0], listPeredacha.get(1)[1])) {

                //рисуем корабли в "pole"
                for (int i = 0; i < listPeredacha.size(); i++) {
                    this.setPoleXY_pole(listPeredacha.get(i)[0], listPeredacha.get(i)[1]);
                }//this.newList(co1i, co1j, co2i, co2j, co3i, co3j, co4i, co4j);


                //рисуем ориол в "twodecks"
                for (int i = 0; i < listPeredacha.size(); i++) {
                    this.setOriolXY_twodecks(listPeredacha.get(i)[0], listPeredacha.get(i)[1]);
                }

                //рисуем поле в "twodecks"
                for (int i = 0; i < listPeredacha.size(); i++) {
                    this.setPoleXY_twodecks(listPeredacha.get(i)[0], listPeredacha.get(i)[1]);
                }

                return true;
            } else return false;
        }
        if (listPeredacha.size() == 1) {
            if (this.checkPole(listPeredacha.get(0)[0], listPeredacha.get(0)[1])) {

                //рисуем корабли в "pole"
                for (int i = 0; i < listPeredacha.size(); i++) {
                    this.setPoleXY_pole(listPeredacha.get(i)[0], listPeredacha.get(i)[1]);
                }//this.newList(co1i, co1j, co2i, co2j, co3i, co3j, co4i, co4j);


                //рисуем ориол в "twodecks"
                for (int i = 0; i < listPeredacha.size(); i++) {
                    this.setOriolXY_twodecks(listPeredacha.get(i)[0], listPeredacha.get(i)[1]);
                }

                //рисуем поле в "twodecks"
                for (int i = 0; i < listPeredacha.size(); i++) {
                    this.setPoleXY_twodecks(listPeredacha.get(i)[0], listPeredacha.get(i)[1]);
                }

                return true;
            } else return false;
        }
        return false;
    }
    //------------------------------------------------------------------------


    //рисуем корабль
    public void setPoleXY_pole(int i, int j) {
        if (((j + 1) > 0 && (i + 1) > 0) && ((j + 1) < 12 && (i + 1) < 12)) {
            this.pole[i + 1][j + 1] = "*  ";
        }
        if (true) {
            if (counter == 0) {
                asheep4.add(0, new Integer[]{i, j});
                aasheep4.add(0, new Integer[]{i, j});
            }
            if (counter == 1) {
                asheep4.add(1, new Integer[]{i, j});
                aasheep4.add(1, new Integer[]{i, j});
            }
            if (counter == 2) {
                asheep4.add(2, new Integer[]{i, j});
                aasheep4.add(2, new Integer[]{i, j});
            }
            if (counter == 3) {
                asheep4.add(3, new Integer[]{i, j});
                aasheep4.add(3, new Integer[]{i, j});
            }



            if (counter == 4) {
                asheep3_1.add(new Integer[]{i, j});
                aasheep3_1.add(new Integer[]{i, j});
            }
            if (counter == 5) {
                asheep3_1.add(new Integer[]{i, j});
                aasheep3_1.add(new Integer[]{i, j});
            }
            if (counter == 6) {
                asheep3_1.add(new Integer[]{i, j});
                aasheep3_1.add(new Integer[]{i, j});
            }

            if (counter == 7) {
                asheep3_2.add(new Integer[]{i, j});
                aasheep3_2.add(new Integer[]{i, j});
            }
            if (counter == 8) {
                asheep3_2.add(new Integer[]{i, j});
                aasheep3_2.add(new Integer[]{i, j});
            }
            if (counter == 9) {
                asheep3_2.add(new Integer[]{i, j});
                aasheep3_2.add(new Integer[]{i, j});
            }



            if (counter == 10) {
                asheep2_1.add(new Integer[]{i, j});
                aasheep2_1.add(new Integer[]{i, j});
            }
            if (counter == 11) {
                asheep2_1.add(new Integer[]{i, j});
                aasheep2_1.add(new Integer[]{i, j});
            }

            if (counter == 12) {
                asheep2_2.add(new Integer[]{i, j});
                aasheep2_2.add(new Integer[]{i, j});
            }
            if (counter == 13) {
                asheep2_2.add(new Integer[]{i, j});
                aasheep2_2.add(new Integer[]{i, j});
            }

            if (counter == 14) {
                asheep2_3.add(new Integer[]{i, j});
                aasheep2_3.add(new Integer[]{i, j});
            }
            if (counter == 15) {
                asheep2_3.add(new Integer[]{i, j});
                aasheep2_3.add(new Integer[]{i, j});
            }



            if (counter == 16) {
                asheep1_1.add(new Integer[]{i, j});
                aasheep1_1.add(new Integer[]{i, j});
            }
            if (counter == 17) {
                asheep1_2.add(new Integer[]{i, j});
                aasheep1_2.add(new Integer[]{i, j});
            }
            if (counter == 18) {
                asheep1_3.add(new Integer[]{i, j});
                aasheep1_3.add(new Integer[]{i, j});
            }
            if (counter == 19) {
                asheep1_4.add(new Integer[]{i, j});
                aasheep1_4.add(new Integer[]{i, j});
            }

            counter ++;
        }
    }
    //рисуем ориол и корабль
    public void setOriolXY_twodecks(int i, int j){
        /*        if(((i + 1) - 1 > 0 && (j + 1) - 1 > 0) && ((i + 1) - 1 < 12 && (j + 1) - 1 < 12)) {
            if (this.twoDecks[(i + 1) - 1][(j + 1) - 1] == "_  ")
                this.twoDecks[(i + 1) - 1][(j + 1) - 1] = "o  ";
        }*/
        if(((i + 1) - 1 > 0 && (j + 1) > 0) && ((i + 1) - 1 < 12 && (j + 1) < 12)) {
            if (this.pole[(i + 1) - 1][(j + 1)] == "_  ")
                this.twoDecks[(i + 1) - 1][(j + 1)] = "o  ";
        }
        /*if(((i + 1) - 1 > 0 && (j + 1) + 1 > 0) && ((i + 1) - 1 < 12 && (j + 1) + 1 < 12)) {
            if (this.pole[(i + 1) - 1][(j + 1) + 1] == "_  ")
                this.twoDecks[(i + 1) - 1][(j + 1) + 1] = "o  ";
        }*/


        if(((i + 1) > 0 && (j + 1) - 1 > 0) && ((i + 1) < 12 && (j + 1) - 1 < 12)) {
            if (this.pole[(i + 1)][(j + 1) - 1] == "_  ")
                this.twoDecks[(i + 1)][(j + 1) - 1] = "o  ";
        }
        if(((i + 1) > 0 && (j + 1) > 0) && ((i + 1) < 12 && (j + 1) < 12)) {
            if (this.pole[(i + 1)][(j + 1)] == "_  ")
                this.twoDecks[(i + 1)][(j + 1)] = "o  ";
        }
        if(((i + 1) > 0 && (j + 1) + 1 > 0) && ((i + 1) < 12 && (j + 1) + 1 < 12)) {
            if (this.pole[(i + 1)][(j + 1) + 1] == "_  ")
                this.twoDecks[(i + 1)][(j + 1) + 1] = "o  ";
        }


        /*if(((i + 1) + 1 > 0 && (j + 1) - 1 > 0) && ((i + 1) + 1 < 12 && (j + 1) - 1 < 12)) {
            if (this.pole[(i + 1) + 1][(j + 1) - 1] == "_  ")
                this.twoDecks[(i + 1) + 1][(j + 1) - 1] = "o  ";
        }*/
        if(((i + 1) + 1 > 0 && (j + 1) > 0) && ((i + 1) + 1 < 12 && (j + 1) < 12)) {
            if (this.pole[(i + 1) + 1][(j + 1)] == "_  ")
                this.twoDecks[(i + 1) + 1][(j + 1)] = "o  ";
        }
        /*if(((i + 1) + 1 > 0 && (j + 1) + 1 > 0) && ((i + 1) + 1 < 12 && (j + 1) + 1 < 12)) {
            if (this.pole[(i + 1) + 1][(j + 1) + 1] == "_  ")
                this.twoDecks[(i + 1) + 1][(j + 1) + 1] = "o  ";
        }*/
    }
    public void setPoleXY_twodecks(int i, int j) {
        if (((j + 1) > 0 && (i + 1) > 0) && ((j + 1) < 12 && (i + 1) < 12))
            this.twoDecks[i + 1][j + 1] = "*  ";
    }
    //рисуем ориол и корабль (атаки) + рисуем промах
    public void setOriolKillView(int i, int j){
        if(((i + 1) - 1 > 0 && (j + 1) > 0) && ((i + 1) - 1 < 12 && (j + 1) < 12)) {
            if (this.pole[(i + 1) - 1][(j + 1)] == "_  ")
                this.killView[(i + 1) - 1][(j + 1)] = "o  ";
        }


        if(((i + 1) > 0 && (j + 1) - 1 > 0) && ((i + 1) < 12 && (j + 1) - 1 < 12)) {
            if (this.pole[(i + 1)][(j + 1) - 1] == "_  ")
                this.killView[(i + 1)][(j + 1) - 1] = "o  ";
        }
        if(((i + 1) > 0 && (j + 1) > 0) && ((i + 1) < 12 && (j + 1) < 12)) {
            if (this.pole[(i + 1)][(j + 1)] == "_  ")
                this.killView[(i + 1)][(j + 1)] = "o  ";
        }
        if(((i + 1) > 0 && (j + 1) + 1 > 0) && ((i + 1) < 12 && (j + 1) + 1 < 12)) {
            if (this.pole[(i + 1)][(j + 1) + 1] == "_  ")
                this.killView[(i + 1)][(j + 1) + 1] = "o  ";
        }


        if(((i + 1) + 1 > 0 && (j + 1) > 0) && ((i + 1) + 1 < 12 && (j + 1) < 12)) {
            if (this.pole[(i + 1) + 1][(j + 1)] == "_  ")
                this.killView[(i + 1) + 1][(j + 1)] = "o  ";
        }
    }
    public void setPoleKillView(int i, int j) {
        if (((j + 1) > 0 && (i + 1) > 0) && ((j + 1) < 12 && (i + 1) < 12))
            this.killView[i + 1][j + 1] = "*  ";
    }
    public void setPoleMissView(int i, int j) {
        if (((j + 1) > 0 && (i + 1) > 0) && ((j + 1) < 12 && (i + 1) < 12))
            this.killView[i + 1][j + 1] = "/  ";
    }


    //проверяю, если не поверх другого корабля
    public boolean checkPole(int i, int j) {
        /*if (((i + 1) - 1 > 0 && (j + 1) - 1 > 0) && ((i + 1) - 1 < 12 && (j + 1) - 1 < 12)) {
            if (this.pole[(i + 1) - 1][(j + 1) - 1] == "*  ") {
                return false;
            }
        }*/
        if (((i + 1) - 1 > 0 && (j + 1) > 0) && ((i + 1) - 1 < 12 && (j + 1) < 12)) {
            if (this.pole[(i + 1) - 1][(j + 1)] == "*  ") {
                return false;
            }
        }
        /*if (((i + 1) - 1 > 0 && (j + 1) + 1 > 0) && ((i + 1) - 1 < 12 && (j + 1) + 1 < 12)) {
            if (this.pole[(i + 1) - 1][(j + 1) + 1] == "*  ") {
                return false;
            }
        }*/


        if(((i + 1) > 0 && (j + 1) - 1 > 0) && ((i + 1) < 12 && (j + 1) - 1 < 12)) {
            if (this.pole[(i + 1)][(j + 1) - 1] == "*  ") {
                return false;
            }
        }
        if(((i + 1) > 0 && (j + 1) > 0) && ((i + 1) < 12 && (j + 1) < 12)) {
            if (this.pole[(i + 1)][(j + 1)] == "*  ") {
                return false;
            }
        }
        if(((i + 1) > 0 && (j + 1) + 1 > 0) && ((i + 1) < 12 && (j + 1) + 1 < 12)) {
            if (this.pole[(i + 1)][(j + 1) + 1] == "*  ") {
                return false;
            }
        }


        /*if(((i + 1) + 1 > 0 && (j + 1) - 1 > 0) && ((i + 1) + 1 < 12 && (j + 1) - 1 < 12)) {
            if (this.pole[(i + 1) + 1][(j + 1) - 1] == "*  ") {
                return false;
            }
        }*/
        if(((i + 1) + 1 > 0 && (j + 1) > 0) && ((i + 1) + 1 < 12 && (j + 1) < 12)) {
            if (this.pole[(i + 1) + 1][(j + 1)] == "*  ") {
                return false;
            }
        }
        /*if(((i + 1) + 1 > 0 && (j + 1) + 1 > 0) && ((i + 1) + 1 < 12 && (j + 1) + 1 < 12)) {
            if (this.pole[(i + 1) + 1][(j + 1) + 1] == "*  ") {
                return false;
            }
        }*/


        return true;
    }




    //атака --------full--
    public void attack(String player) {

        //----текст----
        System.out.println();
        System.out.println("*********(" + player +"!)*********");
        System.out.println("Введите координаты первого выстрела, где i-строка и j-столбец: \n" + "(формат: i,j)");
        this.killviewPrint();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                String numInserted = scanner.nextLine();
                String[] coordinate1 = numInserted.split(",");

                //проверяю если это вoобще числа----
                try {
                    Task20_2new.checkIfItsNumber(coordinate1, coordinate1, coordinate1, coordinate1, 1);
                } catch (NumberFormatException e) {
                    System.out.println("Невенрый ввод, несоответствующий числам");
                    continue;
                }

                //----заменяю на нормальные переменные----
                int co1i = Integer.parseInt(coordinate1[0]);
                int co1j = Integer.parseInt(coordinate1[1]);

                //----атака----
                if (this.pole[co1i + 1][co1j + 1].equals("*  ")) {
                    setPoleKillView(co1i, co1j);

                    //--ищу-----------------------
                    this.checkWhere(co1i, co1j);


                    this.killviewPrint();

                    continue;
                }
                if (this.pole[co1i + 1][co1j + 1].equals("_  ")) {
                    System.out.println("mimo");
                    setPoleMissView(co1i, co1j);
                    break;
                }

            } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Неверный ввод!");
                continue;
            }
        }
    }
    //дописать по уже попавшему месту


    public void checkWhereHelper(ArrayList<Integer[]> asheep, ArrayList<Integer[]> aasheep, int l){
        if (asheep.isEmpty()){
            System.out.println("убил");
            for (int i = 0; i < l; i++) {
                this.setOriolKillView(aasheep.get(i)[0], aasheep.get(i)[1]);
            }
        }else System.out.println("ранил");
    }
    public void checkWhere(int i, int j){
        for (int k = 0; k < asheep4.size(); k++) {
            if (asheep4.get(k)[0] == i && asheep4.get(k)[1] == j){
                asheep4.remove(asheep4.get(k));
                checkWhereHelper(asheep4, aasheep4, 4);
            }
        }

        for (int k = 0; k < asheep3_1.size(); k++) {
            if (asheep3_1.get(k)[0] == i && asheep3_1.get(k)[1] == j){
                asheep3_1.remove(asheep3_1.get(k));
                checkWhereHelper(asheep3_1, aasheep3_1, 3);
            }
        }
        for (int k = 0; k < asheep3_2.size(); k++) {
            if (asheep3_2.get(k)[0] == i && asheep3_2.get(k)[1] == j){
                asheep3_2.remove(asheep3_2.get(k));
                checkWhereHelper(asheep3_2, aasheep3_2, 3);
            }
        }

        for (int k = 0; k < asheep2_1.size(); k++) {
            if (asheep2_1.get(k)[0] == i && asheep2_1.get(k)[1] == j){
                System.out.println("privet");
                asheep2_1.remove(asheep2_1.get(k));
                checkWhereHelper(asheep2_1, aasheep2_1, 2);
            }
        }
        for (int k = 0; k < asheep2_2.size(); k++) {
            if (asheep2_2.get(k)[0] == i && asheep2_2.get(k)[1] == j){
                System.out.println("privet");
                asheep2_2.remove(asheep2_2.get(k));
                checkWhereHelper(asheep2_2, aasheep2_2, 2);
            }
        }
        for (int k = 0; k < asheep2_3.size(); k++) {
            if (asheep2_3.get(k)[0] == i && asheep2_3.get(k)[1] == j){
                System.out.println("privet");
                asheep2_3.remove(asheep2_3.get(k));
                checkWhereHelper(asheep2_3, aasheep2_3, 2);
            }
        }

        for (int k = 0; k < asheep1_1.size(); k++) {
            if (asheep1_1.get(k)[0] == i && asheep1_1.get(k)[1] == j){
                System.out.println("privet");
                asheep1_1.remove(asheep1_1.get(k));
                checkWhereHelper(asheep1_1, aasheep1_1, 1);
            }
        }
        for (int k = 0; k < asheep1_2.size(); k++) {
            if (asheep1_2.get(k)[0] == i && asheep1_2.get(k)[1] == j){
                System.out.println("privet");
                asheep1_2.remove(asheep1_2.get(k));
                checkWhereHelper(asheep1_2, aasheep1_2, 1);
            }
        }
        for (int k = 0; k < asheep1_3.size(); k++) {
            if (asheep1_3.get(k)[0] == i && asheep1_3.get(k)[1] == j){
                System.out.println("privet");
                asheep1_3.remove(asheep1_3.get(k));
                checkWhereHelper(asheep1_3, aasheep1_3, 1);
            }
        }
        for (int k = 0; k < asheep1_4.size(); k++) {
            if (asheep1_4.get(k)[0] == i && asheep1_4.get(k)[1] == j){
                System.out.println("privet");
                asheep1_4.remove(asheep1_4.get(k));
                checkWhereHelper(asheep1_4, aasheep1_4, 1);
            }
        }
    }


    //печатаю TWODECKS
    public void twoDecksPrint(){
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.print(this.twoDecks[i][j]);
            }
            System.out.println();
        }
    }
    //печатаю POLE
    public void polePrint(){
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.print(this.pole[i][j]);
            }
            System.out.println();
        }
    }
    //печатаю killview
    public void killviewPrint(){
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.print(this.killView[i][j]);
            }
            System.out.println();
        }
    }
}
