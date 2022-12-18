package LocationDesign;

import GameDesign.Player;
import MonsterDesign.Monster;
import WeaponDesign.Armor;
import WeaponDesign.Weapon;

import java.util.Random;
import java.util.Scanner;

public abstract class BattleLoc extends Location{

    private Monster monster;
    private String reward;
    private int maxMonster;

    Scanner chosee = new Scanner(System.in);
    public BattleLoc(Player player, String name,Monster monster,String reward,int maxMonster) {
        super(player, name);
        this.monster=monster;
        this.reward=reward;
        this.maxMonster=maxMonster;

    }

    public boolean onLocation(){
        int monsterNumber = this.randomMonster();
        System.out.println("Dikkat et burada "+monsterNumber+" tane "+this.monster.getName()+" bekliyor...");
        System.out.print("Savaş(S) ya da Kaç(K) seçimini yap!!!");
        String selectCase = chosee.nextLine().toUpperCase();
        if(selectCase.equals("S")){
            System.out.println("Savaş başlasın...");
            if(combat(monsterNumber)){
                System.out.println(this.getName()+ " tüm düşmanları katlettin !!!");
                System.out.println("Ödül kazandınız : "+this.getReward());
                takeAward(getReward());
            }

            if(this.getPlayer().getHealthy()<=0){
                System.out.println("Öldünüz !!!");
                return  false;
            }

        }

        return true;
    }


    public boolean combat(int maxMonster){
        for(int i =1;i<=maxMonster;i++){
            this.getMonster().setHealthy(this.getMonster().getResetHealthy());
            playerStats();
            monsterStats(i);
            int firstBlood = firstHit();
            while (this.getPlayer().getHealthy()>0 && this.getMonster().getHealthy()>0){
                System.out.println("Savaş(S) ya da Kaç(K) ");
                String selectAction = chosee.nextLine().toUpperCase();

                if(selectAction.equals("S")){
                    if(firstBlood==1){
                        System.out.println("Siz vurdunuz...");
                        this.getMonster().setHealthy(this.getMonster().getHealthy()-this.getPlayer().getDamage());
                        if (this.getMonster().getHealthy()<0){
                            this.getMonster().setHealthy(0);
                        }
                        afterHit();

                        if(this.getMonster().getHealthy()>0){
                            System.out.println("");
                            System.out.println("Canavar size vurdu...");
                            int monsterHit =this.getMonster().getDamage()-this.getPlayer().getDefense();
                            if(monsterHit<0){
                                monsterHit =0;
                            }
                            this.getPlayer().setHealthy(this.getPlayer().getHealthy()-monsterHit);
                            afterHit();
                        }
                    }
                    else{
                        if(this.getMonster().getHealthy()>0){
                            System.out.println("");
                            System.out.println("Canavar size vurdu...");
                            int monsterHit =this.getMonster().getDamage()-this.getPlayer().getDefense();
                            if(monsterHit<0){
                                monsterHit =0;
                            }
                            this.getPlayer().setHealthy(this.getPlayer().getHealthy()-monsterHit);
                            afterHit();
                        }

                        System.out.println("Siz vurdunuz...");
                        this.getMonster().setHealthy(this.getMonster().getHealthy()-this.getPlayer().getDamage());
                        if (this.getMonster().getHealthy()<0){
                            this.getMonster().setHealthy(0);
                        }
                        afterHit();

                    }

                }
                else{
                    return false;
                }
            }
            if(this.getMonster().getHealthy()<this.getPlayer().getHealthy()){
                System.out.println("Düşmanı katlettiniz...");
                if(monster.getName().equals("Snake")){
                    chanceAward();
                }
                else{
                    System.out.println(this.getMonster().getMoney()+ " para kazandınız...");
                    this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getMonster().getMoney());
                }
                System.out.println("Güncel paranız : "+this.getPlayer().getMoney());
            }
            else {
                return false;
            }
        }
        return true;
    }

    public int firstHit(){
        Random punch = new Random();
        return punch.nextInt(2);
    }

    public void takeAward(String award){
        switch (award){
            case "wood":
                this.getPlayer().getInventory().setWood(true);
                break;
            case "food":
                this.getPlayer().getInventory().setFood(true);
                break;
            case "water":
                this.getPlayer().getInventory().setWater(true);
                break;
            case "poison":
                this.getPlayer().getInventory().setPoison(true);
                break;
        }
    }

    public void chanceAward(){
        Random snakeChance = new Random();
        int chance =snakeChance.nextInt(100)+1;

        if(chance>45){
            if(chance>=45 &&chance<48){
                System.out.println("Bıçak kazandınız...");
                getPlayer().getInventory().setWeaponDamage(Weapon.getWeaponById(1).getDamage());
            }
            if(chance>=48 &&chance<53){
                System.out.println("Kılıç kazandınız...");
                getPlayer().getInventory().setWeaponDamage(Weapon.getWeaponById(2).getDamage());
            }
            if(chance>=53 &&chance<60){
                System.out.println("Tüfek kazandınız...");
                getPlayer().getInventory().setWeaponDamage(Weapon.getWeaponById(3).getDamage());
            }
            if(chance>=60 &&chance<63){
                System.out.println("Hafif Zırh kazandınız...");
                getPlayer().getInventory().setArmorDefense(Armor.getArmorById(1).getDefense());
            }
            if(chance>=63 &&chance<68){
                System.out.println("Orta Zırh kazandınız...");
                getPlayer().getInventory().setArmorDefense(Armor.getArmorById(2).getDefense());
            }
            if(chance>=68 &&chance<75){
                System.out.println("Ağır Zırh kazandınız...");
                getPlayer().getInventory().setArmorDefense(Armor.getArmorById(3).getDefense());
            }
            if(chance>=75 &&chance<80){
                System.out.println("10 para kazandınız...");
                getPlayer().setMoney(getPlayer().getMoney()+10);
            }
            if(chance>=80 &&chance<88){
                System.out.println("5 para kazandınız...");
                getPlayer().setMoney(getPlayer().getMoney()+10);
            }
            if(chance>=88 &&chance<100){
                System.out.println("1 para kazandınız...");
                getPlayer().setMoney(getPlayer().getMoney()+10);
            }

        }
        else {
            System.out.println("Kazanç sağlanamadı...");
        }
    }
    public void afterHit(){
        System.out.println("Canın : "+ this.getPlayer().getHealthy());
        System.out.println(this.getMonster().getName()+" Canı : "+this.getMonster().getHealthy());
        System.out.println("");
    }

    public void playerStats(){
        System.out.println("Oyuncu Değerleri");
        System.out.println("----------------");
        System.out.println("Hasar :"+this.getPlayer().getDamage());
        System.out.println("Sağlık :"+this.getPlayer().getHealthy());
        System.out.println("Para :"+this.getPlayer().getMoney());
        System.out.println("Defans :"+this.getPlayer().getDefense());
        System.out.println("Silah :"+this.getPlayer().getInventory().getWeaponName());
        System.out.println("Zırh :"+this.getPlayer().getInventory().getArmorName());

    }

    public void monsterStats(int i){
        System.out.println(i+". "+ this.monster.getName()+" Değerleri");
        System.out.println("----------------");
        System.out.println("Hasar :"+this.getMonster().getDamage());
        System.out.println("Sağlık :"+this.getMonster().getHealthy());
        System.out.println("Para :"+this.getMonster().getMoney());
    }

    public int randomMonster(){
        Random r = new Random();
        return r.nextInt(this.maxMonster)+1;
    }



    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }
}
