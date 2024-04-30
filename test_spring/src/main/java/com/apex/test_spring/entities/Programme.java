package com.apex.test_spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Programme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prId;
    private String prNom;

    @ManyToMany(mappedBy="programmes", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("programmes")

    private List<Utilisateur> utilisateurs;

    @ManyToOne(cascade = CascadeType.ALL)
    Chaine chaine;
}
