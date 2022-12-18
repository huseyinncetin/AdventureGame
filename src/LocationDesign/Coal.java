package LocationDesign;

import GameDesign.Player;
import MonsterDesign.*;

public class Coal extends BattleLoc{
    public Coal(Player player) {
        super(player,"Maden",new Snake(),"poison",3);
    }
}
