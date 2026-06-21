package com.smartautomationtest.smart_automation_test.Service;

import java.util.List;

import com.smartautomationtest.smart_automation_test.DTO.ApplicationRequest;
import com.smartautomationtest.smart_automation_test.DTO.ApplicationResponse;



public interface ApplicationService {

    ApplicationResponse createApplication(ApplicationRequest applicationRequest);
    ApplicationResponse getApplicationByID(Long id);
    List<ApplicationResponse> getAllApplications();
    ApplicationResponse updateApplication(Long id,ApplicationRequest applicationRequest);
    void deleteApplication(Long id);    
    
    
}