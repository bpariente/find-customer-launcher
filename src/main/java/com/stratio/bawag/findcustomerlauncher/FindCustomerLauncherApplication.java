package com.stratio.bawag.findcustomerlauncher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stratio.bawag.findcustomerlauncher.conductor.WorkFlowManager;

@SpringBootApplication
public class FindCustomerLauncherApplication {

  public static void main(String[] args) {
    SpringApplication.run(FindCustomerLauncherApplication.class, args);
  }
}
