package com.selim.uscis_case_tracker_app.dto;

import lombok.Data;

@Data
public class RegisterRequest {

    private String email;

    private String password;
}
