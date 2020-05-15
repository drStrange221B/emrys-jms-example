package com.emrys.jms.sender;

import com.emrys.jms.config.JmsConfig;
import com.emrys.jms.model.MessageSample;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class HelloSender {

    private final JmsTemplate jmsTemplate;


    @Scheduled(fixedRate = 5000)
    public void sendMessage(){
        System.out.println("I'm Sending a message");

        MessageSample message = MessageSample.builder().id(UUID.randomUUID()).message("Hello MessageSample !").build();

        jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE, message);


        System.out.println("Message send !");


    }






}

