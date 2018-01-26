package com.example.projetofficielm1stic;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by DIOUF ABBAS on 26/02/2016.
 */
public class Acceuil extends Activity {

    private EditText editLog, editPass;
    private Button btn;
    private String monUsName, monPw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);//enlève le titre dans l'activité
        //pour mettre une activité en plein ecran
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.acceuil);

        monUsName = getResources().getString(R.string.us);
        monPw = getResources().getString(R.string.pw);
        editLog = (EditText) findViewById(R.id.edtLogin);
        editPass = (EditText) findViewById(R.id.edtPwd);
        btn = (Button) findViewById(R.id.btnCnx);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editLog.getText().toString().equals("")||editPass.getText().toString().equals(""))
                {
                    AlertDialog alert = new AlertDialog.Builder(Acceuil.this).create();
                    alert.setTitle("Erreur!!!");
                    alert.setMessage("Il faut remplir tous les champs");
                    alert.setButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }

                    });
                    alert.show();
                }else if(editLog.getText().toString().equals(monUsName)&&editPass.getText().toString().equals(monPw))
                {
                    Toast.makeText(Acceuil.this,"Connexion reussie",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Acceuil.this,Bienvenue.class);
                    i.putExtra("keybi",monUsName);
                    startActivity(i);
                    finish();
                }
                else
                {
                    AlertDialog alert = new AlertDialog.Builder(Acceuil.this).create();
                    alert.setTitle("Erreur!!!");
                    alert.setMessage("Nom utilisateur ou mot de passe incorrect");
                    alert.setButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }

                    });
                    alert.show();
                }
            }
        });
    }
}
