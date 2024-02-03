package com.team.syberry.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class GetBanksResponse {

    private final List<BankInfo> banks;
}
