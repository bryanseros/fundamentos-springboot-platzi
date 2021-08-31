package com.fundamenosplatzi.springboot.fundamentos.dto;

import java.time.LocalDate;

public class UserDTO {
    private Long id;
    private String name;
    private LocalDate birthday;

    public UserDTO(Long id, String name, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
