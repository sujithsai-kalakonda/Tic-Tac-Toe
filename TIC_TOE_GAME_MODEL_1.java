package com.company;

import java.util.Scanner;

public class TIC_TOE_GAME_MODEL_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char Result, Player_1, Player_2;

        System.out.println("Positions : ");
        System.out.println("  | 0 | 1 | 2 |");
        System.out.println("  _____________");
        System.out.println("  | 3 | 4 | 5 |");
        System.out.println("  _____________");
        System.out.println("  | 6 | 7 | 8 |");

        System.out.println("Give your symbol 'X' or 'O': ");
        System.out.println("Player-1 Symbol : ");
        Player_1 = in.next().trim().charAt(0);

        System.out.println("Player-2 Symbol : ");
        Player_2 = in.next().trim().charAt(0);


        char[][] Matrix = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Matrix[i][j] = 'n';
            }
        }

        int i;
        for(i = 1; i <= 5; i++){
            System.out.println();
            System.out.println("_____________________________________________________________________");
            System.out.println();
            System.out.println("COUNT = " + i);
            System.out.println("Player-1: ");
            input(Matrix, Player_1);
            Result = Winning_Path(Matrix);
            if (Result == Player_1) {
                System.out.println("_____________ PLAYER - 1 WON _____________");
                System.out.println();
                break;
            }
            else if(Result == Player_2) {
                System.out.println("_____________ PLAYER - 2 WON _____________");
                System.out.println();
                break;
            }

//            cls();

            if(i < 5) {
                System.out.println("Player-2: ");
                input(Matrix, Player_2);
                Result = Winning_Path(Matrix);
                if (Result == Player_1) {
                    System.out.println("_____________ PLAYER - 1 WON _____________");
                    System.out.println();
                    break;
                } else if (Result == Player_2) {
                    System.out.println("_____________ PLAYER - 2 WON _____________");
                    System.out.println();
                    break;
                }

//            cls();
            }
        }

        if(i > 5){
            System.out.println("TIEEEEEEEE");
            System.out.println();
        }

        System.out.println("------------ THANKS FOR PLAYING ----------------");
//        char Result = Winning_Path(Matrix);
    }

    static void input(char[][] ch, char player) {
        Scanner in = new Scanner(System.in);

        int row = 0, col = 0, pos;
        System.out.print("Give position : ");
        pos = in.nextInt();

        if(pos>=0 && pos<=2){
            row = 0;
            col = pos;
        }
        else if(pos>=3 && pos<=5){
            row = 1;
            col = pos - 3;
        }
        else if(pos>=6 && pos<=8){
            row = 2;
            col = pos - 6;
        }

        ch[row][col] = player;

        Tic_Toe_Print(ch);
    }

    static void Tic_Toe_Print(char[][] arr) {  // After every input we have to print this function.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + "  |  ");
            }
            System.out.println();
            System.out.println("________________");
        }
    }

    static char Winning_Path(char[][] arr) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

//                "THIS IS FOR COL'S"
                if (j == 0) {
                    if (arr[i][j] == arr[i][j + 1] && arr[i][j] == arr[i][j + 2] && arr[i][j] != 'n') {
//                        System.out.println("WON");
                        return arr[i][j];
                    }
                }

                if (j == 1) {
                    if (arr[i][j] == arr[i][j - 1] && arr[i][j] == arr[i][j + 1] && arr[i][j] != 'n') {
//                        System.out.println("WON");
                        return arr[i][j];
                    }
                }

                if (j == 2) {
                    if (arr[i][j] == arr[i][j - 1] && arr[i][j] == arr[i][j - 2] && arr[i][j] != 'n') {
//                        System.out.println("WON");
                        return arr[i][j];
                    }
                }
//  __________________________________________________________________________________________________
//                "THIS IS FOR ROWS"

                if (i == 0) {
                    if (arr[i][j] == arr[i + 1][j] && arr[i][j] == arr[i + 2][j] && arr[i][j] != 'n') {
//                        System.out.println("WON");
                        return arr[i][j];
                    }
                }

                if (i == 1) {
                    if (arr[i][j] == arr[i - 1][j] && arr[i][j] == arr[i + 1][j] && arr[i][j] != 'n') {
//                        System.out.println("WON");
                        return arr[i][j];
                    }
                }

                if (i == 2) {
                    if (arr[i][j] == arr[i - 1][j] && arr[i][j] == arr[i - 2][j] && arr[i][j] != 'n') {
//                        System.out.println("WON");
                        return arr[i][j];
                    }
                }
//  __________________________________________________________________________________________________

                if (j == 0 || j == 1 || j == 2) {
                    if (i == 0) {
                        if (j == 0) {
                            if (arr[i][j] == arr[i + 1][j + 1] && arr[i][j] == arr[i + 2][j + 2] && arr[i][j] != 'n') {
//                                System.out.println("WON");
                                return arr[i][j];
                            }
                        }
                        else if (j == 2) {
                            if (arr[i][j] == arr[i + 1][j - 1] && arr[i][j] == arr[i + 2][j - 2] && arr[i][j] != 'n') {
//                                System.out.println("WON");
                                return arr[i][j];
                            }
                        }
                    }

                    if (i == 1) {
                        if (j == 1) {
                            if (arr[i][j] == arr[i - 1][j + 1] && arr[i][j] == arr[i + 1][j + 1] && arr[i][j] != 'n') {
//                                System.out.println("WON");
                                return arr[i][j];
                            }
                            if (arr[i][j] == arr[i - 1][j + 1] && arr[i][j] == arr[i + 1][j - 1] && arr[i][j] != 'n') {
//                                System.out.println("WON");
                                return arr[i][j];
                            }
                        }
                    }

                    if (i == 2) {
                        if (i == 0) {
                            if (j == 0) {
                                if (arr[i][j] == arr[i - 1][j + 1] && arr[i][j] == arr[i - 2][j + 2] && arr[i][j] != 'n') {
//                                    System.out.println("WON");
                                    return arr[i][j];
                                }
                            }
                            else if (j == 2) {
                                if (arr[i][j] == arr[i - 1][j - 1] && arr[i][j] == arr[i - 2][j - 2] && arr[i][j] != 'n') {
//                                    System.out.println("WON");
                                    return arr[i][j];
                                }
                            }
                        }
                    }

                }
            }
        }

        return 'n';
    }

//    public static void cls()  // THIS IS FOR CLEARING SCREEN FOR EVERY INPUT, BUT NOT WORKING
//    {
//        try
//        {
//            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
//        }
//        catch(Exception E)
//        {
//            System.out.println(E);
//        }
//    }

}
