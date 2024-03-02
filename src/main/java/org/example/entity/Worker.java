package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

public class Worker {
    private String name;
    private LocalDate birthday;
    private Level level;
    private Integer salary;

    public Worker(String name, LocalDate birthday, Level level, Integer salary) {
        this.name = name;
        this.birthday = birthday;
        this.level = level;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Level getLevel() {
        return level;
    }

    public Integer getSalary() {
        return salary;
    }

}
