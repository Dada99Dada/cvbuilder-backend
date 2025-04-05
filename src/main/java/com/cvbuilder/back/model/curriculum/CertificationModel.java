package com.cvbuilder.back.model.curriculum;

import lombok.Data;

@Data
public class CertificationModel {
  private String name;
  private String issuer;
  private long year;
}
