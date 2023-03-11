package org.elsys.fatcatserver.module;

import jakarta.persistence.*;

@Entity
@Table(name = "sectors")
public class Sectors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "guards")
    private String guards;

    public Sectors() {
    }

    public Sectors(String guards) {
        this.guards = guards;
    }

    public String getGuards() {
        return guards;
    }

    public void setGuards(String guards) {
        this.guards = guards;
    }
}


