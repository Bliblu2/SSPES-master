package bim17.sspes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import com.google.gson.Gson;

/* Activity class to show statistic data for players.
 * @author Carolin Ludwig, Sabrina Krietsch, Lena Glaesener
 * @version 1.0 03.2019
 */
public class PlayerStatsActivity extends MainActivity {
    // SharedPreferences-Object for long time safe
    SharedPreferences mySP;

    //DataStorage-Object for short time safe
    DataStorage myDS;

    //Declare Buttons, TextViews and variable
    Button btnMainMenu; //Button for navigation
    Button btnPlayer; //Button for choosing a slot from DataStorage-Object
    TextView txtWins, txtLosses, txtDraws; //Textviews for data from DataStorage-Objects
    int player; //Player-ID of the chosen player(slot in DataStorage-Object)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Initialize Instance and set layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_stats);

        //Initialize Shared-Preference-Object
        mySP = getSharedPreferences("myData", MODE_PRIVATE);

        //Connect object with views
        btnMainMenu = findViewById(R.id.btnMainMenu);
        btnPlayer = findViewById(R.id.btnPlayer);
        txtDraws = findViewById(R.id.txtNrDraws);
        txtLosses = findViewById(R.id.txtNrLosses);
        txtWins = findViewById(R.id.txtNrWins);

