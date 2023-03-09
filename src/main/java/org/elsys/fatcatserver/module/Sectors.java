package org.elsys.fatcatserver.module;

import jakarta.persistence.*;

@Entity
@Table(name = "sectors")
public class Sectors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="guards")
    private String guards;
}


