package com.nroad.soc.itsm.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class WebController {

    @GetMapping("/entrance")
    public String entrance() {

        return "entrance";
    }

    @GetMapping("/selfservice")
    public String selfservice() {

        return "selfservice";
    }
    
}
