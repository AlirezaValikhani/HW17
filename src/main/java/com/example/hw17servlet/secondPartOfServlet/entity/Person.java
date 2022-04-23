package com.example.hw17servlet.secondPartOfServlet.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;
    private String nationalCode;

    public Person(String fullName, String nationalCode) {
        this.fullName = fullName;
        this.nationalCode = nationalCode;
    }
}
