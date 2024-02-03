package com.team.syberry.bot.Handlers;

import com.team.syberry.CurrencyBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ErrorHandler {

    public static void sendError(CurrencyBot bot, Message message, String errorMessage) {
        SendMessage errorMessageSend = new SendMessage();
        errorMessageSend.setChatId(message.getChatId());
        errorMessageSend.setText("Произошла ошибка: " + errorMessage);

        try {
            bot.execute(errorMessageSend);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
