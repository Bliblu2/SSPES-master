package bim17.sspes;



import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    ImageButton btnScissor, btnRock, btnPaper, btnLizard, btnSpock;
    TextView textStatus, textResult, textLennard;
    Random rndGen; //Zufallsgenerator
    public int playhero, playnemesis; //Variable fuer Auswahl des Computers
    int turns, compwin, playerwin;
    int player1ID, player2ID;
    DataStorage dsLeonard;
    SharedPreferences sharedLeonard;
  /*  String scissors = "Scissors";
    String rock = getString(R.string.rock);
    String paper = getString(R.string.paper);
    String lizard = getString(R.string.lizard);
    String spock = getString(R.string.spock);
    String winsTxt = getString(R.string.winsTxt);
    String draw2 = getString(R.string.draw);
    String cuts =getString(R.string.cuts);
    String vaporizes = getString(R.string.vaporizes);
    String covers = getString(R.string.covers);
    String decapitates = getString(R.string.decapitates);
    String eats = getString(R.string.eats);
    String crushes = getString(R.string.crushes);
    String smashes = getString(R.string.smashes);
    String poisens = getString(R.string.poisons);
    String disproves = getString(R.string.disproves);
    String crushesS = getString(R.string.crushesS);
    String you = getString(R.string.you);
    String turn = getString(R.string.turn);
    String score = getString(R.string.score);
    */
    String nemesis;
    String hero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        btnScissor = findViewById(R.id.btnScissor);
        btnRock = findViewById(R.id.btnRock);
        btnPaper = findViewById(R.id.btnPaper);
        btnLizard = findViewById(R.id.btnLizard);
        btnSpock = findViewById(R.id.btnSpock);
        textStatus = findViewById(R.id.textStatus);
        textResult = findViewById(R.id.textResult);
        textLennard = findViewById(R.id.textLennard);
        rndGen = new Random();
        turns = 0;
        sharedLeonard = getSharedPreferences("myData", MODE_PRIVATE);
        erbitten();
        player1ID = dsLeonard.getPlayer1();
        player2ID = dsLeonard.getPlayer2();

        if (player2ID == 6) {
            nemesis = getString(R.string.leonard);
        } else if (player2ID == 7) {
            nemesis = getString(R.string.penny);
        } else if (player2ID == 8) {
            nemesis = getString(R.string.sheldon);
        } else if (player2ID == 1) {
            nemesis = dsLeonard.getSlot1name();
        } else if (player2ID == 2) {
            nemesis = dsLeonard.getSlot2name();
        } else if (player2ID == 3) {
            nemesis = dsLeonard.getSlot3name();
        } else if (player2ID == 4) {
            nemesis = dsLeonard.getSlot4name();
        } else if (player2ID == 5) {
            nemesis = dsLeonard.getSlot5name();
        }
        if (player1ID == 1) {
            hero = dsLeonard.getSlot1name();
        } else if (player1ID == 2) {
            hero = dsLeonard.getSlot2name();
        } else if (player1ID == 3) {
            hero = dsLeonard.getSlot3name();
        } else if (player1ID == 4) {
            hero = dsLeonard.getSlot4name();
        } else if (player1ID == 5) {
            hero = dsLeonard.getSlot5name();
        }


        btnScissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playhero=1;
                choosePlayerTwo();
            }
        });

        btnRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playhero=2;
                choosePlayerTwo();
            }
        });

        btnPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playhero=3;
                choosePlayerTwo();
            }
        });

        btnLizard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playhero=4;
                choosePlayerTwo();
            }
        });

        btnSpock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playhero=5;
                choosePlayerTwo();
            }
        });
    }

        public void choosePlayerTwo(){
            if (player2ID == 6) {
                playnemesis = rndGen.nextInt(4) + 1;
            } else if (player2ID == 7) {
                playnemesis = rndGen.nextInt(2) + 1;
            } else if (player2ID == 8) {
                playnemesis = 5;
            }else {
                btnScissor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        playnemesis = 1;
                    }
                });
                btnRock.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        playnemesis = 2;
                    }
                });
                btnPaper.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            playnemesis = 3;
                        playround();
                        refreshStatus();
                    }
                });

                btnLizard.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            playnemesis = 4;
                    }
                });

                btnSpock.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            playnemesis = 5;
                    }
                });
            }
            playround();
            refreshStatus();

        }

    public void teilen(DataStorage dsLeonard){
        SharedPreferences.Editor myEditor = sharedLeonard.edit();
        Gson gson = new Gson();
        String data = gson.toJson(dsLeonard);
        myEditor.putString("data", data);
        myEditor.apply();
    }
    public void erbitten(){
        Gson gson = new Gson();
        String data = sharedLeonard.getString("data", "");
        dsLeonard = gson.fromJson(data, DataStorage.class);
        if (dsLeonard == null){
            dsLeonard = new DataStorage();
        }
    }

    public void playround() {
        erbitten();
        if (playhero == 1) {
            switch (playnemesis) {
                case 1:
                    textResult.setText(getString(R.string.scissors) + "- " + getString(R.string.scissors) + " : "
                            + getString(R.string.draw));
                    turns++;
                    draw(3);
                    break;
                case 2:
                    textResult.setText(getString(R.string.rock) + getString(R.string.crushesS) +
                            getString(R.string.scissors) + "\n" + String.valueOf(nemesis) + getString(R.string.winsTxt));
                    compwin++;
                    playerLoses(1, 3);
                    turns++;
                    break;
                case 3:
                    textResult.setText(getString(R.string.scissors) + getString(R.string.cuts) +
                            getString(R.string.paper) + "\n" + String.valueOf(hero) + getString(R.string.winsTxt));
                    playerwin++;
                    playerWins(2, 3);
                    turns++;
                    break;
                case 4:
                    textResult.setText(getString(R.string.scissors) + getString(R.string.decapitates) +
                            getString(R.string.lizard) + "\n" + String.valueOf(hero) + getString(R.string.winsTxt));
                    playerwin++;
                    playerWins(4, 3);
                    turns++;
                    break;
                case 5:
                    textResult.setText(getString(R.string.spock) + getString(R.string.vaporizes) +
                            getString(R.string.scissors) + "\n" + String.valueOf(nemesis) + getString(R.string.winsTxt));
                    compwin++;
                    playerLoses(5, 3);
                    turns++;
                    break;
            }
        }else if(playhero==2){
            switch (playnemesis) {
                case 1:
                    textResult.setText(getString(R.string.rock) + getString(R.string.crushesS) +
                            getString(R.string.scissors) + "\n" + String.valueOf(hero) + getString(R.string.winsTxt));
                    playerwin++;
                    playerWins(3, 1);
                    turns++;
                    break;
                case 2:
                    textResult.setText(getString(R.string.rock) + "- " + getString(R.string.rock) + ": " +
                            getString(R.string.draw));
                    draw(1);
                    turns++;
                    break;
                case 3:
                    textResult.setText(getString(R.string.paper) + getString(R.string.covers) +
                            getString(R.string.rock) + "\n" + String.valueOf(nemesis) + getString(R.string.winsTxt));
                    compwin++;
                    playerLoses(2, 1);
                    turns++;
                    break;
                case 4:
                    textResult.setText(getString(R.string.rock) + getString(R.string.crushes) +
                            getString(R.string.lizard) + "\n" + String.valueOf(hero) + getString(R.string.winsTxt));
                    playerwin++;
                    playerWins(4, 1);
                    turns++;
                    break;
                case 5:
                    textResult.setText(getString(R.string.spock) + getString(R.string.vaporizes) +
                            getString(R.string.rock) + "\n" + String.valueOf(nemesis) + getString(R.string.winsTxt));
                    compwin++;
                    playerLoses(5, 1);
                    turns++;
                    break;
            }
        }else if(playhero==3){
            switch (playnemesis) {
                case 1:
                    textResult.setText(getString(R.string.scissors) + getString(R.string.cuts) +
                            getString(R.string.paper) + "\n" + String.valueOf(nemesis) + getString(R.string.winsTxt));
                    compwin++;
                    playerLoses(3, 2);
                    turns++;
                    break;
                case 2:
                    textResult.setText(getString(R.string.paper) + getString(R.string.covers) +
                            getString(R.string.rock) + "\n" + String.valueOf(hero) + getString(R.string.winsTxt));
                    playerwin++;
                    playerWins(1, 2);
                    turns++;
                    break;
                case 3:
                    textResult.setText(getString(R.string.paper) + "- " + getString(R.string.paper) + ": " +
                            getString(R.string.draw));
                    draw(2);
                    turns++;
                    break;
                case 4:
                    textResult.setText(getString(R.string.lizard) + getString(R.string.eats) +
                            getString(R.string.paper) + "\n" + String.valueOf(nemesis) + getString(R.string.winsTxt));
                    compwin++;
                    playerLoses(4, 2);
                    turns++;
                    break;
                case 5:
                    textResult.setText(getString(R.string.paper) + getString(R.string.disproves) +
                            getString(R.string.spock) + "\n" + String.valueOf(hero) + getString(R.string.winsTxt));
                    playerwin++;
                    playerWins(5, 2);
                    turns++;
                    break;
            }
        } else if (playhero==4){
            switch (playnemesis) {
                case 1:
                    textResult.setText(getString(R.string.scissors) + getString(R.string.decapitates) +
                            getString(R.string.lizard) + "\n" + String.valueOf(nemesis) + getString(R.string.winsTxt));
                    compwin++;
                    playerLoses(3, 4);
                    turns++;
                    break;
                case 2:
                    textResult.setText(getString(R.string.rock) + getString(R.string.crushes) +
                            getString(R.string.lizard) + "\n" + String.valueOf(nemesis) + getString(R.string.winsTxt));
                    compwin++;
                    playerLoses(1, 4);
                    turns++;
                    break;
                case 3:
                    textResult.setText(getString(R.string.lizard) + getString(R.string.eats) +
                            getString(R.string.paper) + "\n" + String.valueOf(hero) + getString(R.string.winsTxt));
                    playerwin++;
                    playerWins(2, 4);
                    turns++;
                    break;
                case 4:
                    textResult.setText(getString(R.string.lizard) + "- " + getString(R.string.lizard) + ": " +
                            getString(R.string.draw));
                    draw(4);
                    turns++;
                    break;
                case 5:
                    textResult.setText(getString(R.string.lizard) + getString(R.string.poisons) +
                            getString(R.string.spock) + "\n" + String.valueOf(hero) + getString(R.string.winsTxt));
                    playerwin++;
                    playerWins(5, 4);
                    turns++;
                    break;
            }
        } else if (playhero ==5){
            switch (playnemesis) {
                case 1:
                    textResult.setText(getString(R.string.spock) + getString(R.string.smashes) +
                            getString(R.string.scissors) + "\n" + String.valueOf(hero) + getString(R.string.winsTxt));
                    playerwin++;
                    playerWins(3, 5);
                    turns++;
                    break;
                case 2:
                    textResult.setText(getString(R.string.spock) + getString(R.string.vaporizes) +
                            getString(R.string.rock) + "\n" + String.valueOf(hero) + getString(R.string.winsTxt));
                    playerwin++;
                    playerWins(1, 5);
                    turns++;
                    break;
                case 3:
                    textResult.setText(getString(R.string.paper) + getString(R.string.disproves) +
                            getString(R.string.spock) + "\n" + String.valueOf(nemesis) + getString(R.string.winsTxt));
                    compwin++;
                    playerLoses(2, 5);
                    turns++;
                    break;
                case 4:
                    textResult.setText(getString(R.string.lizard) + getString(R.string.poisons) +
                            getString(R.string.spock) + "\n" + String.valueOf(nemesis) + getString(R.string.winsTxt));
                    compwin++;
                    playerLoses(4, 5);
                    turns++;
                    break;
                case 5:
                    textResult.setText(getString(R.string.spock) + "- " + getString(R.string.spock) + ": " +
                            getString(R.string.draw));
                    draw(5);
                    turns++;
                    break;
            }
        }
    }

    public void refreshStatus() {
        teilen(dsLeonard);
        textStatus.setText(getString(R.string.turn) + turns + "\n"+ getString(R.string.score)
                + String.valueOf(hero) + " : " + String.valueOf(playerwin) + "\n" + String.valueOf(nemesis)
                 + ": " + String.valueOf(compwin));
        if(playnemesis==1){
            textLennard.setText(getString(R.string.scissors));
        }
        else if(playnemesis==2){
            textLennard.setText(getString(R.string.rock));
        }
        else if(playnemesis==3){
            textLennard.setText(getString(R.string.paper));
        }
        else if(playnemesis==4){
            textLennard.setText(getString(R.string.lizard));
        }
        else if(playnemesis==5){
            textLennard.setText(getString(R.string.spock));
        }
        else{
            textLennard.setText("Fehler");
        }
    }
    
    public void playerWins(int playComputer, int playPlayer){
        erbitten();
        dsLeonard.setLeonardLosses(dsLeonard.getLeonardLosses() + 1);
        if (player1ID == 1) {
            dsLeonard.setSlot1wins(dsLeonard.getSlot1wins() + 1);
        } else if (player1ID == 2) {
            dsLeonard.setSlot2wins(dsLeonard.getSlot2wins()+1);
        } else if (player1ID == 3) {
            dsLeonard.setSlot3wins(dsLeonard.getSlot3wins() + 1);
        } else if (player1ID == 4) {
            dsLeonard.setSlot4wins(dsLeonard.getSlot4wins() + 1);
        } else if (player1ID == 5) {
            dsLeonard.setSlot5wins(dsLeonard.getSlot5wins() + 1);
        }
        if(playComputer == 1) {
            dsLeonard.setRockWins(dsLeonard.getRockWins() + 1);
        } else if (playComputer == 2){
            dsLeonard.setPaperWins(dsLeonard.getPaperWins()+1);
        } else if (playComputer == 3){
            dsLeonard.setScissorsWins(dsLeonard.getScissorsWins()+1);
        } else if (playComputer == 4){
            dsLeonard.setLizardWins(dsLeonard.getLizardWins()+1);
        } else if (playComputer == 5) {
            dsLeonard.setSpockWins(dsLeonard.getSpockWins()+1);
        }
        if (playPlayer == 1) {
            dsLeonard.setRockWins(dsLeonard.getRockWins() + 1);
        } else if (playPlayer == 2){
            dsLeonard.setPaperWins(dsLeonard.getPaperWins()+1);
        } else if (playPlayer == 3){
            dsLeonard.setScissorsWins(dsLeonard.getScissorsWins()+1);
        } else if (playPlayer == 4){
            dsLeonard.setLizardWins(dsLeonard.getLizardWins()+1);
        } else if (playPlayer == 5) {
            dsLeonard.setSpockWins(dsLeonard.getSpockWins() + 1);
        }
    }
    public void playerLoses(int playComputer, int playPlayer){
        erbitten();
        dsLeonard.setLeonardWins(dsLeonard.getLeonardWins() + 1);
        if (player1ID == 1) {
            dsLeonard.setSlot1losses(dsLeonard.getSlot1losses() + 1);
        } else if (player1ID == 2) {
            dsLeonard.setSlot2losses(dsLeonard.getSlot2losses()+1);
        } else if (player1ID == 3) {
            dsLeonard.setSlot3losses(dsLeonard.getSlot3losses() + 1);
        } else if (player1ID == 4) {
            dsLeonard.setSlot4losses(dsLeonard.getSlot4losses() + 1);
        } else if (player1ID == 5) {
            dsLeonard.setSlot5losses(dsLeonard.getSlot5losses() + 1);
        }
        if(playComputer == 1) {
            dsLeonard.setRockWins(dsLeonard.getRockWins() + 1);
        } else if (playComputer == 2){
            dsLeonard.setPaperWins(dsLeonard.getPaperWins()+1);
        } else if (playComputer == 3){
            dsLeonard.setScissorsWins(dsLeonard.getScissorsWins()+1);
        } else if (playComputer == 4){
            dsLeonard.setLizardWins(dsLeonard.getLizardWins()+1);
        } else if (playComputer == 5) {
            dsLeonard.setSpockWins(dsLeonard.getSpockWins()+1);
        }
        if (playPlayer == 1) {
            dsLeonard.setRockLosses(dsLeonard.getRockLosses() + 1);
        } else if (playPlayer == 2){
            dsLeonard.setPaperLosses(dsLeonard.getPaperLosses()+1);
        } else if (playPlayer == 3){
            dsLeonard.setScissorsLosses(dsLeonard.getScissorsLosses()+1);
        } else if (playPlayer == 4){
            dsLeonard.setLizardLosses(dsLeonard.getLizardLosses()+1);
        } else if (playPlayer == 5) {
            dsLeonard.setSpockLosses(dsLeonard.getSpockLosses() + 1);
        }
    }
    public void draw(int drawElement){
        erbitten();
        dsLeonard.setLeonardDraws(dsLeonard.getLeonardDraws() + 1);
        if (player1ID == 1) {
            dsLeonard.setSlot1draws(dsLeonard.getSlot1draws() + 1);
        } else if (player1ID == 2) {
            dsLeonard.setSlot2draws(dsLeonard.getSlot2draws() + 1);
        } else if (player1ID == 3) {
            dsLeonard.setSlot3draws(dsLeonard.getSlot3draws() + 1);
        } else if (player1ID == 4) {
            dsLeonard.setSlot4draws(dsLeonard.getSlot4draws() + 1);
        } else if (player1ID == 5) {
            dsLeonard.setSlot5draws(dsLeonard.getSlot5draws() + 1);
        }
        if(drawElement == 1) {
            dsLeonard.setRockDraws(dsLeonard.getRockDraws() + 1);
        } else if (drawElement == 2){
            dsLeonard.setPaperDraws(dsLeonard.getPaperDraws()+1);
        } else if (drawElement == 3){
            dsLeonard.setScissorsDraws(dsLeonard.getScissorsDraws()+1);
        } else if (drawElement == 4){
            dsLeonard.setLizardDraws(dsLeonard.getLizardDraws()+1);
        } else if (drawElement == 5) {
            dsLeonard.setSpockDraws(dsLeonard.getSpockDraws()+1);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        turns = savedInstanceState.getInt("turns");
        compwin = savedInstanceState.getInt("compwin");
        playerwin = savedInstanceState.getInt("playerwin");
        erbitten();
        refreshStatus();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("turns", turns);
        outState.putInt("compwin", compwin);
        outState.putInt("playerwin", playerwin);
        teilen(dsLeonard);
    }

     public void onClickQuit(View v){
         Intent intent = new Intent(GameActivity.this, MainActivity.class);
         startActivity(intent);
     }
}