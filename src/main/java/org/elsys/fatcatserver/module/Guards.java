package org.elsys.fatcatserver.module;

import jakarta.persistence.*;

@Entity
@Table(name = "guards")
public class Guards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="total")
    private String total;
}


