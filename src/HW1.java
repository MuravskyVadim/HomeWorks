public class HW1 {
    public static void main(String[] args) {

    }

    public static int matchOutcome(int a, int b, int c, int d){
        return ((a == c && b == d))?2:(((b - a > 0 && d - c > 0) || (a - b > 0 && c - d > 0)) || (a == b && c == d))?1:0;
    }

    public static void printAsteriskDiamond(int a){
        int dimension = a*2-1;
        String[][] asteriskArray = new String[dimension][dimension];

        for (int i = 0; i < a; i++) {
            int y = dimension/2 + i;
            for (int x = i; x < a+i; x++, y--) {
                asteriskArray[x][y] = "*";
            }
        }

        for (String[] x : asteriskArray) {
            for (String y: x) {
                if(y != null)
                    System.out.print(y);
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static double power(double a, double n){
        double result = 1;
        if(n > 0){
            for (int i = 0; i < n; i++) {
                result *= a;
            }
        }else if(n < 0){
            for (int i = 0; i < -n; i++) {
                result *= a;
            }
            result = 1/result;
        }
        return result;
    }
}
