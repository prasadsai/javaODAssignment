//import java.util.*;
//public class Main {
//
//    public static void main(String[] args)
//    {
//        try{
//            Scanner input = new Scanner(System.in);
//            char ch;
//            do{
//                item.item_details();
//                System.out.println("Do you want to enter details of any other item (y/n)");
//                ch =input.next().charAt(0);
//            }while(ch == 'y');
//        }
//        catch (Exception e){
//            System.out.println(e);
//        }
//    }
//}
//class item {
//    public static void item_details() {
//        Scanner input = new Scanner(System.in);
//        System.out.println("Enter the required details");
//        System.out.println("Enter the item name");
//        String item_name = input.next();
//        System.out.println("Enter the prize of the item");
//        float item_prize = Float.parseFloat(input.next());
//        System.out.println("Enter the quantity of the item");
//        int item_quantity = Integer.parseInt(input.next());
//        System.out.println("enter the type of the item(raw/manufactured/imported)");
//        String item_type = input.next();
//
//        float sales_tax = 0;
//        if (item_type.equalsIgnoreCase("raw")) {
//            sales_tax = item_prize * 0.125f;
//        } else if (item_type.equalsIgnoreCase("manufactured")) {
//            sales_tax = item_prize * 0.125f + 0.02f * (item_prize + item_prize * 0.125f);
//        } else if (item_type.equalsIgnoreCase("imported")) {
//            sales_tax = item_prize * 0.1f;
//            if ((sales_tax + item_prize) <= 100) {
//                sales_tax = sales_tax + 5f;
//            } else if ((sales_tax + item_prize) > 100 && (sales_tax + item_prize) <= 200) {
//                sales_tax = sales_tax + 10f;
//            } else if ((sales_tax + item_prize) > 200) {
//                sales_tax = sales_tax + (sales_tax + item_prize) * 0.05f;
//            }
//        }
//        float total_price = sales_tax + item_prize;
//        System.out.println(item_name);
//        System.out.println(item_prize);
//        System.out.println(item_quantity);
//        System.out.println(sales_tax);
//        System.out.println(total_price);
//        System.out.println(item_type);
//    }
//}
/////////////////////////////
//package com.example.helloworld;
//import java.util.*;
//import java.io.*;
////Jcommander is the library used to parse command line args with ease
//
////following are the JCommander library's imports
//import com.beust.jcommander.Parameter;
//import com.beust.jcommander.JCommander;
//
//
//
////following is a Detail's class which has a blueprint of an item and it's assets
//
//class Details{
//    String name,type;
//    double price;
//    int quantity;
//    double Total_price;
//    Details(String name,int quantity,double price,String type,double Total_price){
//        this.name = name;
//        this.quantity = quantity;
//        this.price = price;
//        this.type = type;
//        this.Total_price = Total_price;
//    }
//}
//
////following are the classes for throwing custom exception : )
//
//class User_Choice_1 extends Exception{
//    User_Choice_1(String s){
//        super(s);
//    }
//}
//
//class User_choice_rem extends Exception{
//    User_choice_rem(String s){
//        super(s);
//    }
//}
//
//class type_chice extends Exception{
//    type_chice(String s){
//        super(s);
//    }
//}
//
//
//
//class Assaignment1 {
//
//    //Below code will allow user to enter the details from commandline
//    //the @Parameter is the annotation from 'jcommander'library
//
//    @Parameter(names={"-name"})
//    String Name;
//    @Parameter(names={"-price"})
//    double price;
//    @Parameter(names={"-quantity"})
//    int quantity;
//    @Parameter(names={"-type"},required = true)
//    String type;
//
//    public static void main(String[] args) throws IOException{
//        Assaignment1 main = new Assaignment1();
//        JCommander.newBuilder().addObject(main).build().parse(args);
//        main.run();
//    }
//
//    public void run() throws IOException{
//
//        //BufferedReader input
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        char choice;
//        double total_price=0;
//        //Following is the code for Calculating 'Total_Tax' for the details entered in command line
//        if(type.equals("manufactured")){
//            total_price = price + 0.125*price + 0.02*(price + 0.125*(price));
//        }else if(type.equals("raw")){
//            total_price =  price + 0.125*(price);
//        }else{
//            total_price =  price + 0.1*(price) + 0.125*(price);
//            if(total_price<=100){
//                total_price+=5;
//            }else if(total_price>100 && total_price<=200){
//                total_price+=10;
//            }else{
//                total_price += (0.05*total_price);
//            }
//        }
//
//        //created vector data structure for storing item's details
//        Vector<Details>detailsArray = new Vector<>();
//        Details d = new Details(Name,quantity,price,type,total_price);
//
//        //add user details
//        detailsArray.add(d);
//        System.out.println("Do you want to add more ? (y/n)");
//        //takes  the input choice
//
//        //after entering the details in command line, user is prompted for one more choice.
//
//        //from here after, control goes to console....i.e standard input : )
//        choice = (char) br.read();
//        char choice_end;
//        if(choice=='y') {
//
//
//            do {
//                float Price=0,Sales_tax = 0;
//                int Quantity=0,type_choice = 0;String Name,Type="";
//                //used HashSet datastructure for restricting user on already given choices
//                HashSet<Integer> choices = new HashSet<>();
//                System.out.println("\nEnter the name of the items : ");
////                String name = br.readLine();//useless declaration
//                Name = br.readLine();
//                //lets provide the option to enter the item's details as he wishes;
//
//                while(choices.size()<3) {
//
//                    System.out.println("Please select one of the following : ");
//                    System.out.println("1.Type\n2.Price\n3.Quantity");
//
//                    //input from user;
//                    int choice1 = Integer.parseInt(br.readLine());// user types 1 or 2 or 3
//                    if (choices.contains(choice1) == false) {
//                        if(choice1>0 && choice1<=3)
//                            choices.add(choice1);
//                        try {
//                            validate_user_choice2(choice1);
//                        } catch (Exception e) {
//                            System.out.println("Exception Occured : " + e);
//                        }
//
//                        if (choice1 == 1) {
//                            System.out.println("\nYou have Selected" + "'Type'\n");
//                            System.out.println("Plese select one of the following ; ) ");
//                            System.out.println("1.Raw\n2.Manufactured\n3.Imported");
//
//
//                            type_choice = Integer.parseInt(br.readLine());
//
//                            try {
//                                validate_user_type_choice(type_choice);
//                            } catch (Exception e) {
//                                System.out.println("Not a valid choice" + e);
//                            }
//
//
//
//                            if (type_choice == 1) {
//                                Type = "Raw";
//
//                            } else if (type_choice == 2) {
//                                Type = "Manufactured";
//
//                            } else {
//                                Type = "Imported";
//                            }
//                        } else if (choice1 == 2) {
//                            System.out.println("You have Choosen 'Price' : ");
//                            System.out.println("\nPLease enter the price of the item : ");
//                            Price = Float.parseFloat(br.readLine());
//                        } else if(choice1==3){
//                            System.out.println("You have Choosen 'Quantity' : ");
//                            System.out.println("\nPlease enter the Quantity : ");
//                            Quantity = Integer.parseInt(br.readLine());
//                        }
//                    } else {
//                        System.out.println("You already entered the details of this type : )");
//                    }
//
//                }
//                System.out.println("Do you want to add more ? (y/n)");
//                //takes  the input choice
//
//                choice_end = (char) br.read();
//                try {
//                    validate_user_choice1(choice_end);
//                } catch (Exception e) {
//                    System.out.println("Exception Occured : " + e);
//                }
//                if(type_choice == 1){
//                    total_price = Price + 0.125*Price;
//                }else if(type_choice==2){
//                    total_price = Price + 0.125*Price + 0.02*(Price + 0.125*(Price));
//                }else{
//                    total_price =  price + 0.1*(price) + 0.125*(price);
//                    if(total_price<=100){
//                        total_price+=5;
//                    }else if(total_price>100 && total_price<=200){
//                        total_price+=10;
//                    }else{
//                        total_price += (0.05*total_price);
//                    }
//                }
//                Details new_d  = new Details(Name,Quantity,Price,Type,total_price*quantity);
//                detailsArray.add(new_d);
//            } while (choice_end != 'n');
//
//            System.out.println("The items registered so far.....");
//            Iterator itr = detailsArray.iterator();
//            while(itr.hasNext()){
//                Details dt = (Details) itr.next();
//                System.out.println(dt.name + " " + dt.type+ " "+dt.price+" "+dt.quantity+" "+dt.Total_price);
//            }
//
//        }else{
//
//            System.out.println("Thankyou :)");
//        }
//
//
//    }
//
//    static void validate_user_choice1(char c) throws User_Choice_1{
//        if(c!='y' && c!='n'){
//            throw new User_Choice_1("Not valid Choice");
//        }
//    }
//
//    static void validate_user_choice2(int c) throws User_choice_rem{
//        if(c > 3 || c < 1){
//            throw new User_choice_rem("Not valid Choice");
//        }
//    }
//
//    static void validate_user_type_choice(int c) throws type_chice{
//        if(c < 1 || c > 3){
//            throw new type_chice("Not a valid choice");
//        }
//    }
//
//
//}




