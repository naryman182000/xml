/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import static App.encoding.xmlFilePath;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author DELL
 */
public class update {

    public static final String xmlFilePath = "H:\\year 4\\soa\\SOA_ASS\\terminal\\src\\App\\Books.xml";
    //public static final File file = new File(xmlFilePath);

    static void add_one_book(String ID, String Author, String Title, String Gener, String Price, String PrPublish, String Desc) throws ParserConfigurationException, TransformerConfigurationException, TransformerException, SAXException, IOException {
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        RemoveElement r = new RemoveElement();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        Document document = documentBuilder.parse("H:\\year 4\\soa\\SOA_ASS\\terminal\\src\\App\\Books.xml");
        Element root = document.getDocumentElement();
        Element book = document.createElement("Book");
        root.appendChild(book);
        //System.out.println(ser);
        Attr attr = document.createAttribute("id");
        attr.setValue(ID);

        book.setAttributeNode(attr);
        Element author = document.createElement("Author");

        author.appendChild(document.createTextNode(Author));
        book.appendChild(author);
        Element title = document.createElement("Title");

        title.appendChild(document.createTextNode(Title));
        book.appendChild(title);
        Element gener = document.createElement("Genre");

        gener.appendChild(document.createTextNode(Gener));
        book.appendChild(gener);
        Element price = document.createElement("price");
        String p = Price + "";
        price.appendChild(document.createTextNode(p));
        book.appendChild(price);
        Element Publish_Date = document.createElement("Publish_Date");

        Publish_Date.appendChild(document.createTextNode(PrPublish));
        book.appendChild(Publish_Date);
        Element Description = document.createElement("Description");

        Description.appendChild(document.createTextNode(Desc));
        book.appendChild(Description);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File(xmlFilePath));

        transformer.transform(domSource, streamResult);
    }

    static void update_attribute() throws TransformerException, ParserConfigurationException, SAXException, IOException, ParseException {
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        RemoveElement r = new RemoveElement();
        validation v = new validation();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();
        Element book = document.createElement("Book");

        Scanner input = new Scanner(System.in).useDelimiter("\n");
        ReadXMLFileExample1 o = new ReadXMLFileExample1();
        String Id;
        int choose;
        String id, au, tit, pri, des, gen, data;
        boolean search;
        Node node = null;
        System.out.println("Enter update book ID:");
        Id = input.next();
        Id = v.checkNull(Id);
        search = o.search_ID(Id);
        if (search == false) {
            System.out.println("this id is not exist");
            System.out.println("you wont to add it");
            System.out.println("1- yes");
            System.out.println("2- no");
            choose = input.nextInt();
            if (choose == 1) {
                encoding add = new encoding();
                add.addbook();
            }
        } else {
            node = o.search_ID_node(Id);
            Element eElement = (Element) node;
           /* System.out.println("id :" + eElement.getAttribute("id"));
            System.out.println("Author: " + eElement.getElementsByTagName("Author").item(0).getTextContent());
            System.out.println("Title: " + eElement.getElementsByTagName("Title").item(0).getTextContent());
            System.out.println("Genre: " + eElement.getElementsByTagName("Genre").item(0).getTextContent());
            System.out.println("price: " + eElement.getElementsByTagName("price").item(0).getTextContent());
            System.out.println("Publish_Date: " + eElement.getElementsByTagName("Publish_Date").item(0).getTextContent());
            System.out.println("Description: " + eElement.getElementsByTagName("Description").item(0).getTextContent());
*/
            id = eElement.getAttribute("id");
            au = eElement.getElementsByTagName("Author").item(0).getTextContent();
            tit = eElement.getElementsByTagName("Title").item(0).getTextContent();
            gen = eElement.getElementsByTagName("Genre").item(0).getTextContent();
            pri = eElement.getElementsByTagName("price").item(0).getTextContent();
            data = eElement.getElementsByTagName("Publish_Date").item(0).getTextContent();
            des = eElement.getElementsByTagName("Description").item(0).getTextContent();
            r.fainal_deletion(id);
            System.out.println("CHOOSE UPDATE ELEMENT");
            System.out.println("1- Author");
            System.out.println("2- Title");
            System.out.println("3- Genre");
            System.out.println("4- price");
            System.out.println("5- Publish_Date");
            System.out.println("6- Description");
            System.out.println("7- change all item");
            
            choose = input.nextInt();
            if (choose == 1) {
                System.out.println("Enter update name");
                String name = input.next();
                name =v.checkNull(name);
                name= v.Check_AutherName(name);

                add_one_book(id, name, tit, gen, pri, data, des);

            } else if (choose == 2) {
                System.out.println("Enter update title");
                String name = input.next();
                 //name = input.next();
                name=v.checkNull(name);
                add_one_book(id, au, name, gen, pri, data, des);

            } else if (choose == 3) {
                System.out.println("Enter update genre");
                String name = input.next();
                  name=v.checkNull(name);
                  name=v.Check_Gener(name);
                add_one_book(id, au, tit, name, pri, data, des);                

            } else if (choose == 4) {
                System.out.println("Enter update price");
                double name = input.nextDouble();
                name = v.checkNull_dou(name);
                String n = name +" ";
                add_one_book(id, au, tit, gen, n, data, des);                

            } else if (choose == 5) {
                System.out.println("Enter update publish date \"dd-mm-yyyy\"");
                String name = input.next();
                name=v.checkNull(name);
                 name= v.checkDate(name);
                add_one_book(id, au, tit, gen, pri, name, des);                

            } else if (choose == 6) {
                System.out.println("Enter update Description");
                String name = input.next();
                add_one_book(id, au, tit, gen, pri, data, name);                

            }else if (choose == 7) {
                
                
                System.out.println("Enter update Author");
                String a = input.next();
                a=v.checkNull(a);
                 a=  v.checkDate(a);
                System.out.println("Enter update title");
                String t = input.next();
                t=v.checkNull(t);
                 t=  v.checkDate(t);
                System.out.println("Enter update genre");
                String g = input.next();
                g=v.checkNull(g);
                 g=  v.checkDate(g);
                System.out.println("Enter update price");
                double p = input.nextDouble();
                p=v.checkNull_dou(p);
                String n = p +" ";
                System.out.println("Enter update publish date \"dd-mm-yyyy\"");
                String pd = input.next();
                pd=v.checkNull(pd);
                pd=v.checkDate(pd);
                System.out.println("Enter update Description");
                String d = input.next();
                add_one_book(id, a, t, g, n, pd, d);                

            } 
            else {
                System.out.println("not vaild");
            }
        }
    }
}
