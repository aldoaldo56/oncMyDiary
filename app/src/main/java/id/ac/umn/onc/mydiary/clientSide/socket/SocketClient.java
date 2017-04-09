package id.ac.umn.onc.mydiary.clientSide.socket;

import android.content.Context;
import android.widget.Toast;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import id.ac.umn.onc.mydiary.SelectHostActivity;

/**
 * Created by aldo_ on 09/04/2017.
 */

public class SocketClient implements Runnable{
    public int port;
    public String serverAddr;
    public Socket socket;
    public SelectHostActivity ui;
    public ObjectInputStream In;
    public ObjectOutputStream Out;

    public SocketClient(SelectHostActivity ui) throws IOException{
        this.ui = ui;
        this.serverAddr = ui.addrEdit.getText().toString();
        this.port = Integer.parseInt(ui.portEdit.getText().toString());
        socket = new Socket(InetAddress.getByName(serverAddr),port);
        Out = new ObjectOutputStream(socket.getOutputStream());
        Out.flush();
        In = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public void run(){
        while(true){
            try{
                Message msg = (Message) In.readObject();
                System.out.println("Incoming : "+msg.toString());
            }
            catch (Exception e){
                System.out.println("Something wrong");
            }
        }
    }

    public void send(Message msg){
        try {
            Out.writeObject(msg);
            Out.flush();
            System.out.println("Outgoing : "+msg.toString());
        }
        catch (Exception ex) {
            System.out.println("Message Error");
        }
    }

    public void closeThread(Thread t){
        t = null;
    }
}
