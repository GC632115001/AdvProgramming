package Model.Character;

import Model.DamageType;
import Model.Item.Armor;
import Model.Item.Weapon;

public class BasedCharacter {
    protected String name, imgpath;
    protected DamageType type;
    protected Integer fullHp,basedDef,basedPow,basedRes,basedSpd;
    protected Integer hp,power,defense,resistance,speed;
    protected Weapon weapon;
    protected Armor armor;
    public String getName(){
        return name;
    }
    public String getImgpath(){
        return  imgpath;
    }
    public Integer getHp(){ return hp; }
    public  Integer getFullHp(){
        return  fullHp;
    }
    public  Integer getPower(){
        return  power;
    }
    public Integer getDefense(){
        return  defense;
    }
    public  Integer getResistance(){
        return  resistance;
    }
    public  Integer getSpeed(){
        return  speed;
    }
    public DamageType getType(){return  type;}

    public void equipWeapon(Weapon weapon){
        this.weapon =weapon;
        this.power = this.basedPow+weapon.getPower();
    }
    public void equipArmor(Armor armor){
        this.armor=armor;
        this.defense = this.basedDef+armor.getDefense();
        this.resistance = this.basedRes+armor.getResistance();
    }
    @Override
    public  String toString(){
        return  name;
    }
}

