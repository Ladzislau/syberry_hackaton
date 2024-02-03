package com.team.syberry.bot;

import com.team.syberry.bot.Handlers.*;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CurrencyBot extends TelegramLongPollingBot {

    public static final String START_COMMAND = "/start";
    public static final String[] CURRENCIES = {"USD", "EUR", "GBP", "JPY"};
    public static final String[] BANKS = {"Национальный банк", "Альфа банк", "Беларусбанк"};
    public static final String[] ACTIONS = {"Курс на текущий день", "Курс на выбранный день", "Собрать статистику", "Выбрать другой банк", "Выбрать другую валюту"};

    public CurrencyBot() {
        super("6937428906:AAFVcFNj9iMVo10hiaOvFDo5_gFk1HrV4bA");
    }

    public List<String> getBankButtons(String bank) {
        switch (bank) {
            case "Национальный банк":
                return Arrays.asList("Курс на текущий день", "Курс на выбранный день", "Собрать статистику", "Выбрать другой банк", "Выбрать другую валюту");
            case "Альфа банк":
                return Arrays.asList("Курс на текущий день", "Выбрать другой банк", "Выбрать другую валюту");
            case "Беларусбанк":
                return Arrays.asList("Курс на текущий день", "Выбрать другой банк", "Выбрать другую валюту");
            default:
                return Arrays.asList();
        }
    }
    private Map<Long, UserSelections> userSelectionsMap = new HashMap<>();


    @Override
    public void onUpdateReceived(Update update) {
        try {
            Message inMessage = update.getMessage();
            long chatId = inMessage.getChatId();

            if (START_COMMAND.equals(inMessage.getText())) {
                new StartHandler().handle(this, inMessage);
            } else if (Arrays.asList(BANKS).contains(inMessage.getText())) {
                userSelectionsMap.put(chatId, new UserSelections(inMessage.getText(), null));
                new BankConfirmationHandler().handle(this, inMessage, inMessage.getText());
            } else if (Arrays.asList(CURRENCIES).contains(inMessage.getText())) {
                UserSelections userSelections = userSelectionsMap.get(chatId);
                if (userSelections != null) {
                    userSelections.setSelectedCurrency(inMessage.getText());
                    new CurrencyConfirmationHandler().handle(this, inMessage, inMessage.getText(), userSelections.getSelectedBank());
                } else {
                    ErrorHandler.sendError(this, inMessage, "что-то пошло не так. Нажми /start.");
                }
            } else if (Arrays.asList(ACTIONS).contains(inMessage.getText())) {
                UserSelections userSelections = userSelectionsMap.get(chatId);
                new ActionHandler().handle(this, inMessage, userSelections.getSelectedBank(), userSelections.getSelectedCurrency());

            } else {
                ErrorHandler.sendError(this, inMessage, "что-то пошло не так. Нажми /start.");
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String getExchangeRate(String bank, String currency) {
        return "Курс " + currency + " в банке " + bank + " на текущий день: 75.00";
    }

    String getExchangeRate(String bank, String currency, String date) {
        return "Курс " + currency + " в банке " + bank + " на " + date + ": 74.50";
    }

    @Override
    public String getBotUsername() {
        return "<HackathonBankCurrencybot>";
    }
}
