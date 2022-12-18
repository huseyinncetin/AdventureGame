package LocationDesign;

import GameDesign.Player;
import MonsterDesign.Zombi;

public class Cave extends BattleLoc{
    public Cave(Player player) {
        super(player,"Mağara",new Zombi(),"food",3);
    }
}
