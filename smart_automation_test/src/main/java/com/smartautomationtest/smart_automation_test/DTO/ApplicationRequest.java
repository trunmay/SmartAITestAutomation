package com.smartautomationtest.smart_automation_test.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ApplicationRequest{

@NotBlank(message = "Name is required")
    private String name;
   
    @NotBlank(message = "Base URL is required")
    private String baseURL;
    private String userName; 
    private String password;

}