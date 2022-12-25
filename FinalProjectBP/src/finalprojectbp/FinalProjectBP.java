/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package finalprojectbp;
import java.util.Scanner;
/**
 *
 * @author Diablo Scar
 */
public class FinalProjectBP {
    
    //listProd menu
    static String listProd[] = {"Cilok", "Kebab", "Cotot", "Cireng", "Siomay"};
    static int listPrice[] = {12000, 20000, 22000, 15000, 23000};
    static int cart = 0,cartFind = 0 , portion=0, TotalPaid=0, index=0, idxfind=0;
    
    //Sorting
    static void SortBestSeller(String[] listProd, int[] listPrice, int[]  bestSell){
        int tInt;
        String tString;
        for (int i = 0; i < listProd.length - 1; i++) {
            if(bestSell[i] < bestSell[i+1]){
                tInt = bestSell[i];
                bestSell[i] = bestSell[i+1];
                bestSell[i+1] = tInt;
                tInt = listPrice[i];
                listPrice[i] = listPrice[i+1];
                listPrice[i+1] = tInt;
                tString = listProd[i];
                listProd[i] = listProd[i+1];
                listProd[i+1] = tString;
            }
        }
        for (int i = 0; i < listProd.length; i++) {
            System.out.println((i+1) + ". " + listProd[i] + " Rp " + listPrice[i] + " sold " + bestSell[i] + " times");
        }
    }
    //displayProd
    static void DisplayProd(){
        for (int i = 0; i < listProd.length; i++) {
            System.out.println((i+1)+". "+listProd[i]+"\t"+listPrice[i] );             
        }
    }
    //searchingProd
    static String[][] Find(String[] Fmenu, int Fharga[], String Fcari) {
            String[][] Fhasil = new String[15][2];
            for (int i = 0; i < listProd.length; i++) {
                if (Fmenu[i].contains(Fcari)) {
                    Fhasil[index][0] = Fmenu[i];
                    Fhasil[index][1] = String.valueOf(Fharga[i]);
                    idxfind = i;
                }
            }
            return Fhasil;
        }
    //addProd
    static String[] addData(String[] listProd, String newProd) {
        String result[] = new String[listProd.length + 1];
      
        for (int i = 0; i < listProd.length; i++) {
            result[i] = listProd[i];
        }

        result[listProd.length] = newProd;

        return result;
    }
    static int[] addPrice (int[] listPrice,int newPrice) {
        int result[] = new int[listPrice.length + 1];
        
        for (int i = 0; i < listPrice.length; i++) {
            result[i] = listPrice[i];
        }
        result[listPrice.length] = newPrice;
        return result;
    }
    
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int Mode = 0, Program = 0, auth=0, newPrice;
        boolean order = true;
        int moneyPaid = 0, moneyChange = 0;
        String username, password, newProd;
        String report[]={};
        int bestSell[]={0, 0, 0, 0, 0};
        
