package com.team.syberry.bot.handler;

import com.team.syberry.bot.CurrencyBot;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class BankConfirmationHandler {
    public void handle(CurrencyBot bot, Message message, String selectedBank) throws TelegramApiException {
        SendMessage bankConfirmationMessage = new SendMessage();
        bankConfirmationMessage.setChatId(message.getChatId());
        bankConfirmationMessage.setText("Ты выбрал " + selectedBank + ". Теперь выбери нужную тебе валюту из списка ниже:");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        Arrays.stream(CurrencyBot.CURRENCIES).forEach(row::add);
        keyboard.add(row);
        replyKeyboardMarkup.setKeyboard(keyboard);

        bankConfirmationMessage.setReplyMarkup(replyKeyboardMarkup);

        bot.execute(bankConfirmationMessage);
    }
}
