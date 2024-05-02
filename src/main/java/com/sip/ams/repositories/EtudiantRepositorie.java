package com.sip.ams.repositories;

import com.sip.ams.entities.Etudiant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepositorie extends CrudRepository<Etudiant, Integer> {
    public Etudiant findByNom(String nom);

    public Etudiant findByAge(Integer age);

    void deleteById(Integer id);

    void save(Etudiant etudiant);
}
