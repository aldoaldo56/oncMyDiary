package id.ac.umn.onc.mydiary;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import id.ac.umn.onc.mydiary.clientSide.socket.Message;
import id.ac.umn.onc.mydiary.clientSide.socket.SocketClient;

public class SelectHostActivity extends AppCompatActivity {
    public TextView addrText, portText;
    public EditText addrEdit, portEdit;
    public Button connectButton, localButton;
    public static SocketClient client;
    public Thread clientThread;
    public final SelectHostActivity selectHostActivity = this;

    public void makeToast(String message){
        Toast.makeText(selectHostActivity, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Enable Thread Policy
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_host);

        addrText = (TextView) findViewById(R.id.txtViewAddr);
        portText = (TextView) findViewById(R.id.txtViewPort);
        addrEdit = (EditText) findViewById(R.id.txtAddr);
        portEdit = (EditText) findViewById(R.id.txtPort);
        connectButton = (Button) findViewById(R.id.btnConnect);
        localButton = (Button) findViewById(R.id.btnLocalData);

        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                try {
                    client = new SocketClient(selectHostActivity);
                    clientThread = new Thread(client);
                    clientThread.start();
                    //client.send(new Message("test", "testUser", "testContent", "SERVER"));
                    Toast.makeText(selectHostActivity, "Connection Ok", Toast.LENGTH_SHORT).show();
                    client.send(new Message("test", "testUser", "testContent", "SERVER"));
                    startActivity(new Intent(SelectHostActivity.this, LoginActivity.class));

                } catch (Exception e) {
                    Toast.makeText(SelectHostActivity.this, "Server not found", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
}
}
