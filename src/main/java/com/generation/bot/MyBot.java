package com.generation.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {
    public MyBot(String botToken) {
        super(botToken);
    }

    @Override
    public void onUpdateReceived(Update update) {
        String pupilId = String.valueOf(0L);
        String adminId = String.valueOf(0L);
        String userId = String.valueOf(update.getMessage().getChatId());
        String sendText = update.getMessage().getText();

        System.out.println(update.getMessage().getChatId() + " | " + update.getMessage().getText());

        SendMessage sendMessage = new SendMessage();
        if (sendText.equals("/start")) {
            sendMessage.setChatId(userId);
            sendMessage.setText("Assalom alaykum botimizga x .... admin uchun xabarizni yuboring!");
        } else {
            sendMessage.setText(sendText);
            if (userId.equals(pupilId)) {
                sendMessage.setChatId(adminId);
            } else if (userId.equals(adminId)) {
                sendMessage.setChatId(pupilId);
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
