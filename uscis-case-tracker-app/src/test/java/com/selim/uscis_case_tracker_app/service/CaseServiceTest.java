package com.selim.uscis_case_tracker_app.service;

import com.selim.uscis_case_tracker_app.dto.CaseStatusResponse;
import com.selim.uscis_case_tracker_app.util.UscisApiService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CaseServiceTest {

    @Mock
    private UscisApiService uscisApiService;

    @InjectMocks
    private CaseService caseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getCaseStatusFromUscis_ReturnsExpectedResponse() {
        // Arrange
        String receiptNumber = "ABC1234567890";
        CaseStatusResponse mockResponse = new CaseStatusResponse();
        when(uscisApiService.getCaseStatusFromUscis(receiptNumber)).thenReturn(mockResponse);

        // Act
        CaseStatusResponse result = caseService.getCaseStatusFromUscis(receiptNumber);

        // Assert
        assertEquals(mockResponse, result);
        verify(uscisApiService).getCaseStatusFromUscis(receiptNumber);
    }
}
