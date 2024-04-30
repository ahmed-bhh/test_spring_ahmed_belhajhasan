package com.apex.test_spring.services;

import com.apex.test_spring.entities.*;
import com.apex.test_spring.repositories.ChaineRepository;
import com.apex.test_spring.repositories.ProgrammeRepository;
import com.apex.test_spring.repositories.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ServiceExamenIml implements IServiceTest {
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    ChaineRepository chaineRepository;
    @Autowired
    ProgrammeRepository programmeRepository;

    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur u) {
        return utilisateurRepository.save(u);
    }

    @Override
    public Programme ajouterProgrammeEtChaine(Programme p) {


        return programmeRepository.save(p);
    }

    @Override
    public Programme ajouterProgrammeEtaffecterChaine(Programme p, Long chId) {
        Chaine chaine_affecter =chaineRepository.findById(chId).get();
        p.setChaine(chaine_affecter);
        return programmeRepository.save(p);
    }

    @Override
    public void affecterProgrammeAutilisateur(String prNom, String usrNom) {
        List<Utilisateur> allUsers = utilisateurRepository.findAll();
        List<Programme> allPrograms = programmeRepository.findAll();
        Utilisateur targetUser = null;
        Programme targetProgram = null;

        for (Utilisateur user : allUsers) {
            if (user.getUsrNom().equals(usrNom)) {
                targetUser = user;
                break;
            }
        }

        for (Programme program : allPrograms) {
            if (program.getPrNom().equals(prNom)) {
                targetProgram = program;
                break;
            }
        }

        if (targetUser != null && targetProgram != null) {
            List<Programme> updatedPrograms = new ArrayList<>();
            if (targetUser.getProgrammes() != null) {
                updatedPrograms.addAll(targetUser.getProgrammes());
            }

            boolean programExists = false;
            for (Programme existingProgram : updatedPrograms) {
                if (existingProgram.getPrId().equals(targetProgram.getPrId())) {
                    programExists = true;
                    break;
                }
            }

            if (!programExists) {
                updatedPrograms.add(targetProgram);
            }
            targetUser.setProgrammes(updatedPrograms);

            utilisateurRepository.save(targetUser);
        } else {//fama mochkol
        }
    }

    @Override
    public List<Utilisateur> recupererUtilisateur(Profession p, LocalDate d, Thematique t) {


        return utilisateurRepository.GetUsersbyJPQL(p,d,t);
    }

    @Override
    public void desaffecterProgrammesDeUtilisateur(String prNom, String usrNom) {
        List<Utilisateur> allUsers = utilisateurRepository.findAll();
        List<Programme> allPrograms = programmeRepository.findAll();
        Utilisateur targetUser = null;
        Programme targetProgram = null;

        for (Utilisateur user : allUsers) {
            if (user.getUsrNom().equals(usrNom)) {
                targetUser = user;
                break;
            }
        }

        for (Programme program : allPrograms) {
            if (program.getPrNom().equals(prNom)) {
                targetProgram = program;
                break;
            }
        }

        if (targetUser != null && targetProgram != null) {
            List<Programme> updatedPrograms = new ArrayList<>();
            if (targetUser.getProgrammes() != null) {
                updatedPrograms.addAll(targetUser.getProgrammes());
            }

            boolean programExists = false;
            for (Programme existingProgram : updatedPrograms) {
                if (existingProgram.getPrId().equals(targetProgram.getPrId())) {
                    programExists = true;
                    break;
                }
            }

            if (!programExists) {
                updatedPrograms.remove(targetProgram);
            }
            targetUser.setProgrammes(updatedPrograms);

            utilisateurRepository.save(targetUser);
        } else {//fama mochkol
        }
    }
}
