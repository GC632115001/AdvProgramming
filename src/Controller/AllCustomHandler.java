package Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.StackPane;
import Model.Character.BasedCharacter;
import Model.Item.Armor;
import Model.Item.BasedEquipment;
import Model.Item.Weapon;

import java.util.ArrayList;

public class AllCustomHandler {
    public static class  GenHeroHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Launcher.setMainCharacter(GenCharacter.setUpCharacter());

            Launcher.refreshPane();
        }
    }
    public static void onDragDetected(MouseEvent event, BasedEquipment equipment, ImageView imageView) {
        Dragboard db = imageView.startDragAndDrop(TransferMode.ANY);
        db.setDragView(imageView.getImage());
        ClipboardContent content = new ClipboardContent();
        content.put(equipment.DATA_FORMAT, equipment);
        db.setContent(content);
        event.consume();
    }

    public static void onDragOver(DragEvent event, String type) {
        Dragboard dragboard = event.getDragboard();


        BasedEquipment retrievedEquipment = (BasedEquipment) dragboard.getContent(BasedEquipment.DATA_FORMAT);
        if (dragboard.hasContent(BasedEquipment.DATA_FORMAT) && retrievedEquipment.getClass().getSimpleName().equals(type));
        event.acceptTransferModes(TransferMode.MOVE);
    }

    public static void onDragDropped(DragEvent event, Label lbl, StackPane imgGroup) {
        boolean dragCompleted = false;
        Dragboard dragboard = event.getDragboard();

        ArrayList<BasedEquipment> allEquipmets = Launcher.getAllEquipments();

        if (dragboard.hasContent(BasedEquipment.DATA_FORMAT)) {
            BasedEquipment retrievedEquipment = (BasedEquipment) dragboard.getContent(BasedEquipment.DATA_FORMAT);

            BasedCharacter character = Launcher.getMainCharacter();

            if (retrievedEquipment.getClass().getSimpleName().equals("Weapon")) {

                if(Launcher.getEquippedWeapon()!=null)
                    allEquipmets.add(Launcher.getEquippedWeapon());
                Launcher.setEquippedWeapon((Weapon)retrievedEquipment);

                character.equipWeapon((Weapon) retrievedEquipment);

            } else {
                if(Launcher.getEquippedArmor()!=null)
                    allEquipmets.add(Launcher.getEquippedArmor());
                Launcher.setEquippedArmor((Armor)retrievedEquipment);

                character.equipArmor((Armor) retrievedEquipment);

            }
            Launcher.setMainCharacter(character);

            Launcher.setAllEquipment(allEquipmets);

            Launcher.refreshPane();

            ImageView imgView = new ImageView();
            if (imgGroup.getChildren().size() != 1) {
                imgGroup.getChildren().remove(1);
                Launcher.refreshPane();
            }
            lbl.setText(retrievedEquipment.getClass().getSimpleName() + ":\n" + retrievedEquipment.getName());
            imgView.setImage(new Image(AllCustomHandler.class.getClassLoader().getResource(retrievedEquipment.getImgepath()).toString()));
            imgGroup.getChildren().add(imgView);
            dragCompleted = true;
        }
        event.setDropCompleted(dragCompleted);
    }

    public static void onEquipDone(DragEvent event) {
        Dragboard dragboard = event.getDragboard();
        ArrayList<BasedEquipment> allEquipments = Launcher.getAllEquipments();
        BasedEquipment retrivedEquipment = (BasedEquipment) dragboard.getContent(BasedEquipment.DATA_FORMAT);

        int pos = -1;
        for(int i=0;i<allEquipments.size();i++){
            if(allEquipments.get(i).getName().equals(retrivedEquipment.getName())){
                pos=i;
            }
        }
        if(pos!=-1){
            allEquipments.remove(pos);
        }
        Launcher.setAllEquipment(allEquipments);
        Launcher.refreshPane();
    }
}
