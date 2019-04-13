package bim17.sspes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Random;

public class Strategy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static int playSheldon(){
        int pickSheldon = 5;
        return pickSheldon;
    }

    public static int playLeonard(){
        Random rndGen;
        rndGen = new Random();
        int pickLeonard = rndGen.nextInt(4)+1;
        return pickLeonard;
    }

    public static int playPenny(){
        Random rndGen;
        rndGen = new Random();
        int pickPenny = rndGen.nextInt(2)+1;
        return pickPenny;
    }

}
