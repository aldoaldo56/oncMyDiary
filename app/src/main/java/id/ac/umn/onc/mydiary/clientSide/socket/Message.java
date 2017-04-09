package id.ac.umn.onc.mydiary.clientSide.socket;

import java.io.Serializable;

/**
 * Created by aldo_ on 09/04/2017.
 */

public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    public String type, sender, content, recipient;

    public Message(String type, String sender, String content, String recipient){
        this.type = type; this.sender = sender; this.content = content; this.recipient = recipient;
    }

    @Override
    public String toString(){
        return "{type='"+type+"', sender='"+sender+"', content='"+content+"', recipient='"+recipient+"'}";
    }
}
