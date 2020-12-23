public class Strahl extends Gerade{
    protected final boolean startPunkt;
    public Strahl(Punkt a, Punkt b) {
        super(a, b);
        startPunkt = (this.getP1() == a);
    }

    /**
     * @return true, if and only if the ray begins at the first point.
     * */
    public boolean startsFromp1(){

        return startPunkt;
    }
    /**
     * @return true, if and only if the ray begins at the second point.
     * */
    public boolean startsFormp2(){

        return !startPunkt;
    }
    /**
     * @return String
     * */
    @Override
    public String toString(){
        if (startsFromp1()){
            return "Strahl von " +this.getP1() + " durch " + this.getP2();
        }
        else {
            return "Strahl von " +this.getP2() + " durch " + this.getP1();
        }
    }
    /**
     * @return the straight line, that arises when one moves the ray beyond the point
     * at which the ray begins into infinity extended.
     * */
    public Gerade verlaengern(){

        return new Gerade(this.getP1(), this.getP2());
    }
    @Override
    public boolean enthaelt(Punkt p0){

        if (zwischenp1p2(p0)){
            return true;
        }
        if (startsFromp1() && hinterp2(p0)){
            return true;
        }
        if (startsFormp2() && vorp1(p0)){
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj){
        if (!super.equals(obj)){
            return false;
        }
        else {
            Strahl ray = (Strahl) obj;
            return (this.startsFromp1() == ray.startsFromp1());
        }
    }
}

