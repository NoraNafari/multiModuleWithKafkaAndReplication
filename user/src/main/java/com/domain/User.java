package com.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(schema = "user_schema", name = "user_info")
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

}
