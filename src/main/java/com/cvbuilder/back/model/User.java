package com.cvbuilder.back.model;

import lombok.Data;

@Data
public class User {
    private String id;
    private String email;
    private String password;
    private String name;
}
