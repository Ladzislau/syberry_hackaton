package com.team.syberry.bot.Handlers;

import com.team.syberry.CurrencyBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class DatePickerHandler {
    void handle(CurrencyBot bot, Message message, String selectedBank, String selectedCurrency) throws TelegramApiException {
        SendMessage datePickMessage = new SendMessage();
        datePickMessage.setChatId(message.getChatId());
        datePickMessage.setText("Выберите дату:");

        ReplyKeyboardMarkup replyKeyboardMarkup = createDatePickerKeyboard();
        datePickMessage.setReplyMarkup(replyKeyboardMarkup);

        bot.execute(datePickMessage);
    }

    private ReplyKeyboardMarkup createDatePickerKeyboard() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow yearRow = new KeyboardRow();
        yearRow.add("2022");
        yearRow.add("2023");
        yearRow.add("2024");
        keyboard.add(yearRow);

        KeyboardRow monthRow = new KeyboardRow();
        monthRow.add("Янв");
        monthRow.add("Фев");
        monthRow.add("Мар");
        keyboard.add(monthRow);

        KeyboardRow dayRow = new KeyboardRow();
        for (int i = 1; i <= 31; i++) {
            dayRow.add(String.valueOf(i));
        }
        keyboard.add(dayRow);

        replyKeyboardMarkup.setKeyboard(keyboard);

        return replyKeyboardMarkup;
    }
}
