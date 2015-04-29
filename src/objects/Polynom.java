package objects;

public class Polynom {
	
	private double[] coefficients;
	private double[] xValues;
	
	public Polynom(double[] coefficients, double[] xValues) {
		this.coefficients = coefficients;
		this.xValues = xValues;
	}
	
	public int getYforX(double x) {
		//print();
		 double erg = coefficients[coefficients.length-1];
		    for( int i = coefficients.length - 2; i >= 0; i--)
		    erg = coefficients[i] + (x - xValues[i]) * erg;
		    return (int) Math.round(erg);
	}

}