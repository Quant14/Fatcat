package org.elsys.fatcatserver;


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
    private Integer danger;

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

    public Integer getDanger() {
        return danger;
    }

    public void setDanger(Integer danger) {
        this.danger = danger;
    }
}


