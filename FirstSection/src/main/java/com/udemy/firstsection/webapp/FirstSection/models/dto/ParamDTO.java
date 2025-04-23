package com.udemy.firstsection.webapp.FirstSection.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParamDTO {

    private String message;
    private Integer code;
}
