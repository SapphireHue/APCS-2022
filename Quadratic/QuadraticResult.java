public class QuadraticResult {
    private boolean isReal;
    private int numRoots;
    private double result1;
    private double result2;

    public QuadraticResult() {
    }

    public String toString() {
        String value;
        if (numRoots == 1) {
            value = "real root " + result1;
        } else if (isReal == false) {
            value = "imaginary root1 " + result1 + "+" + result2 + "i imaginary root2 " + result1 + "-" + result2 + "i";
        } else {
            value = "real root1 " + result1 + " real root2 " + result2;
        }
        return value;
    }

    public void setIsReal(boolean real) {
        isReal = real;
    }

    public void setNumRoots(int roots) {
        numRoots = roots;
    }

    public void setResult1(double result){
        result1 = result;
    }

    public void setResult2(double result){
        result2 = result;
    }

}
