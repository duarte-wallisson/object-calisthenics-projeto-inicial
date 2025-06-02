package com.duarte.domain.email;

import lombok.ToString;

@ToString
public class Email {
    private final String email;

    public Email(String email) {
        if (email == null || !email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("Invalid e-mail address");
        }
        this.email = email;
    }


}
