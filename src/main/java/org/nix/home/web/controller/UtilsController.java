package org.nix.home.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/utils")
public class UtilsController {

    @GetMapping(value = "/ping")
    public String hello() {
        return "hello";
    }

}
