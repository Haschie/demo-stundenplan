package org.github.haschie.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Stundenplan {

    @Id
    private UUID uuid;

    private String schueler;

    @Override
    public String toString() {
        return "Stundenplan{" +
                "id=" + uuid +
                ", schueler='" + schueler + '\'' +
                ", von='" + von + '\'' +
                ", bis='" + bis + '\'' +
                '}';
    }

    private String von;
    private String bis;

    protected Stundenplan() {}

    public Stundenplan(UUID uuid, String schueler, String von, String bis) {
        this.uuid = uuid;
        this.schueler = schueler;
        this.von = von;
        this.bis = bis;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getSchueler() {
        return schueler;
    }

    public String getVon() {
        return von;
    }

    public String getBis() {
        return bis;
    }
}
