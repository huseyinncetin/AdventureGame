package LocationDesign;

import GameDesign.Player;
import MonsterDesign.Vampire;

public class Forest extends BattleLoc{
    public Forest(Player player) {
        super(player,"Orman",new Vampire(),"wood",3);
    }

}
