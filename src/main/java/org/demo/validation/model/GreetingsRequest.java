package org.demo.validation.model;

import org.demo.validation.constraint.NotContains;

public class GreetingsRequest {

    @NotContains(
            notAllowValues = {"Juanito","Maria"},
            message = "The name entered is not allowed. values not allowed are {notAllowValues}"
    )
    private String name;

    @NotContains(
            notAllowValues = {"Bernardo","Juana"},
            message = "The name entered is not allowed. values not allowed are {notAllowValues}"
    )
    private String otherName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }
}
