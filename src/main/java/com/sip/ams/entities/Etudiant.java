package com.sip.ams.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "etudiants")

public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 64, unique = true, nullable = false)
    private String nom;

    @Column(nullable = false)
    private Integer age;

    public Etudiant(String nom, Integer age) {
        this.nom = nom;
        this.age = age;
    }

    public Etudiant() {
    }

    // getters and setters are not shown for brevity...

    @Override
    public String toString() {
        return "Etudiant [id=" + id + ", nom=" + nom + ", age=" + age + "]";
    }

    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }


}
