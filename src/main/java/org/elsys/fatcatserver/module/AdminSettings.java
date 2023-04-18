package org.elsys.fatcatserver.module;

import jakarta.persistence.*;

@Entity
@Table(name = "adminsettings")
public class AdminSettings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "totalguards")
    private Integer totalguards;

    @Column(name = "totalsectors")
    private Integer totalsectors;

    public Integer getTotalguards() {
        return totalguards;
    }

    public void setTotalguards(Integer totalguards) {
        this.totalguards = totalguards;
    }

    public Integer getTotalsectors() {
        return totalsectors;
    }

    public void setTotalsectors(Integer totalsectors) {
        this.totalsectors = totalsectors;
    }
}


