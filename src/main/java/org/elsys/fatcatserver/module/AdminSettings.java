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
    private String totalguards;

    @Column(name = "totalsectors")
    private String totalsectors;

    public String getTotalguards() {
        return totalguards;
    }

    public void setTotalguards(String totalguards) {
        this.totalguards = totalguards;
    }

    public String getTotalsectors() {
        return totalsectors;
    }

    public void setTotalsectors(String totalsectors) {
        this.totalsectors = totalsectors;
    }
}


