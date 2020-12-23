public class Strecke extends Strahl {

    Strecke(Punkt p1 , Punkt p2){

        super(p1,p2);
    }
    @Override
    public String toString(){
        return "Strahl startet von " + getP1().toString() + " bis " + getP2().toString();
    }
    @Override
    public boolean enthaelt(Punkt p0){
        return this.zwischenp1p2(p0);
    }
    @Override
    public boolean startsFromp1(){
        return true;
    }
    @Override
    public boolean startsFormp2(){
        return true;
    }

    public Strahl verlaengern(boolean swap){
        if(swap){
            return new Strahl(getP2(),getP2());
        }
        else{
            return new Strahl(getP1(),getP2());
        }
    }
}
