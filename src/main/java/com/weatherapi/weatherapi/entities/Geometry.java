package com.weatherapi.weatherapi.entities;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Geometry{
    public String type;
    
    public HashMap<Float, Float> statCoordinates = new HashMap<Float, Float>();
    public ArrayList<ArrayList<ArrayList<ArrayList<Float>>>> coordinates;
    //ArrayList<ArrayList<ArrayList<ArrayList<Double>>>> 
	public Geometry() {
		super();
	}
	public Geometry(String type, ArrayList<ArrayList<ArrayList<ArrayList<Float>>>> coordinates) {
		super();
		this.type = type;
		this.coordinates = coordinates;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ArrayList<ArrayList<ArrayList<ArrayList<Float>>>> getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(ArrayList<ArrayList<ArrayList<ArrayList<Float>>>> coordinates) {
		this.coordinates = coordinates;
	}
	@Override
	public String toString() {
		return "Geometry [type=" + type + ", coordinates=" + getCoord() + "]";
	}
	
	public HashMap<Float,Float> getCoord(){
		List<Float> myCoord = flattenArray(coordinates);
		
		
		for (int i=0; i<myCoord.size()-1; i++) {
			
			if (i %2==0) {
			statCoordinates.put(myCoord.get(i),myCoord.get(i+1));
			}
			else {
				statCoordinates.put(myCoord.get(i+1),myCoord.get(i));
			}
		}
		return statCoordinates;
	}
   
	
	public List<Float> flattenArray(ArrayList<ArrayList<ArrayList<ArrayList<Float>>>> arr){
		
		return arr
				.stream().flatMap(Collection::stream).
				collect(Collectors.toList())
				.stream().flatMap(Collection::stream).
				collect(Collectors.toList())
				.stream().flatMap(Collection::stream).
				collect(Collectors.toList());
	}
	
	
	public List<Float> getCoordList(){
		
		return flattenArray(coordinates);
	}
//	private static ArrayList<Object> flatten(Object[] array) {
//	    return (ArrayList<Object>) Arrays.stream(array)
//	        .flatMap(o -> o instanceof Object[]? (Stream<Object>) flatten((Object[])o): Stream.of(o))
//	        .collect(Collectors.toList());
//	}
    
    
}