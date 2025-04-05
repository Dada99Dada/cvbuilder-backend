package com.cvbuilder.back.model.curriculum;

import lombok.Data;

@Data
public class EducationModel {
  private String institution;
  private String degree;
  private long fromYear;
  private long toYear;
}
