package com.selim.uscis_case_tracker_app.controller;

import com.selim.uscis_case_tracker_app.dto.CaseStatusResponse;
import com.selim.uscis_case_tracker_app.repository.UserRepository;
import com.selim.uscis_case_tracker_app.service.AuthService;
import com.selim.uscis_case_tracker_app.service.CaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(WebCaseController.class)
@AutoConfigureMockMvc(addFilters = false)
class WebCaseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CaseService caseService;

    @MockBean
    private UserRepository userRepository;  // Eğer AuthService dolaylı olarak çağrılıyorsa

    @MockBean
    private AuthService authService;        // Yukarıdaki gibi dolaylı çağrı varsa


    @Test
    void handleCaseStatusSubmit_ReturnsPopulatedModel() throws Exception {
        String receiptNumber = "ABC1234567890";

        // Mock data oluştur
        CaseStatusResponse.CaseStatusDetails details = new CaseStatusResponse.CaseStatusDetails();
        details.setReceiptNumber(receiptNumber);
        details.setFormType("I-765");
        details.setSubmittedDate("2024-06-01");
        details.setStatus("Case Approved");
        details.setStatusDescription("Your case was approved!");
        details.setHistory(Collections.emptyList());

        CaseStatusResponse response = new CaseStatusResponse();
        response.setCaseStatus(details);

        // Mock servis davranışı
        when(caseService.getCaseStatusFromUscis(receiptNumber)).thenReturn(response);

        // Test HTTP post
        mockMvc.perform(post("/web/uscis-tracker")
                        .param("receiptNumber", receiptNumber))
                .andExpect(status().isOk())
                .andExpect(view().name("uscis-tracker"))
                .andExpect(model().attributeExists("receiptNumber", "formType", "submittedDate", "status", "statusDescription", "history"));
    }
}
