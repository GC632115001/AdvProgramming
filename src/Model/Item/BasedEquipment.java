package Model.Item;

import javafx.scene.input.DataFormat;

import java.io.Serial;
import java.io.Serializable;

public class BasedEquipment implements Serializable {
    public static final DataFormat DATA_FORMAT = new DataFormat("src.model.Item.BasedEquipment");
    protected  String name;
    protected  String imgpath;
    public String getName(){
        return  name;
    }
    public  String getImgepath(){
        return imgpath;
    }
    public void setImgpath (String imgpath){
        this.imgpath=imgpath;
    }
}
