package ua.codegym.serializer.json.handler;

import java.io.IOException;
import java.io.OutputStream;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.Serializers;
import ua.codegym.serializer.shape.Group;
import ua.codegym.serializer.shape.Shape;

public class GroupJsonSerializer implements Serializer {

	@Override
	public void serialize(Shape shape, OutputStream os) throws IOException {
		Group group = (Group) shape;
		int amount = group.getShapes().size();
		int count = 0;
		os.write("{\"group\": [".getBytes());
		for (Shape innerShape : group.getShapes()) {
			Serializers serializers = new Serializers(new SquareJsonSerializer(), new CircleJsonSerializer(),
					new TriangleJsonSerializer(), this);
			Serializer serializer = serializers.getSerializers().get(innerShape.getType());
			serializer.serialize(innerShape, os);
			count++;
			if (count < amount) {
				os.write(",".getBytes());
			}
			os.write("]}".getBytes());
		}

	}

}
