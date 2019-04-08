package bim17.sspes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    // Variablen deklarieren
    Button btnPlayerOne;
    Button btnSheldon, btnLeonard, btnPenny;
    TextView txtMultiplayer, txtOpponent;
    DataStorage myDS;
    SharedPreferences mySP;
    Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Verknuepfungen zum Layout erstellen
        btnPlayerOne = findViewById(R.id.btnPlayerOne);
        btnSheldon = findViewById(R.id.btnSheldon);
        btnLeonard = findViewById(R.id.btnLeonard);
        btnPenny = findViewById(R.id.btnPenny);
        txtMultiplayer = findViewById(R.id.txtMultiplayer);
        txtOpponent = findViewById(R.id.txtOpponent);
        mySP = getSharedPreferences("myData", MODE_PRIVATE);
        pullStatisticsMain();
        myDS.setPlayer1(0);
        myDS.setPlayer2(0);
        pushStatisticsMain();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu options_menu) {
        MenuInflater mMenuInflater = getMenuInflater();
        mMenuInflater.inflate(R.menu.options_menu, options_menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.rules) {
            onClickRulesActivity(findViewById(R.id.rules));
            return true;
        }
        else if (item.getItemId() == R.id.editPlayer) {
            onClickPlayerActivity(findViewById(R.id.editPlayer));
            return true;
        }
        else if (item.getItemId() == R.id.playerStats) {
            onClickPlayerStatsActivity(findViewById(R.id.playerStats));
            return true;
        }
        else if (item.getItemId() == R.id.elementsStats) {
            onClickElementsStatsActivity(findViewById(R.id.elementsStats));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void pushStatisticsMain(){
        SharedPreferences.Editor myEditor = mySP.edit();
        Gson gson = new Gson();
        String data = gson.toJson(myDS);
        myEditor.putString("data", data);
        myEditor.apply();
    }
    public void pullStatisticsMain(){
        Gson gson = new Gson();
        String data = mySP.getString("data", "");
        myDS = gson.fromJson(data, DataStorage.class);
        if (myDS == null){
            myDS = new DataStorage();
        }
    }

    // neue Activity aufrufen, um Regeln anzuzeigen
    public void onClickRulesActivity(View v) {
        Intent intent = new Intent(MainActivity.this, RulesActivity.class);
        startActivity(intent);
    }

    // neue Activities aufrufen, um Statistiken zu zeigen
    public void onClickPlayerStatsActivity(View v) {
        Intent intent = new Intent(MainActivity.this, PlayerStatsActivity.class);
        startActivity(intent);
    }

    public void onClickElementsStatsActivity(View v) {
        Intent intent = new Intent(MainActivity.this, ElementsStatsActivity.class);
        startActivity(intent);
    }

    // neue Activity aufrufen, um Spielernamen einzugeben
    public void onClickPlayerActivity(View v) {
        Intent intent = new Intent(MainActivity.this, EditPlayerActivity.class);
        startActivity(intent);
    }

    public void onClickSheldon(View v){
        pullStatisticsMain();
        myDS.setPlayer2(8);
        pushStatisticsMain();
        Intent intent = new Intent(MainActivity.this, PickPlayerActivity.class);
        startActivity(intent);
    }
    public void onClickLeonard(View v){
        pullStatisticsMain();
        myDS.setPlayer2(6);
        pushStatisticsMain();
        Intent intent = new Intent(MainActivity.this, PickPlayerActivity.class);
        startActivity(intent);
    }
    public void onClickPenny(View v){
        pullStatisticsMain();
        myDS.setPlayer2(7);
        pushStatisticsMain();
        Intent intent = new Intent(MainActivity.this, PickPlayerActivity.class);
        startActivity(intent);
    }

    public void onClickIchGehWiederWeg(View v){
        Intent intent = new Intent(MainActivity.this, ElementsStatsActivity.class);
        startActivity(intent);
    }
}