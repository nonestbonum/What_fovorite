package test.services;

public interface MailSender {
    public void send(String emailTo, String subject, String message);
}
