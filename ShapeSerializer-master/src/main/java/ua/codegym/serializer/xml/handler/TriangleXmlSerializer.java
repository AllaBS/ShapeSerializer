package ua.codegym.serializer.xml.handler;

import java.io.IOException;
import java.io.OutputStream;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Shape;
import ua.codegym.serializer.shape.Triangle;

public class TriangleXmlSerializer implements Serializer {

	@Override
	public void serialize(Shape shape, OutputStream os) throws IOException {
		Triangle triangle = (Triangle) shape;
		int xA = triangle.getxA();
		int yA = triangle.getyA();
		int xB = triangle.getxB();
		int yB = triangle.getyB();
		int xC = triangle.getxC();
		int yC = triangle.getyC(); 
		String out = String.format("<triangle xA=\"%d\" yA=\"%d\" xB=\"%d\" yB=\"%d\" xC=\"%d\" yC=\"%d\"></square>", xA, yA, xB, yB, xC, yC);
		os.write(out.getBytes());

	}

}
