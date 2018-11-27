package be.thomasmore.project_mobile_dev;

public class Stoornis {
    private long id;
    private String stroornis;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStroornis() {
        return stroornis;
    }

    public void setStroornis(String stroornis) {
        this.stroornis = stroornis;
    }

    public Stoornis(long id, String stroornis) {
        this.id = id;
        this.stroornis = stroornis;
    }

    public Stoornis() {
    }
}
