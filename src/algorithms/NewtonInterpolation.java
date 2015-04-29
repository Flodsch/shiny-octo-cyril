package algorithms;

import java.util.ArrayList;

import objects.Matrix;
import objects.Point;
import objects.Polynom;

public class NewtonInterpolation {
	private Matrix matrix;
	private double[] coefficients;
	
	public NewtonInterpolation(Matrix matrix) {
		this.matrix = matrix;
	}
	
	public void interpolate(double[] x, double[] y) {
		//avoid erros instead of exception handling
		if (x.length != y.length) {
            System.out.println("dimension error");
            return;
        }

        if (x.length < 3) {
            System.out.println("number is too small");
            return;
        }
		
		int n = x.length;
		  coefficients = y.clone();
		  for(int i=1; i<n; i++) {
		    for(int j=n-1; j>=i; j--) {
		        coefficients[j] = (coefficients[j]-coefficients[j-1])/(x[j]-x[j-i]);
		    }
		  }
		  Polynom p = new Polynom(coefficients, x);
		draw(p);
	}
	
	
	private void draw(Polynom p) {
		BresenhamLine bresenhamLine = new BresenhamLine(matrix);
		int width = matrix.getWidth();
		ArrayList<Point> points = new ArrayList<Point>();
		for(int i=-width; i<width; i++) {
			points.add(new Point(i, p.getYforX(i)));
			matrix.setPointByCoordinates(new Point(i, p.getYforX(i)));
		}
		for(int i=0; i<points.size()-1; i++) {
			bresenhamLine.drawLine(points.get(i), points.get(i+1));
		}
	}
}