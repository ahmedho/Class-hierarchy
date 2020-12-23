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
       return this.xcoord;
   }
   public BigDecimal getYcoord(){
       return this.ycoord;
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
       String xAxe = xcoord.toString();
       String yAxe = ycoord.toString();
       return "(" + xAxe + "," + yAxe + ")";
   }
   /**
    * This should calculate the Euclidean distance between the point
    * on which the method is called and the transferred point other.
    * */
   public BigDecimal abstand(Punkt other){
       BigDecimal deltaX = this.ycoord.subtract(other.ycoord);
       BigDecimal deltaY = this.xcoord.subtract(other.xcoord);
       BigDecimal deltaXX = deltaX.multiply(deltaX).abs();
       BigDecimal deltaYY = deltaY.multiply(deltaY).abs();

       return BigDecimalUtility.sqrt(deltaXX.add(deltaYY));
   }
   /**
    * when the passed object obj of type point and has the same coordinates as the point
    * on which the method is called.
    * @param obj , a new object
    * @return true, when the new object is a point and has the same xcood & ycoord
    * */
    @Override
    public boolean equals(Object obj){

       if (obj instanceof Punkt){
           return BigDecimalUtility.equalValues(this.xcoord, ((Punkt) obj).xcoord)
                   && BigDecimalUtility.equalValues(this.ycoord, ((Punkt) obj).ycoord);
       } else {
           return false;
       }
   }
}
