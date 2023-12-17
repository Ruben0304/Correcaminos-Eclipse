package modelos.chats;

import java.util.ArrayList;

public class Chat {
    private ArrayList<Mensaje> chat;

    public Chat() {
        this.chat = new ArrayList<Mensaje>();
    }

    public ArrayList<Mensaje> getChat() {
        return chat;
    }
    
}
