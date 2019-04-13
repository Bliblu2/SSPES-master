package bim17.sspes;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;

public class StatusText extends AppCompatActivity {

    DataStorage myDS;
    SharedPreferences mySP;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        mySP = getSharedPreferences("myData", MODE_PRIVATE);
        pullStatistics();
    }

    public String changeStatusText(int elementOne, int elementTwo, int winner){
        mySP = getSharedPreferences("myData", MODE_PRIVATE);
        pullStatistics();
        String elementText = "Fehler";
        String playerText = "Fehler";
        int player1 = myDS.getPlayer1();
        int player2 = myDS.getPlayer2();

        //Set element text based on elements played
        if ((elementOne == 1 && elementTwo == 2) || (elementOne == 2 && elementTwo == 1)){
            elementText = getString(R.string.scissorsVsRock);
        } else if ((elementOne == 1 && elementTwo == 3) || (elementOne == 3 && elementTwo == 1)){
            elementText = getString(R.string.scissorsVsPaper);
        } else if ((elementOne == 1 && elementTwo == 4) ||(elementOne == 4 && elementTwo == 1)){
            elementText = getString(R.string.scissorsVsLizard);
        } else if ((elementOne == 1 && elementTwo == 5) || (elementOne == 5 && elementTwo == 1)){
            elementText = getString(R.string.scissorsVsSpock);
        } else if ((elementOne == 2 && elementTwo == 3) || (elementOne == 3 && elementTwo == 2)){
            elementText = getString(R.string.rockVsPaper);
        } else if ((elementOne == 2 && elementTwo == 4) || (elementOne == 4 && elementTwo == 2)){
            elementText = getString(R.string.rockVsLizard);
        } else if ((elementOne == 2 && elementTwo == 5) || (elementOne == 5 && elementTwo == 2)){
            elementText = getString(R.string.rockVsSpock);
        } else if ((elementOne == 3 && elementTwo == 4) || (elementOne == 4 && elementTwo == 3)){
            elementText = getString(R.string.paperVsLizard);
        } else if ((elementOne == 3 && elementTwo == 5) || (elementOne == 5 && elementTwo == 3)){
            elementText = getString(R.string.paperVsSpock);
        } else if ((elementOne == 4 && elementTwo == 5) || (elementOne == 5 && elementTwo == 4)){
            elementText = getString(R.string.lizardVsSpock);
        }

        //Set player text based on winner
        if (winner == 1){
            playerText = player1 + " " + getString(R.string.winsTxt) + ".";
        } else if (winner == 2){
            playerText = player2 + " " + getString(R.string.winsTxt) + ".";
        }


        String statusText = elementText + "\n" + playerText;

        return statusText;
    }


    //Set element text based on element when draw
    public String changeStatusText(int element) {
        mySP = getSharedPreferences("myData", MODE_PRIVATE);
        pullStatistics();
        String elementText = "Fehler";
        elementText = getString(R.string.draw) + "!";
        return elementText;
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
}
