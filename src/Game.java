import GameDesign.*;
import LocationDesign.*;
import java.util.Scanner;

public class Game {
        private Scanner input  = new Scanner(System.in);
    void start(){
        System.out.println("Oyun Başlıyor Hazırlan!!!");
        System.out.print("Oyuncu Adı Giriniz: ");
        String playerName =input.next();
        Player player =new Player(playerName);
        System.out.println(player.getName()+ " Hoşgeldin !!!");
        player.selectChar();

        Location location = null;
        while (true){

            player.printInfo();
            System.out.println();
            System.out.println();
            System.out.println("----------BÖLGELER----------");
            System.out.println();
            System.out.println("1-Güvenli Ev ===> Canınızı yenilemek için küçük bir mola alın.");
            System.out.println("2-Mağaza ===> Ekipman satın alarak güçlenin.");
            System.out.println("3-Mağara ===> Zombileri katlet ve ödülünü kap.(Ödül:Yemek)");
            System.out.println("4-Orman ===> Vampirleri katlet ve ödülünü kap.(Ödül:Odun)");
            System.out.println("5-Nehir ===> Ayıları katlet ve ödülünü kap.(Ödül:Su)");
            System.out.println("6-Maden ===> Yılanları katlet ve ödülünü kap.(Ödül:Zehir)");
            System.out.println("0-Çıkış yap");
            System.out.print("Gitmek istediğiniz bölgeyi seçiniz:");
            int selectLocNum =input.nextInt();
            System.out.println();
            System.out.println();
            while (selectLocNum<0 || selectLocNum>6){
                System.out.print("Geçersiz bir değer girdiniz.Tekrar deneyiniz : ");
                selectLocNum =input.nextInt();
            }
            if(selectLocNum==3 && player.getInventory().isFood()){
                System.out.println("Bölge görevlerini tamamladınız.Bölge kapatıldı.");
                selectLocNum=1;
            }
            if(selectLocNum==4 && player.getInventory().isWood()){
                System.out.println("Bölge görevlerini tamamladınız.Bölge kapatıldı.");
                selectLocNum =1;
            }
            if(selectLocNum==5 && player.getInventory().isWater()){
                System.out.println("Bölge görevlerini tamamladınız.Bölge kapatıldı.");
                selectLocNum =1;
            }
            if(selectLocNum==6 && player.getInventory().isPoison()){
                System.out.println("Bölge görevlerini tamamladınız.Bölge kapatıldı.");
                selectLocNum =1;
            }
            switch (selectLocNum){
                case 0:
                    location =null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                case 6:
                    location = new Coal(player);
                    break;
            }
            if(player.getInventory().isWater()&&
               player.getInventory().isWood()&&
               player.getInventory().isFood()&&
               player.getInventory().isPoison()){
                System.out.println("================================================");
                System.out.println("==!!! TEBRİKLER TÜM BÖLÜMLERİ TAMAMLADINIZ !!!==");
                System.out.println("================================================");
                break;
            }

            if(location == null){
                System.out.println("Oyun Sonlandırıldı...");
                break;
            }
            if(!location.onLocation()){
                System.out.println("Oyun Bitti...");
                break;
            }
        }
    }
}
