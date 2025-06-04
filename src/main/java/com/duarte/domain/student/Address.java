package com.duarte.domain.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class Address {
    private String street;
    private String number;
    private String province;
    private String city;
    private String state;
    private String country;

}