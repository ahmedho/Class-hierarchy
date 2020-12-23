public class test {
    public static void main(String[] args) {

        Punkt x = new Punkt(3.0, 5.0);
        Punkt y = new Punkt(1.0, 4.0);
        Punkt z = new Punkt(3.0, 2.0);
        Punkt t = new Punkt(15.0, 8.0);

        Gerade f = new Gerade(x, y);
        Gerade g = new Gerade(z, t);

        Strecke h = new Strecke(x, t);

        Strahl i = h.verlaengern(true);

        Gerade j = i.verlaengern();

        System.out.println("f: " + f.toString());
        System.out.println("g: " + g.toString());
        System.out.println("h: " + h.toString());
        System.out.println("i: " + i.toString());
        System.out.println("j: " + j.toString());
        System.out.println("sind f und g gleich? " + f.equals(g));
        System.out.println("sind j und f gleich? " + j.equals(f) + " " + f.equals(j));
    }
}
