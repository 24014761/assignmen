/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author rudza
 */

import java.util.Scanner;

public class Products {
    
    static Scanner Rudzani = new Scanner(System.in);                  // this will allows to read text and numbers in this class
    static ReportData[] storeItems = new ReportData[300];                   // this array can hold up to 300 products
        
    public static int DisplayMenu(){                              //this method  is called displaymenu and it return integer
        System.out.println("Please select one of the following menu items:");
        System.out.println("(1) Capture a new product.");
        System.out.println("(2) Search for a product.");
        System.out.println("(3) Update a product.");
        System.out.println("(4) Delete a product.");
        System.out.println("(5) Print report.");
        System.out.println("(6) Exit Application.");
        int choice = 0;                                 // this will store or holds the number the user selects
        System.out.print("choice >> ");                    //to show the user where to type the selection
        while(true){                                   //this simply means that the loop will start that repeats forever until a valid number is entered
            choice = Rudzani.nextInt();              //it will wait for the user to type a number and then saves it to the cointainer called choice
            Rudzani.nextLine();                                //clears out the leftover key in the scanner so that it does not break our next input
            if(!(choice > 0 && choice < 7)){     //it will check if the number is not between 1 and 6
                System.out.print("Choice must be between 1 and 6");   //it will print whats inside the parenthesis
                continue;                                    //it skips the rest of the code and throws it back to the startof the loop to try again
            }
            System.out.println("");
            return choice;                                               //sends the valid number back and close the menu
        }
    }
    
    public static void CaptureProduct(){                      // a new methods fpr capturing products
        if(ReportData.index >= storeItems.length){            // Using static index to check array capacity bounds smoothly until its full

            System.out.println("Max number of products has been reached");         //display whats inside paranthesis
            return;          //exit method immediately
        }
        else{
            System.out.println("CAPTURE A NEW PRODUCT");                    //display as it is
            System.out.println("**************************");                //display as it is
            
            System.out.print("Enter the product code:");               //ask you to enter  the code
            String prodCode = Rudzani.nextLine();                         //will allow user input  using scanner object named Rudzani
            for(int i=0;i<ReportData.index;i++){                             //it will loop from index zero up until current total filled
                if(storeItems[i]!=null && storeItems[i].getProductCode().equalsIgnoreCase(prodCode)){               //compares the existing product code to the new input while ignoring letter casting
                    System.out.println("Product "+storeItems[i].getProductName()+" is already in the system");           //notify the user that a duplicate product code was deleted
                   
                    return; //exit the method due to error
                }
            }
            
            System.out.print("Enter the product name:");                                     //allow user to enter name of the product
            String prodName = Rudzani.nextLine();  
            
            System.out.println("");
            System.out.println("Select the product category:");                                      //telling you what to do
            System.out.println("Desktop Computer - 1");
            System.out.println("Laptop - 2");
            System.out.println("Tablet - 3");
            System.out.println("Printer - 4");
            System.out.println("Gaming Console - 5");
            System.out.print("Product category >> ");                                      //allow user to write their choice next to the arrows
            int category;                                                                  //datatype named catergory which stores integers
            while(true){                                                                   //a user wont procide until they provide valid input
                category = Rudzani.nextInt();                                                // read the interger typed by the user
                Rudzani.nextLine();
                if(category < 1 || category > 5){  //will check if the entered category falls outside the valid option range of 1 to 5
                    System.out.println("Category has to be between 1 and 5");
                    continue;   //the lloop will skip the rest and jump straight back to the top to ask for input again
                }
                break; //excecute only if the input was valid 1 to 5
            }
            System.out.println("");
            System.out.print("Indicate the product warranty. Enter (1) for 6 months or any other key for 2 years. ");
            String warranty = Rudzani.nextLine();
            double warrantyMonths;
            if("1".equals(warranty)){  //will check if the user typed one
                warrantyMonths = 6.0;
            }
            else{
                warrantyMonths = 24.0;
            }
            System.out.println("");
            System.out.print("Enter the price for " + prodName + " >> ");
            double price;
            while(true){
                price = Rudzani.nextDouble();
                Rudzani.nextLine();
                if(price < 0){
                    System.out.println("Price cannot be negative,Enter price again:");
                    continue;
                }
                break; //skip the rest of the loop and forces a user to re enter again
            }
            
            int stock;
            while(true){ //start the loop to repeatedly prompt the user until valid input is received
                System.out.print("Enter Stock level for " + prodName + " >> "); 
                stock = Rudzani.nextInt();  //read the interger that a user will enter
                Rudzani.nextLine();
                if(stock < 0){ //it will check if the user entered the negative answer
                    System.out.println("Stock cannot be negative");
                    continue; //immediately will restart the  loopto prompt a user to enter something again
                }
                break; // it will exit the loop if the input is o or greater than zero
            }
            
            System.out.print("Enter the supplier for " + prodName + " >> ");
            String supplier = Rudzani.nextLine();    //it will stores a new variable called supplier
            
            ReportData i8 = new ReportData(prodCode.trim(), prodName.trim(), warrantyMonths, category, price, stock, supplier);
            SaveProduct(i8);  //initiates a new object of the reportdata class called i1
        }
    }
   
