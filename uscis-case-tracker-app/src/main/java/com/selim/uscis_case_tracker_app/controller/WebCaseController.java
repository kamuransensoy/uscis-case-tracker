package com.selim.uscis_case_tracker_app.controller;

import com.selim.uscis_case_tracker_app.dto.CaseStatusResponse;
import com.selim.uscis_case_tracker_app.entity.Case;
import com.selim.uscis_case_tracker_app.entity.User;
import com.selim.uscis_case_tracker_app.repository.CaseRepository;
import com.selim.uscis_case_tracker_app.repository.UserRepository;
import com.selim.uscis_case_tracker_app.service.CaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/web")
@RequiredArgsConstructor
public class WebCaseController {

    private final CaseService caseService;
    private final CaseRepository caseRepository;
    private final UserRepository userRepository;

    @GetMapping("/form")
    public String showForm(Model model) {
        // Kullanıcının case listesi gösterilsin diye
        User dummyUser = userRepository.findById(1L).orElse(null);
        if (dummyUser != null) {
            List<Case> caseList = caseRepository.findByUserId(dummyUser.getId());
            model.addAttribute("cases", caseList);
        }
        return "uscis-tracker";
    }

    @PostMapping("/uscis-tracker")
    public String handleCaseStatusSubmit(@RequestParam String receiptNumber, Model model) {
        try {
            CaseStatusResponse response = caseService.getCaseStatusFromUscis(receiptNumber);
            var details = response.getCaseStatus();

            User dummyUser = userRepository.findById(1L).orElseThrow();

            Case newCase = Case.builder()
                    .caseNumber(receiptNumber)
                    .lastStatus(details.getStatus())
                    .lastCheckedAt(LocalDateTime.now())
                    .createdAt(LocalDateTime.now())
                    .user(dummyUser)
                    .build();

            caseRepository.save(newCase);

            // Sayfada gösterilecek veriler
            model.addAttribute("receiptNumber", details.getReceiptNumber());
            model.addAttribute("formType", details.getFormType());
            model.addAttribute("submittedDate", details.getSubmittedDate());
            model.addAttribute("status", details.getStatus());
            model.addAttribute("statusDescription", details.getStatusDescription());
            model.addAttribute("history", details.getHistory());

            // Tüm case’leri getir
            List<Case> caseList = caseRepository.findByUserId(dummyUser.getId());
            model.addAttribute("cases", caseList);

        } catch (Exception e) {
            model.addAttribute("error", "Something went wrong: " + e.getMessage());
        }

        return "uscis-tracker";
    }
}
