package com.cvbuilder.back.model.curriculum;

import com.cvbuilder.back.utils.serializer.LocalDateYearMonthDeserializer;
import com.cvbuilder.back.utils.serializer.LocalDateYearMonthSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.LocalDate;
import lombok.Data;

@Data
public class ExperienceModel {
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
