package com.stratio.bawag.findcustomerlauncher.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.conductor.common.run.Workflow;
import com.stratio.bawag.findcustomerlauncher.conductor.WorkFlowManager;
import com.stratio.bawag.findcustomerlauncher.dto.FindCustomerRequestDto;
import com.stratio.bawag.findcustomerlauncher.dto.FindCustomerResponseDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

@Api(value = "Find Customer WorkFlow Manager API")
@RequestMapping(path = "/workflow")
@Controller
@CrossOrigin(origins = "*", allowCredentials = "false", allowedHeaders = "*", maxAge = 3600)
public class FindCustomerLauncherController {

  private final WorkFlowManager workFlowManager;
  @Autowired
  private ObjectMapper objectMapper;

  public FindCustomerLauncherController(
      WorkFlowManager workFlowManager) {
    this.workFlowManager = workFlowManager;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseStatus(code = HttpStatus.CREATED)
  public ResponseEntity<FindCustomerResponseDto> startFindCustomerCase(
      @ApiParam("Request Body") @RequestBody FindCustomerRequestDto request
  ) {

    Workflow workflowResponse = workFlowManager.startWorkflow(request);
    FindCustomerResponseDto response = objectMapper.convertValue(workflowResponse.getOutput(),FindCustomerResponseDto.class);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }
}