        //Fill statistics table with data from DataStorage
        fillStatistic();
    }

    /* Get data from SharedPreference-Object and safe in DataStorage-Object. If SP-Object empty,
     * create new DataStorage-Object.
     */
    public void pullStatistics(){
        Gson gson = new Gson();
        String data = mySP.getString("data", "");
        myDS = gson.fromJson(data, DataStorage.class);
        if (myDS == null){
            myDS = new DataStorage();
        }
    }

    /* Safe data from DataStorage-Object in SharedPreferences-Object as JSON.
     */
    public void pushStatistics(){
        SharedPreferences.Editor myEditor = mySP.edit();
        Gson gson = new Gson();
        String data = gson.toJson(myDS);
        myEditor.putString("data", data);
        myEditor.apply();
    }

    /* Get DataStorage-Object and fill table with data from DataStorage-Object.
     */
    public void fillStatistic() {
        //Get data from SharedPreference-Object in DataStorage-Object
        pullStatistics();

        //Use switch according to chosen player-slot in DataStorage and fill TextViews with data.
        switch (player) {
            case 1:
                btnPlayer.setText(String.valueOf(myDS.getSlot1name()));
                txtWins.setText(String.valueOf(myDS.getSlot1wins()));
                txtLosses.setText(String.valueOf(myDS.getSlot1losses()));
                txtDraws.setText(String.valueOf(myDS.getSlot1draws()));
                break;
            case 2:
                btnPlayer.setText(String.valueOf(myDS.getSlot2name()));
                txtWins.setText(String.valueOf(myDS.getSlot2wins()));
                txtLosses.setText(String.valueOf(myDS.getSlot2losses()));
                txtDraws.setText(String.valueOf(myDS.getSlot2draws()));
                break;
            case 3:
                btnPlayer.setText(String.valueOf(myDS.getSlot3name()));
                txtWins.setText(String.valueOf(myDS.getSlot3wins()));
                txtLosses.setText(String.valueOf(myDS.getSlot3losses()));
                txtDraws.setText(String.valueOf(myDS.getSlot3draws()));
                break;
            case 4:
                btnPlayer.setText(String.valueOf(myDS.getSlot4name()));
                txtWins.setText(String.valueOf(myDS.getSlot4wins()));
                txtLosses.setText(String.valueOf(myDS.getSlot4losses()));
                txtDraws.setText(String.valueOf(myDS.getSlot4draws()));
                break;
            case 5:
                btnPlayer.setText(String.valueOf(myDS.getSlot5name()));
                txtWins.setText(String.valueOf(myDS.getSlot5wins()));
                txtLosses.setText(String.valueOf(myDS.getSlot5losses()));
                txtDraws.setText(String.valueOf(myDS.getSlot5draws()));
                break;
            case 6:
                btnPlayer.setText(getString(R.string.leonard));
                txtWins.setText(String.valueOf(myDS.getLeonardWins()));
                txtLosses.setText(String.valueOf(myDS.getLeonardLosses()));
                txtDraws.setText(String.valueOf(myDS.getLeonardDraws()));
                break;
            case 7:
                btnPlayer.setText(getString(R.string.penny));
                txtWins.setText(String.valueOf(myDS.getPennyWins()));
                txtLosses.setText(String.valueOf(myDS.getPennyLosses()));
                txtDraws.setText(String.valueOf(myDS.getPennyDraws()));
                break;
            case 8:
                btnPlayer.setText(getString(R.string.sheldon));
                txtWins.setText(String.valueOf(myDS.getSheldonWins()));
                txtLosses.setText(String.valueOf(myDS.getSheldonLosses()));
                txtDraws.setText(String.valueOf(myDS.getSheldonDraws()));
                break;
        }
    }

    /* Create and fill menu with slot names from DataStorage when button btnPlayer is clicked.
     * After menu item is chosen set variable player to concurrent slot in DataStorage.
     * @param v Button btnPlayer
     */
    public void onClickPlayer(View v) {
        //Declare and initialize menu
        PopupMenu playerMenu = new PopupMenu(PlayerStatsActivity.this, btnPlayer);
        playerMenu.getMenuInflater().inflate(R.menu.menu_player, playerMenu.getMenu());

        //Set menu items title to concurrent slot names from DataStorage
        playerMenu.getMenu().getItem(0).setTitle(myDS.getSlot1name());
        playerMenu.getMenu().getItem(1).setTitle(myDS.getSlot2name());
        playerMenu.getMenu().getItem(2).setTitle(myDS.getSlot3name());
        playerMenu.getMenu().getItem(3).setTitle(myDS.getSlot4name());
        playerMenu.getMenu().getItem(4).setTitle(myDS.getSlot5name());

        //Use switch to set variable player
        playerMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.slot1:
                        player = 1;
                        break;
                    case R.id.slot2:
                        player = 2;
                        break;
                    case R.id.slot3:
                        player = 3;
                        break;
                    case R.id.slot4:
                        player = 4;
                        break;
                    case R.id.slot5:
                        player = 5;
                        break;
                    case R.id.leonard:
                        player = 6;
                        break;
                    case R.id.penny:
                        player = 7;
                        break;
                    case R.id.sheldon:
                        player = 8;
                        break;
                    default:
                        break;
                }

                //Fill statistics table new with data from DataStorage
                fillStatistic();
                return true;
            }
        });
        playerMenu.show();
    }

    /* Set data of chosen slot (indicated by variable player) to 0 when button btnDeletePlayer is
     * clicked.
     * @param v Button btnDeletePlayer
     */
    public void onClickDeletePlayer(View v){
        //Set data in DataStorage of chosen player slot to 0.
        switch (player){
            case 1:
                myDS.setSlot1wins(0);
                myDS.setSlot1draws(0);
                myDS.setSlot1losses(0);
                break;
            case 2:
                myDS.setSlot2wins(0);
                myDS.setSlot2draws(0);
                myDS.setSlot2losses(0);
                break;
            case 3:
                myDS.setSlot3wins(0);
                myDS.setSlot3draws(0);
                myDS.setSlot3losses(0);
                break;
            case 4:
                myDS.setSlot4wins(0);
                myDS.setSlot4draws(0);
                myDS.setSlot4losses(0);
                break;
            case 5:
                myDS.setSlot5wins(0);
                myDS.setSlot5draws(0);
                myDS.setSlot5losses(0);
                break;
        }

        //Save data from DataStorage-Object in SharedPreference-Object
        pushStatistics();

        //Fill statistics table new with data from DataStorage
        fillStatistic();
    }
    public void onClickDeleteAll(View v){
        myDS.setSlot1wins(0);
        myDS.setSlot1draws(0);
        myDS.setSlot1losses(0);
        myDS.setSlot2wins(0);
        myDS.setSlot2draws(0);
        myDS.setSlot2losses(0);
        myDS.setSlot3wins(0);
        myDS.setSlot3draws(0);
        myDS.setSlot3losses(0);
        myDS.setSlot4wins(0);
        myDS.setSlot4draws(0);
        myDS.setSlot4losses(0);
        myDS.setSlot5wins(0);
        myDS.setSlot5draws(0);
        myDS.setSlot5losses(0);
        myDS.setLeonardWins(0);
        myDS.setLeonardLosses(0);
        myDS.setLeonardDraws(0);
        myDS.setPennyWins(0);
        myDS.setPennyLosses(0);
        myDS.setPennyDraws(0);
        myDS.setSheldonWins(0);
        myDS.setSheldonLosses(0);
        myDS.setSheldonDraws(0);


        //Save data from DataStorage-Object in SharedPreference-Object
        pushStatistics();

        //Fill statistics table new with data from DataStorage
        fillStatistic();
    }

    /* Return to MainActivity, when button btnMainMenu is clicked.
     * @param v Button btnMainMenu
     */
    public void onClickMainMenu(View v) {
        Intent intent = new Intent(PlayerStatsActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