//my version 1.2



import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);
        char ch;
        String name,type;
        double price,total_price;
        int quantity;
        ArrayList<Details> detailsArrayList = new ArrayList<>();
//            Details d = new Details(name, type, quantity, price, total_price);
        try{
            do{
//                item.item_details();
                detailsArrayList.add(item.item_details());
                System.out.println("Do you want to enter details of any other item (y/n)");
                ch =input.next().charAt(0);
            }while(ch == 'y');
        }
        catch (Exception e){
            System.out.println(e);
        }
        //iteration process
        Iterator ite = detailsArrayList.iterator();
        while (ite.hasNext()){
            Details dt = (Details) ite.next();
            System.out.println(dt.name + " " + dt.type + " " + dt.quantity + " " + dt.price + " " + dt.total_price);
        }
    }
}
class Details{
    String name,type;
    double price,total_price;
    int quantity;
    Details(String name,String type,int quantity,double price,double total_price){
        this.name=name;
        this.type=type;
        this.price=price;
        this.quantity=quantity;
        this.total_price=total_price;
    }
}
class item {
    public static Details item_details() {
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
        float total_price = (sales_tax + item_prize)*item_quantity;
//        System.out.println(item_name);
//        System.out.println(item_prize);
//        System.out.println(item_quantity);
//        System.out.println(sales_tax);
//        System.out.println(total_price);
//        System.out.println(item_type);
        Details d = new Details(item_name, item_type, item_quantity, item_prize, total_price);
        return d;
    }
}