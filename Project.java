//package project;

import java.util.*;
import java.io.*;

//variable class
class variable {
    // All variables are declared globally

    ArrayList<Integer> P_Id = new ArrayList<Integer>(); // Creating array list object names as P_Id
    ArrayList<String> P_Name = new ArrayList<String>(); // Creating array list object names as P_Name
    ArrayList<Integer> P_Price = new ArrayList<Integer>(); // Creating array list object names as P_Price
    ArrayList<Integer> B_Id = new ArrayList<Integer>(); // Creating array list object names as B_Id
    ArrayList<String> B_Name = new ArrayList<String>(); // Creating array list object names as B_Name
    ArrayList<Integer> B_Price = new ArrayList<Integer>(); // Creating array list object names as B_Price
    ArrayList<Integer> B_Quantity = new ArrayList<Integer>(); // Creating array list object names as B_Quantity

    int P_Count = 0, i = 0, PID_Modify = 0, PID_Delete = 0, j = 0, c, choice_seller_choice, main_menu,
            choice_buyer_choice, Modified_Price, buy_products_buyer, quantity_buyer, choice, amount, total,
            null_value_number, counter = 0, seller_count = 1, buyer_count = 1; // Variables
    // of int
    // data type
    char new_user_seller, new_user_buyer, con, condition; // Variables of char data type
    String username_seller, password_seller, username_buyer, password_buyer; // Variables of String data type
    String full_name_seller_signUp, user_name_seller_signUp, password_seller_signUp, address_seller_signUp,
            city_seller_signUp, state_seller_signUp, dob_seller_signUp, email_seller_signUp, contact_seller_signUp;
    String full_name_buyer_signUp, user_name_buyer_signUp, password_buyer_signUp, address_buyer_signUp,
            city_buyer_signUp, state_buyer_signUp, dob_buyer_signUp, email_buyer_signUp, contact_buyer_signUp;
}

/* Inheriting variable class in Menu(Single level inheritance) */
class Menu extends variable {
    Scanner sc = new Scanner(System.in);

    public void menus() // menus function
    {
        System.out.print("\033[H\033[2J");
        System.out.println("\n\t\t\t\t********************\n\t\t\t\t\tHOME\n\t\t\t\t********************");
        System.out.println("\n\t1. To Enter As A Seller Press 1");
        System.out.println("\n\t2. To Enter As A Buyer Press 2");
        System.out.println("\n\t3. To Exit Press 3");
        System.out.print("\n\tEnter Your Choice: ");
        choice = sc.nextInt();
        switch (choice) {

        case 1:
            System.out.print("\n\tAre You New Seller? (Press 'Y' For Yes And 'N' For No): ");
            new_user_seller = sc.next().charAt(0);
            if (new_user_seller == 'y' || new_user_seller == 'Y') {
                getData_SignUp_seller();
                getData_SignIn_seller();
                seller();
            }

            else if (new_user_seller == 'n' || new_user_seller == 'N') {
                getData_SignIn_seller();
                seller();
            }
            break;
        case 2:
            System.out.print("\n\tAre You New Buyer? (Press 'Y' For Yes And 'N' For No): ");
            new_user_buyer = sc.next().charAt(0);
            if (new_user_buyer == 'y' || new_user_buyer == 'Y') {
                getData_SignUp_buyer();
                getData_SignIn_buyer();
                buyer();
            } else if (new_user_buyer == 'n' || new_user_buyer == 'N') {
                getData_SignIn_buyer();
                buyer();
            }
            break;
        case 3:
            System.exit(0);
            break;
        default:
            System.out.print("Enter valid choice\n");
            break;
        }
    }

    public void getData_SignIn_seller() // getData_SignIn_seller function
    {
        try {
            System.out.print("\033[H\033[2J");
            System.out.println("\n\n\t\t\t\t**********************\n\t\t\t\t\tSELLER\n\t\t\t\t**********************");
            System.out.print("\n\n\tEnter Username: ");
            username_seller = sc.next();
            System.out.print("\tEnter Password: ");
            password_seller = sc.next();
            FileWriter fw2 = new FileWriter("D:\\SEM3\\OOP(JAVA)\\Project\\Seller_Login_History.txt", true);
            BufferedWriter bw2 = new BufferedWriter(fw2);
            bw2.write(
                "\n\n\t\t\t\t\t\t********************\n\t\t\t\t\t\tSELLER Login History\n\t\t\t\t\t\t********************");
            bw2.write("\n\t\t\t\t\t\tUsername: " + username_seller);
            bw2.close();
            fw2.close();
        } catch (Exception e) {
            System.out.println("\n\tException Entered:" + e);
        }
    }

