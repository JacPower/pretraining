package org.example.dip;

public class NotificationService {

    private final MessageSender sender;

    public NotificationService(MessageSender sender) {
        this.sender = sender;
    }

    public void notify(String msg) {
        sender.send(msg);
    }
}
