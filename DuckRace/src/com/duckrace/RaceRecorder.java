package com.duckrace;

import java.io.IOException;
import java.util.Scanner;

class RaceRecorder {
    public static void main(String[] args) {
        Board board = new Board();

        String input = getInput(InputType.INT);
        int id = Integer.parseInt(input);
        input = getInput(InputType.REWARD);
        Reward prize = Reward.valueOf(input);
        board.update(id, prize);

        while(input != "Q"){
            input = getInput(InputType.OPTION);
            System.out.println("input = " + input);
            if("B".equalsIgnoreCase(input)){
                board.printBoardToConsole();
            } else if ("S".equalsIgnoreCase(input)) {
                saveBoard(board);
            } else if ("Q".equalsIgnoreCase(input)){
                System.out.println("Have a nice day!");
            }
        }


    }


    private static void saveBoard(Board board) {
        try {
            board.saveRacerMap();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getInput(InputType type) {
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        String input = null;
        while(!valid) {
            System.out.println(getPrompt(type));
            input = scanner.nextLine();
            switch (type){
                case INT:
                    try {
                        Integer.parseInt(input);
                        valid = true;
                    } catch (NumberFormatException e) {
                        valid = false;
                    }
                    break;
                case REWARD:
                    if(input.startsWith("d")) input = "DEBIT_CARD";
                    if(input.startsWith("p")) input = "PRIZES";
                    try{
                        Reward.valueOf(input);
                        valid = true;
                    } catch (IllegalArgumentException e){
                        e.printStackTrace();
                        valid = false;
                    }
                    break;
                case OPTION:
                    if(input.startsWith("b") || input.startsWith("B")){
                        input = "B";
                        valid = true;
                    } else if (input.startsWith("s") || input.startsWith("S")) {
                        input = "S";
                        valid = true;
                    } else if (input.startsWith("q") || input.startsWith("Q")) {
                        input = "Q";
                        valid = true;
                    }
                    break;
            }
        }
        return input;
    }

    private static String getPrompt(InputType type) {
        String prompt = null;
        switch (type) {
            case INT:
                prompt = "Enter the number of the winner: ";
                break;
            case REWARD:
                prompt = "Enter the desired prize (DEBIT_CARD (d), PRIZES (p)):";
                break;
            case OPTION:
                prompt = "Select from the following options: \n b: Show Board\n s: Save Board\n q: Quit";
        }
        return prompt;
    }

    public static enum InputType {INT, REWARD, OPTION}
}