package org.github.haschie.demo.stunden;

public class StundenDTO {
    private int stunde;
    private String wochentag;
    private String fach;
    private String lehrer;

    public int getStunde(){
        return stunde;
    }

    public void setStunde(int stunde){
        this.stunde = stunde;
    }

    public String getWochentag(){
        return wochentag;
    }

    public void setWochentag(String wochentag){
        this.wochentag = wochentag;
    }

    public String getFach(){
        return fach;
    }

    public void setFach(String fach){
        this.fach = fach;
    }

    public String getLehrer(){
        return lehrer;
    }

    public void setLehrer(String lehrer){
        this.lehrer = lehrer;
    }

}
