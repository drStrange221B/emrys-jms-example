package com.emrys.jms.sender;

import com.emrys.jms.config.JmsConfig;
import com.emrys.jms.model.MessageSample;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class MessageListener {


    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload MessageSample messageSample, @Headers MessageHeaders headers, Message message)
    {
        System.out.println("I got a Message !!!!!");

        System.out.println(messageSample);
    }
}
