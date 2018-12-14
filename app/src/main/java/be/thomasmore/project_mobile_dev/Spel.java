package be.thomasmore.project_mobile_dev;

public class Spel {
    private long id;
    private long gebruikerId;
    private long speltypeId;
    private long paarId;

    public Spel() {}

    public Spel(long id, long gebruikerId, long speltypeId, long paarId) {
        this.id = id;
        this.gebruikerId = gebruikerId;
        this.speltypeId = speltypeId;
        this.paarId = paarId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getGebruikerId() {
        return gebruikerId;
    }

    public void setGebruikerId(long gebruikerId) {
        this.gebruikerId = gebruikerId;
    }

    public long getSpeltypeId() {
        return speltypeId;
    }

    public void setSpeltypeId(long speltypeId) {
        this.speltypeId = speltypeId;
    }

    public long getPaarId() {
        return paarId;
    }

    public void setPaarId(long paarId) {
        this.paarId = paarId;
    }
}
