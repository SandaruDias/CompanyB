package com.example.CompanyB.ManufacturingModule.Service;

import com.example.CompanyB.ManufacturingModule.DataTransferObject.FetchUser;
import com.example.CompanyB.ManufacturingModule.DataTransferObject.FetchWorksStationUser;
import com.example.CompanyB.ManufacturingModule.Repository.FetchUserRepository;
import com.example.CompanyB.ManufacturingModule.Repository.FetchWorkStationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserControllingService {
    @Autowired
    FetchUserRepository fetchUserRepository;
    @Autowired
    FetchWorkStationUserRepository fetchWorkStationUserRepository;

    @Autowired
    UserControllingService(FetchUserRepository fetchUserRepository , FetchWorkStationUserRepository fetchWorkStationUserRepository){
        this.fetchWorkStationUserRepository=fetchWorkStationUserRepository;
        this.fetchUserRepository = fetchUserRepository;
    }
    public int loginAdmin(String userName, String password){
        try {
            FetchUser fetchUser = fetchUserRepository.findByUserName(userName);
            if (fetchUser.getRole().equals("employee")) {
                if (fetchUser.getPassword().equals(password)) {
                    return 0; // login successful
                } else {
                    return -2; // password incorrect
                }
            } else {
                return -1; // does not have access

            }
        }
        catch(RuntimeException e){
            return -3; // no such a user in the system
        }
    }
    public int loginWorkstation(int workStationID,String userName, String password){
        boolean isLoggedToStation = fetchWorkStationUserRepository.existsFetchWorksStationUserByWorkStationIdAndActive(workStationID,true);
        if(isLoggedToStation) {
            return -1; // login unsuccessful only one user at one workstation
        }

        try {
            FetchUser fetchUser = fetchUserRepository.findByUserName(userName);
            if (fetchUser.getPassword().equals(password)){
                try{
                    FetchWorksStationUser fetchWorksStationUser = fetchWorkStationUserRepository.findByWorkStationIdAndUserName(workStationID,userName);
                    fetchWorksStationUser.setActive(true);
                    fetchWorkStationUserRepository.save(fetchWorksStationUser);
                }
                catch (RuntimeException e){
                    FetchWorksStationUser fetchWorksStationUser = new FetchWorksStationUser(workStationID,fetchUser.getId(),userName,true);
                    fetchWorkStationUserRepository.insert(fetchWorksStationUser);
                }
                return 0; // login successful
            }
            else{
                return -2; // incorrect password
            }
        }
        catch(RuntimeException e){
            return -3;// No such user exists, Username is wrong
        }

        }


    public int signOut(int workStationID,String userName){
        try {
            FetchWorksStationUser fetchWorksStationUser = fetchWorkStationUserRepository.findByWorkStationIdAndUserName(workStationID, userName);
            fetchWorksStationUser.setActive(false);
            fetchWorkStationUserRepository.save(fetchWorksStationUser);
            return 0; // sign out successful
        }
        catch (Exception e){
            return -1; // sign out unsuccessful
        }
    }
}
