package com.cvbuilder.back.service;

import com.cvbuilder.back.model.curriculum.CurriculumModel;
import com.cvbuilder.back.utils.FileUtils;
import java.io.ByteArrayOutputStream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Slf4j
@RequiredArgsConstructor
@Service
public class CurriculumServiceimpl implements CurriculumService {

  private final TemplateEngine templateEngine;

  @Override
  public String generateCurriculumPdfBase64(CurriculumModel curriculum) {
    Context context = new Context();
    context.setVariable("curriculum", curriculum);

    String htmlContent = templateEngine.process("cv_template", context);

    try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
      FileUtils.convertInPdf(htmlContent, outputStream);

      return FileUtils.convertToBase64(outputStream);

    } catch (Exception e) {
      log.atError().log("Error while generating pdf ", e);
      return null;
    }
  }
}
