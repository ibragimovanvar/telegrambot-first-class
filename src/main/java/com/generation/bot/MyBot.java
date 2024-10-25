package com.generation.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {
    public MyBot(String botToken) {
        super(botToken);
    }

    String firstName;
    String lastName;
    String phoneNumber;
    String state = "START";

    @Override
    public void onUpdateReceived(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        String text = update.getMessage().getText();

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);

        if(text.equals("/start")){
            sendMessage.setText("Assalom alaykum ismizni kiriting!");
            state = "FIRSTNAME";
        }else {
            if(state.equals("FIRSTNAME")){
                firstName = text;
                sendMessage.setText("Familiyezni kiriting!");
                state = "LASTNAME";
            }else if(state.equals("LASTNAME")){
                lastName = text;
                sendMessage.setText("Raqamizni kiriting!");
                state = "REGISTERED";
            }else if(state.equals("REGISTERED")){
                phoneNumber = text;
                sendMessage.setText("Siz muvaffaqiyatli ro'yxatdan o'tdiz iltimos admin javobini kuting!");
                System.out.println("Foydalanuvchi: " + firstName + " | " + lastName + " | " + phoneNumber);
            }
        }

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getBotUsername() {
        return "uenter_bot";
    }
}
