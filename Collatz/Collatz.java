// Completed challenges 1 and 2 (challenge 2 is done in printColumns())

public class Collatz {
    private int startNum;

    public Collatz() {
        startNum = 0;
    }

    public Collatz(int num) {
        startNum = num;
    }

    public int steps() {
        int num = startNum;
        int count = 1; // you get +1 count for every non-1 value, but you also have a "1" always
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = num * 3 + 1;
            }
            count++;
        }
        return count;
    }

    public int[] sequence() {
        int num = startNum;
        int[] sequence = new int[steps()];
        sequence[0] = num;
        int i = 1;
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = num * 3 + 1;
            }
            sequence[i] = num;
            i++;
        }
        return sequence;
    }

    public int maxValue() {
        int max = 0;
        for (int i : sequence()) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public int minOddValue() {
        int min = 1;
        for (int i : oddValues()) {
            if (min == 1) {
                min = i;
            } else if (i < min && i != 1) {
                min = i;
            }

        }
        return min;
    }

    public int[] oddValues() {
        // Pre-challenge method:
        /* 
        int count = 0;
        for (int i : sequence()) {
            if (i % 2 == 1) {
                count++;
            }
        }
        int[] oddValues = new int[count];
        int i = 0;
        for (int element : sequence()) {
            if (element % 2 == 1) {
                oddValues[i] = element;
                i++;
            }
        } 
        */
        
        // Post-challenge method:
        // Although technically I could just have written the counting part in a different method like we did for sequence and eliminated the if-statement that way; instead I have elected to do This and pray it doesn't crash your computer
        // Also if I set a variable int one = 1; could I do i+=one and get around the incrementing by one restriction?
        int[] oddValues = new int[0];
        int[] temp;
        for (int i = 0; i < sequence().length; i++) {
            if (sequence()[i] % 2 == 1) {
                temp = oddValues;
                oddValues = new int[temp.length + 1];
                for (int x = 0; x < temp.length; x++) {
                    oddValues[x] = temp[x];
                }
                oddValues[oddValues.length - 1] = sequence()[i];
            }
        }
        return oddValues;
    }

    public int sumValues() {
        int sum = 0;
        for (int i : sequence()) {
            sum += i;
        }
        return sum;
    }

    public String toString() {
        return ("Starting number " + startNum + " takes " + steps() + " steps");
    }

    public void printColumns() {
        for (int i = 0; i < sequence().length; i++) {
            System.out.printf("step %-10d%10d%n", (i + 1), sequence()[i]);
        }
    }
}