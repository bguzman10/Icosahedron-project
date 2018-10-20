import java.text.DecimalFormat;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

/**
 * Program that creates list of icosahedrons.
 * @author: Benjamin Guzman
 */
public class IcosahedronList2 {
   // Fields
   private String name = "";
   private Icosahedron[] list;
   private int numberOfIcosahedrons;
   
   // Constructor 
   /**
     *Constructs IcosahedronList for use.
     *
     *@param nameIn assigns name.
     *@param listIn assigns array list.
     *@param numberOfIcosahedronsIn num of icos in.
     */
   public IcosahedronList2(String nameIn, Icosahedron[] listIn,
         int numberOfIcosahedronsIn) {
      name = nameIn;
      list = listIn;
      numberOfIcosahedrons = numberOfIcosahedronsIn;
   }
   
   // Methods 
   /**
     *Returns the name of icosahedron.
     *
     *@return name of icosahedron.
     */
   public String getName() {
      return name;
   }
   
   /**
     *Returns the number of icosahedron.
     *
     *@return number of icosahedron.
     */
   public int numberOfIcosahedrons() {
      return numberOfIcosahedrons;
   }
   
   /**
     *Returns the surface area of the icosahedron.
     *
     *@return the surface area.
     */
   public double totalSurfaceArea() {
      double total = 0;
      int i = 0;
      while (i < numberOfIcosahedrons) {
         total += list[i].surfaceArea();
         i++;
      }
      return total;
   }
   
   /**
     *Returns the total volume.
     *
     *@return volume
     */
   public double totalVolume() {
      double tV = 0;
      int i = 0;
      while (i < numberOfIcosahedrons) {
         tV += list[i].volume();
         i++;
      }
      return tV;
   }
   
   /**
     *Returns the average average surface of all icosahedron listed.
     *
     *@return average surface area.
     */
   public double averageSurfaceArea() {
      double aSA = 0;
      if (numberOfIcosahedrons > 0) {
         aSA = totalSurfaceArea() / numberOfIcosahedrons;
      }
      return aSA;
   }
   
   /**
     *Returns the average volume of all icosahedron listed.
     *
     *@return average volume.
     */
   public double averageVolume() {
      double aV = 0;
      if (numberOfIcosahedrons > 0) {
         aV = totalVolume() / numberOfIcosahedrons;
      }
      return aV;
   }
   /**
   * @return return totalR
   */
   public double totalRatio() {
      double totalR = 0;
      int i = 0;
      while (i < numberOfIcosahedrons) {
         totalR += list[i].surfaceToVolumeRatio();
         i++;
      }
      return totalR;
   }
   
   /**
     *Returns average surface to volume ratio for all icosahedron listed.
     *
     *@return average surface to volume ratio.
     */
   public double averageSurfaceToVolumeRatio() {
      double aSTVR = 0;
      if (numberOfIcosahedrons > 0) {
         aSTVR = totalRatio() / numberOfIcosahedrons;
      }
      return aSTVR;
   }
   
   /**
     *Returns the name and array list of all icosahedron listed.
     *
     *@return name and array list.
     */
   public String toString() {
      String result = name + "\n";
      int i = 0;
      while (i < numberOfIcosahedrons) {
         result += "\n" + list[i] + "\n";
         i++;
      }
      return result;
   }
   
   /**
     *Return the name of the list and summary items.
     *
     *@return name and items.
     */
   public String summaryInfo() {
      DecimalFormat format = new DecimalFormat("#,##0.0##");
      String output = "----- Summary for " + getName() + " -----" + "\nNumber "
         + "of Icosahedrons: " + numberOfIcosahedrons() + "\nTotal Surface Area"
         + ": " + format.format(totalSurfaceArea()) + "\nTotal Volume: " 
         + format.format(totalVolume()) + "\nAverage Surface Area: " 
         + format.format(averageSurfaceArea()) + "\nAverage Volume: "
         + format.format(averageVolume()) + "\nAverage Surface/Volume Ratio: "
         + format.format(averageSurfaceToVolumeRatio());
      return output;
   }
   
   /**
     *Returns the array list.
     *
     *@return the array list.
     */
   public Icosahedron[] getList() {
      return list;
   }
   
   /**
     *Returns the size of list.
     *
     *@return the size of list.
     @param fileNameIn the file used.
     @throws FileNotFoundException cannot find file.
     */
   public IcosahedronList2 readFile(String fileNameIn) 
                                 throws FileNotFoundException {
      Icosahedron[] newList = new Icosahedron[100];
      int count = 0;                              
      Scanner fileName = new Scanner(new File(fileNameIn));
      name = fileNameIn;
      name = fileName.nextLine();
      while (fileName.hasNext()) {
         String labelIn = fileName.nextLine();
         String colorIn = fileName.nextLine();
         double edgeIn = Double.parseDouble(fileName.nextLine());
         Icosahedron icos = new Icosahedron(labelIn, colorIn, edgeIn);
         newList[count] = icos;
         numberOfIcosahedrons++;
         count++;
      }
      fileName.close();
      IcosahedronList2 newList2 = 
         new IcosahedronList2(name, list, count);
      list = newList;
      return newList2;
   }
   
   /**
     *Adds and icosahedron to the list.
     *
     *@param labelIn the label.
     *@param colorIn the color.
     *@param edgeIn the edge.
     */
   public void addIcosahedron(String labelIn, String colorIn, double edgeIn) {
      Icosahedron i  = new Icosahedron(labelIn, colorIn, edgeIn);
      list[numberOfIcosahedrons] = i;
      numberOfIcosahedrons++;
   }
   
   /**
     *Finds an icosahedron.
     *
     *@param labelIn the icos to be found.
     *@return found icosahedron.
     */
   public Icosahedron findIcosahedron(String labelIn) {
      Icosahedron result = null;
      for (int i = 0; i < numberOfIcosahedrons; i++) {
         if (list[i].getLabel().equalsIgnoreCase(labelIn)) {
            result = list[i];
            break;
         }
      }
      return result;
   }
   
   /**
     *Deletes the icosahedron from the list.
     *
     *@return the icosahedron.
     *@param labelIn the icos to be deleted.
     */
   public Icosahedron deleteIcosahedron(String labelIn) {
      Icosahedron result = null;
      for (int i = 0; i < numberOfIcosahedrons; i++) {
         if (list[i].getLabel().equalsIgnoreCase(labelIn)) {
            result = list[i];
            for (int j = i; j < numberOfIcosahedrons - 1; j++) {
               list[j] = list[j + 1];
            }
            list[numberOfIcosahedrons - 1] = null;
            numberOfIcosahedrons--;
            break;
         }
      }
      return result;
     
   }
   
   /**
     *Edits a icos in the list.
     *
     *@param labelIn the label.
     *@param colorIn the color.
     *@param edgeIn the edge.
     *@return true or false.
     */
   public boolean editIcosahedron(String labelIn, String colorIn, 
         double edgeIn) {
     
      Icosahedron result = null;
      for (int i = 0; i < numberOfIcosahedrons; i++) {
         if (list[i].getLabel().equalsIgnoreCase(labelIn)) {
            result = list[i];
            list[i].setColor(colorIn);
            list[i].setEdge(edgeIn);
            return true;
         }
      }
      return false;
   }
}