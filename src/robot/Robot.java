package robot;

public class Robot {
    private int x;
    private int y;
    private Direction direction;


    public Robot() {
        this.x = 0;
        this.y = 0;
        this.direction = Direction.UP;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void turnLeft() {
        switch (getDirection()) {
            case UP:
                setDirection(Direction.LEFT);
                break;
            case DOWN:
                setDirection(Direction.RIGHT);
                break;
            case LEFT:
                setDirection(Direction.DOWN);
                break;
            case RIGHT:
                setDirection(Direction.UP);
                break;
        }
    }

    public void turnRight() {
        switch (getDirection()) {
            case UP:
                setDirection(Direction.RIGHT);
                break;
            case DOWN:
                setDirection(Direction.LEFT);
                break;
            case LEFT:
                setDirection(Direction.UP);
                break;
            case RIGHT:
                setDirection(Direction.DOWN);
                break;
        }
    }

    public void stepForward() {
        switch (getDirection()) {
            case UP:
                setY(getY() + 1);
                break;
            case DOWN:
                int y = getY();
                if (y > 0) {
                    setY(--y);
                }
                break;
            case LEFT:
                int x = getX();
                if (x > 0) {
                    setX(++x);
                }
                break;
            case RIGHT:
                setX(getX() + 1);
                break;
        }
    }
}
