package ua.codegym.serializer.xml.handler;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.Serializers;
import ua.codegym.serializer.shape.Shape;

import java.io.IOException;
import java.io.OutputStream;

public class XmlSerializer implements Serializer {

	public void serialize(Shape shape, OutputStream os) throws IOException {

		String type = shape.getType();
		Serializers serializers = new Serializers(new SquareXmlSerializer(), new CircleXmlSerializer(),
				new TriangleXmlSerializer(), new GroupXmlSerializer());
		Serializer serializer = serializers.getSerializers().get(type);
		serializer.serialize(shape, os);
	}
}
