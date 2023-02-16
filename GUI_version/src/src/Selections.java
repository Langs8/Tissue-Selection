package src;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.util.Optional;

public class Selections extends VBox{

    private Label title = new Label("Selections");
    private TableView<Tissue> table = new Table().getTable();
    private Button clear = new Button("Clear all");
    private Button delete = new Button("Delete");
    private Button add = new Button("Add");

    public Selections(){
        createView();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setGraphic(null);
        alert.setContentText("The table has an order of having the selection with best value for money at the top.\n");
        alert.showAndWait();
    }

    private void createView() {
        setProperties();

        Separator sepTop = new Separator();
        sepTop.setPadding(new Insets(0,0,15,0));

        Separator sepBottom = new Separator();
        sepBottom.setPadding(new Insets(15,0,8,0));

        HBox bottomRight = new HBox();
        HBox.setHgrow(bottomRight,Priority.ALWAYS);
        bottomRight.setAlignment(Pos.BOTTOM_RIGHT);
        bottomRight.getChildren().addAll(delete,add);
        bottomRight.setSpacing(9);

        HBox buttons = new HBox();
        buttons.setAlignment(Pos.BOTTOM_LEFT);
        buttons.getChildren().addAll(clear, bottomRight);

        VBox box = new VBox();
        box.getChildren().addAll(title, sepTop, table, sepBottom, buttons);
        VBox.setMargin(box, new Insets(15,20,10,20));

        this.getChildren().add(box);
    }

    private void setProperties(){
        title.setFont(Font.font(30));
        clear.setFont(Font.font(13));
        delete.setFont(Font.font(13));
        add.setFont(Font.font(13));

        clear.setOnAction(this::clearSelections);
        delete.setOnAction(this::delete);
        add.setOnAction(this::addSelection);
    }

    private void clearSelections(ActionEvent evt){
        if(!table.getItems().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Clear selections");
            alert.setHeaderText(null);
            alert.setContentText("You are about to delete all entries.\nPress \"OK\" to proceed or \"Cancel\" to return.");

            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK){
                table.getItems().clear();
                Tissue.setList(table.getItems());
            }
        }
    }

    private void delete(ActionEvent evt){
        int selected = table.getSelectionModel().getSelectedIndex();

        if(!table.getSelectionModel().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete selection");
            alert.setHeaderText(null);
            alert.setContentText("You are about to delete an entry.\nPress \"OK\" to proceed or \"Cancel\" to return.");

            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK){
                table.getItems().remove(selected);
                Tissue.setList(table.getItems());
            }
        }
    }

    private void addSelection(ActionEvent evt){
        AddSelection dialog = new AddSelection();
        Optional<Tissue> value = dialog.showAndWait();

        ObservableList<Tissue> selections = table.getItems();
        value.ifPresent(o -> selections.add(o));
        Tissue.setList(selections);
        table.setItems(Tissue.getList());
    }
}
