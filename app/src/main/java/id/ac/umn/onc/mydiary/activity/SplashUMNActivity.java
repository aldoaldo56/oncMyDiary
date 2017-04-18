package id.ac.umn.onc.mydiary.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import id.ac.umn.onc.mydiary.R;

public class SplashUMNActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        overridePendingTransition(R.transition.fadein, R.transition.fadeout);
        setContentView(R.layout.activity_splash_umn);
        getSupportActionBar().hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashUMNActivity.this, SplashScreenONCActivity.class);
                startActivity(i);
                finish();
            }
        },3000);
    }
}