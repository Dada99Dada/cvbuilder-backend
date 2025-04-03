package com.cvbuilder.back.model.cv;

import lombok.Data;

@Data
public class Education {
    private String institution;
    private String degree;
    private long fromYear;
    private long toYear;
}
