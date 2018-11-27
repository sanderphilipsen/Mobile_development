package be.thomasmore.project_mobile_dev;

public class Klank {
    private long id;
    private String klank;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKlank() {
        return klank;
    }

    public void setKlank(String klank) {
        this.klank = klank;
    }
    @Override
    public String toString() {return klank;}
    public Klank() {
    }

    public Klank(long id, String klank) {
        this.id = id;
        this.klank = klank;
    }
}
