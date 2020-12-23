public class Strahl extends Gerade{
    protected final Punkt startPunkt;
    public Strahl(Punkt a, Punkt b) {
        super(a, b);
        startPunkt = a;
    }
    /**
     * @return the start point
     * */
    public Punkt getStartPunkt(){
        return this.startPunkt;
    }
    /**
     * @return the second point
     * */
    public Punkt getOther(){
        if (this.startPunkt.equals(getP1())){
            return getP2();
        }
        else {
            return getP1();
        }
    }
    /**
     * @return true, if and only if the ray begins at the first point.
     * */
    public boolean startsFromp1(){
        return startPunkt.equals(getP1());
    }
    /**
     * @return true, if and only if the ray begins at the second point.
     * */
    public boolean startsFormp2(){
        return startPunkt.equals(getP2());
    }
    /**
     * @return String
     * */
    @Override
    public String toString(){
        return "Strahl startet in " + getStartPunkt().toString() + " durch " +getOther().toString();
    }
    /**
     * @return the straight line, that arises when one moves the ray beyond the point
     * at which the ray begins into infinity extended.
     * */
    public Gerade verlaengern(){
        return new Strahl(this.getP1(), this.getP2());
    }
    @Override
    public boolean enthaelt(Punkt p0){
        return this.enthaelt(p0);
    }

    @Override
    public boolean equals(Object obj){
        if (this.getClass().equals(obj.getClass())){
            if (this.enthaelt(((Strahl)obj).getP1()) && this.enthaelt(((Strahl)obj).getP2())){
                return this.startPunkt.equals(((Strahl) obj).startPunkt);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}

