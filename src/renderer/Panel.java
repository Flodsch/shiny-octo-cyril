package renderer;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

import javax.swing.JPanel;

import algorithms.MatrixOperations;
import objects.Matrix;
import objects.Point;

@SuppressWarnings("serial")
public class Panel extends JPanel {
	private Matrix originMatrix;
	private MatrixOperations mo;
	private Point middlepoint;
	
	public Panel(Matrix matrix) {
		this.originMatrix = matrix;
		mo = new MatrixOperations(matrix);
		middlepoint = new Point(originMatrix.getWidth()/2, originMatrix.getHeight()/2);
		this.setPreferredSize(new Dimension(originMatrix.getWidth(), originMatrix.getHeight()));
		//this.setSize(originMatrix.getWidth(), originMatrix.getHeight());
	}
	
	 @Override
	 public void paintComponent(Graphics g) {
		 super.paintComponent(g);
		 render(g);
	 }

	private void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		//g2d.drawline(x, y, x, y);
		for(int x=0; x<originMatrix.getWidth(); x++) {
			for(int y=0; y<originMatrix.getHeight(); y++) {
				if(originMatrix.getPoint(y, x) == 1) {
					int xValue = x - middlepoint.getxCoordinate();
					int yValue = middlepoint.getyCoordinate() - y;
					Point drawingPoint = mo.transform(new Point(xValue,yValue));
					xValue = drawingPoint.getxCoordinate() + middlepoint.getxCoordinate();
					yValue = drawingPoint.getyCoordinate() + middlepoint.getyCoordinate();
					if (xValue < originMatrix.getWidth() && yValue < originMatrix.getHeight() && yValue >= 0 && xValue >= 0) {
						g2d.setColor(Color.BLACK);
						g2d.drawLine(yValue,xValue,yValue,xValue);
					}
				}
			}
		}
		
		
	}
	
	public void rotate(double angle){
		mo.rotate(angle);
	}
	
	public void slide(int xslide, int yslide){
		mo.slide(xslide, yslide);
	}
	
	public void scale(double xpercent, double ypercent){
		mo.scale(xpercent, ypercent);
	}
}