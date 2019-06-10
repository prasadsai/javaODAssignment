import java.util.*;
public class Main {

    public static void main(String[] args)
    {
        try{
            Scanner input = new Scanner(System.in);
            char ch;
            do{
                item.item_details();
                System.out.println("Do you want to enter details of any other item (y/n)");
                ch =input.next().charAt(0);
            }while(ch == 'y');
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
class item {
    public static void item_details() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the required details");
        System.out.println("Enter the item name");
        String item_name = input.next();
        System.out.println("Enter the prize of the item");
        float item_prize = Float.parseFloat(input.next());
        System.out.println("Enter the quantity of the item");
        int item_quantity = Integer.parseInt(input.next());
        System.out.println("enter the type of the item(raw/manufactured/imported)");
        String item_type = input.next();

        float sales_tax = 0;
        if (item_type.equalsIgnoreCase("raw")) {
            sales_tax = item_prize * 0.125f;
        } else if (item_type.equalsIgnoreCase("manufactured")) {
            sales_tax = item_prize * 0.125f + 0.02f * (item_prize + item_prize * 0.125f);
        } else if (item_type.equalsIgnoreCase("imported")) {
            sales_tax = item_prize * 0.1f;
            if ((sales_tax + item_prize) <= 100) {
                sales_tax = sales_tax + 5f;
            } else if ((sales_tax + item_prize) > 100 && (sales_tax + item_prize) <= 200) {
                sales_tax = sales_tax + 10f;
            } else if ((sales_tax + item_prize) > 200) {
                sales_tax = sales_tax + (sales_tax + item_prize) * 0.05f;
            }
        }
        float final_cost = sales_tax + item_prize;
        System.out.println(item_name);
        System.out.println(item_prize);
        System.out.println(item_quantity);
        System.out.println(sales_tax);
        System.out.println(final_cost);
        System.out.println(item_type);
    }
}