package ua.codegym.serializer.json.handler;

import java.io.IOException;
import java.io.OutputStream;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Shape;
import ua.codegym.serializer.shape.Square;

public class SquareJsonSerializer implements Serializer {

	@Override
	public void serialize(Shape shape, OutputStream os) throws IOException {
		Square square = (Square) shape;
		int x = square.getX();
		int y = square.getY();
		int side = square.getSide();
		String out = String.format("{\"shapeName\": \"Square\", \"values\": {\"x\":%d, \"y\":%d, \"side\":%d}}", x, y,
				side);
		os.write(out.getBytes());

	}

}
