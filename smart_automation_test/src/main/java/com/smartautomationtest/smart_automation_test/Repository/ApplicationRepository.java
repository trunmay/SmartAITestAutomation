package com.smartautomationtest.smart_automation_test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartautomationtest.smart_automation_test.Entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    // This interface extends JpaRepository, which provides CRUD operations for the Application entity.
    // It allows you to perform database operations on the applications table without writing any SQL queries.
}