package algorithms;

import objects.Matrix;
import objects.Point;

public class BresenhamCircle {

	private Matrix matrix;

	public BresenhamCircle(Matrix matrix) {
		// TODO Auto-generated constructor stub
		this.matrix = matrix;
	}

	public void drawCircle(int radius, Point middlepoint) {
		int distance = 3 - (2 * radius);
		int x = 0;
		int y = radius;
		setPoint(x, y, middlepoint);

		while (x < y) {
			if (distance < 0) {
				distance = distance + 4 * x + 6;
				if (distance > 0) {
					y--;
				}
			} else {
				distance = distance + 4 * (x - y) + 10;
				if (distance > 0) {
					y--;
				}
			}
			x++;
			setPoint(x, y, middlepoint);

		}
	}

	private void setPoint(int x, int y, Point middlepoint) {
		int xOffset = (matrix.getWidth() / 2);
		int yOffset = (matrix.getHeight() / 2);
		matrix.setPoint(x + xOffset + middlepoint.getxCoordinate(), yOffset + y - middlepoint.getyCoordinate());
		matrix.setPoint(-x + xOffset + middlepoint.getxCoordinate(), yOffset + y - middlepoint.getyCoordinate());
		matrix.setPoint(x + xOffset + middlepoint.getxCoordinate(), yOffset - y - middlepoint.getyCoordinate());
		matrix.setPoint(-x + xOffset + middlepoint.getxCoordinate(), yOffset - y - middlepoint.getyCoordinate());
		matrix.setPoint(yOffset - y + middlepoint.getxCoordinate(), -x + xOffset - middlepoint.getyCoordinate());
		matrix.setPoint(yOffset + y + middlepoint.getxCoordinate(), x + xOffset - middlepoint.getyCoordinate());
		matrix.setPoint(yOffset + y + middlepoint.getxCoordinate(), -x + xOffset - middlepoint.getyCoordinate());
		matrix.setPoint(yOffset - y + middlepoint.getxCoordinate(), x + xOffset - middlepoint.getyCoordinate());
	}

}