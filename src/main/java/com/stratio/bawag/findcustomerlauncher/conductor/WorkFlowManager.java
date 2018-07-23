package com.stratio.bawag.findcustomerlauncher.conductor;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.conductor.client.http.WorkflowClient;
import com.netflix.conductor.common.run.Workflow;
import com.stratio.bawag.findcustomerlauncher.dto.FindCustomerRequestDto;
import com.sun.jersey.api.client.config.DefaultClientConfig;

@Component
public class WorkFlowManager {

  private final WorkflowClient workflowClient = new WorkflowClient(new DefaultClientConfig());
  @Value("${workflowapi.url}")
  public String baseUrl;
  @Value("${conductor.workflowname")
  public String workflowName;
  @Autowired
  private ObjectMapper objectMapper;

  public Workflow startWorkflow(FindCustomerRequestDto request) {
    workflowClient.setRootURI(baseUrl);
    Map input = objectMapper.convertValue(request, Map.class);
    String id = workflowClient.startWorkflow(workflowName, 1, "", input);
    Workflow wf = workflowClient.getWorkflow(id, true);
    Workflow.WorkflowStatus workflowStatus = wf.getStatus();
    while (workflowStatus.equals(Workflow.WorkflowStatus.RUNNING)) {
      workflowStatus = workflowClient.getWorkflow(id, true).getStatus();
    }
    return workflowClient.getWorkflow(id, true);
  }
}
