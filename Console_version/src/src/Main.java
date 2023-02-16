package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int flag = 1;
        Scanner inp = new Scanner(System.in);

        while(flag==1){
            System.out.println(createNew());

            List<String> condition = new ArrayList<>(Arrays.asList("0","1"));
            String temp;
            do {
                System.out.println("Do you have another selection? YES 1 , NO 0");
                temp = inp.nextLine();
            } while (!condition.contains(temp));

            flag = Integer.parseInt(temp);
        }

        Tissue best = Tissue.getBest();
        System.out.println("\n\"" + best.getTag() + "\" has the lowest cost per unit, " + best.getCostPerUnit() + ".\n");
        System.out.println("Press ENTER to terminate ...");
        inp.nextLine();
    }
    private static Tissue createNew(){
        List<String> list1 = inputProperties("\nEnter selection name and price, in this order separating by spaces: ", 2);
        List<String> list2 = inputProperties("Enter number of rolls, ply and sheets, in this order separating by spaces: ", 3);
        List<String> list3 = inputProperties("Enter sheet width and height, in this order separating by spaces: ", 2);

        return new Tissue(list1.get(0), Double.parseDouble(list1.get(1)), Integer.parseInt(list2.get(0)), Integer.parseInt(list2.get(1)),
                Integer.parseInt(list2.get(2)), Double.parseDouble(list3.get(0)), Double.parseDouble(list3.get(1)));
    }
    private static List<String> inputProperties(String outputStr, int elements){
        List<String> list;
        Scanner input = new Scanner(System.in);
        String inputStr;
        do {
            System.out.println(outputStr);
            inputStr = input.nextLine();
            list = Arrays.asList(inputStr.split(" "));
        } while (elements != list.size());

        return list;
    }
}