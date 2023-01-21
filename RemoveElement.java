/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

/**
 *
 * @author hgh
 */
import java.io.*;
import java.util.Scanner;
import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.parsers.*;
import javax.xml.transform.*; 
import javax.xml.transform.dom.DOMSource; 
import javax.xml.transform.stream.StreamResult;

public class RemoveElement {
    public static Node delete(NodeList nodeList , String id){
         Scanner input = new Scanner(System.in).useDelimiter("\n");
                   boolean flag= false; 
                    Node del = null;
                    for (int i = 0; i < nodeList.getLength(); i++) {
                        Node node = nodeList.item(i);
                        if (node.getNodeType() == Node.ELEMENT_NODE) {
                            Element v = (Element) node;
                            String ID = v.getAttributes().getNamedItem("id").getNodeValue();
                            if (id.equals(ID)) {
                                flag = true;
                                   del = node;
                                   System.out.println("delete sucessful");
                                   break;
                            }
                        }

                    }if(flag == false){
                       System.out.println("Not Found");
                    }
                    return del;
    }
  public static void StoreData(Document document , Node del) throws TransformerException{
                    document.getDocumentElement().removeChild(del);
                    File f = new File("H:\\year 4\\soa\\SOA_ASS\\terminal\\src\\App\\Books.xml");
                    DOMSource source = new DOMSource(document);
                    Result result =new StreamResult(f);
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    transformer.transform(source, result); 
                    
    }
   public static void fainal_deletion(String id){
         try {
//creating a constructor of file class and parsing an XML file  
            File file = new File("H:\\year 4\\soa\\SOA_ASS\\terminal\\src\\App\\Books.xml");
//an instance of factory that gives a document builder  
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse("H:\\year 4\\soa\\SOA_ASS\\terminal\\src\\App\\Books.xml");
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("Book");
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer tFormer = tFactory.newTransformer();
            // nodeList is not iterable, so we are using for loop  
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);
                Node N= delete(nodeList , id);
                StoreData(doc,N);
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

   }
}