package algorithms;

import java.util.ArrayList;

import objects.*;

public class Bezier {
	private Matrix matrix;
	private ArrayList<Point> points = new ArrayList<Point>();

	public Bezier(Matrix m) {
		this.matrix = m;
	}

	public void draw() {
		BresenhamLine bl = new BresenhamLine(matrix);
		System.out.println("Anzahl an Punkten: " + points.size());
		for (int i = 1; i < points.size(); i++) {
			bl.drawLine(points.get(i - 1), points.get(i));
		}

		// Hier kommt der Algorithmus hin. Man muss die Koordinaten setzen
		ArrayList<Double> tempX = new ArrayList<Double>();
		ArrayList<Double> tempY = new ArrayList<Double>();

		for (double i = 0; i < 1; i += 0.00001) {
			tempX.clear();
			tempY.clear();
			for (int m = 0; m < points.size(); m++) {
				tempX.add((double)points.get(m).getxCoordinate());
				tempY.add((double)points.get(m).getyCoordinate());
			}
			for (int j = 0; j < (points.size() - 1); j++) {
				for (int k = 0; k < (points.size() - j - 1); k++) {
					tempX.set(k, (1-i)*tempX.get(k) + i*tempX.get(k+1));
					tempY.set(k, (1-i)*tempY.get(k) + i*tempY.get(k+1));
				}
			}
			double xhelp = tempX.get(0);
			double yhelp = tempY.get(0);
			int x = (int)xhelp;
			int y = (int)yhelp;
			System.out.println("Koordinaten sind: "+ x +" "+y);
			matrix.setPointByCoordinates(new Point(x,y));

		}

	}

	public void addPoint(Point p) {
		points.add(p);
	}

}
