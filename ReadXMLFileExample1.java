/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

/**
 *
 * @author hgh
 */
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*; 
import javax.xml.transform.dom.DOMSource; 
import javax.xml.transform.stream.StreamResult;


public class ReadXMLFileExample1 {

    static void view() {
        try {
//creating a constructor of file class and parsing an XML file  
            File file = new File("H:\\year 4\\soa\\SOA_ASS\\terminal\\src\\App\\Books.xml");
//an instance of factory that gives a document builder  
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//an instance of builder to parse the specified xml file  
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            boolean flag=false;
            NodeList nodeList = doc.getElementsByTagName("Book");
            // nodeList is not iterable, so we are using for loop  
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    if (true) {
                        System.out.println("Author: " + eElement.getElementsByTagName("Author").item(0).getTextContent());
                        System.out.println("Title: " + eElement.getElementsByTagName("Title").item(0).getTextContent());
                        System.out.println("Genre: " + eElement.getElementsByTagName("Genre").item(0).getTextContent());
                        System.out.println("price: " + eElement.getElementsByTagName("price").item(0).getTextContent());
                        System.out.println("Publish_Date: " + eElement.getElementsByTagName("Publish_Date").item(0).getTextContent());
                        System.out.println("Description: " + eElement.getElementsByTagName("Description").item(0).getTextContent());
                        flag=true;
                    }
                }
            }
            if(flag == false){System.out.println("Book not found");}
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
        static boolean search_ID(String ID) {
             boolean flag=false;
        try {
//creating a constructor of file class and parsing an XML file  
            File file = new File("H:\\year 4\\soa\\SOA_ASS\\terminal\\src\\App\\Books.xml");
//an instance of factory that gives a document builder  
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//an instance of builder to parse the specified xml file  
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            
            NodeList nodeList = doc.getElementsByTagName("Book");
            // nodeList is not iterable, so we are using for loop  
           
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    if (eElement.getAttribute("id").equals(ID)) {
                     System.out.println("Author: " + eElement.getElementsByTagName("Author").item(0).getTextContent());
                        System.out.println("Title: " + eElement.getElementsByTagName("Title").item(0).getTextContent());
                        System.out.println("Genre: " + eElement.getElementsByTagName("Genre").item(0).getTextContent());
                        System.out.println("price: " + eElement.getElementsByTagName("price").item(0).getTextContent());
                        System.out.println("Publish_Date: " + eElement.getElementsByTagName("Publish_Date").item(0).getTextContent());
                        System.out.println("Description: " + eElement.getElementsByTagName("Description").item(0).getTextContent());
                         flag=true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;

    }        
        static Node search_ID_node(String ID) {
             boolean flag=false;
             Node n = null;
        try {
//creating a constructor of file class and parsing an XML file  
            File file = new File("H:\\year 4\\soa\\SOA_ASS\\terminal\\src\\App\\Books.xml");
//an instance of factory that gives a document builder  
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//an instance of builder to parse the specified xml file  
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            
            NodeList nodeList = doc.getElementsByTagName("Book");
            // nodeList is not iterable, so we are using for loop  
           
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    if (eElement.getAttribute("id").equals(ID)) {
                        
                        n = node;
                         flag=true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
     return n; 
    }

   
    static void search() {
        System.out.println("1- search by Title");
        System.out.println("2- search by Author");
        System.out.println("3- search by Description");
        System.out.println("4- search by gener");
        System.out.println("5- search by id");
        System.out.println("6- search by price");
        System.out.println("7- search by Publish_Date");
        System.out.println("8- back");
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        int choice = input.nextInt();
        if (choice == 1) {
            search_title();
        } else if (choice == 2) {
            search_author();
        } else if (choice == 3) {
            search_Description();
        } else if (choice == 4) {
            search_gener();
        } else if (choice == 5) {
            System.out.println("enter the book id");
            String ID = input.next();
            search_ID(ID);
        } else if (choice == 6) {
            search_price();
        } else if (choice == 7) {
            search_Publish_Date();
        }
        else{
            System.out.println("back to main list");
        }

    }

    static void search_title() {
        try {
//creating a constructor of file class and parsing an XML file  
            File file = new File("H:\\year 4\\soa\\SOA_ASS\\terminal\\src\\App\\Books.xml");
//an instance of factory that gives a document builder  
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//an instance of builder to parse the specified xml file  
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            System.out.print("Enter the Title: ");
            Scanner input = new Scanner(System.in).useDelimiter("\n");
            String title = input.next();
            NodeList nodeList = doc.getElementsByTagName("Book");
            // nodeList is not iterable, so we are using for loop  
            boolean flag = false;
            int counter=0;
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    if (eElement.getElementsByTagName("Title").item(0).getTextContent().toString().equalsIgnoreCase(title)) {
                        System.out.println("Author: " + eElement.getElementsByTagName("Author").item(0).getTextContent());
                        System.out.println("Title: " + eElement.getElementsByTagName("Title").item(0).getTextContent());
                        System.out.println("Genre: " + eElement.getElementsByTagName("Genre").item(0).getTextContent());
                        System.out.println("price: " + eElement.getElementsByTagName("price").item(0).getTextContent());
                        System.out.println("Publish_Date: " + eElement.getElementsByTagName("Publish_Date").item(0).getTextContent());
                        System.out.println("Description: " + eElement.getElementsByTagName("Description").item(0).getTextContent());
                        flag = true;
                        counter++;

                    }
                }
            }System.out.println("number of Books founded="+counter);
            if (flag == false) {
                System.out.println("Book not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void search_Description() {
       try {
//creating a constructor of file class and parsing an XML file  
            File file = new File("H:\\year 4\\soa\\SOA_ASS\\terminal\\src\\App\\Books.xml");
//an instance of factory that gives a document builder  
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//an instance of builder to parse the specified xml file  
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            System.out.print("Enter the Description: ");
            Scanner input = new Scanner(System.in).useDelimiter("\n");
            String Description = input.next();
            boolean flag= false;
            int counter =0;
            NodeList nodeList = doc.getElementsByTagName("Book");
            // nodeList is not iterable, so we are using for loop  
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    if (eElement.getElementsByTagName("Description").item(0).getTextContent().toString().equalsIgnoreCase(Description)) {
                        System.out.println("Author: " + eElement.getElementsByTagName("Author").item(0).getTextContent());
                        System.out.println("Title: " + eElement.getElementsByTagName("Title").item(0).getTextContent());
                        System.out.println("Genre: " + eElement.getElementsByTagName("Genre").item(0).getTextContent());
                        System.out.println("price: " + eElement.getElementsByTagName("price").item(0).getTextContent());
                        System.out.println("Publish_Date: " + eElement.getElementsByTagName("Publish_Date").item(0).getTextContent());
                        System.out.println("Description: " + eElement.getElementsByTagName("Description").item(0).getTextContent());
                        flag= true;
                        counter++;
                    }
                }
            }System.out.println("number of Books founded="+counter);
            if(flag== false){System.out.println("item not fond!");}
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void search_price() {
        try {
//creating a constructor of file class and parsing an XML file  
            File file = new File("H:\\year 4\\soa\\SOA_ASS\\terminal\\src\\App\\Books.xml");
//an instance of factory that gives a document builder  
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//an instance of builder to parse the specified xml file  
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            System.out.print("Enter the price: ");
            Scanner input = new Scanner(System.in).useDelimiter("\n");
            String price = input.next();
            int counter=0;
            NodeList nodeList = doc.getElementsByTagName("Book");
            // nodeList is not iterable, so we are using for loop
            boolean flag= false;
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    if (eElement.getElementsByTagName("price").item(0).getTextContent().toString().equalsIgnoreCase(price)) {
                        System.out.println("Author: " + eElement.getElementsByTagName("Author").item(0).getTextContent());
                        System.out.println("Title: " + eElement.getElementsByTagName("Title").item(0).getTextContent());
                        System.out.println("Genre: " + eElement.getElementsByTagName("Genre").item(0).getTextContent());
                        System.out.println("price: " + eElement.getElementsByTagName("price").item(0).getTextContent());
                        System.out.println("Publish_Date: " + eElement.getElementsByTagName("Publish_Date").item(0).getTextContent());
                        System.out.println("Description: " + eElement.getElementsByTagName("Description").item(0).getTextContent());
                        flag= true;
                        counter++;
                    }
                }
            }System.out.println("number of Books founded="+counter);
            if(flag== false){System.out.println("item not fond!");}
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void search_Publish_Date() {
        try {
//creating a constructor of file class and parsing an XML file  
            File file = new File("H:\\year 4\\soa\\SOA_ASS\\terminal\\src\\App\\Books.xml");
//an instance of factory that gives a document builder  
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//an instance of builder to parse the specified xml file  
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            System.out.print("Enter the Publish_Date: ");
            Scanner input = new Scanner(System.in).useDelimiter("\n");
            String Publish_Date = input.next();
            boolean flag= false;
            int counter=0;
            NodeList nodeList = doc.getElementsByTagName("Book");
            // nodeList is not iterable, so we are using for loop  
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    if (eElement.getElementsByTagName("Publish_Date").item(0).getTextContent().toString().equalsIgnoreCase(Publish_Date)) {
                        System.out.println("Author: " + eElement.getElementsByTagName("Author").item(0).getTextContent());
                        System.out.println("Title: " + eElement.getElementsByTagName("Title").item(0).getTextContent());
                        System.out.println("Genre: " + eElement.getElementsByTagName("Genre").item(0).getTextContent());
                        System.out.println("price: " + eElement.getElementsByTagName("price").item(0).getTextContent());
                        System.out.println("Publish_Date: " + eElement.getElementsByTagName("Publish_Date").item(0).getTextContent());
                        System.out.println("Description: " + eElement.getElementsByTagName("Description").item(0).getTextContent());
                        flag=true;
                        counter++;
                    }
                }
            }System.out.println("number of Books founded="+counter);
            if(flag== false){System.out.println("item not fond!");}
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void search_gener() {
       try {
//creating a constructor of file class and parsing an XML file  
            File file = new File("H:\\year 4\\soa\\SOA_ASS\\terminal\\src\\App\\Books.xml");
//an instance of factory that gives a document builder  
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//an instance of builder to parse the specified xml file  
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            System.out.print("Enter the Genre: ");
            Scanner input = new Scanner(System.in).useDelimiter("\n");
            String Genre = input.next();
            NodeList nodeList = doc.getElementsByTagName("Book");
            boolean flag =false;
            int counter=0;
            // nodeList is not iterable, so we are using for loop  
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    if (eElement.getElementsByTagName("Genre").item(0).getTextContent().toString().equalsIgnoreCase(Genre)) {
                        System.out.println("Author: " + eElement.getElementsByTagName("Author").item(0).getTextContent());
                        System.out.println("Title: " + eElement.getElementsByTagName("Title").item(0).getTextContent());
                        System.out.println("Genre: " + eElement.getElementsByTagName("Genre").item(0).getTextContent());
                        System.out.println("price: " + eElement.getElementsByTagName("price").item(0).getTextContent());
                        System.out.println("Publish_Date: " + eElement.getElementsByTagName("Publish_Date").item(0).getTextContent());
                        System.out.println("Description: " + eElement.getElementsByTagName("Description").item(0).getTextContent());
                        flag=true;
                        counter++;
                    }
                }
            }System.out.println("number of Books founded="+counter);
            if(flag== false){System.out.println("item not fond!");}
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void search_author() {
        try {
//creating a constructor of file class and parsing an XML file  
            File file = new File("H:\\year 4\\soa\\SOA_ASS\\terminal\\src\\App\\Books.xml");
//an instance of factory that gives a document builder  
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//an instance of builder to parse the specified xml file  
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            System.out.print("Enter the author: ");
            Scanner input = new Scanner(System.in).useDelimiter("\n");
            String Author = input.next();
            boolean flag= false;
            int counter=0;
            NodeList nodeList = doc.getElementsByTagName("Book");
            // nodeList is not iterable, so we are using for loop  
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    if (eElement.getElementsByTagName("Author").item(0).getTextContent().toString().equalsIgnoreCase(Author)) {
                        System.out.println("Author: " + eElement.getElementsByTagName("Author").item(0).getTextContent());
                        System.out.println("Title: " + eElement.getElementsByTagName("Title").item(0).getTextContent());
                        System.out.println("Genre: " + eElement.getElementsByTagName("Genre").item(0).getTextContent());
                        System.out.println("price: " + eElement.getElementsByTagName("price").item(0).getTextContent());
                        System.out.println("Publish_Date: " + eElement.getElementsByTagName("Publish_Date").item(0).getTextContent());
                        System.out.println("Description: " + eElement.getElementsByTagName("Description").item(0).getTextContent());
                        flag= true;
                        counter++;
                    }
                }
            }System.out.println("number of Books founded="+counter);
            if(flag== false){System.out.println("item not fond!");}
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String argv[]) throws SAXException, IOException, ParserConfigurationException {
        search_Description();
        search();

    }
}
