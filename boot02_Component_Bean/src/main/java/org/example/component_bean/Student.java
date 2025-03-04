package org.example.component_bean;

import lombok.Data;

@Data
public class Student {
    private Person person;
    public Student(Person person) {
        this.person = person;
    }
}
