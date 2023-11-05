package com.chandan.service;

import com.chandan.binding.CitizenApp;
import com.chandan.entity.CitizenAppEntity;
import com.chandan.repository.CitizenAPPRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ArServiceImpl implements ArService {
    @Autowired
    private CitizenAPPRepository appRepo;
    @Override
    public Integer createApplication(CitizenApp app) {
        //make rest call to ssa-web api with ssn as input
        String endpointUrl="https://ssa-web-api.herokuapp.com/ssn/{ssn}";
//        RestTemplate rt=new RestTemplate();
//        ResponseEntity<String> resEntity=rt.getForEntity(endpointUrl,String.class,app.getSsn());
//        String stateName= resEntity.getBody();
                       // 2nd method
        WebClient webClient=WebClient.create();
        String stateName=webClient.get()//it represent Get request
                .uri(endpointUrl,app.getSsn()) //it represents url to send req
                .retrieve() //to retrieve response
                .bodyToMono(String.class) //to specify response type
                .block(); // to make synchronus call
        if ("New Jersey".equals(stateName)){
            //create application
            CitizenAppEntity entity=new CitizenAppEntity();
            BeanUtils.copyProperties(app,entity);
            entity.setStateName(stateName);
           CitizenAppEntity save =appRepo.save(entity);
            return  save.getAppId();
        }
        return 0;
    }
}