    public void getData_SignIn_buyer() // getData_SignIn_buyer function
    {
        try {
            System.out.print("\033[H\033[2J");
            System.out.println("\n\n\t\t\t\t*********************\n\t\t\t\t\tBUYER\n\t\t\t\t*********************");
            System.out.print("\n\n\tEnter Username: ");
            username_buyer = sc.next();
            System.out.print("\tEnter Password: "); 
            password_buyer = sc.next();
            FileWriter fw3 = new FileWriter("D:\\SEM3\\OOP(JAVA)\\Project\\Buyer_Login_History.txt", true);
            BufferedWriter bw3 = new BufferedWriter(fw3);
            bw3.write(
                "\n\n\t\t\t\t\t\t*******************\n\t\t\t\t\t\tBUYER Login History\n\t\t\t\t\t\t*******************");
                bw3.write("\n\t\t\t\t\t\tUsername: " + username_buyer);
            bw3.close();
            fw3.close();
        } catch (Exception e) {
            System.out.println("\n\tException Entered:" + e);
        }
    }

    public void getData_SignUp_seller() // getData_SignUp_seller function
    {
        System.out.print("\033[H\033[2J");
        System.out.println("\n\n\t\t\t\t**********************\n\t\t\t\t\tSELLER\n\t\t\t\t**********************");

        System.out.print("\n\n\tFull Name: ");
        full_name_seller_signUp = sc.nextLine();
        sc.nextLine();
        System.out.print("\tUser Name: ");
        user_name_seller_signUp = sc.next();
        if (user_name_seller_signUp.equals("Stuti") || user_name_seller_signUp.equals("Jinay")
                || user_name_seller_signUp.equals("Purav") || user_name_seller_signUp.equals("Sakshi")) {
            System.out.print("\tUsername Already Exist Press 1 To Enter New Username Press 2 To Exit: ");
            c = sc.nextInt();
            switch (c) {
            case 1:
                getData_SignUp_seller();
                break;
            case 2:
                System.exit(0);
                break;
            default:
                System.out.print("\tWrong number entered\n");
                break;
            }
        }
        System.out.print("\tPassword: ");
        password_seller_signUp = sc.next();
        sc.nextLine();
        System.out.print("\tAddress: ");
        address_seller_signUp = sc.nextLine();
        System.out.print("\tCity: ");
        city_seller_signUp = sc.next();
        System.out.print("\tState: ");
        state_seller_signUp = sc.next();
        System.out.print("\tDOB: ");
        dob_seller_signUp = sc.next();
        System.out.print("\tEmail: ");
        email_seller_signUp = sc.next();
        System.out.print("\tContact: ");
        contact_seller_signUp = sc.next();
    }

    public void getData_SignUp_buyer() // getData_SignUp_buyer function
    {
        System.out.print("\033[H\033[2J");
        System.out.println("\n\n\t\t\t\t*********************\n\t\t\t\t\tBUYER\n\t\t\t\t*********************");

        System.out.print("\n\n\tFull Name: ");
        full_name_buyer_signUp = sc.nextLine();
        sc.nextLine();
        System.out.print("\tUser Name: ");
        user_name_buyer_signUp = sc.next();
        System.out.print("\tPassword: ");
        password_buyer_signUp = sc.next();
        sc.nextLine();
        System.out.print("\tAddress: ");
        address_buyer_signUp = sc.nextLine();
        System.out.print("\tCity: ");
        city_buyer_signUp = sc.next();
        System.out.print("\tState: ");
        state_buyer_signUp = sc.next();
        System.out.print("\tDOB: ");
        dob_buyer_signUp = sc.next();
        System.out.print("\tEmail: ");
        email_buyer_signUp = sc.next();
        System.out.print("\tContact: ");
        contact_buyer_signUp = sc.next();

    }

