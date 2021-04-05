package com.ahmetburakakgul.kelimeoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative_layout);
        EditText editText = (EditText) findViewById(R.id.editTextMetin);
        ListView listView = (ListView) findViewById(R.id.listview);
        Button button = (Button) findViewById(R.id.btnKelimeGir);
        TextView tv1 = (TextView) findViewById(R.id.txtsonharf);
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        String harf="a";
        tv1.setText(harf);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = editText.getText().toString();

                if (newItem.equals("")) {
                    Toast.makeText(getApplicationContext(), "Lütfen Kelime Girin!", Toast.LENGTH_LONG).show();
                    return;
                }

                String str = newItem.substring(newItem.length() - 1);
                String ilkharf=newItem.substring(0,1);

                if (!ilkharf.equals(tv1.getText())){
                    Toast.makeText(getApplicationContext(), "Kelime Başlanacak Harfle Başlamalı!", Toast.LENGTH_LONG).show();
                    editText.setText("");
                }

                else{
                    for (String s:arrayList){
                        if (newItem.equals(s)){
                            Toast.makeText(getApplicationContext(), "Girilen Kelime Listede Mevcut!", Toast.LENGTH_LONG).show();
                            editText.setText("");
                            return;
                        }
                    }
                    tv1.setText(str);
                    arrayList.add(newItem);
                    listView.setAdapter(adapter);
                    editText.setText("");
                }
            }
        });

    }
}