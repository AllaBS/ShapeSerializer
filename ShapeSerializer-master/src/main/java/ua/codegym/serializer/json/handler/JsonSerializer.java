package ua.codegym.serializer.json.handler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Circle;
import ua.codegym.serializer.shape.Group;
import ua.codegym.serializer.shape.Shape;
import ua.codegym.serializer.shape.Square;
import ua.codegym.serializer.shape.Triangle;
import ua.codegym.serializer.xml.handler.CircleXmlSerializer;
import ua.codegym.serializer.xml.handler.GroupXmlSerializer;
import ua.codegym.serializer.xml.handler.SquareXmlSerializer;
import ua.codegym.serializer.xml.handler.TriangleXmlSerializer;

public class JsonSerializer implements Serializer {
	private Map<String, Serializer> serializers = new HashMap<>();

	public JsonSerializer() {
	//	serializers.put(Square.class.getCanonicalName(), new SquareXmlSerializer());
		serializers.put(Circle.class.getCanonicalName(), new CircleJsonSerializer());
	//	serializers.put(Triangle.class.getCanonicalName(), new TriangleXmlSerializer());
	//	serializers.put(Group.class.getCanonicalName(), new GroupXmlSerializer());
		
	}
	
	public void serialize(Shape shape, OutputStream os) throws IOException {
		String type = shape.getType();
		Serializer serializer = serializers.get(type);
		serializer.serialize(shape, os);
		
	}

}
