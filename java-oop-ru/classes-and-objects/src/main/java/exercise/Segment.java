package exercise;

// BEGIN
public class Segment {
    private Point beginPoint;
    private Point endPoint;
    private Point midPoint;

    public Segment(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
        var midX = (endPoint.getX() + beginPoint.getX()) / 2;
        var midY = (endPoint.getY() + beginPoint.getY()) / 2;
        this.midPoint = new Point(midX, midY);
    }

    public Point getBeginPoint() {
        return beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Point getMidPoint() {
        return midPoint;
    }
}
// END
