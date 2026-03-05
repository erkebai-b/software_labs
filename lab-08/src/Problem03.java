class InvalidRadiusException extends Exception {
    private final double radius;

    public InvalidRadiusException(double radius) {
        super("Invalid radius " + radius);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}

class CircleWithCustomException {
    private double radius;
    private static int numOfObjects = 0;

    public CircleWithCustomException() throws InvalidRadiusException {
        this(1.0);
    }

    public CircleWithCustomException(double newRadius) throws InvalidRadiusException {
        setRadius(newRadius);
        numOfObjects++;
    }

    private void setRadius(double newRadius) throws InvalidRadiusException {
        if (newRadius >= 0) {
            radius = newRadius;
        } else {
            throw new InvalidRadiusException(newRadius);
        }
    }

    public static int getNumOfObjects() {
        return numOfObjects;
    }

    public double findArea() {
        return radius * radius * 3.14159;
    }

    public double getRadius() {
        return radius;
    }
}

public class Problem03 {
    public static void main(String[] args) {
        try {
            CircleWithCustomException c1 = new CircleWithCustomException(5);
            CircleWithCustomException c2 = new CircleWithCustomException(-5);
            CircleWithCustomException c3 = new CircleWithCustomException(0);
        } catch (IllegalArgumentException | InvalidRadiusException ex) {
            System.out.println(ex);
        }
        System.out.println("Number of objects created: " + CircleWithCustomException.getNumOfObjects());
    }
}
