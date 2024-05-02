package com.sip.ams;


import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import com.sip.ams.entities.Etudiant;
import com.sip.ams.repositories.EtudiantRepositorie;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestDemoDataController {
    @Autowired
    private EtudiantRepositorie repo;

    @Test
    @Rollback(false)
    @Order(1)
    public void testCreateEtudiant() {
        Etudiant etudiant = new Etudiant();
        etudiant.setNom("Theo");
        etudiant.setAge(22);
        repo.save(etudiant);

        assertThat(etudiant.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void testFindEtudiantByName() {
        String nom = "Theo";
        Etudiant etudiant = repo.findByNom(nom);

        assertThat(etudiant.getNom()).isEqualTo(nom);
    }

    @Test
    @Order(3)
    public void testFindEtudiantByAge() {
        Integer age = 22;
        Etudiant etudiant = repo.findByAge(age);

        assertThat(etudiant.getAge()).isEqualTo(age);
    }

    @Test
    @Order(4)
    public void testUpdateEtudiant() {
        String nom = "Theo";
        Etudiant etudiant = repo.findByNom(nom);
        System.out.println(etudiant);
        etudiant.setAge(23);

        repo.save(etudiant);

        Etudiant updatedEtudiant = repo.findByNom(nom);
        assertThat(updatedEtudiant.getAge()).isEqualTo(23);
    }


    @Test
    @Order(5)
    public void testDeleteEtudiant() {
        String nom = "Theo";
        Etudiant etudiant = repo.findByNom(nom);
        repo.deleteById(etudiant.getId());

        Etudiant deletedEtudiant = repo.findByNom(nom);
        assertThat(deletedEtudiant).isNull();
    }
}
