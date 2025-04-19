package com.cvbuilder.back.controller;

import com.cvbuilder.back.assembler.CurriculumAssembler;
import com.cvbuilder.back.controller.utils.CurriculumUtils;
import com.cvbuilder.back.model.curriculum.CurriculumModel;
import com.cvbuilder.back.model.curriculum.request.CurriculumRequestModel;
import com.cvbuilder.back.model.curriculum.response.CurriculumResponseModel;
import com.cvbuilder.back.service.CurriculumService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/curriculum")
@Slf4j
@Tag(name = "Curriculm Vitae Apis")
@RequiredArgsConstructor
public class CurriculumController {

  private final CurriculumService curriculumService;

  private static final String END_CURRICULUM_GENERATE_LOG = "END - /curriculum/generate";

  @Operation(description = "Generate a curriculm vitae passed all the required informations")
  @ApiResponse(
      responseCode = "200",
      content =
          @Content(
              schema = @Schema(contentSchema = CurriculumResponseModel.class),
              mediaType = MediaType.APPLICATION_JSON_VALUE))
  @ApiResponse(
      responseCode = "400",
      content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
  @ApiResponse(
      responseCode = "500",
      content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
  @PostMapping("/generate")
  public ResponseEntity<CurriculumResponseModel> generateCv(
      @RequestBody CurriculumRequestModel request) {
    log.atInfo().log("START - /curriculum/generate");

    if (!CurriculumUtils.isCurriculumRequestValid(request)) {
      log.atInfo().log(END_CURRICULUM_GENERATE_LOG);
      return ResponseEntity.badRequest().build();
    }

    CurriculumModel curriculum = request.getCurriculum();

    String base64 = "";
    try {
      base64 = curriculumService.generateCurriculumPdfBase64(curriculum);
    } catch (Exception e) {
      log.atInfo().log(END_CURRICULUM_GENERATE_LOG);
    }

    String cvName = CurriculumUtils.getCvName(curriculum.getName(), curriculum.getLastName());

    CurriculumResponseModel response = CurriculumAssembler.createCurriculumResponse(cvName, base64);

    log.atInfo().log(END_CURRICULUM_GENERATE_LOG);

    return ResponseEntity.ok(response);
  }
}
