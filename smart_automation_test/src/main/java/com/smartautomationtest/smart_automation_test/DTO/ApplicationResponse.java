package com.smartautomationtest.smart_automation_test.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApplicationResponse {
   
    private long id;
    private String name;
    private String baseURL;
    private String userName;
    private String password;



   
}