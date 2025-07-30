package com.selim.uscis_case_tracker_app.controller;

import org.springframework.ui.Model;
import com.selim.uscis_case_tracker_app.dto.CaseStatusResponse;
import com.selim.uscis_case_tracker_app.service.CaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/web")
@RequiredArgsConstructor
public class WebCaseController {

    private final CaseService caseService;

    @GetMapping("/form")
    public String showForm() {
        return "uscis-tracker";
    }

    @PostMapping("/uscis-tracker")
    public String handleCaseStatusSubmit(@RequestParam String receiptNumber, Model model) {
        try {
            CaseStatusResponse response = caseService.getCaseStatusFromUscis(receiptNumber);

            var details = response.getCaseStatus();
            model.addAttribute("receiptNumber", details.getReceiptNumber());
            model.addAttribute("formType", details.getFormType());
            model.addAttribute("submittedDate", details.getSubmittedDate());
            model.addAttribute("status", details.getStatus());
            model.addAttribute("statusDescription", details.getStatusDescription());
            model.addAttribute("history", details.getHistory());

        } catch (Exception e) {
            model.addAttribute("error", "Something went wrong: " + e.getMessage());
        }

        return "uscis-tracker";
    }


}
