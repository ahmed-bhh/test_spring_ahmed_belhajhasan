package com.apex.test_spring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chaine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chId;
    private String chNom;
    @Enumerated(EnumType.STRING)

    private Thematique thematique;

}
