package com.team.syberry.bot.Handlers;

import com.team.syberry.bot.CurrencyBot;
import com.team.syberry.dto.response.RateDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class ActionHandler {

    public void handle(CurrencyBot bot, Message message, String selectedBank, String selectedCurrency) throws TelegramApiException {
        String bankServiceName = switch (selectedBank) {
            case "Национальный банк" -> "nationalBankService";
            case "Альфа банк" -> "alfaBankService";
            case "Беларусбанк" -> "belarusbankService";
            default -> "";
        };

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        RestTemplate restTemplate = new RestTemplate();
        String rateUrl = "http://localhost:8080/rate";
        String bankUrl = "http://localhost:8080/api/banks";

        SendMessage actionMessage = new SendMessage();
        actionMessage.setChatId(message.getChatId());

        if (selectedBank == null || selectedCurrency == null) {
            actionMessage.setText(" выберите сначала банк или валюту");
            bot.execute(actionMessage);
            return;
        }

        switch (message.getText()) {
            case "Курс на текущий день":
                RateDto currentDayRate = restTemplate.getForEntity(
                        rateUrl
                                + "?bank=" + bankServiceName
                                + "&currencyCode" + selectedCurrency
                                + "date=" + LocalDate.now().format(formatter),
                        RateDto.class).getBody();
                String sellRateCurDay = String.valueOf(currentDayRate.getSellRate());
                actionMessage.setText("Курс на текущий день:\n" + sellRateCurDay);
                break;
            case "Курс на выбранный день":
                //запрос json
                RateDto selectedDayRate = restTemplate.getForEntity(
                        rateUrl
                                + "?bank=" + bankServiceName
                                + "&currencyCode" + selectedCurrency
                                + "date=02-02-2024",
                        RateDto.class).getBody();
                String sellRateSelectedDay = String.valueOf(selectedDayRate.getSellRate());
                actionMessage.setText("Курс на текущий день:\n" + sellRateSelectedDay);
                break;
//            new DatePickerHandler().handle(bot, message, selectedBank, selectedCurrency);
//            break;
            case "Собрать статистику":
                byte[] image = restTemplate.getForEntity(
                        rateUrl + "/statistics",
                        byte[].class).getBody();
                SendPhoto sendPhoto = new SendPhoto();
                sendPhoto.setChatId(message.getChatId());
                sendPhoto.setPhoto(new InputFile(new ByteArrayInputStream(image), "chart.png"));
                sendPhoto.setCaption("Описание к графику");
                bot.execute(sendPhoto);
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