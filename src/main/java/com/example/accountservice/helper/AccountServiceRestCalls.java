package com.example.accountservice.helper;

import com.example.accountservice.entity.AccountConstants;
import com.example.accountservice.entity.RefreshableProperties;
import com.example.accountservice.infrastructure.RestTemplateFactory;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import java.net.URI;

/**
 * Account Service for rest calls
 * @author  Mounika
 * @version 1.0
 * @since   2020-08-04
 */
@Component
public class AccountServiceRestCalls {

    @Autowired
    private RestTemplateFactory factory;

    @Autowired
    private RefreshableProperties properties;

    @HystrixCommand(fallbackMethod = "fallBackEvent", commandKey = "fallBack-event", groupKey = "fallBack-event")
    @Retryable(maxAttempts = 3)
    public CustomerAccountMapperEntity getCustomerById(long customerId){
        StringBuffer url = new StringBuffer();
        url.append(getHost());
        url.append(AccountConstants.RESTCALL_CUSTOMERSERVICE);
        url.append(customerId);
        CustomerAccountMapperEntity event = factory.getInstance(AccountConstants.CUSTOMERS,properties.getConnectionTimeout(), properties.getRequestTimeout()).getForObject(url.toString(), CustomerAccountMapperEntity.class);
        return event;
    }

    public URI getHost(){
        return URI.create("lb://accountHolder-service");
    }

    public CustomerAccountMapperEntity fallBackEvent(long customerId){
        CustomerAccountMapperEntity event = new CustomerAccountMapperEntity();
        event.setAddress("Dummy");
        event.setCountryOfBirth("Dummy");
        event.setDob("Dummy");
        return event;
    }
}
