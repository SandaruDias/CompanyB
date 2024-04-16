package com.example.CompanyB.HumanResourceManagementModule.Repository;

import com.example.CompanyB.HumanResourceManagementModule.Model.Employ;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class ApplicantSearchRepo implements searchRepository {

    @Override
    public List<Employ> findByText(String text) {
        List<Employ> applicantList = new ArrayList<>();
        //
        //
        // IMPLEMENTATION
        //
        //
        return applicantList;
    }
}
