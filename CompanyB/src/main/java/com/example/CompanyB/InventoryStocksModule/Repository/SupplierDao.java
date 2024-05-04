package com.example.CompanyB.InventoryStocksModule.Repository;

import com.example.CompanyB.InventoryStocksModule.Model.supplier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;
@Repository
public interface SupplierDao extends MongoRepository<supplier, String> {
    // supplier findBySuppliername(String suppliername);

    @Query(value = "{}", fields = "{  'id' : 1, 'suppliername' : 1, 'telephone' : 1, 'address' : 1, 'email' : 1}")
    List<supplier> findAllWithDetails();
}
