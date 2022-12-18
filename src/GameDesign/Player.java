package GameDesign;

import AvatarDesign.*;
import java.util.Scanner;

public class Player {

    private  Inventory inventory;
    private int defense;
    private int damage;
    private int healthy;
    private int money;
    private String charName;
    private String name;

    private int fullHp;

    private final Scanner  input = new Scanner(System.in);
    public void selectChar(){
        Sovalye sovalye = new Sovalye();
        Okcu okcu = new Okcu();
        Samuray samuray = new Samuray();
        System.out.println("--------KARAKTERLER--------");
        System.out.println(samuray.getID()+".Karakter : "+ samuray.getName()+"\t Hasar : "+samuray.getDamage()+"\t Sağlık : "+samuray.getHealthy()+ "\t Para : "+samuray.getMoney() );
        System.out.println(okcu.getID()+".Karakter : "+ okcu.getName()+"\t\t Hasar : "+okcu.getDamage()+"\t Sağlık : "+okcu.getHealthy()+ "\t Para : "+okcu.getMoney() );
        System.out.println(sovalye.getID()+".Karakter : "+ sovalye.getName()+"\t Hasar : "+sovalye.getDamage()+"\t Sağlık : "+sovalye.getHealthy()+ "\t Para : "+sovalye.getMoney() );
        System.out.println("---------------------------");
        System.out.print("Lütfen karakterinizi seçiniz:");
        int selectChar =input.nextInt();
        while (selectChar<1 || selectChar>3){
            System.out.print("Geçersiz seçim karakter seçiniz:");
            selectChar =input.nextInt();
        }


        switch (selectChar) {
            case 1 -> initPlayer(new Samuray());
            case 2 -> initPlayer(new Okcu());
            case 3 -> initPlayer(new Sovalye());
        }
        System.out.println("Karakter: "+this.getCharName()
                          +"\tHasar: "+this.getDamage()
                          +"\tSağlık: "+this.getHealthy()
                          +"\tPara: "+getMoney());
    }
    public void initPlayer(Avatar avatar){
        this.setDamage(avatar.getDamage());
        this.setHealthy(avatar.getHealthy());
        this.setMoney(avatar.getMoney());
        this.setCharName(avatar.getName());
        this.setFullHp(avatar.getHealthy());
    }

    public void printInfo(){
        System.out.println("Hasarınız : "+ getDamage()+" Defansınız : "+getDefense()+ " Sağlığınız : "+getHealthy()+" Paranız : "+getMoney());
    }

    public Player(String name) {
        this.name = name;
        this.inventory=new Inventory(this,false,false,false,"yok","yok",0,0,false);
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getDefense() {
        return defense + this.getInventory().getArmorDefense();
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getFullHp() {
        return fullHp;
    }

    public void setFullHp(int fullHp) {
        this.fullHp = fullHp;
    }
}
