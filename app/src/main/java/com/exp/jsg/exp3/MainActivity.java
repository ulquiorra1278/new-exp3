package com.exp.jsg.exp3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.SharedPreferences;
import android.app.AlertDialog;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      final   SharedPreferences  setting = getSharedPreferences("setting", MODE_PRIVATE);
        //保存按键
        Button set=(Button)this.findViewById(R.id.set);
        set.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                EditText t1 =(EditText)findViewById(R.id.Text1);
                EditText t2 =(EditText)findViewById(R.id.Text2);
                CharSequence k = t1.getText();
                CharSequence val= t2.getText();
                String key=k.toString();
                String value=val.toString();

                setting.edit().putString(key, value)
                        .commit();

                AlertDialog.Builder builder  = new  AlertDialog.Builder (MainActivity.this);
                builder.setTitle("成功" ) ;
                builder.setMessage("存入成功" ) ;
                builder.show();

            }
        });

        //读取按键
        Button get=(Button)this.findViewById(R.id.get);
        get.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText t11 =(EditText)findViewById(R.id.Text1);
                EditText t22 =(EditText)findViewById(R.id.Text2);
                CharSequence k = t11.getText();
                String key=k.toString();
                String thekey = setting.getString(key,"");
                CharSequence val;
                val=thekey;
                t22.setText(val);

                AlertDialog.Builder builder  = new  AlertDialog.Builder (MainActivity.this);
                builder.setTitle("成功" ) ;
                builder.setMessage("读取成功" ) ;
                builder.show();

            }
        });
    }



}
