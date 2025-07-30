package com.selim.uscis_case_tracker_app.service;

import com.selim.uscis_case_tracker_app.dto.CaseStatusResponse;
import com.selim.uscis_case_tracker_app.util.UscisApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CaseService {

    private final UscisApiService uscisApiService;

    public CaseStatusResponse getCaseStatusFromUscis(String receiptNumber) {
        return uscisApiService.getCaseStatusFromUscis(receiptNumber);
    }
}
