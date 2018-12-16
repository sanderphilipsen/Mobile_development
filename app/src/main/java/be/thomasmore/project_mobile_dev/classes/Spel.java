package be.thomasmore.project_mobile_dev.classes;

public class Spel {
    private long id;
    private long gebruikerId;
    private long speltypeId;
    private long doelklankId;

    public Spel() {}

    public Spel(long id, long gebruikerId, long speltypeId, long doelklankId) {
        this.id = id;
        this.gebruikerId = gebruikerId;
        this.speltypeId = speltypeId;
        this.doelklankId = doelklankId;
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

    public long getDoelklankId() {
        return doelklankId;
    }

    public void setDoelklankId(long doelklankId) {
        this.doelklankId = doelklankId;
    }
}
