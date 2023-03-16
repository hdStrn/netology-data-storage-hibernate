package ru.netology.netologydatastoragehibernate.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(schema = "netology_hibernate")
@NoArgsConstructor
@Getter
@Setter
public class Person {

    @EmbeddedId
    private PersonalData personalData;
    private String phoneNumber;
    private String cityOfLiving;
}
