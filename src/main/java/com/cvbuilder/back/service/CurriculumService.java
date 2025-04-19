package com.cvbuilder.back.service;

import com.cvbuilder.back.model.curriculum.CurriculumModel;

public interface CurriculumService {
  public String generateCurriculumPdfBase64(CurriculumModel curriculum);
}
