package robot;

public class RobotApplication {
    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        boolean connection = false;

        for (int i = 0; !connection && i < 3; i++) {
            try (RobotConnection robotConnection = robotConnectionManager.getConnection()){
                robotConnection.moveRobotTo(toX, toY);
                connection = true;
            } catch (RobotConnectionException e) {
                e.getMessage();
            }
        }

        if (!connection) {
            throw new RobotConnectionException("Connection failed");
        }
    }
}
