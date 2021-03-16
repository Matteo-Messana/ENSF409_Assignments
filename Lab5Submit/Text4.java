
class Text implements Cloneable, Resizable
{
	
	private final Double DEFAULT_SIZE = 10.0;
	
    private Colour colour;
    private Double fontSize;
    
    private String text;


	public Text(String text) {
       this.text = text;
       fontSize = DEFAULT_SIZE;
	}
	
	public Double getFontSize(){
		return fontSize;
	}
	
	public void setFontSize(double fontSize){
		this.fontSize = fontSize;
	}
	
	public void setColour(String s){
		colour = new Colour(s);
	}
	
	public void setText(String newText){
		text = newText;
	}
	
	public String getText(){
		return text ;
	}
	
	@Override
	public String toString(){
		return (text);
	}
	
	public Object clone() throws CloneNotSupportedException
	{
		Text temp = (Text)super.clone();
		return temp;
	}
	
	@Override
	public void enlarge(Double multiplier) throws SizeFactorException {
		if(multiplier < LIMIT)
			throw new SizeFactorException();
		setFontSize(getFontSize()*multiplier);	
	}
	
	@Override
	public void shrink(Double divisor) throws SizeFactorException{
		if(divisor < LIMIT)
			throw new SizeFactorException();
		setFontSize(getFontSize()*divisor);	
	}

       
}
