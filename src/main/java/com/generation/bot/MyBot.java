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
        Long chatId = update.getMessage().getChatId();
        if(chatId.equals(1007690054L)){
            SendMessage sendMessage = new SendMessage(String.valueOf(chatId), "Uzr siz uchun dasturimiz faoliyat ko'rsatmaydi!");
            try {
                execute(sendMessage);
                return;
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }

        String message = update.getMessage().getText();
        System.out.println(chatId + " chat id li foydalanuvchi ushbu " + message + " ni yubordi!");
        String welcomeText = "Assalom alaykum bizni uenter botimizga xush kelibsiz!";
        if (message.equals("/start")){
            SendMessage sendMessage = new SendMessage(String.valueOf(chatId), welcomeText);
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "uenter_bot";
    }
}
