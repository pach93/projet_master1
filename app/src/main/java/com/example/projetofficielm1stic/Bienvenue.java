package com.example.projetofficielm1stic;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by DIOUF ABBAS on 04/03/2016.
 */
public class Bienvenue extends Activity {
    private TextView txtv;
    private ListView listv;
    String[] values;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bienvenue);
        txtv = (TextView) findViewById(R.id.textView);
        txtv.setText("Bienvenue: "+getIntent().getExtras().getString("keybi"));
        listv = (ListView) findViewById(R.id.lTV);

    values  = new String[] {"lundi",
            "mardi",
            "mercredi",
            "jeudi",
            "vendredi",
            "samedi",
            "dimanche"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,android.R.id.text1,values);
        listv.setAdapter(adapter);
        listv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String valeur = (String) listv.getItemAtPosition(position);
                Toast.makeText(Bienvenue.this," valeur =" + valeur, Toast.LENGTH_SHORT).show();
            }
        });

        listv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String valeur = (String) listv.getItemAtPosition(position);
                Toast.makeText(Bienvenue.this, "Position=" + position, Toast.LENGTH_SHORT).show();

                return true;
            }
        });



    }
}
