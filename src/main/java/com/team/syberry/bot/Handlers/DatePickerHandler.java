package com.team.syberry.bot.Handlers;

import com.team.syberry.bot.CurrencyBot;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatePickerHandler {

    void handle(CurrencyBot bot, Message message, String selectedBank, String selectedCurrency) throws TelegramApiException {
        SendMessage datePickMessage = new SendMessage();
        datePickMessage.setChatId(message.getChatId());
        datePickMessage.setText("Выберите дату:");

        // Modified code to generate the calendar keyboard
        ReplyKeyboardMarkup replyKeyboardMarkup = createDatePickerKeyboard(LocalDate.now());
        datePickMessage.setReplyMarkup(replyKeyboardMarkup);

        bot.execute(datePickMessage);
    }

    private ReplyKeyboardMarkup createDatePickerKeyboard(LocalDate currentDate) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        currentDate = currentDate.minusMonths(1);

        List<KeyboardRow> keyboard = new ArrayList<>();

        // row - Month and Year
        KeyboardRow headerRow = new KeyboardRow();
        headerRow.add(new SimpleDateFormat("MMM yyyy").format(java.sql.Date.valueOf(currentDate)));
        keyboard.add(headerRow);

        // row - Days of the week
        KeyboardRow daysOfWeekRow = new KeyboardRow();
        String[] daysOfWeek = {"M", "T", "W", "T", "F", "S", "S"};
        for (String day : daysOfWeek) {
            daysOfWeekRow.add(day);
        }
        keyboard.add(daysOfWeekRow);

        LocalDate firstDay = currentDate.withDayOfMonth(1);
        int shift = firstDay.getDayOfWeek().getValue() % 7;
        int daysInMonth = firstDay.lengthOfMonth();
        int rows = ((daysInMonth + shift) % 7 > 0 ? 1 : 0) + (daysInMonth + shift) / 7;
        for (int i = 0; i < rows; i++) {
            keyboard.add(buildRow(firstDay, shift));
            firstDay = firstDay.plusDays(7 - shift);
            shift = 0;
        }

        // Navigation controls
        KeyboardRow controlsRow = new KeyboardRow();
        controlsRow.add("<");
        controlsRow.add(">");
        keyboard.add(controlsRow);

        replyKeyboardMarkup.setKeyboard(keyboard);

        return replyKeyboardMarkup;
    }

    private KeyboardRow buildRow(LocalDate date, int shift) {
        KeyboardRow row = new KeyboardRow();
        int day = date.getDayOfMonth();
        for (int j = 0; j < shift; j++) {
            row.add(" ");
        }
        for (int j = shift; j < 7; j++) {
            if (day <= date.lengthOfMonth()) {
                row.add(date.withDayOfMonth(day).toString());
                day++;
            } else {
                row.add(" ");
            }
        }
        return row;
    }
}