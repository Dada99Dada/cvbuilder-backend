package com.cvbuilder.back.model.curriculum;

import java.util.List;
import lombok.Data;

@Data
public class CurriculumModel {
  private String photoUrl;
  private String name;
  private String lastName;
  private String email;
  private String phone;
  private String address;
  private String summary;
  private List<ExperienceModel> experiences;
  private List<EducationModel> educations;
  private List<SkillModel> skills;
  private List<LanguageModel> languages;
  private List<CertificationModel> certifications;
  private List<SectionModel> sections;
}
