package week1.lab5.exercise1;

abstract class Shape {
    protected String color;
    protected boolean filled;

    public Shape() {
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    abstract double getArea();

    abstract double getPerimeter();

    @Override
    public String toString() {
        String isFilled;
        if (filled) {
            isFilled = "filled";
        } else {
            isFilled = "not filled";
        }
        return "A Shape with color of " + color + " and " + isFilled;
    }
}
