package com.stratio.bawag.findcustomerlauncher.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class PersonKey {

  private String entity;
  private String personNumber;

}
