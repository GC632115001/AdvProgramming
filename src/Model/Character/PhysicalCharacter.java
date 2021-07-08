package Model.Character;

import Model.DamageType;

public class PhysicalCharacter extends BasedCharacter {
    public PhysicalCharacter(String name,String imgpath,int baseDef, int baseRes, int baseSpd){
        this.name=name;
        this.type= DamageType.physical;
        this.imgpath=imgpath;
        this.fullHp= 50;
        this.basedPow= 30;
        this.basedDef=baseDef;
        this.basedRes=baseRes;
        this.basedSpd=baseSpd;
        this.hp=this.fullHp;
        this.power=this.basedPow;
        this.defense=basedDef;
        this.resistance=basedRes;
        this.speed=baseSpd;
    }
}
