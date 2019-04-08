package bim17.sspes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

public class EditPlayerActivity extends AppCompatActivity {
    Button btnDone;
    Button delete1, delete2, delete3, delete4, delete5;
    Button save1, save2, save3, save4, save5;
    TextView slot1name, slot2name, slot3name, slot4name, slot5name;
    EditText slot1, slot2, slot3, slot4, slot5;
    DataStorage myDS;
    SharedPreferences mySP;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_player);
        btnDone = findViewById(R.id.btnDone);
        delete1 = findViewById(R.id.btndelete1);
        delete2 = findViewById(R.id.btndelete2);
        delete3 = findViewById(R.id.btndelete3);
        delete4 = findViewById(R.id.btndelete4);
        delete5 = findViewById(R.id.btndelete5);
        slot1 = findViewById(R.id.editText1);
        slot2 = findViewById(R.id.editText2);
        slot3 = findViewById(R.id.editText3);
        slot4 = findViewById(R.id.editText4);
        slot5 = findViewById(R.id.editText5);
        slot1name = findViewById(R.id.slot1name);
        slot2name = findViewById(R.id.slot2name);
        slot3name = findViewById(R.id.slot3name);
        slot4name = findViewById(R.id.slot4name);
        slot5name = findViewById(R.id.slot5name);
        save1 = findViewById(R.id.btnSave1);
        save2 = findViewById(R.id.btnSave2);
        save3 = findViewById(R.id.btnSave3);
        save4 = findViewById(R.id.btnSave4);
        save5 = findViewById(R.id.btnSave5);
        mySP = getSharedPreferences("myData", MODE_PRIVATE);
        pullStatistics();
        nameSlot1();
        nameSlot2();
        nameSlot3();
        nameSlot4();
        nameSlot5();
    }

    public void nameSlot1(){
        pullStatistics();
        slot1name.setText(String.valueOf(myDS.getSlot1name()));
    }
    public void nameSlot2(){
        pullStatistics();
        slot2name.setText(String.valueOf(myDS.getSlot2name()));
    }
    public void nameSlot3() {
        pullStatistics();
        slot3name.setText(String.valueOf(myDS.getSlot3name()));
    }
    public void nameSlot4(){
        pullStatistics();
        slot4name.setText(String.valueOf(myDS.getSlot4name()));
    }
    public void nameSlot5(){
        pullStatistics();
        slot5name.setText(String.valueOf(myDS.getSlot5name()));
    }


    public void onClickDone(View v) {
        Intent intent = new Intent(EditPlayerActivity.this, MainActivity.class);
        startActivity(intent);
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

    public void onClickSave1(View v){
        myDS.setSlot1name(slot1.getText().toString());
        pushStatistics();
        refreshSlot1();
    }
    public void onClickSave2(View v){
        myDS.setSlot2name(slot2.getText().toString());
        pushStatistics();
        refreshSlot2();
    }
    public void onClickSave3(View v){
        myDS.setSlot3name(slot3.getText().toString());
        pushStatistics();
        refreshSlot3();
    }
    public void onClickSave4(View v){
        myDS.setSlot4name(slot4.getText().toString());
        pushStatistics();
        refreshSlot4();
    }
    public void onClickSave5(View v){
        myDS.setSlot5name(slot5.getText().toString());
        pushStatistics();
        refreshSlot5();
    }

    public void onClickDelete1(View v) {
        myDS.deleteSlot(1);
        pushStatistics();
        refreshSlot1();
    }
    public void onClickDelete2(View v) {
        myDS.deleteSlot(2);
        pushStatistics();
        refreshSlot2();
    }
    public void onClickDelete3(View v) {
        myDS.deleteSlot(3);
        pushStatistics();
        refreshSlot3();
    }
    public void onClickDelete4(View v) {
        myDS.deleteSlot(4);
        pushStatistics();
        refreshSlot4();
    }
    public void onClickDelete5(View v) {
        myDS.deleteSlot(5);
        pushStatistics();
        refreshSlot5();
    }

    public void refreshSlot1(){
        pullStatistics();
        nameSlot1();
        slot1.setText("");
    }
    public void refreshSlot2(){
        pullStatistics();
        nameSlot2();
        slot2.setText("");
    }
    public void refreshSlot3(){
        pullStatistics();
        nameSlot3();
        slot3.setText("");
    }
    public void refreshSlot4(){
        pullStatistics();
        nameSlot4();
        slot4.setText("");
    }
    public void refreshSlot5(){
        pullStatistics();
        nameSlot5();
        slot5.setText("");
    }

}