    public void seller() // seller function
    {
        if (((username_seller.equals("Stuti") || username_seller.equals("Jinay") || username_seller.equals("Purav")
                || username_seller.equals("Sakshi")) && password_seller.equals("gnu123"))
                || (username_seller.equals(user_name_seller_signUp)
                        && password_seller.equals(password_seller_signUp))) {
            seller_choice();

        } else {
            System.out.print(
                    "\n\tAccount Doesn't Exist Or Entered Username Or Password Are Incorrect\n\tPress 1 To Create New Account\n\tPress 2 To Re Enter Username And Password\n\tPress 3 To Exit\n\tEnter Your Choice: ");
            c = sc.nextInt();
            switch (c) {
            case 1:
                getData_SignUp_seller();
                getData_SignIn_seller();
                seller_choice();
                break;
            case 2:
                getData_SignIn_seller();
                seller();
                break;
            case 3:
                System.exit(0);
                return;
            default:
                System.out.print("\tWrong choice entered\n");
                break;
            }
        }
    }

    public void buyer() // buyer function
    {
        if ((username_buyer.equals("Stuti") || username_buyer.equals("Jinay") || username_buyer.equals("Purav")
                || username_buyer.equals("Sakshi")) && password_buyer.equals("gnu123")
                || (username_buyer.equals(user_name_buyer_signUp) && password_buyer.equals(password_buyer_signUp))) {
            buyer_choice();
        } else {
            System.out.print(
                    "\n\tAccount Doesn't Exist Or Entered Username Or Password Are Incorrect\n\tPress 1 To Create New Account\n\tPress 2 To Re Enter Username And Password\n\tPress 3 To Exit\n\tEnter Your Choice: ");
            c = sc.nextInt();
            switch (c) {
            case 1:
                getData_SignUp_buyer();
                getData_SignIn_buyer();
                buyer_choice();
                break;
            case 2:
                getData_SignIn_buyer();
                buyer();
                break;
            case 3:
                System.exit(0);
                return;
            default:
                System.out.print("\tWrong Choice Entered\n");
                break;
            }
        }
    }

    public void seller_choice() // seller_choice function
    {

        System.out.print("\033[H\033[2J");
        System.out.println("\n\n\t\t\t\t*********************\n\t\t\t\t\tSELLER\n\t\t\t\t*********************");
        System.out.println("\n\t1. CREATE PRODUCT");
        System.out.println("\n\t2. MODIFY PRODUCT");
        System.out.println("\n\t3. DELETE PRODUCT");
        System.out.println("\n\t4. VIEW ALL PRODUCTS");
        System.out.println("\n\t5. BACK TO MAIN MENU");
        System.out.print("\n\tEnter Your Choice: ");
        choice_seller_choice = sc.nextInt();
        switch (choice_seller_choice) {
        case 1:
            create_product();
            break;

        case 2:
            modify_product();
            view_products();
            break;

        case 3:
            delete_product();
            break;

        case 4:
            view_products();
            break;

        case 5:
            menus();
            break;

        default:
            System.out.println("Invalid Choice !!!");
            break;
        }

    }

    public void create_product() // create_product function
    {
        System.out.print("\033[H\033[2J");
        System.out.println(
                "\n\n\t\t\t\t***************************\n\t\t\t\t\tCREATE PRODUCT\n\t\t\t\t****************************");

        while (con != 'n') {
            System.out.print("\n\tEnter How Much Items You Want To Insert: ");
            P_Count = sc.nextInt();

            for (i = 0; i < P_Count; i++) {
                System.out.print("\n\tEnter Product " + (i + 1) + " Id: ");
                P_Id.add(sc.nextInt());
                System.out.print("\tEnter Product " + (i + 1) + " Name: ");
                P_Name.add(sc.next());
                System.out.print("\tEnter Product " + (i + 1) + " Price(Per kg): ");
                P_Price.add(sc.nextInt());
            }
            System.out.print("\n\tDo You Want To Create New Product(Press y for yes and n for no):");
            con = sc.next().charAt(0);
        }
        con = 0;
        try {
            FileWriter fw4 = new FileWriter("D:\\SEM3\\OOP(JAVA)\\Project\\All_Products.txt", true);
            BufferedWriter bw4 = new BufferedWriter(fw4);
            bw4.write(
                    "\n\n\t\t\t\t\t***************************\n\t\t\t\t\t\tAll PRODUCTS\n\t\t\t\t\t***************************");
            bw4.write("\n\t\t\t\tPID\t\tPRODUCT NAME\t\tPRICE\n");
            for (int i = 0; i < P_Id.size(); i++) {
                bw4.write("\n\t\t\t\t" + P_Id.get(i) + "\t\t" + P_Name.get(i) + "\t\t\t" + P_Price.get(i));
            }
            bw4.close();
            fw4.close();
        } catch (Exception e) {
            System.out.println("Exception catched:" + e);
        }
        System.out.print("\n\tPress 1 For Return To Main Menu and Press 2 to Exit: ");
        main_menu = sc.nextInt();
        switch (main_menu) {
        case 1:
            seller_choice();
            break;
        case 2:
            System.exit(0);
            break;
        default:
            System.out.print("\n\tWrong Number Entered");
            break;
        }
    }

