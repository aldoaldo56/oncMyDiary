package id.ac.umn.onc.mydiary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import id.ac.umn.onc.mydiary.clientSide.socket.Message;

public class LoginActivity extends AppCompatActivity {
    Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton = (Button) findViewById(R.id.btnLogin);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectHostActivity.client.send(new Message("login", "user2", "password", "SERVER"));
                //Toast.makeText(LoginActivity.this, "Login Login", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
