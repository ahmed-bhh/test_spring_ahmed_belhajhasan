package com.apex.test_spring.controllers;

import com.apex.test_spring.entities.Profession;
import com.apex.test_spring.entities.Programme;
import com.apex.test_spring.entities.Thematique;
import com.apex.test_spring.entities.Utilisateur;
import com.apex.test_spring.services.IServiceTest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level= AccessLevel.PUBLIC)
@RequestMapping("/testjeudi")
public class testController {
    IServiceTest iServiceTest;

    @PutMapping("/ajouterUtilisateur")
    public Utilisateur ajouterUtilisateur(@RequestBody Utilisateur utilisateur){
        return iServiceTest.ajouterUtilisateur(utilisateur);
    }
    @PutMapping("/ajouterProgrammeEtChaine")
    public Programme ajouterProgrammeEtChaine(@RequestBody Programme programme){
        return iServiceTest.ajouterProgrammeEtChaine(programme);
    }

    @PutMapping("/ajouterProgrammeEtaffecterChaine/{chid}")
    public Programme ajouterProgrammeEtaffecterChaine(@RequestBody Programme programme, @PathVariable Long chid){
        return iServiceTest.ajouterProgrammeEtaffecterChaine(programme,chid);
    }

    @PutMapping("/affecterProgrammeAutilisateur/{prnom}/{usrnom}")
    public void affecterProgrammeAutilisateur( @PathVariable String prnom,@PathVariable String usrnom){
         iServiceTest.affecterProgrammeAutilisateur(prnom,usrnom);
    }
    @PutMapping("/recupererUtilisateur/{p}/{d}/{t}")
    public List<Utilisateur> recupererUtilisateur(@PathVariable Profession p, @PathVariable LocalDate d, @PathVariable Thematique t){
      return   iServiceTest.recupererUtilisateur(p,d,t);
    }
    @PutMapping("/desaffecterProgrammesDeUtilisateur/{prnom}/{usrnom}")
    public void desaffecterProgrammesDeUtilisateur(@PathVariable String prnom,@PathVariable String usrnom){
           iServiceTest.desaffecterProgrammesDeUtilisateur(prnom,usrnom);
    }

}
