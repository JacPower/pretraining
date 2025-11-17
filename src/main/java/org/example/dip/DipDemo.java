package org.example.dip;

public class DipDemo {
    public static void show() {
        NotificationService emailService =
                new NotificationService(new EmailSender());
        emailService.notify("Welcome!");

        NotificationService smsService =
                new NotificationService(new SmsSender());
        smsService.notify("OTP: 123456");
    }
}
