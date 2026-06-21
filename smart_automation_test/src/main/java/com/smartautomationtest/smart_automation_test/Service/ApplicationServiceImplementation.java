package com.smartautomationtest.smart_automation_test.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.smartautomationtest.smart_automation_test.DTO.ApplicationRequest;
import com.smartautomationtest.smart_automation_test.DTO.ApplicationResponse;
import com.smartautomationtest.smart_automation_test.Entity.Application;
import com.smartautomationtest.smart_automation_test.Repository.ApplicationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImplementation implements ApplicationService {
   


   private final ApplicationRepository repository;
   @Override
   public ApplicationResponse createApplication(ApplicationRequest request){
    Application application = Application.builder()
            .name(request.getName())
            .baseURL(request.getBaseURL())
            .userName(request.getUserName())
            .password(request.getPassword())
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build();   

            Application saved = repository.save(application);
            return mapToResponse(saved);
   }

    @Override
    public ApplicationResponse getApplicationByID(Long id) {
        Application application = repository.findById(id).orElseThrow(()-> new RuntimeException("Application not found"));
        return mapToResponse(application);
    }

    @Override
    public List<ApplicationResponse> getAllApplications() {
        return repository.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public ApplicationResponse updateApplication(Long id, ApplicationRequest applicationRequest) {
        Application application = repository.findById(id).orElseThrow(()-> new RuntimeException("Application not found with id: " + id));
        
        application.setName(applicationRequest.getName());
        application.setBaseURL(applicationRequest.getBaseURL());
        application.setUserName(applicationRequest.getUserName());
        application.setPassword(applicationRequest.getPassword());
        application.setUpdatedAt(LocalDateTime.now());
        return mapToResponse(repository.save(application));
    }

    @Override
    public void deleteApplication(Long id) {
       Application application = repository.findById(id).orElseThrow(()-> new RuntimeException("Application not found with id: " + id));
       repository.delete(application);
    }





    private ApplicationResponse mapToResponse(
            Application application) {

        return ApplicationResponse.builder()
                .id(application.getId())
                .name(application.getName())
                .baseURL(application.getBaseURL())
                .userName(application.getUserName())
                .build();
    }

}

