package br.senai.sp.agenda.agenda;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.senai.sp.agenda.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                intentListaContatos();
            }
        },3500);

    }

    private void intentListaContatos(){
        Intent intent = new Intent(SplashActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(android.R.anim.fade_in ,android.R.anim.fade_out);
    }

}
