package com.team.syberry.bot.Handlers;

import com.team.syberry.bot.CurrencyBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartHandler {
    public void handle(CurrencyBot bot, Message message) throws TelegramApiException {
        SendMessage startMessage = new SendMessage();
        startMessage.setChatId(message.getChatId());
        startMessage.setText("Привет! Чтобы воспользоваться функциями бота, сперва выбери банк из меню снизу.");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        Arrays.stream(CurrencyBot.BANKS).forEach(row::add);
        keyboard.add(row);
        replyKeyboardMarkup.setKeyboard(keyboard);

        startMessage.setReplyMarkup(replyKeyboardMarkup);

        bot.execute(startMessage);
    }
}
