package id.ac.umn.onc.mydiary.clientSide.socket;

import android.app.Activity;
import android.os.Looper;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import id.ac.umn.onc.mydiary.SelectHostActivity;

/**
 * Created by aldo_ on 10/04/2017.
 */

public class ClientSocket  implements Runnable{
    public int port;
    public String serverAddr;
    public Socket socket;
    public Activity activity;
    public SelectHostActivity ui;
    public DataInputStream In;
    public DataOutputStream Out;

    public ClientSocket(SelectHostActivity ui) throws IOException {
        this.ui = ui;
        this.serverAddr = ui.addrEdit.getText().toString();
        this.port = Integer.parseInt(ui.portEdit.getText().toString());
        socket = new Socket(InetAddress.getByName(serverAddr),port);
        Out = new DataOutputStream(socket.getOutputStream());
        In = new DataInputStream(socket.getInputStream());
        Out.flush();
        activity = ui;
    }

    public void  currActivity(Activity x){
        activity = x;
    }

    @Override
    public void run(){
        while(true){
            try{
                String msg = In.readUTF();
                System.out.println("Incoming : "+msg);
            }
            catch (Exception e){
                System.out.println("Something wrong");
                activity.finish();
                break;
            }
        }
    }

    public void send(String msg){
        try {
            Out.writeUTF(msg);
            System.out.println("Outgoing : "+msg);
        }
        catch (Exception ex) {
            System.out.println("Message Error");
        }
    }

    public void closeThread(Thread t){
        t = null;
    }
}
