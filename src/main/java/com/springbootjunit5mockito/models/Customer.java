package com.springbootjunit5mockito.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBL_CUSTOMERS")
public class Customer {
    @Id
    @GeneratedValue
    private  int id;
    private String name;
    private String surname;
}
