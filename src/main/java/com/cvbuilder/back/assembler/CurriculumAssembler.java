package com.cvbuilder.back.assembler;

import com.cvbuilder.back.model.curriculum.response.CurriculumResponseModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CurriculumAssembler {

  public static CurriculumResponseModel createCurriculumResponse(String name, String downloadLink) {
    String cvName = StringUtils.joinWith("_", "cv", name, System.currentTimeMillis());

    return CurriculumResponseModel.builder().cvName(cvName).base64(downloadLink).build();
  }
}
