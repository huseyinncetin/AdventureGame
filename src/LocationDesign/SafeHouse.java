package LocationDesign;

import GameDesign.*;

public class SafeHouse extends NormalLoc {
    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    public boolean onLocation() {

        System.out.println("Güvenli Evdesiniz!!!");
        System.out.println("Canınız yenilendi...");
        this.getPlayer().setHealthy(this.getPlayer().getFullHp());

        return true;
    }



}