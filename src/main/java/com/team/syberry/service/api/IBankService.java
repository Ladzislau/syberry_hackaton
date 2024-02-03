package com.team.syberry.service.api;

import java.util.List;

public interface IBankService {
   List<String> getAllBanks();

   List<String> getAllCurrencies(String backName);
}
