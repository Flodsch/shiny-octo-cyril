package main;

import javax.swing.plaf.SliderUI;

import algorithms.Bezier;
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
		MatrixOperations mo = new MatrixOperations(matrix);
		BresenhamLine bl = new BresenhamLine(matrix);
		BresenhamCircle bc = new BresenhamCircle(matrix);
		Bezier bz = new Bezier(matrix);
		
		//public static Matrix m = new Matrix(SIZE, SIZE);
		/*
		
		bl.drawLine(new Point(-200,-200), new Point(200,200));
		bl.drawLine(new Point(-200,200), new Point(200,-200));
		bl.drawLine(new Point(50,200), new Point(50,-200));
		
		
		Point testMiddlepoint= new Point(50,0);
		bc.drawCircle(50, new Point(0,0));
		bc.drawCircle(50, testMiddlepoint );
		
		
		
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
		
		NewtonInterpolation ni = new NewtonInterpolation();
		double[] f = {40.7, 50.9};
		double[] x = {90.3, 66.6};
		ni.newton(f, x);
		*/
		
		
		
		//bl.drawLine(new Point(100,100), new Point(100,-100));
		//bc.drawCircle(50, new Point(50,0));
		bz.addPoint(new Point(-200,-100));
		bz.addPoint(new Point(-50,100));
		bz.addPoint(new Point(100,80));
		bz.addPoint(new Point(150,-50));
		bz.draw();
		Panel drawingPanel = new Panel(matrix);
		//drawingPanel.rotate(180);
		//drawingPanel.scale(150, 150);
		//drawingPanel.slide(50, 50);
		new Frame(drawingPanel);
		
		//drawingPanel.slide(0, 0);
		
		//drawingPanel.rotate(90, new Point(0, 0));
		//drawingPanel.slide(200, 15);
		//drawingPanel.rotate(30);
		
		
		
		//mo.scale(150, 150);
		/*
		Point testpunkt = new Point(100,150);
		mo.rotate(90);
		testpunkt = mo.transform(testpunkt);
		System.out.println(testpunkt.getxCoordinate() + " " + testpunkt.getyCoordinate());
		int xValue = testpunkt.getxCoordinate() + 300;
		int yValue = -testpunkt.getyCoordinate() + 300;
		System.out.println(xValue + " " + yValue);
		*/
		
	}

}