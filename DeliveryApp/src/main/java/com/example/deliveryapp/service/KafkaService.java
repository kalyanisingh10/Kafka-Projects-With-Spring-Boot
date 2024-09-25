package com.example.deliveryapp.service;

import com.example.deliveryapp.config.AppConstant;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class KafkaService {

    //private Logger logger= (Logger) LoggerFactory.getLogger(KafkaService.class);

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public boolean updateLocation(String location){

        this.kafkaTemplate.send(AppConstant.LOCATION_UPDATE_TOPIC_NAME,location);
      //  logger.info("Message produced successfully");
        return  true;

    }
}
