package ua.codegym.serializer.xml.handler;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Circle;
import ua.codegym.serializer.shape.Group;
import ua.codegym.serializer.shape.Shape;
import ua.codegym.serializer.shape.Square;
import ua.codegym.serializer.shape.Triangle;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class XmlSerializer implements Serializer {
	private Map<String, Serializer> serializers = new HashMap<>();

	public XmlSerializer() {
		serializers.put(Square.class.getCanonicalName(), new SquareXmlSerializer());
		serializers.put(Circle.class.getCanonicalName(), new CircleXmlSerializer());
		serializers.put(Triangle.class.getCanonicalName(), new TriangleXmlSerializer());
		serializers.put(Group.class.getCanonicalName(), new GroupXmlSerializer());
		
	}

	public void serialize(Shape shape, OutputStream os) throws IOException {

		String type = shape.getType();
		Serializer serializer = serializers.get(type);
		serializer.serialize(shape, os);
	}
}
