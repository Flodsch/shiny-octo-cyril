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
	private Matrix matrix;
	private MatrixOperations mo;
	
	public Panel(Matrix matrix) {
		this.matrix = matrix;
		mo = new MatrixOperations(matrix);
		this.setPreferredSize(new Dimension(matrix.getWidth(), matrix.getHeight()));
		//this.setSize(Matrix.getWidth(), Matrix.getHeight());
	}
	
	 @Override
	 public void paintComponent(Graphics g) {
		 super.paintComponent(g);
		 render(g);
	 }

	private void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		//g2d.drawline(x, y, x, y);
		
		for(int i=0; i<matrix.getWidth(); i++) {
			for(int j=0; j<matrix.getHeight(); j++) {
				if(matrix.getPoint(j, i) == 1) {
					g2d.setColor(Color.BLACK);
					g2d.drawLine(j,i,j,i);
				}
			}
		}
		
		
	}
	
	public void rotate(double angle, Point point){
		Matrix tempArray = new Matrix(matrix.getWidth(), matrix.getHeight());
		for(int x = 0; x < matrix.getWidth(); x++){
			for(int y = 0; y < matrix.getHeight(); y++){
				if(matrix.getPoint(x, y)==1){
					Point newPoint = mo.rotate(angle, new Point(x,y));
					tempArray.setPointByCoordinates(new Point(newPoint.getxCoordinate(), newPoint.getyCoordinate()));
				}
			}
		}
		matrix.setMatrix(tempArray.getMatrix());
	}
	
	public void slide(int xslide, int yslide){
		Matrix tempArray = new Matrix(matrix.getWidth(), matrix.getHeight());
		for(int x = 0; x < matrix.getWidth(); x++){
			for(int y = 0; y < matrix.getHeight(); y++){
				if(matrix.getPoint(x, y)==1){
					Point newPoint = mo.slide(xslide, yslide, new Point(x,y));
					tempArray.setPoint(newPoint.getxCoordinate(), newPoint.getyCoordinate());
				}
			}
		}
		matrix.setMatrix(tempArray.getMatrix());
	}
	
	public void scale(double xpercent, double ypercent){
		Matrix tempArray = new Matrix(matrix.getWidth(), matrix.getHeight());
		for(int x = 0; x < matrix.getWidth(); x++){
			for(int y = 0; y < matrix.getHeight(); y++){
				if(matrix.getPoint(x, y)==1){
					Point newPoint = mo.scale(xpercent, ypercent, new Point(x,y));
					tempArray.setPoint(newPoint.getxCoordinate(), newPoint.getyCoordinate());
				}
			}
		}
		matrix.setMatrix(tempArray.getMatrix());
	}
}