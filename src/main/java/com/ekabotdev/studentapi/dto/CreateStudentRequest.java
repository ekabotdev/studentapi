package com.ekabotdev.studentapi.dto;

import lombok.Getter;
import lombok.Setter;

public class CreateStudentRequest {

    @Getter
    @Setter
    private String firstName;
    @Getter
    @Setter
    private String lastName;
    @Getter
    @Setter
    private String email;

    public CreateStudentRequest(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

}
