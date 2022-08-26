package alura.com.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import alura.com.aluraviagens.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                iniciarLista();
            }
        }, 2000);
    }

    private void iniciarLista() {
        Intent intent = new Intent(this, ListaPacotesActivity.class);
        startActivity(intent);
        finish();
    }
}
