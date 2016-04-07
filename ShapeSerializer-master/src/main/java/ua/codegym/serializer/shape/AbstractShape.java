package ua.codegym.serializer.shape;

public class AbstractShape implements Shape {
    public String getType() {
        return this.getClass().getCanonicalName();
    }
}
