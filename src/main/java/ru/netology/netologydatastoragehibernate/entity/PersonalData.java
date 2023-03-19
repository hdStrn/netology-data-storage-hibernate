package ru.netology.netologydatastoragehibernate.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class PersonalData implements Serializable {

    private String name;
    private String surname;
    private Integer age;
}
