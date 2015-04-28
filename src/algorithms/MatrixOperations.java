package algorithms;
import objects.Matrix;
import objects.Point;

public class MatrixOperations {
	
	private Matrix matrix;
	private double[][] operationArray = new double[3][3];
	
	
	public MatrixOperations(Matrix matrix){
		this.resetToIdentityMatrix();
		this.matrix = matrix;
	}
	
	public Point slide(int x, int y, Point point){
		double [][] slideArray = {{1,0,x},{0,1,y},{0,0,1}};
		return this.transform(point, slideArray);
	}
	
	public Point rotate(double angle, Point point){
		double [][] rotationArray = {{Math.round(Math.cos(Math.toRadians(angle))),-Math.round((Math.sin(Math.toRadians(angle)))),0},{Math.round(Math.sin(Math.toRadians(angle))),Math.round(Math.cos(Math.toRadians(angle))),0},{0,0,1}};
		return this.transform(point, rotationArray);
	}
	
	public Point scale(double xPercent, double yPercent, Point point){
		double [][] scaleArray = {{(double)(xPercent/100),0,0},{0,(double)(yPercent/100),0},{0,0,1}};
		return this.transform(point, scaleArray);
	}
	
	//Multiplies 3x3 Matrix -> Untested
	public double [][] multiplyMatrix(double [][] matrixOne, double [][] matrixTwo){
		double [][] result = new double[3][3];
		for(int i = 0; i<3;i++){
			for(int j = 0; j < 3;j++){
				result[i][j] = matrixOne[i][0] * matrixTwo[0][j] + matrixOne[i][1] * matrixTwo[1][j] + matrixOne[i][2] * matrixTwo[2][j];
			}
		}
		return result;
	}
	
	// Offsets between 1 and Matrix Width or Matrix Height
	private Point transform(Point middlepoint, double[][]transformationArray){
		//TODO: If Offsets are in range
		int newxValue = (int)(transformationArray[0][0] * middlepoint.getxCoordinate() + transformationArray[0][1] * middlepoint.getyCoordinate() + transformationArray[0][2]);
		int newyValue = (int)(transformationArray[1][0] * middlepoint.getxCoordinate() + transformationArray[1][1] * middlepoint.getyCoordinate() + transformationArray[1][2]);
		return new Point(newxValue, newyValue);
		//System.out.println("Old Value: " + i +" "+  j + "New Value: " + (middlepoint.getyCoordinate() - newyValue) +" "+  (newxValue+middlepoint.getxCoordinate()));
	}
	
	private void resetToIdentityMatrix(){
		operationArray[0][0] = 1;
		operationArray[0][1] = 0;
		operationArray[0][2] = 0;
		operationArray[1][0] = 0;
		operationArray[1][1] = 1;
		operationArray[1][2] = 0;
		operationArray[2][0] = 0;
		operationArray[2][1] = 0;
		operationArray[2][2] = 1;
	}
	
	
	public Point transform(Point middlepoint){
		return null;
	}
	

}
