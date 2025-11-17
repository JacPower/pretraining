package org.example.dip;

public class EmailSender implements MessageSender {
    @Override
    public void send(String message) {
        System.out.println("Sending EMAIL: " + message);
    }
}
