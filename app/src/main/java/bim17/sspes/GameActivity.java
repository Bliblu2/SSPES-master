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
    int round, compwin, playerwin, turn;
    int player1ID, player2ID;
    DataStorage myDS;
    SharedPreferences mySP;
    StatusText myST;
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
        myST = new StatusText();
        rndGen = new Random();
        round = 0;
        mySP = getSharedPreferences("myData", MODE_PRIVATE);
        pullStatistics();
        player1ID = myDS.getPlayer1();
        player2ID = myDS.getPlayer2();
        turn = 1;




        /*
        btnScissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (turn == 1){
                    playhero = 1;
                    if (player2ID <= 5){
                        turn = 2;
                    } else if (player2ID == 6){
                        playnemesis = Strategy.playLeonard();
                        endRound();
                    }
                } else if (turn == 2){
                    playnemesis = 1;
                    endRound();
                }
            }
        });


        btnRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (turn == 1){
                    playhero = 2;
                    if (player2ID <= 5){
                        turn = 2;
                    } else if (player2ID == 6){
                        playnemesis = Strategy.playLeonard();
                        endRound();
                    }
                } else if (turn == 2){
                    playnemesis = 2;
                    endRound();
                }
            }
        });

        btnPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (turn == 1){
                    playhero = 3;
                    if (player2ID <= 5){
                        turn = 2;
                    } else if (player2ID == 6){
                        playnemesis = Strategy.playLeonard();
                        endRound();
                    }
                } else if (turn == 2){
                    playnemesis = 3;
                    endRound();
                }
            }
        });

        btnLizard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (turn == 1){
                    playhero = 4;
                    if (player2ID <= 5){
                        turn = 2;
                    } else if (player2ID == 6){
                        playnemesis = Strategy.playLeonard();
                        endRound();
                    }
                } else if (turn == 2){
                    playnemesis = 4;
                    endRound();
                }
            }
        });

        btnSpock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (turn == 1){
                    playhero = 5;
                    if (player2ID <= 5){
                        turn = 2;
                    } else if (player2ID == 6){
                        playnemesis = Strategy.playLeonard();
                        endRound();
                    }
                } else if (turn == 2){
                    playnemesis = 5;
                    endRound();
                }
            }
        });
        */
    }

    public void onClickScissors(View v){
        if (turn == 1){
            playhero = 1;
            if (player2ID <= 5){
                turn = 2;
            } else if (player2ID == 6){
                playnemesis = Strategy.playLeonard();
            } else if (player2ID == 7){
                playnemesis = Strategy.playPenny();
            } else if (player2ID == 8){
                playnemesis = Strategy.playSheldon();
            }
        } else if (turn == 2){
            playnemesis = 1;
            endRound();
        }
    }

    public void onClickRock(View v){
        if (turn == 1){
            playhero = 2;
            if (player2ID <= 5){
                turn = 2;
            } else if (player2ID == 6){
                playnemesis = Strategy.playLeonard();
                endRound();
            }
        } else if (turn == 2){
            playnemesis = 2;
            endRound();
        }
    }

    public void onClickPaper(View v){
        if (turn == 1){
            playhero = 3;
            if (player2ID <= 5){
                turn = 2;
            } else if (player2ID == 6){
                playnemesis = Strategy.playLeonard();
                endRound();
            }
        } else if (turn == 2){
            playnemesis = 3;
            endRound();
        }
    }

    public void onClickLizard(View v){
        if (turn == 1){
            playhero = 4;
            if (player2ID <= 5){
                turn = 2;
            } else if (player2ID == 6){
                playnemesis = Strategy.playLeonard();
                endRound();
            }
        } else if (turn == 2){
            playnemesis = 4;
            endRound();
        }
    }

    public void onClickSpock(View v){
        if (turn == 1){
            playhero = 5;
            if (player2ID <= 5){
                turn = 2;
            } else if (player2ID == 6){
                playnemesis = Strategy.playLeonard();
                endRound();
            }
        } else if (turn == 2){
            playnemesis = 5;
            endRound();
        }
    }

    public void pushStatistics(DataStorage myDS){
        SharedPreferences.Editor myEditor = mySP.edit();
        Gson gson = new Gson();
        String data = gson.toJson(myDS);
        myEditor.putString("data", data);
        myEditor.apply();
    }
    public void pullStatistics(){
        Gson gson = new Gson();
        String data = mySP.getString("data", "");
        myDS = gson.fromJson(data, DataStorage.class);
        if (myDS == null){
            myDS = new DataStorage();
        }
    }

    public void refreshStatus() {
        pushStatistics(myDS);
        textStatus.setText(getString(R.string.turn) + round + "\n"+ getString(R.string.score)
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
    
    public void playerOneWins(int playComputer, int playPlayer){
        pullStatistics();
        switch (playPlayer){
            case 1:
                myDS.setScissorsWins(myDS.getScissorsWins()+1);
                break;
            case 2:
                myDS.setRockWins(myDS.getRockWins()+1);
                break;
            case 3:
                myDS.setPaperWins(myDS.getPaperWins()+1);
                break;
            case 4:
                myDS.setLizardWins(myDS.getLizardWins()+1);
                break;
            case 5:
                myDS.setSpockWins(myDS.getSpockWins()+1);
                break;
        }
        switch (playComputer){
            case 1:
                myDS.setScissorsLosses(myDS.getScissorsLosses()+1);
                break;
            case 2:
                myDS.setRockLosses(myDS.getRockLosses()+1);
                break;
            case 3:
                myDS.setPaperLosses(myDS.getPaperLosses()+1);
                break;
            case 4:
                myDS.setLizardLosses(myDS.getLizardLosses()+1);
                break;
            case 5:
                myDS.setSpockLosses(myDS.getSpockLosses()+1);
                break;
        }


        switch (player1ID){
            case 1:
                myDS.setSlot1wins(myDS.getSlot1wins()+1);
                if (player2ID == 2) {
                    myDS.setSlot2losses(myDS.getSlot2losses() + 1);
                } else if (player2ID == 3) {
                    myDS.setSlot3losses(myDS.getSlot3losses() + 1);
                }else if (player2ID == 4) {
                    myDS.setSlot4losses(myDS.getSlot4losses() + 1);
                }else if (player2ID == 5) {
                    myDS.setSlot5losses(myDS.getSlot5losses() + 1);
                }else if (player2ID == 6) {
                    myDS.setLeonardLosses(myDS.getLeonardLosses() + 1);
                }else if (player2ID == 7) {
                    myDS.setPennyLosses(myDS.getPennyLosses() + 1);
                }else if (player2ID == 8) {
                    myDS.setSheldonLosses(myDS.getSheldonLosses() + 1);
                }
                round++;
                turn = 1;
                break;
            case 2:
                myDS.setSlot2wins(myDS.getSlot2wins()+1);
                if (player2ID == 1) {
                    myDS.setSlot1losses(myDS.getSlot1losses() + 1);
                } else if (player2ID == 3) {
                    myDS.setSlot3losses(myDS.getSlot3losses() + 1);
                }else if (player2ID == 4) {
                    myDS.setSlot4losses(myDS.getSlot4losses() + 1);
                }else if (player2ID == 5) {
                    myDS.setSlot5losses(myDS.getSlot5losses() + 1);
                }else if (player2ID == 6) {
                    myDS.setLeonardLosses(myDS.getLeonardLosses() + 1);
                }else if (player2ID == 7) {
                    myDS.setPennyLosses(myDS.getPennyLosses() + 1);
                }else if (player2ID == 8) {
                    myDS.setSheldonLosses(myDS.getSheldonLosses() + 1);
                }
                round++;
                turn = 1;
                break;
            case 3:
                myDS.setSlot3wins(myDS.getSlot3wins()+1);
                if (player2ID == 2) {
                    myDS.setSlot2losses(myDS.getSlot2losses() + 1);
                } else if (player2ID == 1) {
                    myDS.setSlot1losses(myDS.getSlot1losses() + 1);
                }else if (player2ID == 4) {
                    myDS.setSlot4losses(myDS.getSlot4losses() + 1);
                }else if (player2ID == 5) {
                    myDS.setSlot5losses(myDS.getSlot5losses() + 1);
                }else if (player2ID == 6) {
                    myDS.setLeonardLosses(myDS.getLeonardLosses() + 1);
                }else if (player2ID == 7) {
                    myDS.setPennyLosses(myDS.getPennyLosses() + 1);
                }else if (player2ID == 8) {
                    myDS.setSheldonLosses(myDS.getSheldonLosses() + 1);
                }
                round++;
                turn = 1;
                break;
            case 4:
                myDS.setSlot4wins(myDS.getSlot4wins()+1);
                if (player2ID == 2) {
                    myDS.setSlot2losses(myDS.getSlot2losses() + 1);
                } else if (player2ID == 3) {
                    myDS.setSlot3losses(myDS.getSlot3losses() + 1);
                }else if (player2ID == 1) {
                    myDS.setSlot1losses(myDS.getSlot1losses() + 1);
                }else if (player2ID == 5) {
                    myDS.setSlot5losses(myDS.getSlot5losses() + 1);
                }else if (player2ID == 6) {
                    myDS.setLeonardLosses(myDS.getLeonardLosses() + 1);
                }else if (player2ID == 7) {
                    myDS.setPennyLosses(myDS.getPennyLosses() + 1);
                }else if (player2ID == 8) {
                    myDS.setSheldonLosses(myDS.getSheldonLosses() + 1);
                }
                round++;
                turn = 1;
                break;
            case 5:
                myDS.setSlot5wins(myDS.getSlot5wins()+1);
                if (player2ID == 2) {
                    myDS.setSlot2losses(myDS.getSlot2losses() + 1);
                } else if (player2ID == 3) {
                    myDS.setSlot3losses(myDS.getSlot3losses() + 1);
                }else if (player2ID == 4) {
                    myDS.setSlot4losses(myDS.getSlot4losses() + 1);
                }else if (player2ID == 1) {
                    myDS.setSlot1losses(myDS.getSlot1losses() + 1);
                }else if (player2ID == 6) {
                    myDS.setLeonardLosses(myDS.getLeonardLosses() + 1);
                }else if (player2ID == 7) {
                    myDS.setPennyLosses(myDS.getPennyLosses() + 1);
                }else if (player2ID == 8) {
                    myDS.setSheldonLosses(myDS.getSheldonLosses() + 1);
                }
                round++;
                turn = 1;
                break;
        }
    }
    public void playerTwoWins(int playComputer, int playPlayer){
        pullStatistics();

        switch (playComputer){
            case 1:
                myDS.setScissorsWins(myDS.getScissorsWins()+1);
                break;
            case 2:
                myDS.setRockWins(myDS.getRockWins()+1);
                break;
            case 3:
                myDS.setPaperWins(myDS.getPaperWins()+1);
                break;
            case 4:
                myDS.setLizardWins(myDS.getLizardWins()+1);
                break;
            case 5:
                myDS.setSpockWins(myDS.getSpockWins()+1);
                break;
        }
        switch (playPlayer){
            case 1:
                myDS.setScissorsLosses(myDS.getScissorsLosses()+1);
                break;
            case 2:
                myDS.setRockLosses(myDS.getRockLosses()+1);
                break;
            case 3:
                myDS.setPaperLosses(myDS.getPaperLosses()+1);
                break;
            case 4:
                myDS.setLizardLosses(myDS.getLizardLosses()+1);
                break;
            case 5:
                myDS.setSpockLosses(myDS.getSpockLosses()+1);
                break;
        }

        switch (player2ID){
            case 1:
                myDS.setSlot1wins(myDS.getSlot1wins()+1);
                if (player1ID == 2) {
                    myDS.setSlot2losses(myDS.getSlot2losses() + 1);
                } else if (player1ID == 3) {
                    myDS.setSlot3losses(myDS.getSlot3losses() + 1);
                }else if (player1ID == 4) {
                    myDS.setSlot4losses(myDS.getSlot4losses() + 1);
                }else if (player1ID == 5) {
                    myDS.setSlot5losses(myDS.getSlot5losses() + 1);
                }
                round++;
                turn = 1;
                break;
            case 2:
                myDS.setSlot2wins(myDS.getSlot2wins()+1);
                if (player1ID == 1) {
                    myDS.setSlot1losses(myDS.getSlot1losses() + 1);
                } else if (player1ID == 3) {
                    myDS.setSlot3losses(myDS.getSlot3losses() + 1);
                }else if (player1ID == 4) {
                    myDS.setSlot4losses(myDS.getSlot4losses() + 1);
                }else if (player1ID == 5) {
                    myDS.setSlot5losses(myDS.getSlot5losses() + 1);
                }
                round++;
                turn = 1;
                break;
            case 3:
                myDS.setSlot3wins(myDS.getSlot3wins()+1);
                if (player1ID == 2) {
                    myDS.setSlot2losses(myDS.getSlot2losses() + 1);
                } else if (player1ID == 1) {
                    myDS.setSlot1losses(myDS.getSlot1losses() + 1);
                }else if (player1ID == 4) {
                    myDS.setSlot4losses(myDS.getSlot4losses() + 1);
                }else if (player1ID == 5) {
                    myDS.setSlot5losses(myDS.getSlot5losses() + 1);
                }
                round++;
                turn = 1;
                break;
            case 4:
                myDS.setSlot4wins(myDS.getSlot4wins()+1);
                if (player1ID == 2) {
                    myDS.setSlot2losses(myDS.getSlot2losses() + 1);
                } else if (player1ID == 3) {
                    myDS.setSlot3losses(myDS.getSlot3losses() + 1);
                }else if (player1ID == 1) {
                    myDS.setSlot1losses(myDS.getSlot1losses() + 1);
                }else if (player1ID == 5) {
                    myDS.setSlot5losses(myDS.getSlot5losses() + 1);
                }
                round++;
                turn = 1;
                break;
            case 5:
                myDS.setSlot5wins(myDS.getSlot5wins()+1);
                if (player1ID == 2) {
                    myDS.setSlot2losses(myDS.getSlot2losses() + 1);
                } else if (player1ID == 3) {
                    myDS.setSlot3losses(myDS.getSlot3losses() + 1);
                }else if (player1ID == 4) {
                    myDS.setSlot4losses(myDS.getSlot4losses() + 1);
                }else if (player1ID == 1) {
                    myDS.setSlot1losses(myDS.getSlot1losses() + 1);
                }
                round++;
                turn = 1;
                break;
            case 6:
                myDS.setSlot5wins(myDS.getSlot5wins()+1);
                if (player1ID == 2) {
                    myDS.setSlot2losses(myDS.getSlot2losses() + 1);
                } else if (player1ID == 3) {
                    myDS.setSlot3losses(myDS.getSlot3losses() + 1);
                }else if (player1ID == 4) {
                    myDS.setSlot4losses(myDS.getSlot4losses() + 1);
                }else if (player1ID == 1) {
                    myDS.setSlot1losses(myDS.getSlot1losses() + 1);
                }else if (player1ID == 5) {
                    myDS.setSlot5losses(myDS.getSlot5losses() + 1);
                }
                round++;
                turn = 1;
                break;
            case 7:
                myDS.setSlot5wins(myDS.getSlot5wins()+1);
                if (player1ID == 2) {
                    myDS.setSlot2losses(myDS.getSlot2losses() + 1);
                } else if (player1ID == 3) {
                    myDS.setSlot3losses(myDS.getSlot3losses() + 1);
                }else if (player1ID == 4) {
                    myDS.setSlot4losses(myDS.getSlot4losses() + 1);
                }else if (player1ID == 1) {
                    myDS.setSlot1losses(myDS.getSlot1losses() + 1);
                }else if (player1ID == 5) {
                    myDS.setSlot5losses(myDS.getSlot5losses() + 1);
                }
                round++;
                turn = 1;
                break;
            case 8:
                myDS.setSlot5wins(myDS.getSlot5wins()+1);
                if (player1ID == 2) {
                    myDS.setSlot2losses(myDS.getSlot2losses() + 1);
                } else if (player1ID == 3) {
                    myDS.setSlot3losses(myDS.getSlot3losses() + 1);
                }else if (player1ID == 4) {
                    myDS.setSlot4losses(myDS.getSlot4losses() + 1);
                }else if (player1ID == 1) {
                    myDS.setSlot1losses(myDS.getSlot1losses() + 1);
                }else if (player1ID == 5) {
                    myDS.setSlot5losses(myDS.getSlot5losses() + 1);
                }
                round++;
                turn = 1;
                break;
        }
    }
    public void draw(int drawElement){
        pullStatistics();
        myDS.setLeonardDraws(myDS.getLeonardDraws() + 1);
        if (player1ID == 1) {
            myDS.setSlot1draws(myDS.getSlot1draws() + 1);
        } else if (player1ID == 2) {
            myDS.setSlot2draws(myDS.getSlot2draws() + 1);
        } else if (player1ID == 3) {
            myDS.setSlot3draws(myDS.getSlot3draws() + 1);
        } else if (player1ID == 4) {
            myDS.setSlot4draws(myDS.getSlot4draws() + 1);
        } else if (player1ID == 5) {
            myDS.setSlot5draws(myDS.getSlot5draws() + 1);
        }
        if(drawElement == 1) {
            myDS.setRockDraws(myDS.getRockDraws() + 1);
        } else if (drawElement == 2){
            myDS.setPaperDraws(myDS.getPaperDraws()+1);
        } else if (drawElement == 3){
            myDS.setScissorsDraws(myDS.getScissorsDraws()+1);
        } else if (drawElement == 4){
            myDS.setLizardDraws(myDS.getLizardDraws()+1);
        } else if (drawElement == 5) {
            myDS.setSpockDraws(myDS.getSpockDraws()+1);
        }
        round++;
        turn = 1;
    }

    public void endRound(){
        switch (WinnerCalculation.calculateWinner(playhero, playnemesis)){
            case 0:
                //textResult.setText(myST.changeStatusText(playhero));
                draw(playhero);
                break;
            case 1:
                //textResult.setText(myST.changeStatusText(playhero, playnemesis, 1));
                playerOneWins(playnemesis, playhero);
                break;
            case 2:
                //textResult.setText(myST.changeStatusText(playhero, playnemesis, 2));
                playerTwoWins(playnemesis, playhero);
                break;
            default:
                break;
        }
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        round = savedInstanceState.getInt("round");
        compwin = savedInstanceState.getInt("compwin");
        playerwin = savedInstanceState.getInt("playerwin");
        pullStatistics();
        refreshStatus();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("round", round);
        outState.putInt("compwin", compwin);
        outState.putInt("playerwin", playerwin);
        pushStatistics(myDS);
    }

     public void onClickQuit(View v){
         Intent intent = new Intent(GameActivity.this, MainActivity.class);
         startActivity(intent);
     }
}