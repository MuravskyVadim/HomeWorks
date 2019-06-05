public class FirstHomeWork {
    public static void main(String[] args) {
        System.out.println(matchOutcome(1,1,2,2));
        System.out.println(matchOutcome(1,2,3,0));
        System.out.println(matchOutcome(1,2,0,3));
        System.out.println(matchOutcome(2,1,0,3));
        System.out.println(matchOutcome(2,2,2,2));

        printAsteriskDiamond(3);
        printAsteriskDiamond(7);

        System.out.println(mathPower(3,0));
        System.out.println(mathPower(0,0));
        System.out.println(mathPower(2,2));
        System.out.println(mathPower(2,-2));
        System.out.println(mathPower(-2,-2));
        System.out.println(mathPower(-2,2));
    }

    public static int matchOutcome(int firstTeam, int secondTeam, int userFirstTeam, int userSecondTeam) {
        return ((firstTeam == userFirstTeam && secondTeam == userSecondTeam)) ? 2 :
                (((secondTeam - firstTeam > 0 && userSecondTeam - userFirstTeam > 0)
                        || (firstTeam - secondTeam > 0 && userFirstTeam - userSecondTeam > 0))
                        || (firstTeam == secondTeam && userFirstTeam == userSecondTeam)) ? 1 : 0;
    }

    public static void printAsteriskDiamond(int quantityAsterisks) {
        int sizeArray = quantityAsterisks * 2 - 1;
        String[][] asteriskArray = new String[sizeArray][sizeArray];

        for (int i = 0; i < quantityAsterisks; i++) {
            int y = sizeArray / 2 + i;
            for (int x = i; x < quantityAsterisks + i; x++, y--) {
                asteriskArray[x][y] = "*";
            }
        }

        for (String[] line : asteriskArray) {
            for (String cell : line) {
                if (cell != null)
                    System.out.print(cell);
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static double mathPower(double base, double power) {
        double result = 1;
        if (power > 0) {
            for (int i = 0; i < power; i++) {
                result *= base;
            }
        } else if (power < 0) {
            for (int i = 0; i < -power; i++) {
                result *= base;
            }
            result = 1 / result;
        }
        return result;
    }
}
