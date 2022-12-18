package GameDesign;


public class Inventory {
    private Player player;
    private boolean water;
    private boolean food;

    private boolean poison;

    private boolean wood;
    private String weaponName;
    private String armorName;
    private int weaponDamage;
    private int armorDefense;

    public Inventory(Player player,boolean water, boolean food,boolean wood,String weaponName, String armorName, int weaponDamage, int armorDefense,boolean poison) {
        this.player =player;
        this.water = water;
        this.food = food;
        this.wood = wood;
        this.weaponName = weaponName;
        this.armorName = armorName;
        this.weaponDamage = weaponDamage;
        this.armorDefense = armorDefense;
        this.poison=poison;
    }

    public boolean isWater() {
        return water;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isWood() {
        return wood;
    }

    public boolean isPoison() {
        return poison;
    }

    public void setPoison(boolean poison) {
        this.poison = poison;
    }

    public void setWood(boolean wood) {
        this.wood = wood;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public int getArmorDefense() {
        return armorDefense;
    }

    public void setArmorDefense(int armorDefense) {
        this.armorDefense = armorDefense;
    }
}
