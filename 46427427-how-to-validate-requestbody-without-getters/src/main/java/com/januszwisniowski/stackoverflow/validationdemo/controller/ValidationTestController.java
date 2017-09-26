package com.januszwisniowski.stackoverflow.validationdemo.controller;

import com.januszwisniowski.stackoverflow.validationdemo.controller.dto.ValidationTestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/test")
public class ValidationTestController {

    @PostMapping(
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public ValidationTestDTO create(@RequestBody @Valid ValidationTestDTO validationTestDTO) {
        return validationTestDTO;
    }
}
