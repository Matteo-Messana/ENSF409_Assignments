
class Rectangle extends Shape 
{
	protected Double width, length;
	
	public Rectangle(Double x_origin, Double y_origin, Double newlength, Double newwidth, String  name, Colour colour) throws SizeFactorException{
		super(x_origin, y_origin, name, colour);
		length= newlength;
		width =newwidth;
	}
	
	protected void  set_length(Double newlength){
		length = newlength;
	}
	
	protected Double  get_length() {
		return length;
	}
	
	protected void  set_width(Double newwidth){
		length = newwidth;
	}
	
	protected Double  get_width() {
		return length;
	}
	
	protected Double  area(){
		return  width *length;
	}
	
	protected Double  perimeter(){
		return  width  * 2 + length * 2;
	}
	
	protected Double  volume(){
		return 0.0;
	}
	
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
		
	@Override
	public String toString(){
		String s = super.toString()+ "\nWidth: " + width + "\nLength: " + length;
		return s;
	}
	
	@Override
	public void enlarge(Double multiplier) throws SizeFactorException
	{
		if(multiplier < LIMIT)
			throw new SizeFactorException();
		set_width(get_width()*multiplier);
		set_length(get_length()*multiplier);
		
	}
	
	@Override
	public void shrink(Double divisor) throws SizeFactorException
	{
		if(divisor < LIMIT)
			throw new SizeFactorException();
		set_width(get_width()*divisor);
		set_length(get_length()*divisor);
	}
        	
	
}