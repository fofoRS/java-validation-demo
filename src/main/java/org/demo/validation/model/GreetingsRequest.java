package org.demo.validation.model;

import org.demo.validation.constraint.NotContains;
import org.hibernate.validator.constraints.Length;

public class GreetingsRequest {

    @NotContains(
            notAllowValues = {"Michael","Bill"},
            message = "The first name is not allowed. Following values are not allowed {notAllowValues}"
    )
    private String firstName;

    @NotContains(
            notAllowValues = {"Jackson","Gates"},
            message = "The last name is not allowed. Following values are not allowed {notAllowValues}"
    )
    @Length(
            min = 1,
            max = 10,
            message = "The last name must have a length between {min} and {max}"
    )
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
