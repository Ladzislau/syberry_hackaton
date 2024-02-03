package com.team.syberry.bot.Handlers;

import com.team.syberry.CurrencyBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CurrencyConfirmationHandler {
    public void handle(CurrencyBot bot, Message message, String selectedCurrency, String selectedBank) throws TelegramApiException {
        SendMessage currencyConfirmationMessage = new SendMessage();
        currencyConfirmationMessage.setChatId(message.getChatId());
        currencyConfirmationMessage.setText("Выбранная валюта: " + selectedCurrency + ". Выбранный банк: " + selectedBank +
                ". Теперь выбери нужное действие с валютой:");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        Arrays.stream(CurrencyBot.ACTIONS).forEach(row::add);
        keyboard.add(row);
        replyKeyboardMarkup.setKeyboard(keyboard);

        currencyConfirmationMessage.setReplyMarkup(replyKeyboardMarkup);

        bot.execute(currencyConfirmationMessage);
    }
}
