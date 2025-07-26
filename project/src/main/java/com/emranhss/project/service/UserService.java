package com.emranhss.project.service;

import com.emranhss.project.entity.User;
import com.emranhss.project.repository.IUserRepo;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private IUserRepo userRepo;

    @Autowired
    private EmailService emailService;

    @Value("src/main/resources/static/images")
    private String uploadDir;

    public void saveOrUpdate(User user, MultipartFile imageFile) {
        if (imageFile != null && !imageFile.isEmpty()) {

            String fileName = saveImage(imageFile, user);
            user.setPhoto(fileName);
        }

        userRepo.save(user);
        sendActivationEmail(user);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User findById(int id) {
        return userRepo.findById(id).get();
    }

    public void delete(User user) {
        userRepo.delete(user);
    }

    private void sendActivationEmail(User user) {

        String subject = "Welcome to Our Service – Confirm Your Registration";
        String mailText = "<!DOCTYPE html>"
                + "<html>"
                + "<body style='margin:0; padding:0; font-family:Arial, sans-serif; background-color:#f4f4f4;'>"
                + "  <div style='max-width:600px; margin:40px auto; background:#ffffff; border-radius:12px; overflow:hidden; box-shadow:0 4px 20px rgba(0,0,0,0.1);'>"
                + "    <div style='background-color:#4CAF50; color:#ffffff; padding:20px 30px; text-align:center;'>"
                + "      <h2 style='margin:0; font-size:24px;'>Welcome to Our Platform</h2>"
                + "    </div>"
                + "    <div style='padding:30px;'>"
                + "      <p style='font-size:16px; color:#333333;'>Dear <strong>" + user.getName() + "</strong>,</p>"
                + "      <p style='font-size:15px; color:#555555; line-height:1.8;'>"
                + "        Thank you for registering with us. We're thrilled to have you on board!"
                + "      </p>"
                + "      <p style='font-size:15px; color:#555555; line-height:1.8;'>"
                + "        Please confirm your email address to activate your account and get started."
                + "      </p>"
                + "      <p style='font-size:15px; color:#555555; line-height:1.8;'>"
                + "        If you have any questions or need assistance, our support team is here to help."
                + "      </p>"
                + "      <p style='font-size:15px; color:#555555; margin-top:30px;'>"
                + "        Best regards,<br><span style='font-weight:bold;'>The Support Team</span>"
                + "      </p>"
                + "    </div>"
                + "    <div style='background-color:#f0f0f0; padding:15px; text-align:center; font-size:13px; color:#999999;'>"
                + "      &copy; " + java.time.Year.now() + " crk. All rights reserved."
                + "    </div>"
                + "  </div>"
                + "</body>"
                + "</html>";


        try {
            emailService.sendSimpleEmail(user.getEmail(), subject, mailText);

        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send activation email", e);
        }

    }

    public String saveImage(MultipartFile file, User user) {

        Path uploadPath = Paths.get(uploadDir + "/users");
        if (!Files.exists(uploadPath)) {
            try {
                Files.createDirectory(uploadPath);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        String fileName = user.getName() + "_" + UUID.randomUUID();


        try {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileName;
    }
}
