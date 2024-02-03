package com.team.syberry.service.implementation;

import com.team.syberry.service.EBank;
import com.team.syberry.service.api.IBankService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankService implements IBankService {


    @Override
    public List<String> getAllBanks() {
        return Arrays.stream(EBank.values())
                .map(EBank::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllCurrencies(String backName) {
        return null;
    }
}
