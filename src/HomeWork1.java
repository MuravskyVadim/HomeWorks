public class HomeWork1 {
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

    public static int matchOutcome(int team1, int team2, int userRateTeam1, int userRateTeam2) {
        return ((team1 == userRateTeam1 && team2 == userRateTeam2)) ? 2 :
                (((team2 - team1 > 0 && userRateTeam2 - userRateTeam1 > 0)
                        || (team1 - team2 > 0 && userRateTeam1 - userRateTeam2 > 0))
                        || (team1 == team2 && userRateTeam1 == userRateTeam2)) ? 1 : 0;
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
