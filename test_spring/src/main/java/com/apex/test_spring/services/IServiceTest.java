package com.apex.test_spring.services;

import com.apex.test_spring.entities.Profession;
import com.apex.test_spring.entities.Programme;
import com.apex.test_spring.entities.Thematique;
import com.apex.test_spring.entities.Utilisateur;

import java.time.LocalDate;
import java.util.List;

public interface IServiceTest {
    public Utilisateur ajouterUtilisateur(Utilisateur u);
    public Programme ajouterProgrammeEtChaine(Programme p);
    public Programme ajouterProgrammeEtaffecterChaine(Programme p, Long chId);
    public void affecterProgrammeAutilisateur(String prNom,String usrNom);
    public List<Utilisateur> recupererUtilisateur(Profession p, LocalDate d, Thematique t);
    public void desaffecterProgrammesDeUtilisateur(String prNom,String usrNom);

}
