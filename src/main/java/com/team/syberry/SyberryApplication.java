package com.team.syberry;

import com.team.syberry.bot.CurrencyBot;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@EnableFeignClients
@SpringBootApplication
@RequiredArgsConstructor
public class SyberryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SyberryApplication.class, args);
    }

}
