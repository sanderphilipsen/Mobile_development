package be.thomasmore.project_mobile_dev;

public class Doelklank {
    private long id;
    private String doelklank;
    private long klankId;
    private long stoornisId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDoelklank() {
        return doelklank;
    }

    public void setDoelklank(String doelklank) {
        this.doelklank = doelklank;
    }

    public long getKlankId() {
        return klankId;
    }

    public void setKlankId(long klankId) {
        this.klankId = klankId;
    }

    public long getStoornisId() {
        return stoornisId;
    }

    public void setStoornisId(long stoornisId) {
        this.stoornisId = stoornisId;
    }

    public Doelklank() {
    }
    @Override
    public String toString() {return doelklank;}

    public Doelklank(long id, String doelklank, long klankId, long stoornisId) {
        this.id = id;
        this.doelklank = doelklank;
        this.klankId = klankId;
        this.stoornisId = stoornisId;
    }
}
