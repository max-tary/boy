package Pervii;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Field01 {
    private String[][] pole = new String[12][12];
    private String[][] oriol = new String[12][12];
    private String[][] fourDecks = new String [12][12];
    private String[][] twoDecks = new String [12][12];

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
    }

    //???????????? ??????????????
    public void setPoleXY_pole(int i, int j) {
        if (((j + 1) > 0 && (i + 1) > 0) && ((j + 1) < 12 && (i + 1) < 12))
            this.pole[i + 1][j + 1] = "*  ";
    }
    //???????????? ?????????? ?? ??????????????
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


    //????????????????, ???????? ???? ???????????? ?????????????? ??????????????
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


    //????????????????, ???????? ???? ??????????
    public boolean checkPoleKill(int i, int j){
        if (this.pole[i+1][j+1].equals("*  ")) {
            System.out.println("eeee");
            return true;
        }
        if (this.pole[i+1][j+1].equals("_  ")) {
            System.out.println("mimo");
            return false;
        }
        return false;
    }

    //?????????? P1
    public void attack(String player) {

        //----??????????----
        System.out.println();
        System.out.println("*********(" + player +"!)*********");
        System.out.println("?????????????? ???????????????????? ?????????????? ????????????????, ?????? i-???????????? ?? j-??????????????: \n" + "(????????????: i,j)");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                String numInserted = scanner.nextLine();
                String[] coordinate1 = numInserted.split(",");

                //???????????????? ???????? ?????? ??o???????? ??????????----
                try {
                    Task20_2new.checkIfItsNumber(coordinate1, coordinate1, coordinate1, coordinate1, 1);
                } catch (NumberFormatException e) {
                    System.out.println("???????????????? ????????, ?????????????????????????????????? ????????????");
                    continue;
                }

                //----?????????????? ???? ???????????????????? ????????????????????----
                int co1i = Integer.parseInt(coordinate1[0]);
                int co1j = Integer.parseInt(coordinate1[1]);

                //----??????????----
                if (this.pole[co1i + 1][co1j + 1].equals("*  ")) {
                    System.out.println("eeee");
                    continue;
                }
                if (this.pole[co1i + 1][co1j + 1].equals("_  ")) {
                    System.out.println("mimo");
                    break;
                }

            } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                System.out.println("???????????????? ????????!");
                continue;
            }
        }
    }



    //?????????????? TWODECKS
    public void twoDecksPrint(){
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.print(this.twoDecks[i][j]);
            }
            System.out.println();
        }
    }
    //?????????????? POLE
    public void polePrint(){
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.print(this.pole[i][j]);
            }
            System.out.println();
        }
    }

    //setOriolFust(){}
    /*public void setOreolFust(int i, int j) {
        if(((i + 1) - 1 > 0 && (j + 1) - 1 > 0) && ((i + 1) - 1 < 12 && (j + 1) - 1 < 12))
            this.oriol[(i + 1) - 1][(j + 1) - 1] = "o  ";
        if(((i + 1) - 1 > 0 && (j + 1) > 0) && ((i + 1) - 1 < 12 && (j + 1) < 12))
            this.oriol[(i + 1) - 1][(j + 1)] = "o  ";
        if(((i + 1) - 1 > 0 && (j + 1) + 1 > 0) && ((i + 1) - 1 < 12 && (j + 1) + 1 < 12))
            this.oriol[(i + 1) - 1][(j + 1) + 1] = "o  ";

        if(((i + 1) > 0 && (j + 1) - 1 > 0) && ((i + 1) < 12 && (j + 1) - 1 < 12))
            this.oriol[(i + 1)][(j + 1) - 1] = "o  ";
        if(((i + 1) > 0 && (j + 1) > 0) && ((i + 1) < 12 && (j + 1) < 12))
            this.oriol[(i + 1)][(j + 1)] = "o  ";
        if(((i + 1) > 0 && (j + 1) + 1 > 0) && ((i + 1) < 12 && (j + 1) + 1 < 12))
            this.oriol[(i + 1)][(j + 1) + 1] = "o  ";

        if(((i + 1) + 1 > 0 && (j + 1) - 1 > 0) && ((i + 1) + 1 < 12 && (j + 1) - 1 < 12))
            this.oriol[(i + 1) + 1][(j + 1) - 1] = "o  ";
        if(((i + 1) + 1 > 0 && (j + 1) > 0) && ((i + 1) + 1 < 12 && (j + 1) < 12))
            this.oriol[(i + 1) + 1][(j + 1)] = "o  ";
        if(((i + 1) + 1 > 0 && (j + 1) + 1 > 0) && ((i + 1) + 1 < 12 && (j + 1) + 1 < 12))
            this.oriol[(i + 1) + 1][(j + 1) + 1] = "o  ";
        */
    /*{
            if(((i + 1) - 1 > 0 && (j + 1) - 1 > 0) && ((i + 1) - 1 < 12 && (j + 1) - 1 < 12))
                this.oreol[(i + 1) - 1][(j + 1) - 1] = "o  ";
            this.twoDecks[(i + 1) - 1][(j + 1) - 1] = "o  ";
            if(((i + 1) - 1 > 0 && (j + 1) > 0) && ((i + 1) - 1 < 12 && (j + 1) < 12))
                this.oreol[(i + 1) - 1][(j + 1)] = "o  ";
            this.twoDecks[(i + 1) - 1][(j + 1)] = "o  ";
            if(((i + 1) - 1 > 0 && (j + 1) + 1 > 0) && ((i + 1) - 1 < 12 && (j + 1) + 1 < 12))
                this.oreol[(i + 1) - 1][(j + 1) + 1] = "o  ";
            this.twoDecks[(i + 1) - 1][(j + 1) + 1] = "o  ";

            if(((i + 1) > 0 && (j + 1) - 1 > 0) && ((i + 1) < 12 && (j + 1) - 1 < 12))
                this.oreol[(i + 1)][(j + 1) - 1] = "o  ";
            this.twoDecks[(i + 1)][(j + 1) - 1] = "o  ";
            if(((i + 1) > 0 && (j + 1) > 0) && ((i + 1) < 12 && (j + 1) < 12))
                this.oreol[(i + 1)][(j + 1)] = "o  ";
            this.twoDecks[(i + 1)][(j + 1)] = "o  ";
            if(((i + 1) > 0 && (j + 1) + 1 > 0) && ((i + 1) < 12 && (j + 1) + 1 < 12))
                this.oreol[(i + 1)][(j + 1) + 1] = "o  ";
            this.twoDecks[(i + 1)][(j + 1) + 1] = "o  ";

            if(((i + 1) + 1 > 0 && (j + 1) - 1 > 0) && ((i + 1) + 1 < 12 && (j + 1) - 1 < 12))
                this.oreol[(i + 1) + 1][(j + 1) - 1] = "o  ";
            this.twoDecks[(i + 1) + 1][(j + 1) - 1] = "o  ";
            if(((i + 1) + 1 > 0 && (j + 1) > 0) && ((i + 1) + 1 < 12 && (j + 1) < 12))
                this.oreol[(i + 1) + 1][(j + 1)] = "o  ";
            this.twoDecks[(i + 1) + 1][(j + 1)] = "o  ";
            if(((i + 1) + 1 > 0 && (j + 1) + 1 > 0) && ((i + 1) + 1 < 12 && (j + 1) + 1 < 12))
                this.oreol[(i + 1) + 1][(j + 1) + 1] = "o  ";
            this.twoDecks[(i + 1) + 1][(j + 1) + 1] = "o  ";
        }*//*
    }*/



}
