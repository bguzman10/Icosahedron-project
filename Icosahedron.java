import java.text.DecimalFormat;


/**
* Program designed to read in data to calculate the surface area,
* volume, and surface to volume ratio of an Icosahedron object.
* Proj 07
* @author Benjamin Guzman COMP 1210 012
* @version 10/18/18
*
*/


public class Icosahedron {

   //Instance variables
   private String label = new String("");
   private String color = new String("");
   private double edge = 0;
   
   //Constructor
   /**
   * @param labelIn for label.
   * @param colorIn for color.
   * @param edgeIn for edge.
   */
  
   
   public Icosahedron(String labelIn, String colorIn, double edgeIn) {
      setLabel(labelIn);
      setColor(colorIn);
      setEdge(edgeIn);
   
   }
   
   //methods
   /** 
   * @return label label
   */
   public String getLabel() {
      return label;
   }
   /** 
   * @param labelIn for label.
   * @return true or false.
   */
  
   public boolean setLabel(String labelIn) {
      if (labelIn != null) {
         label = labelIn.trim();
         return true;
      }
      else {
         return false;
      }
   }   
   
   /** 
   *@return color color.
   */
   public String getColor() {
      return color;
      
   }
   
   /**
   * @param colorIn for color.
   * @return true or false.
   */
   public boolean setColor(String colorIn) {
      if (colorIn != null) {
         color = colorIn.trim();
         return true;
      }
      else {
         return false;
      }
      
   }   
   
   /** 
   * @return edge edge.
   */
   public double getEdge() {
      return edge;
   }         
   
   /** 
   * @param edgeIn for edge.
   * @return true or false.
   */
   public boolean setEdge(double edgeIn) {
      if (edgeIn > 0) {
         edge = edgeIn;
         return true;
      }
      else {
         return false;
      }
   }
            
   
   
   /**
   * @return surfaceArea surface area.
   */
   public double surfaceArea() {
      double surfaceArea = 0;
      surfaceArea = (5 * Math.sqrt(3) * Math.pow(edge, 2));
      return surfaceArea;
   }   
   
  /**
  * @return volume volume.
  */
   public double volume() {
      double volume = 0;
      volume = ((5 * (3 + Math.sqrt(5)) * Math.pow(edge, 3) / 12));
      return volume;
   }
   
   /**
   * @return surfaceToVolumeRatio surface to volume ratio.
   */
   public double surfaceToVolumeRatio() {
      double surfaceToVolumeRatio = 0;
      surfaceToVolumeRatio = (surfaceArea() / volume());
      return surfaceToVolumeRatio;
   }
   
   /**
   * @return output output.
   */
   public String toString() {
      String aF = "";
      String vF = "";
      String sVF = "";
      DecimalFormat df = new DecimalFormat("#,##0.0#####");
      aF = df.format(surfaceArea());
      vF = df.format(volume());
      sVF = df.format(surfaceToVolumeRatio());
      String output = "Icosahedron \"" + label + "\" is \""
         + color + "\" with 30 edges of length " + edge + " units.\n"
         + "\tsurface area = " + aF + " square units\n\tvolume = " + vF
         + " cubic units\n\tsurface/volume ratio = " + sVF;
         
      return output;
         
   }
    
   
}