import java.math.*;
public class Punkt {
   private final BigDecimal xcoord;
   private final BigDecimal ycoord;
   /**
   * should have a corresponding parameter for each attribute and set the attributes to the passed values
   * */
   public Punkt(BigDecimal xcoord, BigDecimal ycoord){
       this.xcoord = xcoord;
       this.ycoord = ycoord;
   }
   public BigDecimal getXcoord(){
       return xcoord;
   }
   public BigDecimal getYcoord(){
       return ycoord;
   }
   /**
    * should allow the user to create a new point from two values of type double
    * */
   public Punkt(double x, double y){
       this.xcoord = BigDecimal.valueOf(x);
       this.ycoord = BigDecimal.valueOf(y);
   }

    @Override
    public String toString(){
       return "(" + xcoord + "," + ycoord + ")";
   }
   /**
    * This should calculate the Euclidean distance between the point
    * on which the method is called and the transferred point other.
    * */
   public BigDecimal abstand(Punkt other){
       BigDecimal deltaX = this.getXcoord().subtract(other.getXcoord());
       BigDecimal deltaY = this.getYcoord().subtract(other.getYcoord());

       return BigDecimalUtility.sqrt(deltaX.pow(2).add(deltaY.pow(2)));
   }
   /**
    * when the passed object obj of type point and has the same coordinates as the point
    * on which the method is called.
    * @param obj , a new object
    * @return true, when the new object is a point and has the same xcood & ycoord
    * */
    @Override
    public boolean equals(Object obj){
        if (obj == this){
            return true;
        }
       else if (!(obj instanceof Punkt)){
           return false;
       }
       Punkt point = (Punkt) obj;
       if (!BigDecimalUtility.equalValues(point.getXcoord(), this.getXcoord())){
           return false;
       } else if(!BigDecimalUtility.equalValues(point.getYcoord(), this.getYcoord())){
           return false;
       } else{
           return true;
       }
   }
}
