package com.example.android.tictactoe;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameLogic {
    private final int [][] gameBoard;
    private Button playAgainBTN;
    private Button homeBTN;
    private TextView playerTurn;
    private String[] playerNames = {"Player 1, Player 2"};

    private int player = 1 ;


    GameLogic(){
        gameBoard = new int [3][3];
        for(int r= 0; r<3; r++){
            for (int c= 0; c<3; c++){
                gameBoard[r][c] = 0;
            }
        }
    }
    @SuppressLint("SetTextI18n")
    public boolean updateGameBoard(int row, int col) {
        if (gameBoard[row - 1][col - 1] == 0) {
            gameBoard[row-1][col-1] = player;

            if (player == 1){
                playerTurn.setText((playerNames[1] + "Turn"));
            }
            else{
                playerTurn.setText((playerNames[0] + "Turn"));
            }
            return true;

        }
        else {
            return false;
        }
    }
    @SuppressLint("SetTextI18n")
    public boolean winnerCheck() {
        boolean isWinner = false;
        for (int r = 0; r < 3; r++) {
            if (gameBoard[r][0] == gameBoard[r][1] && gameBoard[r][0] == gameBoard[r][2] &&
                    gameBoard[r][0] != 0) {
                isWinner = true;
                break;
            }
        }
        for (int c = 0; c < 3; c++) {
            if (gameBoard[c][0] == gameBoard[c][1] && gameBoard[c][0] == gameBoard[c][2] &&
                    gameBoard[c][0] != 0) {
                isWinner = true;
                break;
            }
        }
        if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2] &&
                gameBoard[0][0] != 0) {
            isWinner = true;
        }
        if (gameBoard[2][0] == gameBoard[1][1] && gameBoard[2][0] == gameBoard[0][2] &&
                gameBoard[2][0] != 0) {
            isWinner = true;
        }
        int boardFilled = 0;
        for (int r=0; r<3; r++){
            for (int c=0; c<3; c++){
              if (gameBoard[r][c] != 0){
                  boardFilled += 1;

              }
            }
        }
        if (isWinner){
            playAgainBTN.setVisibility(View.VISIBLE);
            homeBTN.setVisibility(View.VISIBLE);
            playerTurn.setText((playerNames[player-1] + " Won"));
            return true;

        }
        else if(boardFilled == 9){
            playAgainBTN.setVisibility(View.VISIBLE);
            homeBTN.setVisibility(View.VISIBLE);
            playerTurn.setText("Tie Game");
            return true;

        }
        else{
            return false;
        }
    }
    @SuppressLint("SetTextI18n")
    public void resetGame(){
        for(int r= 0; r<3; r++){
            for (int c= 0; c<3; c++){
                gameBoard[r][c] = 0;
            }
        }
        player =  1 ;
        playAgainBTN.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);
        playerTurn.setText((playerNames[0] + "turn"));

    }
    public void setPlayAgainBTN(Button playAgainBTN){
        this.playAgainBTN = playAgainBTN;
    }
    public void setHomeBTN(Button homeBTN){
        this.homeBTN = homeBTN;
    }
    public void setPlayerTurn(TextView playerTurn){
        this.playerTurn = playerTurn;
    }
    public void setPlayerNames(String[] playerNames){
        this.playerNames = playerNames;
    }

    public int [][] getGameBoard() {
        return gameBoard;
    }
    public void setPlayer(int player){
        this.player = player;
    }
    public int getPlayer() {
        return player;
    }
}
