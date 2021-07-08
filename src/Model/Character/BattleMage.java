package Model.Character;

import Model.DamageType;

public class BattleMage extends BasedCharacter{
    public BattleMage(String name, String imgpath, int basedDef, int basedRes, int baseSpd) {
        this.name=name;
        this.type= DamageType.magical;
        this.imgpath=imgpath;
        this.fullHp= 40;
        this.basedPow= 40;
        this.basedDef=basedDef;
        this.basedRes=basedRes;
        this.basedSpd=baseSpd;
        this.hp=this.fullHp;
        this.power=this.basedPow;
        this.defense=basedDef;
        this.resistance=basedRes;
        this.speed=baseSpd;
    }
}
