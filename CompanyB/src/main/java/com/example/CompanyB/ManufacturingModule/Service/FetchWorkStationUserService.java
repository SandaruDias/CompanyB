package com.example.CompanyB.ManufacturingModule.Service;

import com.example.CompanyB.ManufacturingModule.DataTransferObject.FetchWorksStationUser;
import com.example.CompanyB.ManufacturingModule.Repository.FetchWorkStationUserRepository;
import org.springframework.stereotype.Service;

@Service
public class FetchWorkStationUserService {

    private final FetchWorkStationUserRepository fetchWorkStationUserRepository;

    public FetchWorkStationUserService(FetchWorkStationUserRepository fetchWorkStationUserRepository) {
        this.fetchWorkStationUserRepository = fetchWorkStationUserRepository;
    }

    public FetchWorksStationUser GetWorkstationDocument(int StationId){
     return fetchWorkStationUserRepository.findByWorkStationId(StationId);
    }
}