    public void modify_product() // modify_product function
    {

        System.out.print("\033[H\033[2J");
        System.out.println(
                "\n\n\t\t\t\t***************************\n\t\t\t\t\tMODIFY PRODUCT\n\t\t\t\t****************************");
        if (P_Id.size() == 0) {
            System.out.print(
                    "\n\tYou Didn't Created Any Products.\n\n\tIf You Want To Create Product Press 1 and Press 2 to exit: ");
            null_value_number = sc.nextInt();
            switch (null_value_number) {
            case 1:
                create_product();
                break;
            case 2:
                System.exit(0);
                break;
            default:
                System.out.println("\tWrong Choice !!!!");
                break;
            }
        } else {
            System.out.println("\n\t\tPID\t\tPRODUCT NAME\t\tPRICE");
            for (int i = 0; i < P_Id.size(); i++) {
                System.out.println("\t\t" + P_Id.get(i) + "\t\t" + P_Name.get(i) + "\t\t\t" + P_Price.get(i));
            }

            System.out.print("\n\tEnter Product's Number Which You Want To Change: ");
            PID_Modify = sc.nextInt();
            System.out.print("\n\tEnter New Price: ");
            Modified_Price = sc.nextInt();

            for (i = 0; i < P_Id.size(); i++) {
                if (P_Id.get(i) == PID_Modify) {
                    P_Price.set(i, Modified_Price);
                }
            }
            System.out.print("\n\tPress 1 For Return To Main Menu and Press 2 to Exit: ");
            main_menu = sc.nextInt();
            switch (main_menu) {
            case 1:
                seller_choice();
                break;
            case 2:
                System.exit(0);
                break;
            default:
                System.out.print("\n\tWrong Number Entered");
                break;
            }
        }
    }

    public void delete_product() // delete_product function
    {
        System.out.print("\033[H\033[2J");
        System.out.println(
                "\n\n\t\t\t\t*******************************\n\t\t\t\t\tDELETE PRODUCTS\n\t\t\t\t*******************************");
        if (P_Id.size() == 0) {
            System.out.print("\n\tYou Didn't Created Any Products.\n\n\tIf You Want To Create Product Press 1: ");
            null_value_number = sc.nextInt();
            switch (null_value_number) {
            case 1:
                create_product();
                break;
            case 2:
                System.exit(0);
                break;
            default:
                System.out.println("\tWrong Choice Entered");
                break;
            }
        } else {
            System.out.println("\n\t\tPID\t\tPRODUCT NAME\t\tPRICE");
            for (int i = 0; i < P_Id.size(); i++) {
                System.out.println(
                        "\t\t" + P_Id.get(i) + "\t\t" + P_Name.get(i) + "\t\t\t" + P_Price.get(i));
            }
            System.out.print("\n\tEnter Product's Number Which You Want To Delete: ");
            PID_Delete = sc.nextInt();
            for (i = 0; i < P_Id.size(); i++) {
                if (P_Id.get(i) == PID_Delete) {
                    j = i;
                    break;
                }
            }
            P_Id.remove(j);
            P_Price.remove(j);
            P_Name.remove(j);
            System.out.println("\n\t\tPID\t\tPRODUCT NAME\t\tPRICE");
            for (int i = 0; i < P_Id.size(); i++) {
                System.out.println("\t\t" + P_Id.get(i) + "\t\t" + P_Name.get(i) + "\t\t\t" + P_Price.get(i));
            }
            System.out.print("\n\tPress 1 For Return To Main Menu and Press 2 to Exit: ");
            main_menu = sc.nextInt();
            switch (main_menu) {
            case 1:
                seller_choice();
                break;
            case 2:
                System.exit(0);
                break;
            default:
                System.out.print("\n\tWrong Number Entered");
                break;
            }
        }

    }

