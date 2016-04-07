package ua.codegym.serializer.json.handler;

import java.io.IOException;
import java.io.OutputStream;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Circle;
import ua.codegym.serializer.shape.Shape;

public class CircleJsonSerializer implements Serializer {

	@Override
	public void serialize(Shape shape, OutputStream os) throws IOException {
		Circle circle = (Circle) shape;
		int x = circle.getX();
		int y = circle.getY();
		int radius = circle.getRadius();
		String out = String.format("{\"shapeName\": \"Circle\", \"values\": {\"x\":%d, \"y\":%d, \"radius\":%d}}", x, y, radius);
		os.write(out.getBytes());

	}

}
