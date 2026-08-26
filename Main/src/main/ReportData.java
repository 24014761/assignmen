/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author rudza
 */
public class ReportData {
    static int index=0;     //keeping track of the number of objects already made and belongs to the class
    
    private String productCode; // declared as private so that other files  cannot accidentally  change them
    private String productName;
    private double warranty;
    private int category;
    private double price;
    private int stockLevels;
    private String supplier;
    
    
    public ReportData(String productCode,String productName,double warranty,int category,  //a constructor
            double  price,int stockLevels,String supplier){
        this.productCode=productCode;// takes the product code you just typed into the formand saves it securely to the specific product
        this.productName=productName;
        this.warranty=warranty;
        this.category=category;
        this.price=price;
        this.stockLevels=stockLevels;
        this.supplier=supplier;    
    }
    
    // starting with getters method
    public String getProductCode(){  //method that looks up and sends back the saved product code
        return this.productCode;
    }
    public String getProductName(){  //this one sends back the saved product
        return this.productName;
    }
    public double getWarranty(){   //this one sends back decimal number
        return this.warranty;
    }
    public int getCategory(){  // this one sends back the number
        return this.category;
    }
    public double getPrice(){   // this one sends back the decimal number for price
        return this.price;
    }
    public int getstockLevels(){   //this one will sends back  the number for getstockLevels
        return this.stockLevels;
    }
    public String getSupplier(){   //this onewill sends back the string for getsupplier
        return this.supplier;
    }
    
    // this ones is setters methods they update data  they dont return  anything
    public void setProductCode(String newProductcode){  //it expects  text data to be passed into it
        this.productCode=newProductcode; //update  the object's permanent  product code variable with the new text received in the code
    }
    public void setProductName(String newproductName){  //change the name of the product using string input parameter
        this.productName=newproductName;
    }
    public void setWarranty(int newwarranty){
        this.warranty=newwarranty;
    }
    public void setCategory(int newcategory){
        this.category=newcategory;
    }
    public void setPrice(double newprice){
        this.price=newprice;     //update the object price variable with the value p
    }
    public void setStockLevels(int newstocklevel){
        this.stockLevels=newstocklevel;
    }
    public void setSupplier(String newsupplier){
        this.supplier=newsupplier;
    }  //closes the setsupplier method
}



