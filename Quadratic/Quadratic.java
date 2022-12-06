public class Quadratic {
    private double a;
    private double b;
    private double c;

    static int realRoots;
    static int imaginaryRoots;

    private QuadraticResult result = null;

    public Quadratic() {
        a = 0;
        b = 0;
        c = 0;

    }

    public Quadratic(double a1, double b1, double c1) {
        a = a1;
        b = b1;
        c = c1;
    }

    public void solve() {
        result = new QuadraticResult();
        double determinant = Math.pow(b, 2) - (4 * a * c);

        if (determinant == 0) {
            result.setIsReal(true);
            realRoots++;
            result.setNumRoots(1);

            result.setResult1(-b / (2 * a));
        } else if (determinant < 0) {
            result.setIsReal(false);
            imaginaryRoots++;
            result.setNumRoots(2);

            result.setResult1(-b / (2 * a));
            result.setResult2(Math.sqrt(Math.abs(determinant)) / (2 * a));
        } else {
            result.setIsReal(true);
            realRoots++;
            result.setNumRoots(2);

            result.setResult1((-b + Math.sqrt(determinant)) / (2 * a));
            result.setResult2((-b - Math.sqrt(determinant)) / (2 * a));
        }
    }

    public String toString() {
        String equation = a + "x^2 + " + b + "x + " + c + " ";
        if (result == null) {
            return equation + "has not been solved yet!!!";
        } else {
            return equation + result;
        }
    }

}