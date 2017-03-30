package es.uniovi.asw.dbmanagement.model;

/**
 * Created by fercats on 3/30/17.
 */
public class Message {

    public Message(){

    }

    public Message(String param){
        this.message = param;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;



}
