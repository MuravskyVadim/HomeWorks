package robot;

public class Application {
    public static void main(String[] args) {
        Robot robot = new Robot();
        moveRobot(robot, 3, 6);
        System.out.println(robot.getX() + ", " + robot.getY() + " direction " + robot.getDirection());
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        Direction direction = robot.getDirection();
        int x = robot.getX();
        int y = robot.getY();
        if (toX > -1 && toY > -1) {
            if (toX > robot.getX()) {
                while (direction != Direction.RIGHT) {
                    robot.turnLeft();
                    direction = robot.getDirection();
                }

                while (toX != x) {
                    robot.stepForward();
                    x = robot.getX();
                }
            } else if (toX < robot.getX()) {
                while (direction != Direction.LEFT) {
                    robot.turnLeft();
                    direction = robot.getDirection();
                }

                while (toX != x) {
                    robot.stepForward();
                    x = robot.getX();
                }
            }

            if (toY > robot.getY()) {
                while (direction != Direction.UP) {
                    robot.turnLeft();
                    direction = robot.getDirection();
                }

                while (toY != y) {
                    robot.stepForward();
                    y = robot.getY();
                }
            } else if (toY < robot.getY()) {
                while (direction != Direction.DOWN) {
                    robot.turnLeft();
                    direction = robot.getDirection();
                }

                while (toY != y) {
                    robot.stepForward();
                    y = robot.getY();
                }
            }
        }
    }
}
