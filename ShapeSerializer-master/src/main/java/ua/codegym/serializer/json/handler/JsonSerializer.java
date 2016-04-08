package ua.codegym.serializer.json.handler;

import java.io.IOException;
import java.io.OutputStream;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.Serializers;

import ua.codegym.serializer.shape.Shape;

public class JsonSerializer implements Serializer {

	public void serialize(Shape shape, OutputStream os) throws IOException {
		String type = shape.getType();

		Serializers serializers = new Serializers(new SquareJsonSerializer(), new CircleJsonSerializer(),
				new TriangleJsonSerializer(), new GroupJsonSerializer());
		Serializer serializer = serializers.getSerializers().get(type);
		serializer.serialize(shape, os);

	}

}
