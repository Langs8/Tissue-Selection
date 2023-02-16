package src;

import javafx.collections.ObservableList;

import java.util.Comparator;

public class Tissue {
    private static ObservableList<Tissue> selections;

    private static Comparator<Tissue> comparator = Comparator.comparingDouble(t -> t.getCostPerUnit());

    public static void sort(){
        selections.sort(comparator);
    }

    public static ObservableList<Tissue> getList(){
        sort();
        return selections;
    }

    public static void setList(ObservableList<Tissue> list){
        selections = list;
    }


    private String name;
    private double price;
    private int rolls, ply, sheets;
    private double width, height;
    private double costPerUnit;

    public Tissue(String name, double price, int rolls, int ply, int sheets, double width, double height) {
        this.name = name;
        this.price = price;
        this.rolls = rolls;
        this.ply = ply;
        this.sheets = sheets;
        this.width = width;
        this.height = height;

        costPerUnit = price/(width*height*sheets*ply*rolls);
    }

    public double getCostPerUnit(){
        return costPerUnit;
    }

    public String getName(){
        return name;
    }

    public int getPly(){
        return ply;
    }

    public int getRolls(){
        return rolls;
    }

    public double getPrice(){
        return price;
    }
}