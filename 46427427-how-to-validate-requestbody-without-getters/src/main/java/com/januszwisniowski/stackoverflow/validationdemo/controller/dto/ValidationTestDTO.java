package com.januszwisniowski.stackoverflow.validationdemo.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

@ToString
public class ValidationTestDTO {

    @NotBlank
    private String fieldWithGetter;

    @NotBlank
    @JsonProperty
    private String fieldWithoutGetter;

    public String getFieldWithGetter() {
        return fieldWithGetter;
    }
}
