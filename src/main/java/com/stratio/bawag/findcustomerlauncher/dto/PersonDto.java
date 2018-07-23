package com.stratio.bawag.findcustomerlauncher.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

  private String address;
  private String birthDate;
  private String hints;
  private String identFlag;
  private String name;
  private Boolean naturalPerson;
  private String oenbId;
  private PersonKey personKey;
  private String registerNumber;
}
