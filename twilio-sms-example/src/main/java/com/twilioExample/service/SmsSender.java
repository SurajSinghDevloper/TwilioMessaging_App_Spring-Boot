package com.twilioExample.service;

import com.twilioExample.dto.SmsRequest;

public interface SmsSender {
    void sendSms(SmsRequest smsRequest);
    // or maybe void sendSms(String phoneNumber, String message);
}
