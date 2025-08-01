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

    @GetMapping
    public ResponseEntity<?> getMyCases() {
        var user = getCurrentUser();
        return ResponseEntity.ok(caseService.getCasesByUser(user));
    }

    @PostMapping
    public ResponseEntity<?> addCase(@RequestParam String receiptNumber) {
        var user = getCurrentUser();
        caseService.addCaseForUser(user, receiptNumber);
        return ResponseEntity.ok("Case added successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCase(@PathVariable Long id) {
        var user = getCurrentUser();
        caseService.deleteCaseForUser(id, user);
        return ResponseEntity.ok("Case deleted successfully");
    }

    private com.selim.uscis_case_tracker_app.entity.User getCurrentUser() {
        var authentication = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication();
        return (com.selim.uscis_case_tracker_app.entity.User) authentication.getPrincipal();
    }
}

