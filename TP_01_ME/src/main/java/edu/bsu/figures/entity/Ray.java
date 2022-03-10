package main.java.edu.bsu.figures.entity;

import java.awt.*;

public class Ray extends Segment{

    public Ray(Point firstPoint, Point secondPoint) {
        super(firstPoint, secondPoint);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(getBorderColor());
        Point startPoint = getFirstPoint();
        Point outScreenPoint = getOutScreenPoint(this.getFirstPoint(), this.getSecondPoint());
        graphics.drawLine(startPoint.x, startPoint.y, outScreenPoint.x, outScreenPoint.y);
    }

    private Point getOutScreenPoint(Point startPoint, Point directionPoint) {
        Point result = new Point();
        double deltaX = directionPoint.x - startPoint.x;
        double deltaY = directionPoint.y - startPoint.y;
        if (deltaX==0 && deltaY==0)
            return directionPoint;
        if (Math.abs(deltaX) < Math.abs(deltaY)) {
            double height;
            if (deltaY < 0)
                height = -1;
            else
                height = Toolkit.getDefaultToolkit().getScreenSize().getHeight() + 1;
            result.setLocation(deltaX / deltaY * (height - startPoint.y) + startPoint.x, height);
        } else {
            double width;
            if (deltaX < 0)
                width = -1;
            else
                width = Toolkit.getDefaultToolkit().getScreenSize().getWidth() + 1;
            result.setLocation(width, deltaY / deltaX * (width - startPoint.x) + startPoint.y);
        }
        return result;
    }
}
