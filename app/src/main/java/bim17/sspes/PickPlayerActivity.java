package bim17.sspes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

public class PickPlayerActivity extends AppCompatActivity {
    // Variablen deklarieren
    Button btnStart, btnBack, playerOne, playerTwo, editPlayer;
    //Objekte implementieren
    DataStorage myDS;
    SharedPreferences mySP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_player);

        // Verknuepfungen zum Layout erstellen
        btnStart = findViewById(R.id.btnStart);
        btnBack = findViewById(R.id.btnMainMenu);
        editPlayer = findViewById(R.id.btnEditPlayer);
        playerOne = findViewById(R.id.btnPlayer1);
        playerTwo = findViewById(R.id.btnPlayer2);
        mySP = getSharedPreferences("myData", MODE_PRIVATE);
        pullStatistics();
        myDS.setPlayer1(0);
        if (myDS.getPlayer2()== 6 || myDS.getPlayer2()== 7 || myDS.getPlayer2()== 8) {
            playerTwo.setVisibility(View.INVISIBLE);
        } else {
            myDS.setPlayer2(0);
        }
        pushStatistics();
    }
    public void pushStatistics(){
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

    public void onClickPlayerOne (View v){
        PopupMenu player1Menu = new PopupMenu(PickPlayerActivity.this, playerOne);
        player1Menu.getMenuInflater().inflate (R.menu.menu_player, player1Menu.getMenu());

        //Set menu items title to concurrent slot names from DataStorage
        player1Menu.getMenu().getItem(0).setTitle(myDS.getSlot1name());
        player1Menu.getMenu().getItem(1).setTitle(myDS.getSlot2name());
        player1Menu.getMenu().getItem(2).setTitle(myDS.getSlot3name());
        player1Menu.getMenu().getItem(3).setTitle(myDS.getSlot4name());
        player1Menu.getMenu().getItem(4).setTitle(myDS.getSlot5name());
        player1Menu.getMenu().getItem(5).setVisible(false);
        player1Menu.getMenu().getItem(6).setVisible(false);
        player1Menu.getMenu().getItem(7).setVisible(false);

        player1Menu.setOnMenuItemClickListener (new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                pullStatistics();

                switch (item.getItemId()) {
                    case R.id.slot1:
                        if (myDS.getPlayer2() == 1 /*|| myDS.getSlot1name() == "Player 1"*/) {
                            Toast.makeText(PickPlayerActivity.this, getString(R.string.error), Toast.LENGTH_SHORT).show();
                        } else {
                            myDS.setPlayer1(1);
                        }
                        break;
                    case R.id.slot2:
                        if (myDS.getPlayer2() == 2 /*|| myDS.getSlot2name() == "Player 2"*/) {
                            Toast.makeText(PickPlayerActivity.this, getString(R.string.error), Toast.LENGTH_SHORT).show();
                        } else {
                            myDS.setPlayer1(2);
                        }
                        break;
                    case R.id.slot3:
                        if (myDS.getPlayer2() == 3 /*|| myDS.getSlot3name() == "Player 3"*/) {
                            Toast.makeText(PickPlayerActivity.this, getString(R.string.error), Toast.LENGTH_SHORT).show();
                        } else {
                            myDS.setPlayer1(3);
                        }
                        break;
                    case R.id.slot4:
                        if (myDS.getPlayer2() == 4 /*|| myDS.getSlot4name() == "Player 4"*/) {
                            Toast.makeText(PickPlayerActivity.this, getString(R.string.error), Toast.LENGTH_SHORT).show();
                        } else {
                            myDS.setPlayer1(4);
                        }
                        break;
                    case R.id.slot5:
                        if (myDS.getPlayer2() == 5 /*|| myDS.getSlot5name() == "Player 5"*/) {
                            Toast.makeText(PickPlayerActivity.this, getString(R.string.error), Toast.LENGTH_SHORT).show();
                        } else {
                            myDS.setPlayer1(5);
                        }
                        break;
                    default:
                        break;
                }
                pushStatistics();
                fillButtons();
                return true;
            }
        });
        player1Menu.show();
    }
    public void onClickPlayerTwo (View v){
        PopupMenu player2Menu = new PopupMenu(PickPlayerActivity.this, playerTwo);
        player2Menu.getMenuInflater().inflate (R.menu.menu_player, player2Menu.getMenu());

        //Set menu items title to concurrent slot names from DataStorage
        player2Menu.getMenu().getItem(0).setTitle(myDS.getSlot1name());
        player2Menu.getMenu().getItem(1).setTitle(myDS.getSlot2name());
        player2Menu.getMenu().getItem(2).setTitle(myDS.getSlot3name());
        player2Menu.getMenu().getItem(3).setTitle(myDS.getSlot4name());
        player2Menu.getMenu().getItem(4).setTitle(myDS.getSlot5name());
        player2Menu.getMenu().getItem(5).setVisible(false);
        player2Menu.getMenu().getItem(6).setVisible(false);
        player2Menu.getMenu().getItem(7).setVisible(false);

        player2Menu.setOnMenuItemClickListener (new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                pullStatistics();
                switch (item.getItemId()) {
                    case R.id.slot1:
                        if (myDS.getPlayer1() == 1 /*|| myDS.getSlot1name() == "Player 1"*/) {
                            Toast.makeText(PickPlayerActivity.this, getString(R.string.error) , Toast.LENGTH_SHORT).show();
                        }
                        else {
                            myDS.setPlayer2(1);
                        }
                        break;
                    case R.id.slot2:
                        if (myDS.getPlayer1() == 2 /*|| myDS.getSlot2name() == "Player 2"*/) {
                            Toast.makeText(PickPlayerActivity.this, getString(R.string.error) , Toast.LENGTH_SHORT).show();
                        }
                        else {
                            myDS.setPlayer2(2);
                        }
                        break;
                    case R.id.slot3:
                        if (myDS.getPlayer1() == 3 /*|| myDS.getSlot3name() == "Player 3"*/) {
                            Toast.makeText(PickPlayerActivity.this, getString(R.string.error) , Toast.LENGTH_SHORT).show();
                        }
                        else {
                            myDS.setPlayer2(3);
                        }
                        break;
                    case R.id.slot4:
                        if (myDS.getPlayer1() == 4 /*|| myDS.getSlot4name() == "Player 4"*/) {
                            Toast.makeText(PickPlayerActivity.this, getString(R.string.error) , Toast.LENGTH_SHORT).show();
                        }
                        else {
                            myDS.setPlayer2(4);
                        }
                        break;
                    case R.id.slot5:
                        if (myDS.getPlayer1() == 5 /*|| myDS.getSlot5name() == "Player 5"*/) {
                            Toast.makeText(PickPlayerActivity.this, getString(R.string.error) , Toast.LENGTH_SHORT).show();
                        }
                        else {
                            myDS.setPlayer2(5);
                        }
                        break;
                    default:
                        break;
                }
                pushStatistics();
                fillButtons();
                return true;
            }
        });
        player2Menu.show();
    }

    public void fillButtons(){
        pullStatistics();
        switch (myDS.getPlayer1()){
            case 1:
                playerOne.setText(String.valueOf(myDS.getSlot1name()));
                break;
            case 2:
                playerOne.setText(String.valueOf(myDS.getSlot2name()));
                break;
            case 3:
                playerOne.setText(String.valueOf(myDS.getSlot3name()));
                break;
            case 4:
                playerOne.setText(String.valueOf(myDS.getSlot4name()));
                break;
            case 5:
                playerOne.setText(String.valueOf(myDS.getSlot5name()));
                break;
        }
        switch (myDS.getPlayer2()){
            case 1:
                playerTwo.setText(String.valueOf(myDS.getSlot1name()));
                break;
            case 2:
                playerTwo.setText(String.valueOf(myDS.getSlot2name()));
                break;
            case 3:
                playerTwo.setText(String.valueOf(myDS.getSlot3name()));
                break;
            case 4:
                playerTwo.setText(String.valueOf(myDS.getSlot4name()));
                break;
            case 5:
                playerTwo.setText(String.valueOf(myDS.getSlot5name()));
                break;
        }
    }

    //Activity "Spieler erstellen" aufrufen
    public void gotoEditPlayer(View v){
        Intent intent = new Intent(PickPlayerActivity.this, EditPlayerActivity.class);
        startActivity(intent);

    }

    // neue Activity aufrufen, um zum Einstiegsbildschirm zurueckzukehren
    public void goToMainActivity (View v){
        Intent intent = new Intent(PickPlayerActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickStart(View v){
        pushStatistics();
        Intent intent = new Intent(PickPlayerActivity.this, GameActivity.class);
        startActivity(intent);
    }

    //Vor dem Starten des Spiels prüfen, ob beide Spieler ausgewählt sind.
}