    public static void SaveProduct(ReportData i1){
        // Save at current active index tracking boundary position
        storeItems[ReportData.index] = i1;  
        ReportData.index++; // Counter ticks up exactly once per save
        System.out.println("Product details has been saved successfully!!!");
    }

    public static void SearchProduct(){
        System.out.print("Please enter the product code to search: ");
        String prodCode = Rudzani.nextLine();
        
        for(int i = 0; i < ReportData.index; i++){ //loops sequentially through the occupied elements of the storeitems array
            if(storeItems[i] != null && storeItems[i].getProductCode().equals(prodCode)){ //validates that the current slot is populated to check if the items code exaclty matches the user input
                System.out.println("*************************************************");
                System.out.println("PRODUCT SEARCH RESULTS");
                System.out.println("*************************************************");
                System.out.println("PRODUCT CODE: " + storeItems[i].getProductCode());  //display the matching code retrieved from the data object
                System.out.println("PRODUCT NAME: " + storeItems[i].getProductName());
                System.out.println("PRODUCT WARRANTY: " + (storeItems[i].getWarranty() / 12) + " years"); //divides the stored monthlly variable by 12 to convert and display it cleanly as integers years
                System.out.println("PRODUCT CATEGORY: " + CategName(storeItems[i].getCategory()));
                System.out.println("PRODUCT PRICE: R" + storeItems[i].getPrice());
                System.out.println("PRODUCT STOCK LEVELS: " + storeItems[i].getstockLevels());
                System.out.println("PRODUCT SUPPLIER: " + storeItems[i].getSupplier());
                return;
            }   
        }
        System.out.println("The product cannot be located. Invalid Product");
        return;
    }
    
