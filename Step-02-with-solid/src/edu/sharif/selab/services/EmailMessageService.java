package edu.sharif.selab.services;

import edu.sharif.selab.models.Message;
import edu.sharif.selab.models.EmailMessage;

import java.util.regex.Pattern;

public class EmailMessageService implements MessageService {

    @Override
    public void sendMessage(Message message) {
        if (message instanceof EmailMessage) {
            EmailMessage emailMessage = (EmailMessage) message;
            if (validateEmailAddress(emailMessage.getSourceEmailAddress()) && validateEmailAddress(emailMessage.getTargetEmailAddress())) {
                System.out.println("Sending an Email from " + emailMessage.getSourceEmailAddress() +
                                   " to " + emailMessage.getTargetEmailAddress() +
                                   " with content: " + emailMessage.getContent());
            } else {
                throw new IllegalArgumentException("Email Address is Not Correct!");
            }
        } else {
            throw new IllegalArgumentException("Invalid message type for EmailMessageService");
        }
    }

    private boolean validateEmailAddress(String email) {
        String emailRegex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
}
