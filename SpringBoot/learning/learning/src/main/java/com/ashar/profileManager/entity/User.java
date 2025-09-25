package com.ashar.profileManager.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_table",uniqueConstraints = {
        @UniqueConstraint(name = "uc_username",columnNames = {"username"})
},indexes = {
        @Index(name = "index_username",columnList = "username",unique = true)
})

public class User {

    @Id
    @SequenceGenerator(name = "seq_id", allocationSize = 20, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id")
    private int id;
    private String name;
    private Date dateOfBirth;
    private String address;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonManagedReference
    @ToString.Exclude
    private List<Profile> profiles;
}
