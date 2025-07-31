package com.example.crudexm.service;

import com.example.crudexm.entity.Student;
import com.example.crudexm.repo.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private IStudentRepo studentRepo;


    public List<Student> getAll() {

        return studentRepo.findAll();
    }

    public Student getById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    public Student save(Student student) {
        return studentRepo.save(student);
    }

    public void deleteById(Long id) {
        studentRepo.deleteById(id);
    }

}
