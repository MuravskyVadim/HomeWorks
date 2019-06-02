package robot;

public class RobotApplication {
    public static void main(String[] args) {
        RobotConnectionManager robotConnectionManager = new RobotConnectionManager() {
            @Override
            public RobotConnection getConnection() {
                return null;
            }
        };

        moveRobot(robotConnectionManager, 1, 2);
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        RobotConnection robotConnection = null;
        boolean connection = false;

        for (int i = 0; !connection && i < 3; i++) {
            try {
                robotConnection = robotConnectionManager.getConnection();
                robotConnection.moveRobotTo(toX, toY);
                connection = true;
            } catch (RobotConnectionException e) {
                e.getMessage();
            }finally {
                if(robotConnection != null){
                    try {
                        robotConnection.close();
                    }catch (RobotConnectionException e){
                        e.getMessage();
                    }
                }
            }
        }

        if (!connection) {
            throw new RobotConnectionException("Connection failed");
        }
    }
}
