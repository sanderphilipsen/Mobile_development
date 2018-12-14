package be.thomasmore.project_mobile_dev.classes;

public class SpelType {
    private long id;
    private String naam;

    public SpelType() {
    }

    public SpelType(long id, String naam) {
        this.id = id;
        this.naam = naam;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    @Override
    public String toString() {return naam;}
}
