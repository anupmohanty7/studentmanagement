package com.erp.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.demo.model.DashboardResponse;
import com.erp.demo.repo.StudentRepository;
import com.erp.demo.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public DashboardResponse getDashboardData() {

        DashboardResponse response = new DashboardResponse();

        response.setTotalStudents(studentRepository.count());

        response.setTotalCourses(studentRepository.countDistinctCourses());

        response.setTotalMaleStudents(studentRepository.countByGender("Male"));

        response.setTotalFemaleStudents(studentRepository.countByGender("Female"));

        return response;
    }

}