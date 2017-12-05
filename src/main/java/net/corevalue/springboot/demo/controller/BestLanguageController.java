package net.corevalue.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class BestLanguageController {

    @Value("${best.language}")
    String bestLanguage;

    @GetMapping("/language")
    public Map language() {
        return Collections.singletonMap("best_language", bestLanguage);
    }
}