    public static void DeleteProduct(){
        System.out.print("Please enter the product code to delete: ");
        String prodCode = Rudzani.nextLine();
        boolean found = false;
        
        for(int i = 0; i < ReportData.index; i++){//loop condition is designed to avoid going out of bounds
            if(storeItems[i] != null && storeItems[i].getProductCode().equals(prodCode)){//check if the index we on is not null helps avoid outOfBounds error
                found = true;
                System.out.println("Are you sure that you want to delete? (y) for yes, any other key to cancel");
                String confirm = Rudzani.nextLine();
                if("y".equalsIgnoreCase(confirm.trim())){
                    
                    //loop for shifting things left 
                    for (int j = i; j < ReportData.index - 1; j++) {//we minusing coz sure, < will stop at the last index but we wanna delete and leave last index empty,hence this
                        storeItems[j] = storeItems[j + 1];//replaces item on the current index with item from next index
                    }
                    //deleting the last index duplicate so it can be reused for another product
                    storeItems[ReportData.index - 1] = null;
                    
                    ReportData.index--; // Static variable for tracking number of objects in ReportData class is reduced by 1
                    System.out.println("Deletion was successful");
                    break;
                }
                else{//this block will be executed when any other key is entered
                    System.out.println("Cancellation successful");
                }
            } 
        } 
        if(!found){//will only be true  if variable found is still false meaning when product was not found
            System.out.println("The product was not found in the system");
        }
        
    }
    public static void UpdateProduct(){
    System.out.print("Please enter the product code to update: ");
    String prodCod = Rudzani.nextLine().trim();
    boolean code = false;
    
    for(int i = 0; i < ReportData.index; i++){
        if(storeItems[i] != null && storeItems[i].getProductCode().equals(prodCod)){
            code = true;
            
            // updating the product name section
            System.out.print("Update the warranty? (y) Yes, (n) No ");
            while(true){
                String warrInput = Rudzani.nextLine().trim().toLowerCase();
                if(warrInput.isEmpty()){
                    System.out.print("Please enter 'y' or 'n': ");
                    continue;
                }
                char warrantychoice = warrInput.charAt(0);
                
                if(warrantychoice == 'y'){
                    System.out.print("Indicate the new product warranty. Enter (1) for 6 months or any other key for 2 years. ");
                    String warranty = Rudzani.nextLine();
                    if("1".equals(warranty.trim())){
                        storeItems[i].setWarranty(6);
                    }
                    else{
                        storeItems[i].setWarranty(24);
                    }
                    break;
                }
                else if(warrantychoice == 'n'){
                    System.out.println("It won't be changed then");//change the message to be more user friendly
                    break;
                }
                else{
                    System.out.print("Invalid character entered! Try again (y/n): ");
                }
            }
            
            // updating the price section
            System.out.print("Update the price? (y) Yes, (n) No ");
            while(true){  //it loop until valid input (y or n) is provided
                String costInput = Rudzani.nextLine().trim().toLowerCase();  //read user  response ,remove outer spacing and convert it to lowercase
                if(costInput.isEmpty()){  //make sure that the input is not empty or blank
                    System.out.print("Please enter 'y' or 'n': ");  //notify user to enter y or n
                    continue; //it will skip current iteration 
                }
                char cost= costInput.charAt(0);
                
                if(cost == 'y'){ // it means that  it will handle yes selection only here
                    while(true){
                        System.out.print("Enter the new price for >> " + storeItems[i].getProductName() + " "); //ask you to nter the new product 
                        double price = Rudzani.nextDouble();            // a user will enter decimal number
                        Rudzani.nextLine();
                        storeItems[i].setPrice(price);          //update the object price attribute
                        break;                                // exit the price entry loop
                    } 
                    break;                                  //exit the user validation loop
                }
                else if(cost == 'n'){                      // this one will handle no selection
                    System.out.println("Okay, Moving on");      //its a confirmation that the price update is being skipped
                    break;                                         //exit the price update validation
                }
                else{  //it will handle any input that is not  y or n
                    System.out.print("Invalid character entered! Try again (y/n): "); //alert the user and request a valid input
                }
            }
            
            // updating the stock level section
            System.out.print("Update the stock level? (y) Yes, (n) No ");           //displaying  prompt that will ask a user if wants to change stock details
            while(true){
                String choiceInput = Rudzani.nextLine().trim().toLowerCase();      //it will read  response ,remove leading/trailing spaces,and converting to lowercase
                
                if (choiceInput.isEmpty()) {                                       //check  if the user entered something
                    System.out.print("Please enter 'y' or 'n': ");  //re-prompt  user for a valid  character selection
                    continue;                               //resrart a loop  to wait for new input
                }
                choiceInput = choiceInput.toLowerCase();  //convert string tto lowercase
                char stok = choiceInput.charAt(0);       //extract the first character of string to evaluate the option
                
                if(stok == 'y'){ 
                    while(true){
                        System.out.print("Enter the new stock level for " + storeItems[i].getProductName() + " >> ");
                        int st = Rudzani.nextInt();
                        Rudzani.nextLine();
                        
                        if(st >= 0){
                            storeItems[i].setStockLevels(st);
                            break; 
                        }
                        else{
                            System.out.println("Stock cannot be negative.");
                        }
                    }
                    break; 
                }
                else if(stok == 'n'){
                    System.out.println("Stock level left unchanged.");
                    break; 
                }
                else{
                    System.out.print("Invalid character entered! Enter (y) for Yes or (n) for No: ");
                } 
            }
            
           
            System.out.println("Product details updated successfully.");
            
            return; 
        }
    } 
    
    
    if(!code){//message to be displayed if the loop doesn't find any products in the system
        System.out.println("Product not found");//message to the user
        
    }
}
    public static void PrintProductReport(){
        System.out.println("PRODUCT REPORT");
        System.out.println("=====================================================================================");
        
        if(ReportData.index == 0){//this if statement is to ensure that the array isn't empty,if condition true then we return nothing
            System.out.println("No products available.");
            System.out.println("");
            
            return;
        }
        double total = 0;
        for(int i = 0; i < ReportData.index; i++){
            total += storeItems[i].getPrice() * storeItems[i].getstockLevels();
            System.out.println("PRODUCT " + (i + 1));
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("PRODUCT CODE >> " + storeItems[i].getProductCode());
            System.out.println("PRODUCT NAME >> " + storeItems[i].getProductName());
            double warranty = storeItems[i].getWarranty() / 12;
            System.out.println("PRODUCT WARRANTY >> " + warranty+ " years");
            System.out.println("PRODUCT CATEGORY >> " + CategName(storeItems[i].getCategory()));
            System.out.println("PRODUCT PRICE >> " + storeItems[i].getPrice());
            System.out.println("PRODUCT STOCK LEVELS >> " + storeItems[i].getstockLevels());
            System.out.println("PRODUCT SUPPLIER >> " + storeItems[i].getSupplier());
            System.out.println("-------------------------------------------------------------------------------------");  
        }
        System.out.println("==================================================================================");
        System.out.println("TOTAL PRODUCT COUNT: " + ReportData.index);
        System.out.println("TOTAL PRODUCT VALUE: R " + total);
        double average = total / ReportData.index;
        System.out.println("AVERAGE PRODUCT VALUE: R " + average);
        System.out.println("==================================================================================");
        
    }
    public static String CategName(int category){
        switch (category) {
            case 1:
                return "Desktop Computer";
            case 2:
                return "Laptop";
            case 3:
                return "Tablet";
            case 4:
                return "Printer";
            case 5:
                return "Gaming Console";
            default:
                break;
        }
        return "";
    }
    public static void ExitApplication(){
        System.exit(0);
    }
}
    


