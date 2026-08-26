/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

/**
 *
 * @author rudza
 */

import java.util.Scanner;  //this will allow the user to enter something on the keyboard
public class Main {
    public static void main(String[] args) {    //this is our main metheod where our code is being executed
        Scanner input = new Scanner(System.in);  //this will allow a compiler to read what a user is typing
        
        System.out.println("BRIGHT FUTURE TECHNOLOGIES APPLICATION");
        System.out.println("**************************************");
        while (true) {  //meaning that it will keep on looping forever until a user press to exit
        System.out.println("");
        System.out.print("Enter (1) to launch menu or any other key to exit ");
        String value = input.nextLine();  //it will read what a user type
        System.out.println("");
        if("1".equals(value.trim())){   //trim it will remove accidental spaces that a user entered
            int choice = Products.DisplayMenu();
            if (choice == 1) {       //here it will show the menu and you have to select one that you want to use and then it will go to the menu that you selected
                    Products.CaptureProduct();
                } else if (choice == 2) {
                    Products.SearchProduct();
                } else if (choice == 3) {
                    Products.UpdateProduct();
                } else if (choice == 4) {
                    Products.DeleteProduct();
                } else if (choice == 5) {
                    Products.PrintProductReport();
                } else if (choice == 6) {
                    Products.ExitApplication();
                }
            }
            else{  //if you choose any key beside the one on the if it will Exit the application
                Products.ExitApplication();            }
        }
       
        } 
            
        }
    
    
    

