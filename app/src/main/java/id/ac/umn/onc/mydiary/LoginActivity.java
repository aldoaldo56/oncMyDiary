package id.ac.umn.onc.mydiary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.ac.umn.onc.mydiary.clientSide.socket.Message;

public class LoginActivity extends AppCompatActivity {
    Button loginButton;
    EditText inputEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton = (Button) findViewById(R.id.btnLogin);
        inputEdit = (EditText) findViewById(R.id.txtInput);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputEdit.getText().equals("")){
                    inputEdit.setError("Jangan Kosong !");
                }
                else {
                    SelectHostActivity.client.send(inputEdit.getText().toString());
                    inputEdit.setText("");
                }

            }
        });
    }
}
