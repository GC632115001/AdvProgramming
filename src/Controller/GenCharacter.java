package Controller;

import Model.Character.BasedCharacter;
import Model.Character.BattleMage;
import Model.Character.MagicalCharacter;
import Model.Character.PhysicalCharacter;

import java.util.Random;

public class GenCharacter {
    public static BasedCharacter setUpCharacter() {
        BasedCharacter character;
        Random rand = new Random();
        int type = rand.nextInt(3) + 1;
        int basedDef = rand.nextInt(50) + 1;
        int basedRes = rand.nextInt(50) + 1;
        int basedSpd = rand.nextInt(50) + 1;
        if (type == 1) {
            character = new MagicalCharacter("MagicChar1", "assets/wizard.png", basedDef, basedRes, basedSpd);
        } else if (type==2) {
            character = new PhysicalCharacter("PhysicalChar1", "assets/knight.png", basedDef, basedRes, basedSpd);
        }else{
            character = new BattleMage("Battlemage1","assets/blank.png", basedDef, basedRes, basedSpd);
        }
        return character;
    }

}
