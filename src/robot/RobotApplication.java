package robot;

public class RobotApplication {
    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        boolean connection = false;
        RobotConnection robotConnection = null;

        for (int i = 0; !connection && i < 3; i++) {
            try {
                robotConnection = robotConnectionManager.getConnection();
                robotConnection.moveRobotTo(toX, toY);
                connection = true;
            } catch (RobotConnectionException e) {
                e.getMessage();
            } finally {
                if (robotConnection != null) {
                    try {
                        robotConnection.close();
                    } catch (RobotConnectionException e) {
                        e.getMessage();
                    }
                }
            }

            if (!connection) {
                throw new RobotConnectionException("Connection failed");
            }
        }
    }
}
