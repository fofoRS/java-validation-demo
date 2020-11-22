package org.demo.validation.model;

import org.demo.validation.constraint.NotContains;
import org.hibernate.validator.constraints.Length;

public class GreetingsRequest {

    @NotContains(
            notAllowValues = {"Juanito","Maria"},
            message = "The first name is not allowed. values not allowed are {notAllowValues}"
    )
    private String fistName;

    @NotContains(
            notAllowValues = {"Bernardo","Juana"},
            message = "The last name is not allowed. values not allowed are {notAllowValues}"
    )
    @Length(
            min = 1,
            max = 10,
            message = "The lasted must have a length between {min} and {max}"
    )
    private String lastName;

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
