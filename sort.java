/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import static App.encoding.file;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Attr;
import java.util.Scanner;
import java.util.Arrays;
/**
 *
 * @author hgh
 */
public class sort {

    public static final String xmlFilePath = "H:\\year 4\\soa\\SOA_ASS\\terminal\\src\\App\\Books.xml";
    //public static final File file2 = new File(xmlFilePath);
    public static void sort_title(){try {
//creating a constructor of file class and parsing an XML file  
            File file = new File("H:\\year 4\\soa\\SOA_ASS\\terminal\\src\\App\\Books.xml");
//an instance of factory that gives a document builder  
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//an instance of builder to parse the specified xml file  
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            boolean flag = false;
            NodeList nodeList = doc.getElementsByTagName("Book");
            class book {

                String author;
                String title;
                String ID;
                String Gener;
                String price;
                String Publish_Date;
                String Description;
            };
            ArrayList<book> books = new ArrayList<book>();

            String [] a = new String[nodeList.getLength()];
            // nodeList is not iterable, so we are using for loop  
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    if (true) {
                        book n = new book();
                        n.Description = eElement.getElementsByTagName("Description").item(0).getTextContent();
                        n.Gener = eElement.getElementsByTagName("Genre").item(0).getTextContent();
                        n.ID = eElement.getAttribute("id").toString();
                        n.Publish_Date = eElement.getElementsByTagName("Publish_Date").item(0).getTextContent();
                        n.author = eElement.getElementsByTagName("Author").item(0).getTextContent();
                        n.price = eElement.getElementsByTagName("price").item(0).getTextContent();
                        n.title = eElement.getElementsByTagName("Title").item(0).getTextContent();
                        books.add(n);
                        a[itr] =eElement.getElementsByTagName("Author").item(0).getTextContent();
                       
                        

                    }
                }
            }
            
            
            
            //System.out.println(IDs.length);
          //  for(int i=0 ; i<IDs.length ; i++){
          //    System.out.println(a[i]);
          //  }
            String temp =null;
            System.out.println("sort ascending or descending");
            System.out.println("1- ascending ");
            System.out.println("2- descending");
            Scanner input = new Scanner(System.in).useDelimiter("\n");
            String b = input.nextLine();
            if(b.equals("1")){
            for (int i=0; i< a.length ; i++){
               for(int j= i+1 ; j<a.length ; j++){
                  if(a[i].compareTo(a[j])>0){
                   temp =a[i];
                   a[i]=a[j];
                   a[j]=temp;
                  }
                }
            }
         
            
            }
           else if(b.equals("2")){
              for (int i=0; i< a.length ; i++){
               for(int j= i+1 ; j<a.length ; j++){
                  if(a[i].compareTo(a[j])<0){
                  
                   temp =a[i];
                   a[i]=a[j];
                   a[j]=temp;
                  }
                }
            }
           }
            
             
            //IDs = IDs.revers();
            
