package AvatarDesign;

public abstract class Avatar {
    private int healthy;
    private int damage;
    private int money ;
    private String charName;

    private int ID;

    public Avatar(int healthy, int damage, int money,String charName,int ID) {
        this.healthy = healthy;
        this.damage = damage;
        this.money = money;
        this.charName = charName;
        this.ID = ID;

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return charName;
    }

    public void setName(String name) {
        this.charName = charName;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
