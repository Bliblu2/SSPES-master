package bim17.sspes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class WinnerCalculation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static int calculateWinner(int choicePlayerOne, int choicePlayerTwo){
        int winner = 0;
        if (choicePlayerOne == 1 && choicePlayerTwo == 1){
            winner = 0;
        } else if (choicePlayerOne == 1 && choicePlayerTwo == 2){
            winner = 2;
        } else if (choicePlayerOne == 1 && choicePlayerTwo == 3){
            winner = 1;
        } else if (choicePlayerOne == 1 && choicePlayerTwo == 4){
            winner = 1;
        } else if (choicePlayerOne == 1 && choicePlayerTwo == 5){
            winner = 2;
        } else if (choicePlayerOne == 2 && choicePlayerTwo == 1){
            winner = 1;
        } else if (choicePlayerOne == 2 && choicePlayerTwo == 2){
            winner = 0;
        } else if (choicePlayerOne == 2 && choicePlayerTwo == 3){
            winner = 2;
        } else if (choicePlayerOne == 2 && choicePlayerTwo == 4){
            winner = 2;
        } else if (choicePlayerOne == 2 && choicePlayerTwo == 5){
            winner = 2;
        } else if (choicePlayerOne == 3 && choicePlayerTwo == 1){
            winner = 2;
        } else if (choicePlayerOne == 3 && choicePlayerTwo == 2){
            winner = 1;
        } else if (choicePlayerOne == 3 && choicePlayerTwo == 3){
            winner = 0;
        } else if (choicePlayerOne == 3 && choicePlayerTwo == 4){
            winner = 2;
        } else if (choicePlayerOne == 3 && choicePlayerTwo == 5){
            winner = 1;
        } else if (choicePlayerOne == 4 && choicePlayerTwo == 1){
            winner = 2;
        } else if (choicePlayerOne == 4 && choicePlayerTwo == 2){
            winner = 2;
        } else if (choicePlayerOne == 4 && choicePlayerTwo == 3){
            winner = 1;
        } else if (choicePlayerOne == 4 && choicePlayerTwo == 4){
            winner = 0;
        } else if (choicePlayerOne == 4 && choicePlayerTwo == 5){
            winner = 1;
        } else if (choicePlayerOne == 5 && choicePlayerTwo == 1){
            winner = 1;
        } else if (choicePlayerOne == 5 && choicePlayerTwo == 2){
            winner = 1;
        } else if (choicePlayerOne == 5 && choicePlayerTwo == 3){
            winner = 2;
        } else if (choicePlayerOne == 5 && choicePlayerTwo == 4){
            winner = 2;
        } else if (choicePlayerOne == 5 && choicePlayerTwo == 5) {
            winner = 0;
        }
        return winner;
    }

}
