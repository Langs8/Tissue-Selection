package src;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Table {

    private TableView<Tissue> table = new TableView<>();
    TableColumn<Tissue,String> colName = new TableColumn<>("Name");
    TableColumn<Tissue,Integer> colPly = new TableColumn<>("Ply");
    TableColumn<Tissue,Integer> colRolls = new TableColumn<>("Rolls");
    TableColumn<Tissue,Double> colPrice = new TableColumn("Price");

    public Table(){
        colName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        colPly.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getPly()).asObject());
        colRolls.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getRolls()).asObject());
        colPrice.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrice()).asObject());

        colName.setResizable(false);
        colPly.setResizable(false);
        colRolls.setResizable(false);
        colPrice.setResizable(false);

        colName.prefWidthProperty().bind(table.widthProperty().multiply(0.46));
        colPly.prefWidthProperty().bind(table.widthProperty().multiply(0.18));
        colRolls.prefWidthProperty().bind(table.widthProperty().multiply(0.18));
        colPrice.prefWidthProperty().bind(table.widthProperty().multiply(0.18));

        table.getColumns().addAll(colName,colPly,colRolls,colPrice);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    public TableView<Tissue> getTable(){
        return table;
    }
}
