package ru.netology.netologydatastoragehibernate.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class PersonalData implements Serializable {

    private String name;
    private String surname;
    private Integer age;
}
