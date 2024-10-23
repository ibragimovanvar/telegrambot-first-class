package com.generation;

import com.generation.bot.MyBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) throws TelegramApiException {

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyBot("7633614057:AAHNa9vOT4ZsApbLGcwzclwlCowVns_L1Ks"));
        System.out.println("Telegam bot ishga tushdi!");

    }
}