            DocumentBuilderFactory documentFactory2 = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder2 = documentFactory2.newDocumentBuilder();
            Document document2 = documentBuilder2.newDocument();
            Element root = document2.createElement("catalog");
            document2.appendChild(root);
            for (int j = 0; j < a.length ; j++) {
                for(int i= 0 ; i< a.length ; i++ ){
                    if (books.get(i).author.equals(a[j])) {
                        System.out.println(books.get(j).ID);
                        Element book = document2.createElement("Book");
                        root.appendChild(book);
                        Attr attr = document2.createAttribute("id");
                        attr.setValue(books.get(j).ID);
                        System.out.println("ID" + books.get(j).ID);
                        book.setAttributeNode(attr);
                        Element author = document2.createElement("Author");
                        author.appendChild(document2.createTextNode(books.get(j).author));
                        book.appendChild(author);
                        System.out.println("Author" + books.get(j).author);
                        Element title = document2.createElement("Title");
                        title.appendChild(document2.createTextNode(books.get(j).title));
                        book.appendChild(title);
                        Element gener = document2.createElement("Genre");
                        gener.appendChild(document2.createTextNode(books.get(j).Gener));
                        book.appendChild(gener);
                        System.out.println("Gener" + books.get(j).Gener);
                        Element price = document2.createElement("price");
                        price.appendChild(document2.createTextNode(books.get(j).price));
                        book.appendChild(price);
                        System.out.println("price" + books.get(j).price);
                        Element Publish_Date = document2.createElement("Publish_Date");
                        Publish_Date.appendChild(document2.createTextNode(books.get(j).Publish_Date));
                        book.appendChild(Publish_Date);
                        System.out.println("Publish_Date" + books.get(j).Publish_Date);
                        Element Description = document2.createElement("Description");
                        Description.appendChild(document2.createTextNode(books.get(j).Description));
                        book.appendChild(Description);
                        System.out.println("Description" + books.get(j).Description);
                        TransformerFactory transformerFactory = TransformerFactory.newInstance();
                        Transformer transformer = transformerFactory.newTransformer();
                        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
                        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                        DOMSource domSource = new DOMSource(document2);
                        StreamResult streamResult = new StreamResult(new File(xmlFilePath));
                        transformer.transform(domSource, streamResult);

                    }

                }
            }
           

        } catch (Exception e) {
            e.printStackTrace();
        }
}
    public static void sort_file() {

        try {
//creating a constructor of file class and parsing an XML file  
            File file = new File("H:\\year 4\\soa\\SOA_ASS\\terminal\\src\\App\\Books.xml");
//an instance of factory that gives a document builder  
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//an instance of builder to parse the specified xml file  
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            boolean flag = false;
            NodeList nodeList = doc.getElementsByTagName("Book");
            class book {

                String author;
                String title;
                String ID;
                String Gener;
                String price;
                String Publish_Date;
                String Description;
            };
            ArrayList<book> books = new ArrayList<book>();

            String [] IDs = new String[nodeList.getLength()];
            // nodeList is not iterable, so we are using for loop  
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    if (true) {
                        book n = new book();
                        n.Description = eElement.getElementsByTagName("Description").item(0).getTextContent();
                        n.Gener = eElement.getElementsByTagName("Genre").item(0).getTextContent();
                        n.ID = eElement.getAttribute("id").toString();
                        n.Publish_Date = eElement.getElementsByTagName("Publish_Date").item(0).getTextContent();
                        n.author = eElement.getElementsByTagName("Author").item(0).getTextContent();
                        n.price = eElement.getElementsByTagName("price").item(0).getTextContent();
                        n.title = eElement.getElementsByTagName("Title").item(0).getTextContent();
                        books.add(n);
                        IDs[itr] = eElement.getAttribute("id").toString();
                       
                        

                    }
                }
            }
            int[] a= new int[IDs.length];
            for(int i=0 ; i< IDs.length ; i++){
                a[i]=Integer.parseInt(IDs[i]);
            }
            
            //System.out.println(IDs.length);
          //  for(int i=0 ; i<IDs.length ; i++){
          //    System.out.println(a[i]);
          //  }
            int temp =0;
            System.out.println("sort ascending or descending");
            System.out.println("1- ascending ");
            System.out.println("2- descending");
            Scanner input = new Scanner(System.in).useDelimiter("\n");
            String b = input.nextLine();
            if(b.equals("1")){
            for (int i=0; i< a.length ; i++){
               for(int j= i+1 ; j<a.length ; j++){
                  if(a[i]>a[j]){
                   temp =a[i];
                   a[i]=a[j];
                   a[j]=temp;
                  }
                }
            }
         
            
            }
           else if(b.equals("2")){
              for (int i=0; i< a.length ; i++){
               for(int j= i+1 ; j<a.length ; j++){
                  if(a[i]<a[j]){
                  temp = 0;
                   temp =a[i];
                   a[i]=a[j];
                   a[j]=temp;
                  }
                }
            }
           }
            String [] strArray = new String[a.length];
            for(int i=0 ; i< a.length ; i++){
            strArray[i] = String.valueOf(a[i]);
            }
             
            //IDs = IDs.revers();
            
            DocumentBuilderFactory documentFactory2 = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder2 = documentFactory2.newDocumentBuilder();
            Document document2 = documentBuilder2.newDocument();
            Element root = document2.createElement("catalog");
            document2.appendChild(root);
            for (int j = 0; j < strArray.length ; j++) {
                for(int i= 0 ; i< strArray.length ; i++ ){
                    if (books.get(i).ID.equals(strArray[j])) {
                        System.out.println(books.get(j).ID);
                        Element book = document2.createElement("Book");
                        root.appendChild(book);
                        Attr attr = document2.createAttribute("id");
                        attr.setValue(strArray[j]);
                        System.out.println("ID" + strArray[j]);
                        book.setAttributeNode(attr);
                        Element author = document2.createElement("Author");
                        author.appendChild(document2.createTextNode(books.get(j).author));
                        book.appendChild(author);
                        System.out.println("Author" + books.get(j).author);
                        Element title = document2.createElement("Title");
                        title.appendChild(document2.createTextNode(books.get(j).title));
                        book.appendChild(title);
                        Element gener = document2.createElement("Genre");
                        gener.appendChild(document2.createTextNode(books.get(j).Gener));
                        book.appendChild(gener);
                        System.out.println("Gener" + books.get(j).Gener);
                        Element price = document2.createElement("price");
                        price.appendChild(document2.createTextNode(books.get(j).price));
                        book.appendChild(price);
                        System.out.println("price" + books.get(j).price);
                        Element Publish_Date = document2.createElement("Publish_Date");
                        Publish_Date.appendChild(document2.createTextNode(books.get(j).Publish_Date));
                        book.appendChild(Publish_Date);
                        System.out.println("Publish_Date" + books.get(j).Publish_Date);
                        Element Description = document2.createElement("Description");
                        Description.appendChild(document2.createTextNode(books.get(j).Description));
                        book.appendChild(Description);
                        System.out.println("Description" + books.get(j).Description);
                        TransformerFactory transformerFactory = TransformerFactory.newInstance();
                        Transformer transformer = transformerFactory.newTransformer();
                        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
                        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                        DOMSource domSource = new DOMSource(document2);
                        StreamResult streamResult = new StreamResult(new File(xmlFilePath));
                        transformer.transform(domSource, streamResult);

                    }

                }
            }
           

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String argv[]) throws SAXException, IOException, ParserConfigurationException {
        sort_title();

    }
}
        
