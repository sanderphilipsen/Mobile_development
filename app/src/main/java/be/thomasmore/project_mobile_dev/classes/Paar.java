package be.thomasmore.project_mobile_dev.classes;

public class Paar {
    private long id;
    private String eerstepaar;
    private String tweedepaar;
    private long doelklankId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEerstepaar() {
        return eerstepaar;
    }

    public void setEerstepaar(String eerstepaar) {
        this.eerstepaar = eerstepaar;
    }

    public String getTweedepaar() {
        return tweedepaar;
    }

    public void setTweedepaar(String tweedepaar) {
        this.tweedepaar = tweedepaar;
    }

    public long getDoelklankId() {
        return doelklankId;
    }

    public void setDoelklankId(long doelklankId) {
        this.doelklankId = doelklankId;
    }
    @Override
    public String toString() {return eerstepaar + " - " + tweedepaar;}
    public Paar() {
    }

    public Paar(long id, String eerstepaar, String tweedepaar, long doelklankId) {
        this.id = id;
        this.eerstepaar = eerstepaar;
        this.tweedepaar = tweedepaar;
        this.doelklankId = doelklankId;
    }
}
