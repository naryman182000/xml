/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class validation {
        static String checkNull(String attr){
            Scanner input = new Scanner(System.in).useDelimiter("\n");
            if(attr == null || attr.isEmpty()){
                System.out.println("this attribute can not be impty");
                System.out.println("enter the value : ");
                attr = input.next();
                checkNull(attr);
                
            }
            return attr;
    }
        static double checkNull_dou(double attr){
        // Double a = new Double(attr);
         
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        Double a = attr;
      
        if(!a.isNaN() || attr != 0.0 || attr != 0){

        }
        else{
            System.out.println("this attribute can not be impty or zero");
            System.out.println("enter price : ");
            attr = input.nextDouble();
            checkNull_dou(attr);
        }
        return attr;
      
    }
        static String checkDate(String attr) throws ParseException {
         Scanner input = new Scanner(System.in).useDelimiter("\n");
           Date data = null ;
          
          SimpleDateFormat d = new SimpleDateFormat("dd-mm-yyyy");
          //d.setLenient(false);
          try{
          data = d.parse(attr);
          System.out.println("date:" + d.format(data));
          if(!attr.equals(d.format(data))){
            System.out.println("invalid format");
            System.out.println("enter Publish_Date as dd-mm-yyyy : ");
            attr = input.next();
            checkNull(attr);
           checkDate(attr);
          }
          }catch(ParseException e){
            System.out.println("invalid format");
            System.out.println("enter Publish_Date as dd-mm-yyyy : ");
            attr = input.next();
            checkNull(attr);
           checkDate(attr);
          
          }
          return attr;
        }
    static String Check_AutherName(String attr){
       
        boolean f;
        Scanner input = new Scanner(System.in).useDelimiter("\n");
            //attr = attr.trim();
            //char[] values = attr.toCharArray();
            for (int i = 0; i<attr.length(); i++) {
                f = Character.isDigit(attr.charAt(i));
                if(f){
                    System.out.println("NOT VALID! Enter Author name form(a-z) digit not valid : ");
                    attr = input.next();
                    checkNull(attr);
                    Check_AutherName(attr);
                    
                }    }
            return attr;
        }
        static String Check_Gener(String attr){
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        attr = attr.trim();
        char[] values = attr.toCharArray();
       
           if( attr.contains("science")|| attr.contains("fiction") || attr.contains("Drama")){
             
           }else{
       
        System.out.println("NOT VALID! it should be from this feild(science,fiction,Drama) Enter what you need:");
        attr = input.next();
        checkNull(attr);
        Check_Gener(attr);
           }
           return attr;
            
        }
}
