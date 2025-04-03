package com.cvbuilder.back.model.cv;

import lombok.Data;

@Data
public class Certification {
    private String name;
    private String issuer;
    private long year;
}
