package src;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Tissue {
    private static List<Tissue> selections = new ArrayList<>();

    private static Comparator<Tissue> comparator = Comparator.comparingDouble(t -> t.getCostPerUnit());
    public static void sort(){
        selections.sort(comparator);
    }

    public static Tissue getBest(){
        sort();
        return selections.get(0);
    }

    private String name;
    private double price;
    private int rolls, ply, sheets;
    private double width, height;

    private double costPerUnit;

    private String tag;

    public Tissue(String name, double price, int rolls, int ply, int sheets, double width, double height) {
        this.name = name;
        this.price = price;
        this.rolls = rolls;
        this.ply = ply;
        this.sheets = sheets;
        this.width = width;
        this.height = height;

        costPerUnit = price/(width*height*sheets*ply*rolls);

        selections.add(this);
    }

    public String getName(){
        return name;
    }

    public double getCostPerUnit(){
        return costPerUnit;
    }

    public String getTag(){
        return tag;
    }

    public String toString(){
        tag = name + " " + ply + "-ply, " + rolls + " rolls";

        String str1 = "Selection " + (selections.indexOf(this)+1) + ": " + tag;
        String str2 = "Price: " + price;
        String str3 = sheets + " sheets, " + width + "mm x " + height + "mm";

        int multiplier = Math.max(str1.length(), Math.max(str2.length(),str3.length()));

        String dash = "-".repeat(multiplier+1);

        return dash + "\n" + str1 + "\n" + str2 + "\n" + str3 + "\n" + dash;
    }
}