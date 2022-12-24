/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package finalbp;
import  java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Diablo Scar
 */
public class FinalBP {
    private static int choice=0;
    private static Scanner input = new Scanner(System.in);
    static String [] listProd = {"Cilok", "Kebab Keju", "Kebab Singkong Keju", "Cireng", "Tahu Bakso"};
    static int [] listPrice = {12000, 20000, 22000, 15000, 23000};
    static int [] cart = new int [5];
    
    
    static void Homepg(){
    int cekvar = 0;
        System.out.println("Welcome to Frozen Agna Information System "
                + "\n=================" 
                + "\n1. Cashier\n2. Admin\n3. Owner");
        System.out.println("Please input your token (numeric only");        
        int User = input.nextInt();
        
    switch (User){
        case 1 -> choice = 1;
        case 2 -> choice = 2;
        case 3 -> choice = 3;
    }
    
    }
      static void Cashier(){ 
          System.out.println("Welcome, Cashier\n========================");
          System.out.println("Menu: ");          
          for (int i = 0; i < listProd.length; i++) {
              System.out.println((i+1)+ ". " + listProd[i] + "  " + listPrice[i] );              
          }
      }
          /*System.out.println("Menu:\n1. Cilok\n2. Kebab Keju\n3. Singkong Keju\n4. Cireng\n5. Tahu Bakso");
          
          int stop=0;
          //ArrayList ArrayCart;
          //ArrayCart = new ArrayList();
         ArrayList<String> cart = new ArrayList<String>();
                        
         System.out.println("Input your item(s) (numeric only)");
         cart.add(input.nextLine());
          do {
           // System.out.println("Number of string in array: " + cart.size());
            cart.add(input.nextLine());
            System.out.println("Input your next item \n(type 'end' if you finish)");
      // Display eveything in the list
          } while (!input.hasNext("end"));
        displayList(cart);  
      }
          
    
  
      static void displayList(ArrayList cart){
          for (int i = 0; i < cart.size(); i++) {
              System.out.println(cart.get(i));                 
          }
          System.out.println("Number of string in array: " + cart.size());
      }
      
         */
      
        static void Admin(){
          System.out.println("ADmin cek");
      }
        static void Owner(){
          System.out.println("Owner cek");
      }
          
    
    

    /**
     * @param args the command line arguments
     */
      
    public static void main(String[] args) {
        Homepg();
        if (choice==1) {
        Cashier();
        }else{
        if (choice==2){
        Admin();
        }else{
        Owner();
        }
        }
            
        
        //System.out.println(cekvar);
// TODO code application logic here
    }
}
    

