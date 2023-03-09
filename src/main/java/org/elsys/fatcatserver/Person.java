package org.elsys.fatcatserver;


import jakarta.persistence.*;

@Entity
@Table(name = "person")
public class Person {
    enum dangerLevel {
        LOW, MEDIUM, HIGH
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="emp_id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="sector")
    private String sector;

    @Column(name="description")
    private String desc;

    @Column(name="danger")
    private dangerLevel danger;
}


