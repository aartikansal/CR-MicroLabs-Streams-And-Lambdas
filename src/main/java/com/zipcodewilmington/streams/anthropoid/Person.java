package com.zipcodewilmington.streams.anthropoid;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zipcodewilmington.streams.tools.DateUtils;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by leon on 5/1/17.
 *
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this class
 */
public class Person implements Comparable<Person> {
    private String name;
    private Integer age;
    private Boolean isMale;
    private Long personalId;
    private Date birthDate;
    private String[] aliases;

    public Person(String name, Boolean isMale, Long personalId, Date birthDate, String... aliases) {
        this.name = name;
        this.isMale = isMale;
        this.personalId = personalId;
        this.birthDate = birthDate;
        this.age = DateUtils.yearsBetween(birthDate, LocalDate.now());
        this.aliases = aliases;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isMale() {
        return isMale;
    }

    public long getPersonalId() {
        return personalId;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String[] getAliases() {
        return aliases;
    }


    @Override // implemented for comparison purposes
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new Error(e);
        }
    }

    @Override // implemented for sorting purposes
    public int compareTo(Person o) {
        return o.toString().compareTo(this.toString());
    }
}