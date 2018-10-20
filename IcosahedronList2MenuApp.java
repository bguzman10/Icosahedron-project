import java.util.Scanner;
import java.io.FileNotFoundException;

/**
* Program designed to create menu for Icosahedron list.
* Proj 06
* @author Benjamin Guzman COMP 1210 012
* @version 10/9/18
*/
public class IcosahedronList2MenuApp {
   /**
     *Main method.
     *
     *@param args not used.
     *@throws FileNotFoundException error for file not found.
     */
   public static void main(String[] args) throws FileNotFoundException {
      Scanner input = new Scanner(System.in);
      String icosListName = "";
      Icosahedron[] myList = new Icosahedron[100];
      IcosahedronList2 icosList = new IcosahedronList2(icosListName, myList, 0);
      String code = "";
      
      System.out.println("Icosahedron List System Menu" 
            + "\nR - Read File and Create Icosahedron List"
            + "\nP - Print Icosahedron List"
            + "\nS - Print Summary"
            + "\nA - Add Icosahedron"
            + "\nD - Delete Icosahedron"
            + "\nF - Find Icosahedron"
            + "\nE - Edit Icosahedron"
            + "\nQ - Quit");
      do {
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
         code = input.nextLine();
         if (code.length() == 0) {
            continue;
         }
         code = code.toUpperCase();
         char choice = code.charAt(0);
         switch (choice) {
            case 'R' :
               System.out.print("\tFile name: ");
               String fileName = new String(input.nextLine());
               icosList.readFile(fileName);
               System.out.println("\tFile read in and "
                  + "Icosahedron List created");
               System.out.println();
               break;
            
            case 'P' : 
               System.out.println(icosList);
               break;
            
            case 'S' :
               System.out.println("\n" + icosList.summaryInfo() + "\n");
               break;
            
            case 'A' : 
               String labelIn = "";
               String colorIn = "";
               double edgeIn = 0;
               System.out.print("\tLabel: ");
               labelIn = input.nextLine();
               System.out.print("\tColor: ");
               colorIn = input.nextLine();
               System.out.print("\tEdge: ");
               edgeIn = Double.parseDouble(input.nextLine());
               icosList.addIcosahedron(labelIn, colorIn, edgeIn);
               System.out.println("\t*** Icosahedron added ***\n");
               break;
            
            case 'D' : 
               String label = "";
               System.out.print("\tLabel: ");
               label = input.nextLine();
               if (icosList.findIcosahedron(label) != null) {
                  icosList.deleteIcosahedron(label);
                  label = label.toUpperCase();
                  char c = label.charAt(0);
                  label = label.substring(1).toLowerCase();
                  label = c + label;
                  System.out.println("\t\"" + label + "\" deleted");
                  System.out.println();
               }
               else {
                  System.out.println("\t\"" + label + "\" not found");
                  System.out.println();
               }
               break;   
            case 'F' :
               System.out.print("\tLabel: ");
               labelIn = input.nextLine();
               if (icosList.findIcosahedron(labelIn) == null) {
                  System.out.println("\t\"" + labelIn + "\" not found");
                  System.out.println("");
               }
               else {
                  System.out.println(icosList.
                                     findIcosahedron(labelIn).toString());
                  System.out.println("");
               }
               break;
               
            case 'E' : 
               System.out.print("\tLabel: ");
               labelIn = input.nextLine();       
               System.out.print("\tColor: ");
               colorIn = input.nextLine();               
               System.out.print("\tEdge: ");
               edgeIn = Double.parseDouble(input.nextLine());
               if (icosList.findIcosahedron(labelIn) == null) {
                  System.out.println("\t\"" + labelIn + "\" not found");
                  System.out.println("");
               }
               else {
                  icosList.editIcosahedron(labelIn, colorIn, edgeIn);
                  System.out.println("\t\""
                     + labelIn + "\" successfully edited");
                  System.out.println("");
               }
               break;
               
            case 'Q' :
               break;
               
            default :
               System.out.println("\t*** invalid code ***\n");
         }
      } while (!code.equalsIgnoreCase("Q"));
   }

}