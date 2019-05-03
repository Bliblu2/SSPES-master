package bim17.sspes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.gson.Gson;

/* Activity class to show statistic data for elements.
 * @author Carolin Ludwig, Sabrina Krietsch, Lena Glaesener
 * @version 1.0 03.2019
 */
public class ElementsStatsActivity extends MainActivity {
    // SharedPreferences-Object for long time memory
    SharedPreferences mySP;

    //DataStorage-Object for short time memory
    DataStorage myDS;

    //Declare Buttons and Textviews
    Button btnMainMenu;
    Button btnDelete;
    TextView txtWins, txtLosses, txtDraws;
    TextView txtRockWins, txtRockLosses, txtRockDraws;
    TextView txtPaperWins, txtPaperLosses, txtPaperDraws;
    TextView txtScissorsWins, txtScissorsLosses, txtScissorsDraws;
    TextView txtLizardWins, txtLizardLosses, txtLizardDraws;
    TextView txtSpockWins, txtSpockLosses, txtSpockDraws;

    /* Method used when opening the activity.
     * @param Bundle savedInstanceState The saved instance state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //initialize Instance and set layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elements_stats);

        //initialize long time memory
        mySP = getSharedPreferences("myData", MODE_PRIVATE);

        //Connect object with views
        btnMainMenu = findViewById(R.id.btnMainMenu);
        btnDelete = findViewById(R.id.btnDelete);

        txtWins = findViewById(R.id.txtWins);
        txtLosses = findViewById(R.id.txtLosses);
        txtDraws = findViewById(R.id.txtDraws);

        txtRockWins = findViewById(R.id.txtRockWins);
        txtRockLosses = findViewById(R.id.txtRockLosses);
        txtRockDraws = findViewById(R.id.txtRockDraws);

        txtPaperWins = findViewById(R.id.txtPaperWins);
        txtPaperLosses = findViewById(R.id.txtPaperLosses);
        txtPaperDraws = findViewById(R.id.txtPaperDraws);

        txtScissorsWins = findViewById(R.id.txtScissorsWins);
        txtScissorsLosses = findViewById(R.id.txtScissorsLosses);
        txtScissorsDraws = findViewById(R.id.txtScissorsDraws);

        txtLizardWins = findViewById(R.id.txtLizardWins);
        txtLizardLosses = findViewById(R.id.txtLizardLosses);
        txtLizardDraws = findViewById(R.id.txtLizardDraws);

        txtSpockWins = findViewById(R.id.txtSpockWins);
        txtSpockLosses = findViewById(R.id.txtSpockLosses);
        txtSpockDraws = findViewById(R.id.txtSpockDraws);

        //Fill statistics table with data from short time memory
        fillTable();
    }

    /* Get data from long time memory and safe in short time memory.
     */
    public void pullStatistics(){
        Gson gson = new Gson();
        String data = mySP.getString("data", "");
        myDS = gson.fromJson(data, DataStorage.class);
        if (myDS == null){
            myDS = new DataStorage();
        }
    }

    /* Safe data from short time memory in long time memory as JSON.
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
    public void fillTable(){
        //get DataStorage-Object
        pullStatistics();

        //Fill table with data from DataStorage-Object
        txtRockWins.setText(String.valueOf(myDS.getRockWins()));
        txtRockLosses.setText(String.valueOf(myDS.getRockLosses()));
        txtRockDraws.setText(String.valueOf(myDS.getRockDraws()));
        txtPaperWins.setText(String.valueOf(myDS.getPaperWins()));
        txtPaperLosses.setText(String.valueOf(myDS.getPaperLosses()));
        txtPaperDraws.setText(String.valueOf(myDS.getPaperDraws()));
        txtScissorsWins.setText(String.valueOf(myDS.getScissorsWins()));
        txtScissorsLosses.setText(String.valueOf(myDS.getScissorsLosses()));
        txtScissorsDraws.setText(String.valueOf(myDS.getScissorsDraws()));
        txtLizardWins.setText(String.valueOf(myDS.getLizardWins()));
        txtLizardLosses.setText(String.valueOf(myDS.getLizardLosses()));
        txtLizardDraws.setText(String.valueOf(myDS.getLizardDraws()));
        txtSpockWins.setText(String.valueOf(myDS.getSpockWins()));
        txtSpockLosses.setText(String.valueOf(myDS.getSpockLosses()));
        txtSpockDraws.setText(String.valueOf(myDS.getSpockDraws()));
    }

    /* Set data in DataStorage-Object to 0, when button btnDelete is clicked.
     * Save new data in DataStorage-Object and then refresh data in table with data from
     * DataStorage-Object.
     * @param v Button btnDelete
     */
    public void onClickDelete(View v){
        //Set data in DataStorage-Object
        myDS.setRockWins(0);
        myDS.setRockLosses(0);
        myDS.setRockDraws(0);
        myDS.setPaperWins(0);
        myDS.setPaperLosses(0);
        myDS.setPaperDraws(0);
        myDS.setScissorsWins(0);
        myDS.setScissorsLosses(0);
        myDS.setScissorsDraws(0);
        myDS.setLizardWins(0);
        myDS.setLizardLosses(0);
        myDS.setLizardDraws(0);
        myDS.setSpockWins(0);
        myDS.setSpockLosses(0);
        myDS.setSpockDraws(0);

        //Save data in DataStorage-Object
        pushStatistics();

        //Fill table with data from DataStorage-Object
        fillTable();
    }

    /* Return to MainActivity, when button btnMainMenu is clicked.
     * @param v Button btnMainMenu
     */
    public void onClickMainMenu(View v) {
        Intent intent = new Intent(ElementsStatsActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
