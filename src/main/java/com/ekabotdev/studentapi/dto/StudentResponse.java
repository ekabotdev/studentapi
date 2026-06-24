package com.ekabotdev.studentapi.dto;

import lombok.Getter;
import lombok.Setter;

public class StudentResponse {
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String firstName;
    @Getter
    @Setter
    private String lastName;
    @Getter
    @Setter
    private String email;
}
