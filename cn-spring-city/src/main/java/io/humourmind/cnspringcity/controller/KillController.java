package io.humourmind.cnspringcity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KillController {

  @RequestMapping("/kill")
  public String kill(){
    return "Instance Killed";
  }
}
