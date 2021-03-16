

class Circle extends Shape 
{
	private Double radius;

	Circle(Double x_origin, Double y_origin, Double newradius,  String name, Colour colour) throws SizeFactorException{
		super(x_origin, y_origin, name, colour);
		radius = newradius;
	}
	
	
	public void set_radius(Double newradius){
		radius = newradius;
	}
	
	public Double get_radius() {
		return radius;
	}
	
	public Double area() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	public Double perimeter() {
		return 2 * Math.PI * radius;
	}
	
	public Double  volume(){
		return 0.0;
	}
	
	
	public String toString(){
		String s = super.toString()+ "\nRadius: " + radius;
		return s;
	}
	
	public Object clone() throws CloneNotSupportedException
	{
		Circle temp = (Circle)super.clone();
		return temp;
	}
	
	@Override
	public void enlarge(Double multiplier) throws SizeFactorException
	{
		if(multiplier < LIMIT)
			throw new SizeFactorException();
		set_radius(get_radius()*multiplier);
	}
	
	@Override
	public void shrink(Double divisor) throws SizeFactorException
	{
		if(divisor < LIMIT)
			throw new SizeFactorException();
		set_radius(get_radius()*divisor);
	}
         
}