package org.github.haschie.demo.stunden.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Stunden {

    @Id
    private UUID uuid;

    private int stunde;
    private String wochentag;
    private String fach;
    private String lehrer;

    @Override
    public String toString(){
        return "Stundenplan{" +
                "id=" + uuid +
                ", wochentag='" + wochentag + '\'' +
                ", fach='" + fach + '\'' +
                ", lehrer='" + lehrer + '\'' +
                '}';
    }

    protected Stunden(){}

    public Stunden(UUID uuid, int stunde, String wochentag, String fach, String lehrer){
        this.uuid = uuid;
        this.stunde = stunde;
        this.wochentag = wochentag;
        this.fach = fach;
        this.lehrer = lehrer;
    }

    public UUID getUuid(){
        return uuid;
    }

    public int getStunde(){
        return stunde;
    }

    public String getWochentag(){
        return wochentag;
    }

    public String getFach(){
        return fach;
    }

    public String getLehrer(){
        return lehrer;
    }
}
