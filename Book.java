/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Book {

    private String ID;
    private String Author;
    private String Title;
    private String Genre;
    private double price;
    private String Publish_Date;
    private String Description;

    public Book(String ID, String Author, String Title, String Genre, double price, String Publish_Date, String Description) {
        this.ID = ID;
        this.Author = Author;
        this.Title = Title;
        this.Genre = Genre;
        this.price = price;
        this.Publish_Date = Publish_Date;
        this.Description = Description;

    }

    Book() {
    }

    public void AddBook() {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter Books number You will add");
        int num = input.nextInt();
        for (int j = 0; j < num; j++) {
            System.out.print("ID :");
            String IDNum = input.next();
            System.out.print("Auother :");
            String Auo = input.next();
            System.out.print("Title :");
            String Title = input.next();
            System.out.print("Genre :");
            String Gen = input.next();
            System.out.print("Price :");
            double P = input.nextDouble();
            System.out.print("Publish Date :");
            String PD = input.next();
            System.out.print("Description :");
            String Des = input.next();

        }
    }

    @Override
    public String toString() {
        return "<" + "ID: " + ID + ", " + " Author: " + Author + ", " + "Title: " + Title + ", " + "Genre: " + Genre + ", " + "price: " + price + ", " + "Publish_Date: " + Publish_Date + ", " + "Description: " + Description + ">";
    }

}
