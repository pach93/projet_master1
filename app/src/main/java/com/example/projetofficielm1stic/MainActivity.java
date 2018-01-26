package com.example.projetofficielm1stic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  requestWindowFeature(Window.FEATURE_NO_TITLE);//enlève le titre dans l'activité
        //pour mettre une activité en plein ecran
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        afficherLaSecondeActivite();
    }

    private void afficherLaSecondeActivite() {
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent i = new Intent(MainActivity.this,Acceuil.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}
