package com.cvbuilder.back.model.curriculum;

import lombok.Data;

@Data
public class EducationModel {
  private String institution;
  private String degree;
  private Long fromYear;
  private Long toYear;
}
