import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.*;



class MainMethod{
    /**Main*/
    public static void main(String[] args){
        
        boolean exitVal = false;                    //Exit value for peaceful end of program
        Scanner in = new Scanner(System.in);        //Scanner - will be used throughout and passed
        int selection;                              //Selection - for menu item selection.

        do{//exitVal = 5

            mainMenu();                             //Print Main Menu
            selection = in.nextInt();               //get user selection

            switch(selection){
                case 1: {
                    //Browse a catalog
                    selectCatalog(in, 1);
                    break;
                }
                case 2: {
                    //Search a catalog
                    selectCatalog(in, 2);
                    break;
                }
                case 3: {
                    //Browse a profile
                    break;
                }
                case 4: {
                    //Search a profile
                    break;
                }
                case 5: {
                    System.out.println("Exiting program");
                    exitVal = true;
                    break;
                }
                default: {
                    System.out.println("Please make a valid selection.");
                    break;
                }
            }
            
        }while(!exitVal);
        
        
    }

    /** 
     * Prints main menu for program  
     */
    public static void mainMenu(){
        System.out.println("Please make a selection: \n");
        System.out.println("1.  Browse a catalog");
        System.out.println("2.  Search a catalog");
        System.out.println("3.  Browse a profile");
        System.out.println("4.  Search a profile");
        System.out.println("5.  Quit");
    }

    /**
     * Allows user to select which catalog they wish to either browse or search
     * @param in This is the Scanner object
     */
    public static int selectCatalog(Scanner in, int b1s2){
        //Strings representing files of catalogs
        String NISTRev4Catalog = "C:\\Users\\ingrid.foehrkolb\\JDK\\VSCode Workspace\\OSCAL-1.0.0-milestone2\\OSCAL-1.0.0-milestone2\\content\\nist.gov\\SP800-53\\rev4\\xml\\NIST_SP-800-53_rev4_catalog.xml";
        String FedRAMPCatalog = "C:\\Users\\ingrid.foehrkolb\\JDK\\VSCode Workspace\\OSCAL-1.0.0-milestone2\\OSCAL-1.0.0-milestone2\\content\\fedramp.gov\\xml\\FedRAMP_catalog.xml";

        String selectedCatalog = "";                                //Will hold String value for whichever catalog file is selected
        int selection;                                              //Will hold menu selection value
        boolean exitVal = false;                                    //Sets exitVal to false so user must enter valid value for menu

        do{//exitVal = 3

            //Catalog Menu
            System.out.println("Please select a catalog:\n");
            System.out.println("1.  NIST SP800-53 Rev4 catalog");
            System.out.println("2.  FedRAMP catalog");
            System.out.println("3.  Go back");
            System.out.print("Selection:  ");

            selection = in.nextInt();                                 //Input selection

            //Processing selection
            switch(selection){
                case 1:{
                    //NIST SP800-53 Rev 4 selected
                    selectedCatalog = NISTRev4Catalog;
                    exitVal = true;
                    break;
                }
                case 2:{
                    //FedRAMP catalog selected
                    selectedCatalog = FedRAMPCatalog;
                    exitVal = true;
                    break;
                }
                case 3:{
                    //Back 
                    exitVal = true;
                    System.out.println("Going back...");
                    return 0;
                }
                default:{
                    System.out.println("Please make a valid selection.");
                    exitVal = false;
                    break;
                }
            }


        }while(!exitVal);

        //This will direct to next method (browse or search) based on b1s2.
        //if b1s2 == 1, the user wants to browse the catalog.
        //if b1s2 == 2, the user wants to search the catalog.
        if(b1s2 == 1){
            //browse
            browseCatalog(selectedCatalog)
            return 0;
        } else if(b1s2 == 2){
            //search
            return 0;
        } else {
            System.out.println("Something went wrong!");
            System.out.println("Returning to main menu...");
            return 1;
        }

    }

    public static void browseCatalog(String fileName){
        //Get Document Builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        //Build Document
        Document document = builder.parse(new File(fileName));
        
        //Normalize the XML Structure; It's just too important !!
        document.getDocumentElement().normalize();
        
        //Here comes the root node
        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());
        
        //Get all employees
        NodeList groupList = document.getElementsByTagName("group");
        System.out.println("============================");
        
        for (int temp = 0; temp < groupList.getLength(); temp++)
        {
        Node groupNode = groupList.item(temp);
        System.out.println("");    //Just a separator
        if (groupNode.getNodeType() == Node.ELEMENT_NODE)
        {
            //Print each employee's detail
            Element groupElement = (Element) node;
            System.out.println("Employee id : "    + groupElement.getAttribute("id"));
            
        }
        }
    }

   
}