/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

/**
 *
 * @author hgh
 */
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
import org.xml.sax.SAXException;

/**
 *
 * @author hgh
 */
public class encoding {

    public static final String xmlFilePath = "H:\\year 4\\soa\\SOA_ASS\\terminal\\src\\App\\Books.xml";
    public static final File file = new File(xmlFilePath);

    static void addbook() throws TransformerException, ParserConfigurationException, SAXException, IOException, ParseException {
        String ID, Author, Title, PrPublish, Desc, Gener;
        double Price;

        boolean ser;
        ReadXMLFileExample1 o = new ReadXMLFileExample1();
        validation v = new validation();
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        if (file.createNewFile()) {
            Document document = documentBuilder.newDocument();
            Element root = document.createElement("catalog");
            document.appendChild(root);
            System.out.println("enter the number of Books");
            Scanner input = new Scanner(System.in).useDelimiter("\n");
            int iter = input.nextInt();
            for (int i = 0; i < iter; i++) {
                Element book = document.createElement("Book");
                root.appendChild(book);
                System.out.println("enter the Book ID");
                ID = input.next();
                ID=v.checkNull(ID);

                if (i > 0) {
                   // ID=v.checkNull(ID);
                    System.out.println("enter Book Author");
                    Author = input.next();
                    Author=v.checkNull(Author);
                    Author=v.Check_AutherName(Author);


                    System.out.println("enter Book Title");
                    Title = input.next();
                    Title=v.checkNull(Title);
                    System.out.println("enter Book Gener");
                    Gener = input.next();
                    Gener=v.checkNull(Gener);
                    Gener=v.Check_Gener(Gener);
                    System.out.println("enter Book price");
                    Price = input.nextDouble();
                   Price= v.checkNull_dou(Price);
                    System.out.println("enter Book Publish_Date \"dd-mm-yyyy\"");
                    PrPublish = input.next();
                    PrPublish=v.checkNull(PrPublish);
                    PrPublish=v.checkDate(PrPublish);
                    System.out.println("enter the Book Description");
                    Desc = input.next();
                } else {
                    //System.out.println(ser);

                    System.out.println("enter Book Author");
                    Author = input.next();
                     Author=v.checkNull(Author);
                    Author=v.Check_AutherName(Author);
                   

                    System.out.println("enter Book Title");
                    Title = input.next();
                    Title=v.checkNull(Title);
                    System.out.println("enter Book Gener");
                    Gener = input.next();
                    Gener=v.checkNull(Gener);
                    Gener=v.Check_Gener(Gener);
                    System.out.println("enter Book price");
                    Price = input.nextDouble();
                    Price=v.checkNull_dou(Price);
                    System.out.println("enter Book Publish_Date \"dd-mm-yyyy\"");
                    PrPublish = input.next();
                    PrPublish=v.checkNull(PrPublish);
                    PrPublish=v.checkDate(PrPublish);
                    System.out.println("enter the Book Description");
                    Desc = input.next();

                }
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
        } else {
            Document document = documentBuilder.parse("H:\\year 4\\soa\\SOA_ASS\\terminal\\src\\App\\Books.xml");
            Element root = document.getDocumentElement();
            System.out.println("enter the number of Books");
            Scanner input = new Scanner(System.in).useDelimiter("\n");
            int iter = input.nextInt();
            for (int i = 0; i < iter; i++) {
                Element book = document.createElement("Book");
                root.appendChild(book);
                System.out.println("enter the Book ID");
                ID = input.next();
                ID=v.checkNull(ID);
                ser = o.search_ID(ID);
                //System.out.println(ser);
                if (ser == true) {
                    System.out.println("this id is already exist");
                    break;
                } else {
                    System.out.println("enter Book Author");
                    Author = input.next();
                    Author = v.checkNull(Author);
                    Author = v.Check_AutherName(Author);
                    System.out.println("enter Book Title");
                    Title = input.next();
                    Title = v.checkNull(Title);
                    System.out.println("enter Book Gener");
                    Gener = input.next();
                    Gener = v.checkNull(Gener);
                    Gener = v.Check_Gener(Gener);
                    System.out.println("enter Book fraction price");
                    Price = input.nextDouble();
                   // String s = Price +"";
                    Price = v.checkNull_dou(Price);
                    System.out.println("enter Book Publish_Date as \"dd-mm-yyyy\"");
                    PrPublish = input.next();
                    PrPublish = v.checkNull(PrPublish);
                    PrPublish = v.checkDate(PrPublish);
                    System.out.println("enter Book Description");
                    Desc = input.next();
                }
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
                String p = Price + " ";
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

        }

    }

    public static void main(String argv[]) throws TransformerException, ParserConfigurationException, SAXException, IOException, ParseException {
        addbook();

    }
}
