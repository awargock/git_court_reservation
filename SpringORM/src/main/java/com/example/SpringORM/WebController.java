package com.example.SpringORM;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class WebController {
  @RequestMapping(value="/",method = RequestMethod.GET)
    public String homepage(){
        return "hello";
    }
}






