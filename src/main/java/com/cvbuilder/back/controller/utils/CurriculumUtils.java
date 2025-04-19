package com.cvbuilder.back.controller.utils;

import com.cvbuilder.back.model.curriculum.*;
import com.cvbuilder.back.model.curriculum.request.CurriculumRequestModel;
import com.cvbuilder.back.utils.FileUtils;
import java.util.List;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CurriculumUtils {

  public static String getCvName(String name, String lastName) {
    return StringUtils.joinWith("_", name, lastName, String.valueOf(System.currentTimeMillis()));
  }

  public static boolean isCurriculumRequestValid(CurriculumRequestModel curriculumRequest) {
    boolean isValid = true;
    CurriculumModel cv = curriculumRequest.getCurriculum();

    if (Objects.isNull(cv)) {
      log.atWarn().log("Curriculum must be populated");
      return false;
    }

    if (!isBasicInfoValid(cv)) isValid = false;

    String photo = cv.getPhotoUrl();
    if (!StringUtils.isEmpty(photo) && FileUtils.isBase64(photo)) isValid = false;

    if (!areExperiencesValid(cv.getExperiences())) isValid = false;

    if (!areEducationsValid(cv.getEducations())) isValid = false;

    if (!areSkillsValid(cv.getSkills())) isValid = false;

    if (!areLanguagesValid(cv.getLanguages())) isValid = false;

    if (!areCertificationsValid(cv.getCertifications())) isValid = false;

    if (!areSectionsValid(cv.getSections())) isValid = false;

    return isValid;
  }

  private static boolean isBasicInfoValid(CurriculumModel cv) {
    if (StringUtils.isEmpty(cv.getName())
        || StringUtils.isEmpty(cv.getEmail())
        || StringUtils.isEmpty(cv.getPhone())
        || StringUtils.isEmpty(cv.getAddress())) {
      log.atError().log("Name, phone, and address are required.");
      return false;
    }
    return true;
  }

  private static boolean areExperiencesValid(List<ExperienceModel> experiences) {
    if (CollectionUtils.isEmpty(experiences)) return true;

    for (ExperienceModel exp : experiences) {
      if (StringUtils.isEmpty(exp.getCompany())
          || StringUtils.isEmpty(exp.getPosition())
          || exp.getFromDate() == null
          || exp.getToDate() == null
          || StringUtils.isEmpty(exp.getDescription())) {
        log.atError().log("Experience fields must be populated");
        return false;
      }
    }
    return true;
  }

  private static boolean areEducationsValid(List<EducationModel> educations) {
    if (CollectionUtils.isEmpty(educations)) return true;

    for (EducationModel edu : educations) {
      if (StringUtils.isEmpty(edu.getInstitution())
          || StringUtils.isEmpty(edu.getDegree())
          || edu.getFromYear() == null
          || edu.getToYear() == null) {
        log.atError().log("Education fields must be populated");
        return false;
      }
    }
    return true;
  }

  private static boolean areSkillsValid(List<SkillModel> skills) {
    if (CollectionUtils.isEmpty(skills)) return true;

    for (SkillModel skill : skills) {
      if (StringUtils.isEmpty(skill.getName())) {
        log.atError().log("Skill fields must be populated");
        return false;
      }
    }
    return true;
  }

  private static boolean areLanguagesValid(List<LanguageModel> languages) {
    if (CollectionUtils.isEmpty(languages)) return true;

    for (LanguageModel lang : languages) {
      if (StringUtils.isEmpty(lang.getLanguage()) || StringUtils.isEmpty(lang.getLevel())) {
        log.atError().log("Language fields must be populated");
        return false;
      }
    }
    return true;
  }

  private static boolean areCertificationsValid(List<CertificationModel> certifications) {
    if (CollectionUtils.isEmpty(certifications)) return true;

    for (CertificationModel cert : certifications) {
      if (StringUtils.isEmpty(cert.getName())
          || StringUtils.isEmpty(cert.getIssuer())
          || cert.getYear() == null) {
        log.atError().log("Certification fields must be populated");
        return false;
      }
    }
    return true;
  }

  private static boolean areSectionsValid(List<SectionModel> sections) {
    if (CollectionUtils.isEmpty(sections)) return true;

    for (SectionModel section : sections) {
      if (StringUtils.isEmpty(section.getSectionName())
          || StringUtils.isEmpty(section.getContenuto())) {
        log.atError().log("Custom section fields must be populated");
        return false;
      }
    }
    return true;
  }
}
