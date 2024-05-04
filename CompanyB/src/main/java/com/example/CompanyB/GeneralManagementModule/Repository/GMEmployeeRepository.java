package com.example.CompanyB.GeneralManagementModule.Repository;

import com.example.CompanyB.GeneralManagementModule.Model.GMEmployee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface GMEmployeeRepository extends MongoRepository<GMEmployee,String> {
    GMEmployee findByUserName(String username);
    boolean existsById(String id);
    boolean existsByUserName(String username);

}
