package id.ac.umn.onc.mydiary.clientSide.socket;

import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import id.ac.umn.onc.mydiary.LoginActivity;
import id.ac.umn.onc.mydiary.SelectHostActivity;


/**
 * Created by aldo_ on 10/04/2017.
 */

public class ClientSocket  implements Runnable{
    public int port;
    public String serverAddr;
    public Socket socket;
    public SelectHostActivity ui;
    public LoginActivity uiLogin;
    public DataInputStream In;
    public DataOutputStream Out;
    public String message;

    public ClientSocket(SelectHostActivity ui) throws IOException {
        this.ui = ui;
        this.serverAddr = ui.addrEdit.getText().toString();
        this.port = Integer.parseInt(ui.portEdit.getText().toString());
        socket = new Socket(InetAddress.getByName(serverAddr),port);
        Out = new DataOutputStream(socket.getOutputStream());
        In = new DataInputStream(socket.getInputStream());
        Out.flush();
        this.ui = ui;
    }

    @Override
    public void run(){
        while(true){
            try{
                String msg = In.readUTF();
                message = msg;
                System.out.println("Incoming : "+msg);
            }
            catch (Exception e){
                System.out.println("Disconnected From Server");
                break;
            }
        }
    }

    public void logout(){
        try {
            Out.writeUTF("56c93ea0dda0b9bac4aa1f225ff6127b");
            System.out.println("Outgoing : 56c93ea0dda0b9bac4aa1f225ff6127b");
        }
        catch (Exception ex) {
            System.out.println("Message Error");
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
