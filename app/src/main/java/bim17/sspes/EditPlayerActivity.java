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

/* Class to change or clear the player slots including the statistical data
 * @author Carolin Ludwig, Sabrina Krietsch, Lena Glaesener
 * @version 1.0 5.2019
 */
public class EditPlayerActivity extends AppCompatActivity {
    //elements of the activity
    Button btnDone;
    Button delete1, delete2, delete3, delete4, delete5;
    Button save1, save2, save3, save4, save5;
    TextView slot1name, slot2name, slot3name, slot4name, slot5name;
    EditText slot1, slot2, slot3, slot4, slot5;

    //temporary memory
    DataStorage myDS;

    //longtime memory
    SharedPreferences mySP;

    /* Method used when opening the activity.
     * @param Bundle savedInstanceState The saved instance state.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_player);

        //connecting the elements with the element of the xml-file
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

        //initiating the longtime memory
        mySP = getSharedPreferences("myData", MODE_PRIVATE);

        //getting data from longtime memory
        pullStatistics();

        //showing the slot names
        nameSlot1();
        nameSlot2();
        nameSlot3();
        nameSlot4();
        nameSlot5();
    }

    /* Method to set name for slot one with data from memory
     */
    public void nameSlot1(){
        pullStatistics();
        slot1name.setText(String.valueOf(myDS.getSlot1name()));
    }

    /* Method to set name for slot two with data from memory
     */
    public void nameSlot2(){
        pullStatistics();
        slot2name.setText(String.valueOf(myDS.getSlot2name()));
    }

    /* Method to set name for slot three with data from memory
     */
    public void nameSlot3() {
        pullStatistics();
        slot3name.setText(String.valueOf(myDS.getSlot3name()));
    }

    /* Method to set name for slot four with data from memory
     */
    public void nameSlot4(){
        pullStatistics();
        slot4name.setText(String.valueOf(myDS.getSlot4name()));
    }

    /* Method to set name for slot five with data from memory
     */
    public void nameSlot5(){
        pullStatistics();
        slot5name.setText(String.valueOf(myDS.getSlot5name()));
    }

    /* Method to change activity
     * @param View v Element that is clicked
     */
    public void onClickDone(View v) {
        Intent intent = new Intent(EditPlayerActivity.this, MainActivity.class);
        startActivity(intent);
    }

    /* Method to set data into longtime memory
     */
    public void pushStatistics(){
        SharedPreferences.Editor myEditor = mySP.edit();
        Gson gson = new Gson();
        String data = gson.toJson(myDS);
        myEditor.putString("data", data);
        myEditor.apply();
    }

    /* Method to get data from longtime memory
     */
    public void pullStatistics(){
        Gson gson = new Gson();
        String data = mySP.getString("data", "");
        myDS = gson.fromJson(data, DataStorage.class);
        if (myDS == null){
            myDS = new DataStorage();
        }
    }

    /* Method to change name of slot 1
     * @param View v Element that is clicked
     */
    public void onClickSave1(View v){
        myDS.setSlot1name(slot1.getText().toString());
        pushStatistics();
        refreshSlot1();
    }

    /* Method to change name of slot 2
     * @param View v Element that is clicked
     */
    public void onClickSave2(View v){
        myDS.setSlot2name(slot2.getText().toString());
        pushStatistics();
        refreshSlot2();
    }

    /* Method to change name of slot 3
     * @param View v Element that is clicked
     */
    public void onClickSave3(View v){
        myDS.setSlot3name(slot3.getText().toString());
        pushStatistics();
        refreshSlot3();
    }

    /* Method to change name of slot 4
     * @param View v Element that is clicked
     */
    public void onClickSave4(View v){
        myDS.setSlot4name(slot4.getText().toString());
        pushStatistics();
        refreshSlot4();
    }

    /* Method to change name of slot 5
     * @param View v Element that is clicked
     */
    public void onClickSave5(View v){
        myDS.setSlot5name(slot5.getText().toString());
        pushStatistics();
        refreshSlot5();
    }

    /* Method to clear name and statistical data from slot 1
     * @param View v Element that is clicked
     */
    public void onClickDelete1(View v) {
        myDS.deleteSlot(1);
        pushStatistics();
        refreshSlot1();
    }

    /* Method to clear name and statistical data from slot 2
     * @param View v Element that is clicked
     */
    public void onClickDelete2(View v) {
        myDS.deleteSlot(2);
        pushStatistics();
        refreshSlot2();
    }

    /* Method to clear name and statistical data from slot 3
     * @param View v Element that is clicked
     */
    public void onClickDelete3(View v) {
        myDS.deleteSlot(3);
        pushStatistics();
        refreshSlot3();
    }

    /* Method to clear name and statistical data from slot 4
     * @param View v Element that is clicked
     */
    public void onClickDelete4(View v) {
        myDS.deleteSlot(4);
        pushStatistics();
        refreshSlot4();
    }

    /* Method to clear name and statistical data from slot 5
     * @param View v Element that is clicked
     */
    public void onClickDelete5(View v) {
        myDS.deleteSlot(5);
        pushStatistics();
        refreshSlot5();
    }

    /* Method to change the displayed name of slot 1
     */
    public void refreshSlot1(){
        pullStatistics();
        nameSlot1();
        slot1.setText("");
    }

    /* Method to change the displayed name of slot 2
     */
    public void refreshSlot2(){
        pullStatistics();
        nameSlot2();
        slot2.setText("");
    }

    /* Method to change the displayed name of slot 3
     */
    public void refreshSlot3(){
        pullStatistics();
        nameSlot3();
        slot3.setText("");
    }

    /* Method to change the displayed name of slot 4
     */
    public void refreshSlot4(){
        pullStatistics();
        nameSlot4();
        slot4.setText("");
    }

    /* Method to change the displayed name of slot 5
     */
    public void refreshSlot5(){
        pullStatistics();
        nameSlot5();
        slot5.setText("");
    }
}
