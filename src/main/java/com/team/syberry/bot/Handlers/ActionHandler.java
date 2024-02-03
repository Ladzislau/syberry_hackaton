package com.team.syberry.bot.Handlers;

import com.team.syberry.bot.CurrencyBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ActionHandler {
    public void handle(CurrencyBot bot, Message message, String selectedBank, String selectedCurrency) throws TelegramApiException {
        SendMessage actionMessage = new SendMessage();
        actionMessage.setChatId(message.getChatId());

        if (selectedBank == null || selectedCurrency == null) {
            actionMessage.setText(" выберите сначала банк или валюту");
            bot.execute(actionMessage);
            return;
        }

        switch (message.getText()) {
            case "Курс на текущий день":
                String exchangeRate = bot.getExchangeRate(selectedBank, selectedCurrency);
                actionMessage.setText("Курс на текущий день:\n" + exchangeRate);
                break;
            case "Курс на выбранный день":
                //запрос json
                new DatePickerHandler().handle(bot, message, selectedBank, selectedCurrency);

                break;
            case "Собрать статистику":
                actionMessage.setText("Статистика еще не реализована.");
                break;
            case "Выбрать другой банк":
                new StartHandler().handle(bot, message);
                return;
            case "Выбрать другую валюту":
                new BankConfirmationHandler().handle(bot, message, selectedBank);
                return;
            default:
                actionMessage.setText("Неверное действие");
                break;
        }

        bot.execute(actionMessage);
    }
}
