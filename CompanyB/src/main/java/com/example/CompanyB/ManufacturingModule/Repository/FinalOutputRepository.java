
package com.example.CompanyB.ManufacturingModule.Repository;

import com.example.CompanyB.ManufacturingModule.DataTransferObject.FetchOrder;
import com.example.CompanyB.ManufacturingModule.DataTransferObject.FinalOutput;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FinalOutputRepository extends MongoRepository<FinalOutput,String>
{

}
