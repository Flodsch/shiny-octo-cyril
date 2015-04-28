package main;

import javax.swing.plaf.SliderUI;

import algorithms.BresenhamCircle;
import algorithms.FillPolygon;
import algorithms.MatrixOperations;
import algorithms.BresenhamLine;
import algorithms.NewtonInterpolation;
import objects.Matrix;
import objects.Point;
import renderer.Frame;
import renderer.Panel;

public class Main {

	public static void main(String[] args) {
		final int SIZE = 600;
		Matrix matrix = new Matrix(SIZE, SIZE);
		
		//public static Matrix m = new Matrix(SIZE, SIZE);
		
		BresenhamLine bl = new BresenhamLine(matrix);
		bl.drawLine(new Point(-200,-200), new Point(200,200));
		bl.drawLine(new Point(-200,200), new Point(200,-200));
		bl.drawLine(new Point(50,200), new Point(50,-200));
		
		BresenhamCircle bc = new BresenhamCircle(matrix);
		Point testMiddlepoint= new Point(50,0);
		bc.drawCircle(50, new Point(0,0));
		bc.drawCircle(50, testMiddlepoint );
		
		
		MatrixOperations mo = new MatrixOperations(matrix);
		Point testing = new Point(60,60);
		testing=mo.rotate(180, testMiddlepoint);
		bc.drawCircle(50, testing );
		FillPolygon fp = new FillPolygon(matrix);
		//fp.fill(210, 20);
		fp.fill(new Point(40,0));
		
		Point testRotate = new Point(10,10);
		testRotate = mo.rotate(180, testRotate);
		//testing = mo.scale(150, 150, testing);
		System.out.println(testRotate.getxCoordinate());
		System.out.println(testRotate.getyCoordinate());
		//mo.rotate(25, new Point(200,200));
		/*
		NewtonInterpolation ni = new NewtonInterpolation();
		double[] f = {40.7, 50.9};
		double[] x = {90.3, 66.6};
		ni.newton(f, x);
		*/
		Panel drawingPanel = new Panel(matrix);
		new Frame(drawingPanel);
		
		//drawingPanel.slide(000, 0);
		drawingPanel.rotate(90, new Point(0, 0));
		
	}

}