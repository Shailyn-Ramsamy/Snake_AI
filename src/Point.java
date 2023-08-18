public class Point {
    int x;
    int y;
    Point parent;

    public Point(int x, int y, Point parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    public Point getParent() {
        return this.parent;
    }

    public String toString() {
        return "x = " + y + " y = " + x;
    }
}
