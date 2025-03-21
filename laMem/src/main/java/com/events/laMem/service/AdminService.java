package com.events.laMem.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.events.laMem.model.Admin;
import com.events.laMem.repository.AdminRepository;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin registerAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Optional<Admin> findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }
}
