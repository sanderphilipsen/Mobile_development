package be.thomasmore.project_mobile_dev.classes;

public class Gebruiker {
    private long id;
    private String voornaam;
    private String familienaam;
    private String token;
    private Number minimedaillesluistergoed;
    private Number grotemedaillesluistergoed;
    private Number minimedailleszeg;
    private Number grotemedailleszeg;



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

    public Number getMinimedaillesluistergoed() {
        return minimedaillesluistergoed;
    }

    public void setMinimedaillesluistergoed(Number minimedaillesluistergoed) {
        this.minimedaillesluistergoed = minimedaillesluistergoed;
    }

    public Number getGrotemedaillesluistergoed() {
        return grotemedaillesluistergoed;
    }

    public void setGrotemedaillesluistergoed(Number grotemedaillesluistergoed) {
        this.grotemedaillesluistergoed = grotemedaillesluistergoed;
    }

    public Number getMinimedailleszeg() {
        return minimedailleszeg;
    }

    public void setMinimedailleszeg(Number minimedailleszeg) {
        this.minimedailleszeg = minimedailleszeg;
    }

    public Number getGrotemedailleszeg() {
        return grotemedailleszeg;
    }

    public void setGrotemedailleszeg(Number grotemedaillezeg) {
        this.grotemedailleszeg = grotemedaillezeg;
    }

    @Override
    public String toString() {return voornaam + " " + familienaam; }
    public String welkom() {return voornaam;}
    public Gebruiker(long id, String voornaam, String familienaam, String token, Number minimedaillesluistergoed, Number grotemedaillesluistergoed, Number minimedailleszeg, Number grotemedailleszeg) {
        this.id = id;
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.token = token;
        this.minimedaillesluistergoed = minimedaillesluistergoed;
        this.grotemedaillesluistergoed = grotemedaillesluistergoed;
        this.grotemedailleszeg = grotemedailleszeg;
        this.minimedailleszeg = minimedailleszeg;
    }
}
