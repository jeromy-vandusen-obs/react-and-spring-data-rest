package com.obsglobal.boot.react.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Employee {
    private @Id @GeneratedValue Long id;
    private @NonNull String firstName;
    private @NonNull String lastName;
    private @NonNull String description;

    private @Version @JsonIgnore Long version;
}
