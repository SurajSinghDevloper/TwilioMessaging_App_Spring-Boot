package com.twilioExample.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilioExample.dto.SmsRequest;
import com.twilioExample.service.SmsService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/sms")
public class SmsController {
	
    private final SmsService smsService;
    
    @Autowired
    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }
    @PostMapping
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
    	
        smsService.sendSms(smsRequest);
    }
}
