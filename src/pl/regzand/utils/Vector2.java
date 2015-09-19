package pl.regzand.utils;

public class Vector2 {
	
	public double x;
	public double y;
	
	/**
	 * Creates new vector with given coordinates
	 * @param x
	 * @param y
	 */
	public Vector2(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Returns new Vector2 object with the same coordinates
	 * @return
	 */
	public Vector2 copy(){
		return new Vector2(this.x, this.y);
	}
	
	/**
	 * Adds given vector to this vector
	 * @param v
	 * @return this
	 */
	public Vector2 add(Vector2 v){
		return this.add(v.x, v.y);
	}
	
	/**
	 * Adds given coordinates to this vector
	 * @param x
	 * @param y
	 * @return this
	 */
	public Vector2 add(double x, double y){
		this.x += x;
		this.y += y;
		return this;
	}
	
	/**
	 * Subtracts given vector from this vector
	 * @param v
	 * @return this
	 */
	public Vector2 subtract(Vector2 v){
		return this.add(v.x, v.y);
	}
	
	/**
	 * Subtracts given coordinates from this vector
	 * @param x
	 * @param y
	 * @return this
	 */
	public Vector2 subtract(double x, double y){
		this.x -= x;
		this.y -= y;
		return this;
	}
	
	/**
	 * Multiplies this vector by the coordinates of given vector
	 * @param v
	 * @return this
	 */
	public Vector2 multiply(Vector2 v){
		return this.multiply(v.x, v.y);
	}
	
	/**
	 * Multiplies this vector by given coordinates
	 * @param x
	 * @param y
	 * @return this
	 */
	public Vector2 multiply(double x, double y){
		this.x *= x;
		this.y *= y;
		return this;
	}
	
	/**
	 * Multiplies this vector by given value
	 * @param m
	 * @return this
	 */
	public Vector2 multiply(double m){
		this.x *= m;
		this.y *= m;
		return this;
	}
	
	/**
	 * Returns length of this vector
	 * @return
	 */
	public double getLength(){
		return Math.sqrt(this.x*this.x + this.y*this.y);
	}
	
	/**
	 * Sets length of this vector to 1
	 * @return this
	 */
	public Vector2 normalize(){
		double length = this.getLength();
		if(length==0)return this;
		this.x /= length;
		this.y /= length;
		return this;
	}
	
	/**
	 * Compares given object to this one
	 */
	@Override
	public boolean equals(Object other){
	    if (other == null) return false;
	    if (!(other instanceof Vector2))return false;
		
	    Vector2 v = (Vector2)other;
	    return (v.x==this.x && v.y==this.y);
	}
	
	/**
	 * Returns distance between given vectors
	 * @param a
	 * @param b
	 * @return
	 */
	public static double distance(Vector2 a, Vector2 b){
		double x = b.x - a.x;
		double y = b.y - a.y;
		return Math.sqrt(x*x + y*y);
	}
}
