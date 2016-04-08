package ua.codegym.serializer;

import java.util.HashMap;
import java.util.Map;

import ua.codegym.serializer.shape.Circle;
import ua.codegym.serializer.shape.Group;
import ua.codegym.serializer.shape.Square;
import ua.codegym.serializer.shape.Triangle;


public class Serializers {
	private Map<String, Serializer> serializers = new HashMap<>();
	public Serializers(Serializer squareSerializer, Serializer circleSerializer, Serializer triangleSerializer,Serializer groupSerializer) {
		serializers.put(Square.class.getCanonicalName(), squareSerializer);
		serializers.put(Circle.class.getCanonicalName(), circleSerializer);
		serializers.put(Triangle.class.getCanonicalName(), triangleSerializer);
		serializers.put(Group.class.getCanonicalName(), groupSerializer);
		
	}
	public Map<String, Serializer> getSerializers() {
		return serializers;
	}
	

}
