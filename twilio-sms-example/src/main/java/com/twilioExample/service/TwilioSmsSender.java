package com.twilioExample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import com.twilioExample.config.TwilioConfiguration;
import com.twilioExample.dto.SmsRequest;

@Service("twilio")
public class TwilioSmsSender implements SmsSender {
    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class);
    private final TwilioConfiguration twilioConfiguration;
    
    @Value("${twilio.phoneNumber}")
    private String toNumber;

    @Autowired
    public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }
    
    @Override
    public void sendSms(SmsRequest smsRequest) {
        if (isPhoneNumberValid(smsRequest.getPhoneNumber())) {
        	System.out.println(smsRequest.getPhoneNumber());
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            
            
            System.out.println(toNumber+"😊😊😊😊😊");

            System.out.println(twilioConfiguration.getTrialNumber());
            System.out.println(twilioConfiguration.getAccountSid());
            System.out.println(twilioConfiguration.getAuthToken());
            
            PhoneNumber from = new PhoneNumber(toNumber);
            System.out.println(smsRequest.getMessage());
            String message = smsRequest.getMessage();
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
            
            LOGGER.info("Send sms {}", smsRequest);
        } else {
            throw new IllegalArgumentException(
                    "Phone number [" + smsRequest.getPhoneNumber() + "] is not a valid number"
            );
        }
    }
    private boolean isPhoneNumberValid(String phoneNumber) {
        // TODO: Implement phone number validator
        return true;
    }
}
