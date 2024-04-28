package com.example.CompanyB.ManufacturingModule.Service;

import com.example.CompanyB.ManufacturingModule.DataTransferObject.FetchUser;
import com.example.CompanyB.ManufacturingModule.Repository.FetchUserRepository;
import org.springframework.stereotype.Service;

@Service
public class FetchUserService {
    private final FetchUserRepository fetchUserRepository;

    public FetchUserService(FetchUserRepository fetchUserRepository) {
        this.fetchUserRepository = fetchUserRepository;
    }

    public FetchUser findByUserName(String userName) {
        return fetchUserRepository.findByUserName(userName);
    }
}