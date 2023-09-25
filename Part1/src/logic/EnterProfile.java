package logic;

public class EnterProfile {
    private Person person;
    private int bodyTemperature;

    public Person getPerson() {
        return person;
    }

    public int getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(int bodyTemperature) {
        if (bodyTemperature > 42) bodyTemperature = 42;
        if (bodyTemperature < 35) bodyTemperature = 35;
        this.bodyTemperature = bodyTemperature;
    }
    public boolean hasFever(){
        return getBodyTemperature()>=37;
    }

    public EnterProfile(Person person,int bodyTemperature) {
        setBodyTemperature(bodyTemperature);
        this.person = person;
    }
}
