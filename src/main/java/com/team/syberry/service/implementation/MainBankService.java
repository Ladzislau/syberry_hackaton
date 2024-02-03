package com.team.syberry.service.implementation;

import com.team.syberry.service.EBank;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MainBankService {

    public List<String> getAllBanks() {
        return Arrays.stream(EBank.values())
                .map(EBank::getValue)
                .collect(Collectors.toList());
    }
}
