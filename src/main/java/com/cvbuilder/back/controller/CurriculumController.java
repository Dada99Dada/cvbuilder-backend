package com.cvbuilder.back.controller;

import com.cvbuilder.back.assembler.CurriculumAssembler;
import com.cvbuilder.back.model.curriculum.request.CurriculumRequestModel;
import com.cvbuilder.back.model.curriculum.response.CurriculumResponseModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Curriculm Vitae Apis")
public class CurriculumController {

  @Operation(description = "Generate a curriculm vitae passed all the required informations")
  @PostMapping("/generate")
  public ResponseEntity<CurriculumResponseModel> generateCv(
      @RequestBody CurriculumRequestModel request) {

    CurriculumResponseModel response = CurriculumAssembler.createCurriculumResponse("link");

    return ResponseEntity.ok(response);
  }
}
