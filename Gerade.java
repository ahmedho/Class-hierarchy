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
            throw new NullPointerException("Die Eingabe ist ungueltig");
        } else {
            if (p1.getXcoord().compareTo(p2.getXcoord()) < 0 ){
                this.p1 = p2;
                this.p2 = p1;
            } else if(p1.getYcoord().compareTo(p2.getYcoord()) == 0){
                this.p1 = p1;
                this.p2 = p2;
            } else{
                this.p1 = p2;
                this.p2 = p1;
            }
        }
    }
    /**
     * @return p1, point
     * */
    public Punkt getP1(){
        return this.p1;
    }
    /**
     * @return p2, point
     * */
    public Punkt getP2(){
        return this.p2;
    }

    /**
     * @return String
     * */
    @Override
    public String toString(){
        return "Gerade durch " +this.getP1().toString() + " und " + this.getP2().toString();
    }
    /**
     * @param p0 , a new point
     * @return true, if and only if p0 lies on the straight line between points p1 and p2
     * or on one of these two points.*/
    protected boolean zwischenp1p2(Punkt p0) {
        if (this.enthaelt(p0)) {
            BigDecimal absp0p1 = p0.abstand(getP1());
            BigDecimal absp0p2 = p0.abstand(getP2());
            BigDecimal absp1p2 = getP1().abstand(getP2());
            return BigDecimalUtility.equalValues(absp0p1.add(absp0p2), absp1p2);
        }
        else return false;
    }
    /**
     * @param p0 , a new point
     * @return true, if and only if p0 lies on the straight line in such a way
     * that the distance to p1 is smaller than to p2
     **/
    protected boolean vorp1(Punkt p0) {
        if (this.zwischenp1p2(p0)) {
            return false;
        } else {
            BigDecimal absp0p1 = p0.abstand(getP1());
            BigDecimal absp0p2 = p0.abstand(getP2());
            return absp0p1.compareTo(absp0p2) < 0;
        }
    }
    /**
     * @param p0 , a new point to be checked
     * @return true, if and only if p0 is on the straight line,
     * but none of the first two methods returns true as a parameter when called with p0
     * */
    protected boolean hinterp2(Punkt p0){
        return  (this.enthaelt(p0) && !this.vorp1(p0) && !this.zwischenp1p2(p0));
    }
    /**
     * @param p0 , a new point to be checked
     * @return true, f and only if p0 lies on the straight line
     * */
    protected boolean enthaelt(Punkt p0){
        BigDecimal p1Xcoord = getP1().getXcoord();
        BigDecimal p1Ycoord = getP1().getYcoord();
        BigDecimal p2Xcoord = getP2().getXcoord();
        BigDecimal p2Ycoord = getP2().getYcoord();
        BigDecimal p0Xcoord = p0.getXcoord();
        BigDecimal p0Ycoord = p0.getYcoord();
        if (p1Xcoord.compareTo(p2Xcoord) == 0){
            return p0Xcoord.compareTo(p1Xcoord) == 0;
        } else {
            BigDecimal m = (p2Ycoord.subtract(p1Ycoord)).divide(p2Xcoord.subtract(p1Xcoord));
            BigDecimal n = p1Ycoord.subtract(m.multiply(p1Xcoord));
            return p0Ycoord.compareTo(n.add(m.multiply(p0Xcoord))) == 0;
        }
    }
    /**
     * */

    @Override
    public boolean equals(Object obj){
        if(this.getClass().equals(obj.getClass())){
            return this.enthaelt(((Gerade) obj).getP1())
                    && this.enthaelt(((Gerade) obj).getP2());
        } else {
            return false;
        }
    }
}
