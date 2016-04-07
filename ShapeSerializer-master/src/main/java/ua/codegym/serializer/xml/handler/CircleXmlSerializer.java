package ua.codegym.serializer.xml.handler;

import java.io.IOException;
import java.io.OutputStream;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Circle;
import ua.codegym.serializer.shape.Shape;

public class CircleXmlSerializer implements Serializer {

	@Override
	public void serialize(Shape shape, OutputStream os) throws IOException {
		Circle circle = (Circle) shape;
		int x = circle.getX();
		int y = circle.getY();
		int radius = circle.getRadius();
		String out = String.format("<circle x=\"%d\" y=\"%d\" radius=\"%d\"></circle>", x, y, radius);
		os.write(out.getBytes());

	}

}
