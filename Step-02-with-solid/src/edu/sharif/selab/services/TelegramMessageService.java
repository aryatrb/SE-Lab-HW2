package edu.sharif.selab.services;

import edu.sharif.selab.models.Message;
import edu.sharif.selab.models.TelegramMessage;

public class TelegramMessageService implements MessageService {

    @Override
    public void sendMessage(Message message) {
        if (message instanceof TelegramMessage) {
            TelegramMessage telegramMessage = (TelegramMessage) message;
            if (validatePhoneNumber(telegramMessage.getSourcePhoneNumber()) && validatePhoneNumber(telegramMessage.getTargetPhoneNumber())) {
                System.out.println("Sending a Telegram Message from " + telegramMessage.getSourcePhoneNumber() +
                                   " to " + telegramMessage.getTargetPhoneNumber() +
                                   " with content: " + telegramMessage.getContent());
            } else {
                throw new IllegalArgumentException("Phone Number is Not Correct!");
            }
        } else {
            throw new IllegalArgumentException("Invalid message type for TelegramMessageService");
        }
    }

    private boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.length() == 11 && phoneNumber.chars().allMatch(Character::isDigit);
    }
}
