package com.generation.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class MyBot extends TelegramLongPollingBot {
    public MyBot(String botToken) {
        super(botToken);
    }

    List<String> messages = new ArrayList<>();

    @Override
    public void onUpdateReceived(Update update) {
        String text = update.getMessage().getText();
        if(text.equals("/show")){
            int i = 1;
            for (String message : messages) {
                System.out.println(i + ". " + message);
                i++;
            }
        }else if(text.equals("/clear")){
            messages.clear();
        }else{
            messages.add(text);
        }
    }

    @Override
    public String getBotUsername() {
        return "uenter_bot";
    }
}
