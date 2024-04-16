package com.example.CompanyB.HumanResourceManagementModule.Repository;

import com.example.CompanyB.HumanResourceManagementModule.Model.Employ;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface searchRepository {
    List<Employ> findByText(String text);
}
