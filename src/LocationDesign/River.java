package LocationDesign;

import GameDesign.Player;
import MonsterDesign.Bear;

public class River extends BattleLoc{
    public River(Player player) {
        super(player,"Nehir",new Bear(),"water",3);
    }

}
