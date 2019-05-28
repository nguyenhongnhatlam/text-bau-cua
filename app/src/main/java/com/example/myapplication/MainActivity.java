package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity
{
    Button btnInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInfo = (Button)findViewById(R.id.button);



        Button btnCancel =  (Button)findViewById(R.id.button2);
        Button btnInfo =  (Button)findViewById(R.id.button);
        final EditText geteditName =  (EditText)findViewById(R.id.editText2);
        final EditText geteditEmail =  (EditText)findViewById(R.id.editText3);
        final CheckBox getchkCoding =  (CheckBox) findViewById(R.id.checkBox3);
        final CheckBox getchkReading =  (CheckBox) findViewById(R.id.checkBox);
        final CheckBox getchkTravelling =  (CheckBox) findViewById(R.id.checkBox2);
        final RadioButton getMale =  (RadioButton) findViewById(R.id.radioButton2);
        final RadioButton getFemale =  (RadioButton) findViewById(R.id.radioButton3);
        final Spinner getspinLang =  (Spinner) findViewById(R.id.spinner);
        final Switch getswitchExpert =  (Switch) findViewById(R.id.switch1);



        btnCancel.setOnClickListener(new View.OnClickListener() {
                                         public void onClick(View v) {
                                             cancel(v);
                                         }
                                     }
        );
        btnInfo.setOnClickListener(new View.OnClickListener() {
                                       public void onClick(View v) {
                                           String msg = "Tên: " + geteditName.getText().toString() +
                                                   System.getProperty("line.separator") +
                                                   "Email: " + geteditEmail.getText().toString();
                                           msg += System.getProperty("line.separator") + "Sở thích: ";

                                           geteditName.setText("");
                                           geteditEmail.setText("");



                                           if(getchkCoding.isChecked())
                                               msg +=  getchkCoding.getText().toString()+ ", ";
                                           if(getchkReading.isChecked())
                                               msg += getchkReading.getText().toString() + ", ";
                                           if(getchkTravelling.isChecked())
                                               msg += getchkTravelling.getText().toString()+ ",  ";

                                           msg += System.getProperty("line.separator") + "Giới tính: ";

                                           getchkCoding.setChecked(false);
                                           getchkReading.setChecked(false);
                                           getchkTravelling.setChecked(false);

                                           if(getFemale.isChecked())
                                               msg += getFemale.getText().toString();
                                           if(getMale.isChecked())
                                               msg += getMale.getText().toString();

                                           getFemale.setChecked(false);
                                           getMale.setChecked(false);
                                           msg += System.getProperty("line.separator") + "Ngôn ngữ của tôi: " + getspinLang.getSelectedItem().toString();

                                           msg += System.getProperty("line.separator") + "Xác nhận thông tin trên là đúng: ";

                                           if(getswitchExpert.isChecked())
                                               msg += "Có";
                                           else
                                               msg += "Không";

                                           info(v,msg);



                                       }
                                   }
        );



    }

    public void info(View v, String msg)
    {
        Intent mh2;
        mh2 = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(mh2);


        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setMessage(msg);
        dlgAlert.setTitle("Thông Tin:");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();

    }
    public void cancel(View v){
        System.exit(0);
    }
}