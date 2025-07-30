package com.selim.uscis_case_tracker_app.controller;

import com.selim.uscis_case_tracker_app.dto.CaseStatusResponse;
import com.selim.uscis_case_tracker_app.service.CaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/cases")
@RequiredArgsConstructor
public class CaseController {

    private final CaseService caseService;

    @GetMapping("/status/{receiptNumber}")
    public ResponseEntity<CaseStatusResponse> getCaseStatus(@PathVariable String receiptNumber) {
        CaseStatusResponse response = caseService.getCaseStatusFromUscis(receiptNumber);
        return ResponseEntity.ok(response);
    }
}

