package be.thomasmore.project_mobile_dev.classes;

public class Gebruiker {
    private long id;
    private String voornaam;
    private String familienaam;
    private String token;
    private Long minimedaillesluistergoed;
    private Long grotemedaillesluistergoed;
    private Long minimedailleszeg;
    private Long grotemedailleszeg;



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

    public Long getMinimedaillesluistergoed() {
        return minimedaillesluistergoed;
    }

    public void setMinimedaillesluistergoed(Long minimedaillesluistergoed) {
        this.minimedaillesluistergoed = minimedaillesluistergoed;
    }

    public Long getGrotemedaillesluistergoed() {
        return grotemedaillesluistergoed;
    }

    public void setGrotemedaillesluistergoed(Long grotemedaillesluistergoed) {
        this.grotemedaillesluistergoed = grotemedaillesluistergoed;
    }

    public Long getMinimedailleszeg() {
        return minimedailleszeg;
    }

    public void setMinimedailleszeg(Long minimedailleszeg) {
        this.minimedailleszeg = minimedailleszeg;
    }

    public Long getGrotemedailleszeg() {
        return grotemedailleszeg;
    }

    public void setGrotemedailleszeg(Long grotemedailleszeg) {
        this.grotemedailleszeg = grotemedailleszeg;
    }

    @Override
    public String toString() {return voornaam + " " + familienaam; }
    public String welkom() {return voornaam;}
    public Gebruiker(long id, String voornaam, String familienaam, String token, Long minimedaillesluistergoed, Long grotemedaillesluistergoed, Long minimedailleszeg, Long grotemedailleszeg) {
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
