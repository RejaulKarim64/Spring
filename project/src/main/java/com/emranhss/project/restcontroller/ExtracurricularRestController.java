package com.emranhss.project.restcontroller;

import com.emranhss.project.dto.ExtracurricularDTO;
import com.emranhss.project.entity.Extracurricular;
import com.emranhss.project.entity.JobSeeker;
import com.emranhss.project.entity.User;
import com.emranhss.project.repository.IUserRepo;
import com.emranhss.project.service.ExtracurricularService;
import com.emranhss.project.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/extracurricular/")
public class ExtracurricularRestController {

    @Autowired
    private ExtracurricularService extracurricularService;
    @Autowired
    private JobSeekerService jobSeekerService;
    @Autowired
    private IUserRepo userRepo;

    @PostMapping("add")
    public ResponseEntity<Extracurricular> addExtracurricular(@RequestBody Extracurricular extracurricular, Authentication authentication) {

        String email = authentication.getName();
        Extracurricular savedExtracurricular = extracurricularService.save(extracurricular, email);
        return ResponseEntity.ok(savedExtracurricular);
    }

    @GetMapping("all")
    public ResponseEntity<List<ExtracurricularDTO>> getExtracurricularByJobSeeker(Authentication authentication) {
        String email = authentication.getName();

        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        JobSeeker jobSeeker = jobSeekerService.getProfileByUserId(user.getId());

        List<ExtracurricularDTO> extracurriculars = extracurricularService.getByJobSeekerId(jobSeeker.getId());
        return ResponseEntity.ok(extracurriculars);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteExtracurricular(@PathVariable int id) {
        extracurricularService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
