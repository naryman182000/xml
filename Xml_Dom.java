/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;
import java.io.File;
import java.io.IOException;
import static java.lang.System.in;
import java.text.ParseException;
import static java.time.Clock.system;
//import static java.time.InstantSource.system;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author DELL
 */
public class Xml_Dom {

    public static void main(String[] args) throws ParserConfigurationException, TransformerException, SAXException, IOException, ParseException {
        Book book = new Book();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         DocumentBuilder builder = factory.newDocumentBuilder();
        ReadXMLFileExample1 opj2=new ReadXMLFileExample1();

            while (true) {
                System.out.println("Choose what's you need");
                System.out.println("1- Add Books");
                System.out.println("2- Show data");
                System.out.println("3- search ");
                System.out.println("4- delete specific record");
                System.out.println("5- update");
                System.out.println("6- sort");
                System.out.println("7- break");
                // Print all employees.
                //scanner input = new scanner (system in). document("\n");
                Scanner input = new Scanner(System.in).useDelimiter("\n");
                int choose = input.nextInt();
                if (choose == 1) {
                    encoding add= new encoding();
                    add.addbook();
                } else if (choose == 2) {
                    opj2.view();
                } else if (choose == 3) {
                    
                    opj2.search();
                    
                }else if (choose == 4) {
                   RemoveElement opj=new RemoveElement();
                   System.out.println("Enter id: ");
                   String id = input.next();
                   opj.fainal_deletion(id);
                } else if (choose == 5) {

                   update up =new update();
                   up.update_attribute();
                }else if (choose == 6) {
                    sort s = new sort();
                    s.sort_file();
                }else if (choose == 7) {
                    break;
                } else {
                    System.out.println("Enter the correct number");
                }

            }
        }

    
}
