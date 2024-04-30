package com.apex.test_spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usrId;
    private String usrNom;
    private LocalDate usrDateInscription;
    @Enumerated(EnumType.STRING)
    private Profession profession;


    @ManyToMany(cascade = CascadeType.ALL)

    private List<Programme> programmes;
}
