package bim17.sspes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RulesActivity extends AppCompatActivity {

    // Variablen deklariren
    Button btnBack;
    TextView txtRules, txtRulesHeading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        // Verknuepfungen zum Layout erstellen
        btnBack = findViewById(R.id.btnMainMenu);
        txtRules = findViewById(R.id.txtRules);
        txtRulesHeading = findViewById(R.id.txtRulesHeading);
    }

    // neue Activity aufrufen, um zum Einstiegsbildschirm zurueckzukehren
    public void goToMainActivity (View v){
        Intent intent = new Intent(RulesActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
