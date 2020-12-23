import java.math.BigDecimal;

public class Gerade {
    private final Punkt p1;
    private final Punkt p2;

    /**
     * The constructor recognize when the two points of the straight line have the same coordinates.
     * In this case, the user should be informed of his invalid input via command line output.
     * The attributes are then set to zero.
     * the first point is always to the left of the second point lies.
     * If the points are exactly one below the other, the first point should always be below the second.
     * */
    public  Gerade (Punkt p1, Punkt p2){
        if(p1.equals(p2)){
            System.out.println("Die Eingabe ist ungueltig.");
            this.p1 = null;
            this.p2 = null;
        } else if (p1.getXcoord().compareTo(p2.getXcoord()) == 1
        && p1.getYcoord().compareTo(p2.getYcoord()) == 1){
                this.p1 = p2;
                this.p2 = p1;
            } else{
                this.p1 = p2;
                this.p2 = p1;
            }
    }
    /**
     * @return p1, point
     * */
    public Punkt getP1(){

        return p1;
    }
    /**
     * @return p2, point
     * */
    public Punkt getP2(){

        return p2;
    }

    /**
     * @return String
     * */
    @Override
    public String toString(){
        return "Gerade durch " + p1 + " und " + p2;

    }
    /**
     * @param p0 , a new point
     * @return true, if and only if p0 lies on the straight line between points p1 and p2
     * or on one of these two points.*/
    protected boolean zwischenp1p2(Punkt p0) {
            BigDecimal absp1p0 = p1.abstand(p0);
            BigDecimal absp0p2 = p0.abstand(p2);
            BigDecimal absp1p2 = getP1().abstand(getP2());
            return BigDecimalUtility.equalValues(absp1p0.add(absp0p2), absp1p2);
    }
    /**
     * @param p0 , a new point
     * @return true, if and only if p0 lies on the straight line in such a way
     * that the distance to p1 is smaller than to p2
     **/
    protected boolean vorp1(Punkt p0) {
        BigDecimal absp1p2 = p1.abstand(p2);
        BigDecimal absp1p0 = p1.abstand(p0);
        BigDecimal absp2p0 = p2.abstand(p0);
        return (BigDecimalUtility.equalValues(absp2p0.subtract(absp1p0), absp1p2));
    }
    /**
     * @param p0 , a new point to be checked
     * @return true, if and only if p0 is on the straight line,
     * but none of the first two methods returns true as a parameter when called with p0
     * */
    protected boolean hinterp2(Punkt p0){
        BigDecimal absp1p2 = p1.abstand(p2);
        BigDecimal absp1p0 = p1.abstand(p0);
        BigDecimal absp2p0 = p2.abstand(p0);
        return  (BigDecimalUtility.equalValues(absp1p0.subtract(absp2p0), absp1p2));
    }
    /**
     * @param p0 , a new point to be checked
     * @return true, f and only if p0 lies on the straight line
     * */
    protected boolean enthaelt(Punkt p0){
        //between p1 and p2
        if(zwischenp1p2(p0)){
            return true;
        }
        // behind p2
        if (hinterp2(p0)){
            return true;
        }
        //before p1
        if (vorp1(p0)){
            return true;
        }
        return false;
    }
    /**
     * */

    @Override
    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }
        else if(this.getClass() != obj.getClass()){
            return false;
        }
        else {
            Gerade stright = (Gerade) obj;
            return (stright.enthaelt(this.getP1()) && stright.enthaelt(this.getP2())
                    && this.enthaelt(stright.getP1()) && this.enthaelt(stright.getP2()));
        }
    }
}
