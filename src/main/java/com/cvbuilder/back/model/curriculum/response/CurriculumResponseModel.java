package com.cvbuilder.back.model.curriculum.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CurriculumResponseModel {
  String cvName;
  String downloadLink;
}
