package be.thomasmore.project_mobile_dev;

public class Gebruiker {
    private long id;
    private String voornaam;
    private String familienaam;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Gebruiker() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public void setFamilienaam(String familienaam) {
        this.familienaam = familienaam;
    }


    @Override
    public String toString() {return voornaam + " " + familienaam; }
    public String welkom() {return voornaam;}
    public Gebruiker(long id, String voornaam, String familienaam, String token) {
        this.id = id;
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.token = token;

    }
}
