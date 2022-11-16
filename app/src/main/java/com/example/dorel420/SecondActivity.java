package com.example.dorel420;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    TextView tv5, tv6, tv7, tv8;
    ListView lisv3;
    String [] list1 = new String[20];
    Double [] arr2 = new Double[20];
    double first, num1;
    boolean nom1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv5 = findViewById(R.id.tv5);
        tv6 = findViewById(R.id.tv6);
        tv7 = findViewById(R.id.tv7);
        tv8 = findViewById(R.id.tv8);
        lisv3 = findViewById(R.id.lisv3);
        Intent gi = getIntent();
        first = gi.getDoubleExtra("n",0);
        num1 = gi.getDoubleExtra("nn",0);
        nom1 = gi.getBooleanExtra("nnn",true);
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list1);
        lisv3.setAdapter(adp);
        lisv3.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lisv3.setOnItemClickListener(this);
        tv5.setText(Double.toString(first));
        tv6.setText(Double.toString(num1));
        if(nom1 == true){
            Mathemtical();
        }
        else{
            Geometrical();
        }
    }

    public void Mathemtical(){
       for(int i=0; i<20;i++){
           arr2[i] = first;
           int x  = dorelkrief(Double.toString(first));
           String str1 = String.format("%.02f",first);
           if(x>2){
               list1[i] = str1 + "E" + Integer.toString(x-2);
           }
           else{
               list1[i] = str1;
           }
           first = first + num1;
       }
    }

    public void Geometrical(){
        for(int ii=0; ii<20;ii++){
            arr2[ii] = first;
            int y = dorelkrief(Double.toString(first));
            String str4 = String.format("%.02f",first);
            if(y>2){
                list1[ii] = str4 + "E" + Integer.toString(y-2);
            }
            else{
                list1[ii] = str4;
            }
            first = first * num1;
        }
    }

    public int dorelkrief(String lol){
        int q = lol.indexOf(".");
        int E = lol.indexOf("E");
        if(E==-1){
            return (lol.substring(q+1)).length();
        }
        else{
            return (lol.substring(q+1)).length()+Integer.parseInt(lol.substring(E+1));
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Double all = 0.0;
        tv7.setText(Integer.toString(i+1));
        for(int m =0; m<i+1;m++){
            all = all + arr2[m];
        }
        int tivdok = dorelkrief(Double.toString(all));
        String str5 = String.format("%.02f", all);
        if(tivdok>2){
            tv8.setText(str5 + "E" + Integer.toString(tivdok-2));
        }
        else{
            tv8.setText(str5);
        }
    }

    public void end(View view) {
        finish();
    }
}