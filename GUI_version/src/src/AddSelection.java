package src;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class AddSelection extends Dialog<Tissue> {

    private GridPane gp = new GridPane();
    private TextField name = new TextField(), price = new TextField(), rolls = new TextField(), sheets = new TextField(), height = new TextField(), width = new TextField();
    private ChoiceBox<Integer> ply = new ChoiceBox<>();
    private ButtonType add = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);

    public AddSelection(){
        DialogPane dp = getDialogPane();
        setTitle("Add selection");
        dp.setContent(createForm());
        setResultConverter(this::formResult);
        dp.getButtonTypes().addAll(ButtonType.CANCEL,add);
    }

    private Tissue formResult(ButtonType bt){
        if(bt.getButtonData() == ButtonBar.ButtonData.OK_DONE){
            double priceTemp = Double.parseDouble(price.getText());
            int rollsTemp = Integer.parseInt(rolls.getText());
            int sheetsTemp = Integer.parseInt(sheets.getText());
            double widthTemp = Double.parseDouble(width.getText());
            double heightTemp = Double.parseDouble(height.getText());

            return new Tissue(name.getText(), priceTemp, rollsTemp, ply.getValue(), sheetsTemp, widthTemp, heightTemp);
        }
        return null;
    }

    private VBox createForm(){

        setTag("Name", name, 0);
        setTag("Price", price, 1);
        setTag("Rolls", rolls, 2);

        gp.add(new Label("Ply"), 0, 3);
        ply.getItems().addAll(1,2,3);
        gp.add(ply, 1, 3);

        setTag("Sheets", sheets, 4);
        setTag("Height (mm)", height, 5);
        setTag("Width (mm)", width, 6);

        gp.setVgap(8);
        gp.setHgap(15);
        VBox box = new VBox(gp);
        box.setPadding(new Insets(20,20,15,20));

        return box;
    }

    private void setTag(String name, TextField field, int order){
        gp.add(new Label(name), 0, order);
        gp.add(field, 1, order);
    }
}
