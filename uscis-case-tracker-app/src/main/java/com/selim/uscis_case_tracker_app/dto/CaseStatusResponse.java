package com.selim.uscis_case_tracker_app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CaseStatusResponse {

    @JsonProperty("case_status")
    private CaseStatusDetails caseStatus;

    private String message;

    @Data
    public static class CaseStatusDetails {
        private String receiptNumber;
        private String formType;
        private String submittedDate;
        private String modifiedDate;

        @JsonProperty("current_case_status_text_en")
        private String status;

        @JsonProperty("current_case_status_desc_en")
        private String statusDescription;

        @JsonProperty("hist_case_status")
        private List<CaseHistory> history;
    }

    @Data
    public static class CaseHistory {
        private String date;

        @JsonProperty("completed_text_en")
        private String completedTextEn;
    }

    public String getStatusMessage() {
        return caseStatus != null ? caseStatus.status : "❌ Status not found";
    }
}
