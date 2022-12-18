package WeaponDesign;

public class Armor {
    private String name;
    private int id;
    private int defense;
    private int price;
    public Armor(String name, int id, int defense, int price) {
        this.name = name;
        this.id = id;
        this.defense = defense;
        this.price = price;
    }

    public static Armor[] armors(){
        Armor[] armorList = new Armor [3];
        armorList[0] = new Armor("Hafif",1,1,2);
        armorList[1] = new Armor("Orta",2,3,35);
        armorList[2] = new Armor("Ağır",3,5,45);

        return armorList;
    }

    public static Armor getArmorById(int id){
        for (Armor a:Armor.armors()) {
            if(a.getId() == id){
                return  a;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
