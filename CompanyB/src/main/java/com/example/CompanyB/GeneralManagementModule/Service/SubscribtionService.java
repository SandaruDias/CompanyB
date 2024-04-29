package com.example.CompanyB.GeneralManagementModule.Service;

import com.example.CompanyB.GeneralManagementModule.Model.Subscribtion;
import com.example.CompanyB.GeneralManagementModule.Repository.SubscribtionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SubscribtionService {

    private final SubscribtionRepository subscribtionRepository;

    @Autowired
    public SubscribtionService(SubscribtionRepository subscribtionRepository) {
        this.subscribtionRepository = subscribtionRepository;
    }

    public Subscribtion gettingSubscribtion(String email) {
        if (subscribtionRepository.existsByEmail(email)) {
            throw new RuntimeException("Email already entered,Thank you.");
        } else {
            Subscribtion newSubscribtion = new Subscribtion();
            newSubscribtion.setEmail(email);
            try {
                return subscribtionRepository.save(newSubscribtion);
            } catch (DataIntegrityViolationException e) {
                // Handle duplicate entry gracefully
                throw new RuntimeException("Email already exists. Please try with a different email.");
            }
        }
    }
    public List getallsubscribtions() {
        return subscribtionRepository.findAll();
    }
}



