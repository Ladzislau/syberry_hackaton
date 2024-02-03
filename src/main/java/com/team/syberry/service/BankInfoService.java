package com.team.syberry.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankInfoService {

    public List<String> getAllBanks() {
        return Arrays.stream(EBank.values())
                .map(EBank::getValue)
                .collect(Collectors.toList());
    }
}
