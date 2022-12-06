public class Task{
    final static int DRIPS_PER_GALLON = 15140;

    public static int favorite() {
        return (((((16*65)+12)*72)/68)-1);
    }

    public static void wasted(double r, int d){
        System.out.println("A faucet with " + r + " drips per minute over " + d + " days will waste " + (int)((r*60*24)*d/DRIPS_PER_GALLON + .5) + " gallons of water");
    }

    public static int count(double a, double b, int mL){
        double beanVolume = (5*Math.PI*a*(Math.pow(b, 2)/24));
        return (int) (mL*0.698/beanVolume);
    }

    /*public static void main(String[] args){
        wasted(7.5, 5);
    }*/
}