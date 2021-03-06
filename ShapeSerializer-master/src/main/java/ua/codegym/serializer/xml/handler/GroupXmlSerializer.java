package ua.codegym.serializer.xml.handler;

import java.io.IOException;
import java.io.OutputStream;


import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.Serializers;
import ua.codegym.serializer.shape.Group;
import ua.codegym.serializer.shape.Shape;


public class GroupXmlSerializer implements Serializer {


	@Override
	public void serialize(Shape shape, OutputStream os) throws IOException {
		Group group = (Group) shape;
		os.write("<group>".getBytes());
		for (Shape innerShape : group.getShapes()) {
			Serializers serializers = new Serializers(new SquareXmlSerializer(), new CircleXmlSerializer(),new TriangleXmlSerializer(), this);
			Serializer serializer = serializers.getSerializers().get(innerShape.getType());
			serializer.serialize(innerShape, os);
			os.write("</group>".getBytes());
		}

	}

}
