package com.lboeri.boeriapi.controller;

import com.lboeri.boeriapi.record.Greeting;
import com.lboeri.boeriapi.service.BoeriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ApiController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    BoeriService boeriServiceImp;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        boeriServiceImp.findApiConfig("getUserCityInfo");
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}
