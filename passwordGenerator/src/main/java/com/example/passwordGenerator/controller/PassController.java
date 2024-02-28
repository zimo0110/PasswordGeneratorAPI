package com.example.passwordGenerator.controller;

import java.util.HashMap;
import java.util.List;

import com.example.passwordGenerator.src.Generator;
import com.example.passwordGenerator.src.GeneratorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class PassController {

//    @Autowired
//    private GeneratorRequest generatorRequest;

    @RequestMapping(value = "/generate", method=RequestMethod.GET)
    public String getPassword(@RequestBody GeneratorRequest g) {
        Generator gg = new Generator(g.getUpper(), g.getLower(), g.getNum(), g.getSym(), g.getLength());
        return gg.generatePass().toString();
    }
}