        System.out.println("Welcome to Frozen Agna Information System");
        System.out.println("===========================================");        
               
        
        do {
            System.out.println("1. Cashier\n2. Admin\n3. Owner\n4.Exit");        
            System.out.println("Please input your token (numeric only)"); 
            Mode = input.nextInt();
            switch (Mode){
                case 1 : //Cashier
                  
                    System.out.println("Welcome, Cashier!");
                    System.out.println("====================");                   
                        
                    while (order){
                    System.out.println("Choose Program \n1. Menu List \n2.Find Menu\n3.Exit");
                    Program = input.nextInt();
                   
                        if (Program==1) {

                            DisplayProd();
                            System.out.println("Choose your menu");                       
                            cart = input.nextInt();
                            System.out.println("Portion of menu");  
                            portion = input.nextInt();
                            TotalPaid += listPrice[cart-1]*portion;
                            bestSell[cart-1]=portion;
                            System.out.println("Order more?");
                            System.out.println("(yes/no)");                   
                            String decide = input.next();
                        if (decide.equals("yes")) {
                           order=true;
                        }
                        else if (decide.equals("no")){
                            break;
                        }
                        }
                        else if(Program==2){
                            System.out.println("Input your keyword"); 
                            String inputFind = input.next();
                            String[][] ResultFind = Find(listProd, listPrice, inputFind);
                            System.out.println("==========");

                                if (ResultFind[0][0]!=null) {
                                    System.out.println("Item found at number: ");                                
                                    System.out.println((idxfind+1) + ". " + ResultFind[0][0]+ "\t" +ResultFind[0][1]);
                                    System.out.println("Choose your menu");                       
                                    cart = input.nextInt();
                                    System.out.println("Portion of menu");  
                                    portion = input.nextInt();
                                    TotalPaid += listPrice[cart-1]*portion;   
                                    System.out.println("Order more?");
                                    System.out.println("(yes/no)");                   
                                    String decide = input.next();
                                        if (decide.equals("yes")) {
                                            order=true;
                                        }
                                        else if (decide.equals("no")){
                                            break;
                                            }
                                }
                                else {
                                    System.out.println("Item not found");  
                                    System.out.println("============");    
                                    System.out.println("Order more?");
                                    System.out.println("(yes/no)");                   
                                    String decide = input.next();
                                    if (decide.equals("yes")) {
                                        order=true;
                                    }
                                    else if (decide.equals("no")){
                                        break;
                                    }
                                }
                        }
                        else if(Program==3){
                        break;
                        }
                    }      
                    System.out.println("Amount you have to pay:");                    
                    System.out.println("Rp"+TotalPaid);
                    while(moneyPaid < TotalPaid) {
                                    System.out.print("Input your money: ");
                                    moneyPaid = input.nextInt();
                                    if(moneyPaid < TotalPaid){
                                        System.out.println("Your money is not enough.");
                                    } else {
                                        moneyChange = moneyPaid - TotalPaid;
                                        
                                        if(moneyChange > 0){
                                            System.out.println("Your change money is : Rp" + moneyChange);
                                        }
                                        report = addData(report, "Total Bayar Rp " + TotalPaid +  " Uang Pembeli Rp " + moneyPaid);
                                        System.out.println("Thank you very much");
                                        System.out.println("We look forward to serving you again!");                                        
                                        System.out.println("===========");                                        
                                        TotalPaid = 0;
                                        
                                    }
                                }                    
                break;
                case 2 : //Admin
                   System.out.println("Welcome, Admin");  
                    do {
                        Scanner s = new Scanner(System.in);
                        System.out.print("Enter username:");//username:admin
                        username = s.nextLine();
                        System.out.print("Enter password:");//password:Admin
                        password = s.nextLine();
                        if(username.equals("admin") && password.equals("Admin"))
                        {
                            System.out.println("Authentication Successful");
                            auth = 0;
                        }
                        else
                        {
                            System.out.println("Authentication Failed");
                            auth = 1;
                        }
                    } 
                    while (auth==1);
                    
                    System.out.println("============");    
                    while(Program!=5){
                    System.out.println("Choose Program\n1. Display Data\n2. Add Data\n3. Change Data\n4. Delete Data\n5. Exit");                    
                    Program = input.nextInt();
                    
                    switch(Program){
                        case 1:
                        DisplayProd();    
                        break;
                        
                        case 2:
                        System.out.println("Input your name of product: "); 
                        newProd=input.next();
                        System.out.println("Input your price of product: ");   
                        newPrice=input.nextInt();
                        listProd = addData(listProd, newProd);
                        listPrice= addPrice(listPrice, newPrice);
                        System.out.println("\nProduct Added");  
                        System.out.println("");                            
                        break;    
                        
                        case 3:
                        System.out.println("Input your keyword"); 
                        String inputFind = input.next();
                        String[][] ResultFind = Find(listProd, listPrice, inputFind);
                        if (ResultFind[0][0]!=null) {
                            System.out.println("Item found at number: ");                                
                            System.out.println((idxfind+1) + ". " + ResultFind[0][0]+ "\t" +ResultFind[0][1]); 
                            
                            System.out.println("Input your name of new product");                            
                            listProd[idxfind]=input.next();
                            System.out.println("Input your price of new product");                            
                            listPrice[idxfind]=input.nextInt();
                            System.out.println("Data successfully changed");  
                                }
                                else {
                                    System.out.println("Item not found");  
                                    System.out.println("============");    
                                   
                                }
                                                  
                        break;   
                        
                        case 4:
                        System.out.println("Input your keyword"); 
                        inputFind = input.next();
                        ResultFind = Find(listProd, listPrice, inputFind);
                        if (ResultFind[0][0]!=null) {
                            System.out.println("Item found at number: ");                                
                            System.out.println((idxfind+1) + ". " + ResultFind[0][0]+ "\t" +ResultFind[0][1]); 
                            for (int i = idxfind; i <listProd.length-1 ; i++) {
                                listProd[i]=listProd[i+1];
                                listPrice[i]=listPrice[i+1];
                                idxfind++;
                            }
                            listProd[idxfind]="null";
                            listPrice[idxfind]=0;
                            System.out.println("Data successfully deleted");   
                                }
                                else {
                                    System.out.println("Item not found");  
                                    System.out.println("============");    
                                   
                                }
                        break;
                        case 5:
                        break;
                            
                    }
                    }
                    
                                       
                break;
                case 3 : //Owner
                    System.out.println("Welcome, Owner");
                 do {
                        Scanner s = new Scanner(System.in);
                        System.out.print("Enter username:");//username:owner
                        username = s.nextLine();
                        System.out.print("Enter password:");//password:Owner
                        password = s.nextLine();
                        if(username.equals("owner") && password.equals("Owner"))
                        {
                            System.out.println("Authentication Successful");
                            auth = 0;
                        }
                        else
                        {
                            System.out.println("Authentication Failed");
                            auth = 1;
                        }
                    } 
                    while (auth==1); 
                 
                    System.out.println("============");    
                    while(Program!=3){
                    System.out.println("Choose Program\n1. Income Report\n2. Best Seller\n3. Exit");                    
                    Program = input.nextInt();
                    
                    switch(Program){
                        
                        case 1:
                            System.out.println("Report Income");                            
                            System.out.println("");                            
                            if (report.length>0) {
                                for (int i = 0; i < report.length; i++) {
                                    System.out.println((i+1)+". "+report[i]);                                    
                                }
                            }
                            else{
                                System.out.println("Report not found");                                
                            }
                            break;
                        case 2:
                            SortBestSeller(listProd, listPrice, bestSell);
                            break;
                        
                        case 3:
                            break;
                    }
                    }
                break;
                default : //Exit
                    System.out.println("Exiting program...");                    
                    System.out.println("Have a nice day!");                
           } 
        } while (Mode != 4);
    }
    
}
