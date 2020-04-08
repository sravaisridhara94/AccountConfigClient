package com.example.accountservice.entity;

public class AccountConstants {

    public static final String RESTCALL_CUSTOMERSERVICE = "/v1/customers/";
    public static final int SUCCESS= 200;
    public static final int NOT_AUTHORIZED = 401;
    public static final int FORBIDDEN = 403;
    public static final int NOT_FOUND = 404;
    public static final String CUSTOMERS ="Customers";
    public static final String CUSTOMER_SERVICE="lb://accountHolder-service";
}