    public void view_products() // view_products function
    {
        System.out.print("\033[H\033[2J");
        System.out.println(
                "\n\n\t\t\t\t****************************\n\t\t\t\t\tVIEW PRODUCTS\n\t\t\t\t****************************");
        if (P_Id.size() == 0) {
            System.out.print("\n\tYou Didn't Created Any Products.\n\n\tIf You Want To Create Product Press 1: ");
            null_value_number = sc.nextInt();
            if (null_value_number == 1) {
                create_product();
            } else {
                System.out.println("Wrong Choice Entered");
            }
        } else {
            System.out.println("\n\t\tPID\t\tPRODUCT NAME\t\tPRICE");
            for (int i = 0; i < P_Id.size(); i++) {
                System.out.println("\t\t" + P_Id.get(i) + "\t\t" + P_Name.get(i) + "\t\t\t" + P_Price.get(i));
            }
            System.out.print("\n\tPress 1 For Return To Main Menu and Press 2 to Exit: ");
            main_menu = sc.nextInt();
            switch (main_menu) {
            case 1:
                seller_choice();
                break;
            case 2:
                System.exit(0);
                break;
            default:
                System.out.print("\n\tWrong Number Entered");
                break;
            }
        }
    }

    public void buyer_choice() // buyer_choice function
    {
        System.out.print("\033[H\033[2J");
        System.out.println("\n\n\t\t\t\t*********************\n\t\t\t\t\tBUYER\n\t\t\t\t*********************");
        System.out.println("\n\t1. VIEW ALL PRODUCTS");
        System.out.println("\n\t2. BUY PRODUCTS");
        System.out.println("\n\t3. VIEW CART AND BILL");
        System.out.println("\n\t4. BACK TO MAIN MENU");
        System.out.print("\n\tEnter Your Choice: ");
        choice_buyer_choice = sc.nextInt();
        switch (choice_buyer_choice) {
        case 1:
            view_products_buyer();
            break;

        case 2:
            buy_products();
            break;

        case 3:
            view_cart();
            break;

        case 4:
            menus();
            break;

        default:
            System.out.println("Wrong Number Entered");
            break;
        }
    }

    public void view_products_buyer() // view_products_buyer function
    {
        System.out.print("\033[H\033[2J");
        System.out.println(
                "\n\n\t\t\t\t****************************\n\t\t\t\t\tVIEW PRODUCTS\n\t\t\t\t****************************");
        if (P_Id.size() == 0) {
            System.out.print("\n\tSorry We Don't Have Any Products For You Right Now.");
        }

        else {
            System.out.println("\n\t\tPID\t\tPRODUCT NAME\t\tPRICE");
            for (int i = 0; i < P_Id.size(); i++) {
                System.out.println("\t\t" + P_Id.get(i) + "\t\t" + P_Name.get(i) + "\t\t\t" + P_Price.get(i));
            }
            System.out.print("\n\tPress 1 For Return To Main Menu Press 2 to Exit: ");
            main_menu = sc.nextInt();
            switch (main_menu) {
            case 1:
                buyer_choice();
                break;
            case 2:
                System.exit(0);
                break;
            default:
                System.out.print("\n\tWrong Number Entered");
                break;
            }
        }
    }

    public void buy_products() // buy_products function
    {
        con = 0;
        System.out.print("\033[H\033[2J");
        System.out.println("\n\n\t\t\t\t*********************\n\t\t\t\t\tBUYER\n\t\t\t\t*********************");
        if (P_Id.size() == 0) {
            System.out.print("\n\tSorry We Don't Have Any Products For You Right Now.");
        } else {
            System.out.println("\n\n\t\tPID\t\tPRODUCT NAME\t\tPRICE");
            for (int i = 0; i < P_Id.size(); i++) {
                System.out.println("\t\t" + P_Id.get(i) + "\t\t" + P_Name.get(i) + "\t\t\t" + P_Price.get(i));
            }
            while (con != 'n') {
                System.out.print("\n\tEnter PID You Want To Buy: ");
                buy_products_buyer = sc.nextInt();
                for (i = 0; i < P_Id.size(); i++) {
                    if (buy_products_buyer == P_Id.get(i)) {
                        counter++;
                    }
                }
                if (counter == 0) {
                    System.out.print(
                            "\n\tEntered PID Does Not Exist \n\tPress Y To Enter Again N To Go Back To Main Menu: ");
                    condition = sc.next().charAt(0);
                    if (condition == 'y' || condition == 'Y') {
                        buy_products();
                    } else if (condition == 'n' || condition == 'N') {
                        buyer_choice();
                    } else {
                        System.out.println("\n\tWrong Choice Entered");
                    }
                }
                counter = 0;
                System.out.print("\n\tEnter Quantity: ");
                quantity_buyer = sc.nextInt();
                for (i = 0; i < P_Id.size(); i++) {
                    if (buy_products_buyer == P_Id.get(i)) {
                        amount = P_Price.get(i) * quantity_buyer;
                        total += amount;
                        B_Id.add(P_Id.get(i));
                        B_Name.add(P_Name.get(i));
                        B_Quantity.add(quantity_buyer);
                        B_Price.add(amount);
                    }
                }

                System.out.print("\n\tDo You Want To Buy Another Product (Press y For Yes And n For No):");
                con = sc.next().charAt(0);
            }
        }
        con = 0;
        System.out.print("\n\tPress 1 For Return To Main Menu: ");
        main_menu = sc.nextInt();
        switch (main_menu) {
        case 1:
            buyer_choice();
            break;

        default:
            System.out.print("\n\tWrong Number Entered");
            break;
        }

    }

