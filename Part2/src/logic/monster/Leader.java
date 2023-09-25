package logic.monster;

import logic.attack.Attack;

public class Leader extends Monster{
    private int maxChargeTurns;
    private int currentChargeTurns;
    boolean isGuard;
    public Leader(String name, int hp, int def, int sp_def, Attack attack,int chargeTurns) {
        super(name, hp, def, sp_def, attack);
        setMaxChargeTurns(chargeTurns);
        setCurrentChargeTurns(0);
    }

    public int getMaxChargeTurns() {
        return maxChargeTurns;
    }

    public void setMaxChargeTurns(int maxChargeTurns) {
        this.maxChargeTurns = maxChargeTurns;
    }

    public int getCurrentChargeTurns() {
        return currentChargeTurns;
    }

    public void setCurrentChargeTurns(int currentChargeTurns) {
        this.currentChargeTurns = Math.min(Math.max(0,currentChargeTurns),getMaxChargeTurns());
    }

    public boolean isGuard() {
        return isGuard;
    }

    public void setGuard(boolean guard) {
        isGuard = guard;
    }
    public boolean isReady() {
        return getCurrentChargeTurns()>=getMaxChargeTurns();
    }
    public int takeDamage(Attack attack){
        if(isGuard) return 0;
        if(attack.isLeader()){
            int n = attack.calculateDamage(this);
            setHp(getHp()- n);
            if(getHp()==0) isDead = true;
            return n;
        }
        else{
            int n = (int) Math.ceil(attack.calculateDamage(this)*0.5);
            setHp(getHp()-n);
            if(getHp()==0) isDead = true;
            return n;
        }
    }
}
