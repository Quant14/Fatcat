package org.elsys.fatcatserver.module;

import jakarta.persistence.*;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="sector")
    private String sector;

    @Column(name="description")
    private String description;

    @Column(name="danger")
    private String danger;

    public Person() {
    }

    public Person(String name, String sector, String description, String danger) {
        this.name = name;
        this.sector = sector;
        this.description = description;
        this.danger = danger;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDanger() {
        return danger;
    }

    public void setDanger(String danger) {
        this.danger = danger;
    }
}