    public void view_cart() // view_cart function
    {
        try {
            if (B_Id.size() != 0) {
                System.out.print("\033[H\033[2J");
                System.out.println("\n\n\t\t\t\t*********************\n\t\t\t\t\tCART\n\t\t\t\t*********************");
                System.out.println("\n\n\t\tPID\t\tPRODUCT NAME\t\tQUANTITY\t\tPRICE");
                for (int i = 0; i < B_Id.size(); i++) {
                    System.out.println("\t\t" + B_Id.get(i) + "\t\t" + B_Name.get(i) + "\t\t\t" + B_Quantity.get(i)
                            + "\t\t\t" + B_Price.get(i));
                }
                System.out.println("\n\t\t\t\t\t\t\t\t\tTotal Price: " + total);
                FileWriter fw1 = new FileWriter("D:\\SEM3\\OOP(JAVA)\\Project\\bill.txt");
                BufferedWriter bw1 = new BufferedWriter(fw1);
                bw1.write(
                        "\n\n\t\t\t\t\t\t*********************\n\t\t\t\t\t\t\tCART\n\t\t\t\t\t\t*********************");
                bw1.write("\n\n\t\t\tPID\t\tPRODUCT NAME\t\tQUANTITY\t\tPRICE");
                for (int i = 0; i < B_Id.size(); i++) {
                    bw1.write("\n\t\t\t" + B_Id.get(i) + "\t\t" + B_Name.get(i) + "\t\t\t" + B_Quantity.get(i)
                            + "\t\t\t" + B_Price.get(i));
                }
                bw1.write("\n\t\t\t\t\t\t\t\t\t\tTotal Price: " + total);
                bw1.close();
                fw1.close();
                FileWriter fw = new FileWriter("D:\\SEM3\\OOP(JAVA)\\Project\\Bill_All_Records.txt.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(
                        "\n\n\t\t\t\t\t\t*********************\n\t\t\t\t\t\t\tCART\n\t\t\t\t\t\t*********************");
                bw.write("\n\n\t\t\tPID\t\tPRODUCT NAME\t\tQUANTITY\t\tPRICE");
                for (int i = 0; i < B_Id.size(); i++) {
                    bw.write("\n\t\t\t" + B_Id.get(i) + "\t\t" + B_Name.get(i) + "\t\t\t" + B_Quantity.get(i) + "\t\t\t"
                            + B_Price.get(i));
                }
                bw.write("\n\t\t\t\t\t\t\t\t\t\tTotal Price: " + total);
                bw.close();
                fw.close();
                System.out.print("\n\tPress 1 For Return To Main Menu and Press 2 to Exit: ");
                main_menu = sc.nextInt();
                switch (main_menu) {
                case 1:
                    buyer_choice();
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.print("\n\tWrong Number Entered");
                    break;
                }
            } else {
                System.out.println("Your Cart Is Empty.");
                System.out.print("\n\tPress 1 For Return To Main Menu and Press 2 to Exit: ");
                main_menu = sc.nextInt();
                switch (main_menu) {
                case 1:
                    buyer_choice();
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.print("\n\tWrong Number Entered");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("\n\tException Entered:" + e);
        }
    }
}

public class Project {

    public static void main(String[] args) // main function
    {
        Menu men1 = new Menu(); // Creating object of Menu class as men1
        men1.menus();
    }
}