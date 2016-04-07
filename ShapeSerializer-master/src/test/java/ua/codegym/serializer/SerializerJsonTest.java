package ua.codegym.serializer;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Test;

import ua.codegym.serializer.shape.Circle;
import ua.codegym.serializer.shape.Shape;
import ua.codegym.serializer.shape.Triangle;

public class SerializerJsonTest {
	@Test
	  public void verifyThatSingleCircleToJsonCorrectly() throws IOException {
		  // given
		    Shape shape = new Circle(0, 1, 5);
		    ByteArrayOutputStream out = new ByteArrayOutputStream();
		    Serializer xml = SerializerFactory.newJsonSerializer();

		    // when
		    xml.serialize(shape, out);

		    // then
		    String output = new String(out.toByteArray());
		    assertEquals("{\"shapeName\": \"Circle\", \"values\": {\"x\":0, \"y\":1, \"radius\":5}}", output);
	  }
	
	 @Test
	  public void verifyThatSingleTriangleToJsonCorrectly() throws IOException {
		  // given
		    Shape shape = new Triangle(1, 1, 4, 1, 3, 4);
		    ByteArrayOutputStream out = new ByteArrayOutputStream();
		    Serializer xml = SerializerFactory.newJsonSerializer();

		    // when
		    xml.serialize(shape, out);

		    // then
		    String output = new String(out.toByteArray());
		    assertEquals("{\"shapeName\": \"Triangle\", \"values\": {\"xA\":1, \"yA\":1, \"xB\":4, \"yB\":1, \"xC\":3, \"yC\":4}}", output);
	  }

}
