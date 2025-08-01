package com.selim.uscis_case_tracker_app.service;

import com.selim.uscis_case_tracker_app.dto.CaseStatusResponse;
import com.selim.uscis_case_tracker_app.entity.Case;
import com.selim.uscis_case_tracker_app.entity.User;
import com.selim.uscis_case_tracker_app.repository.CaseRepository;
import com.selim.uscis_case_tracker_app.util.UscisApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CaseService {

    private final UscisApiService uscisApiService;
    private final CaseRepository caseRepository;

    public CaseStatusResponse getCaseStatusFromUscis(String receiptNumber) {
        return uscisApiService.getCaseStatusFromUscis(receiptNumber);
    }

    public List<Case> getCasesByUser(User user){
        return caseRepository.findByUserId(user.getId());
    }

    public void addCaseForUser(User user, String receiptNumber){
        CaseStatusResponse response = getCaseStatusFromUscis(receiptNumber);

        var details = response.getCaseStatus();
        var newCase = Case.builder()
                .user(user)
                .caseNumber(details.getReceiptNumber())
                .lastStatus(details.getStatus())
                .lastCheckedAt(LocalDateTime.now())
                .build();

        caseRepository.save(newCase);
    }

    public void deleteCaseForUser(Long caseId, User user){
        var optionalCase = caseRepository.findById(caseId);

        if(optionalCase.isPresent()){
            var c = optionalCase.get();
            if(c.getUser().getId() == user.getId()){
                caseRepository.deleteById(caseId);
            }else{
                throw new SecurityException("This in not your case.");
            }
        }else{
            throw new RuntimeException("Case not found.");
        }
    }
}
