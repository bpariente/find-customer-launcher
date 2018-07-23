package com.stratio.bawag.findcustomerlauncher.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class FindCustomerRequestDto {

  private String iban;
  private String firstName;
  private LocalDate birthDate;
  private String registerNumber;
  private Boolean phoneticSearch;
  private String postalCode;
  private String street;
  private String oenbId;
  private Integer maxHostCalls;

}
