package com.apex.test_spring.repositories;

import com.apex.test_spring.entities.Profession;
import com.apex.test_spring.entities.Thematique;
import com.apex.test_spring.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    @Query
            ("select u from Utilisateur   u join u.programmes pr where u.profession= :p and pr.chaine.thematique= :t and u.usrDateInscription > :d")
    List<Utilisateur> GetUsersbyJPQL(@Param("p") Profession p,@Param("d") LocalDate d,@Param("t") Thematique t);
}
