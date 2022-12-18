package LocationDesign;

import GameDesign.*;
import WeaponDesign.*;

public class ToolStore extends NormalLoc{
    private Inventory inventory;
    public ToolStore(Player player) {
        super(player,"Mağaza");

    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya hoşgeldiniz...");
        boolean key = true;
        while(key){
            System.out.println("1-Siahlar");
            System.out.println("2-Zırhlar");
            System.out.println("0-Çıkış yap");

            int selectCase = input.nextInt();

            while(selectCase<0 || selectCase>2){
                System.out.print("Geçersiz değer girdiniz.Tekrar bir değer giriniz:");
                selectCase = input.nextInt();
            }

            switch (selectCase){
                case 1:
                    printWeapon();
                    break;
                case 2:
                    printArmor();
                    break;
                case 0:
                    System.out.println("Tekrar bekleriz...");
                    key =false;
                    return true;
            }
        }

        return true;
    }
    private void printWeapon(){
        System.out.println("-------------SİLAHLAR-------------");
        for (Weapon w:Weapon.weapons()){
            System.out.println(w.getId()+"-"+w.getName()+ "     Para : " + w.getPrice()+ "      Hasar : "+w.getDamage());
        }
        System.out.println("0-Çıkış yap");
        System.out.print("Bir silah seçiniz : ");
        int selectWeapon = input.nextInt();

        if(selectWeapon !=0){
            while(selectWeapon<0 || selectWeapon>Weapon.weapons().length){
                System.out.print("Geçersiz değer girdiniz.Tekrar bir değer giriniz:");
                selectWeapon = input.nextInt();
            }

            if(Weapon.getWeaponById(selectWeapon).getPrice()>getPlayer().getMoney()){
                System.out.println("!!!Bakiyeniz yetersiz!!!");
            }
            else{
                System.out.println(Weapon.getWeaponById(selectWeapon).getName()+" ürününü satın alma başarılı!!!");
                int trade = getPlayer().getMoney()-Weapon.getWeaponById(selectWeapon).getPrice();
                getPlayer().setMoney(trade);
                System.out.println("Kalan paranız :"+ getPlayer().getMoney());
                this.getPlayer().getInventory().setWeaponName(Weapon.getWeaponById(selectWeapon).getName());
                this.getPlayer().getInventory().setWeaponDamage(Weapon.getWeaponById(selectWeapon).getDamage());
                this.getPlayer().setDamage(getPlayer().getDamage() + Weapon.getWeaponById(selectWeapon).getDamage());
            }
        }

    }

    private void printArmor(){
        System.out.println("-------------ZIRHLAR-------------");
        for (Armor a:Armor.armors()){
            System.out.println(a.getId()+"-"+a.getName()+ "\tPara : " + a.getPrice()+ "\tDefans : "+a.getDefense());
        }
        System.out.println("0-Çıkış yap");
        System.out.print("Bir zırh seçiniz : ");
        int selectArmor = input.nextInt();
        if(selectArmor !=0) {
            while (selectArmor < 0 || selectArmor > Armor.armors().length) {
                System.out.print("Geçersiz değer girdiniz.Tekrar bir değer giriniz:");
                selectArmor = input.nextInt();
            }

            if (Armor.getArmorById(selectArmor).getPrice() > this.getPlayer().getMoney()) {
                System.out.println("!!!Bakiyeniz yetersiz!!!");
            } else {
                System.out.println("satın alma başarılı!!!");
                int trade = this.getPlayer().getMoney() - Armor.getArmorById(selectArmor).getPrice();
                this.getPlayer().setMoney(trade);
                System.out.println("Kalan paranız :" + getPlayer().getMoney());
                this.getPlayer().getInventory().setArmorName(Armor.getArmorById(selectArmor).getName());
                this.getPlayer().getInventory().setWeaponDamage(Armor.getArmorById(selectArmor).getDefense());
                this.getPlayer().setDefense(Armor.getArmorById(selectArmor).getDefense());
            }
        }
    }

}
