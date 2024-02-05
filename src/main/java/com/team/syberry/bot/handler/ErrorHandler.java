package com.team.syberry.bot.handler;

import com.team.syberry.bot.CurrencyBot;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
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
