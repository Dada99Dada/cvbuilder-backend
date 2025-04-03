package com.cvbuilder.back.model.cv;

import com.cvbuilder.back.util.serializer.LocalDateYearMonthDeserializer;
import com.cvbuilder.back.util.serializer.LocalDateYearMonthSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Experience {
    private String company;
    private String position;

    @JsonSerialize(using = LocalDateYearMonthSerializer.class)
    @JsonDeserialize(using = LocalDateYearMonthDeserializer.class)
    private LocalDate fromDate;
    @JsonSerialize(using = LocalDateYearMonthSerializer.class)
    @JsonDeserialize(using = LocalDateYearMonthDeserializer.class)
    private LocalDate toDate;

    private String description;
}
