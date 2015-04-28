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
	
	public void slide(int x, int y){
		double [][] slideArray = {{1,0,x},{0,1,y},{0,0,1}};
		operationArray = this.multiplyMatrix(slideArray, operationArray);
	}
	
	public Point rotate(double angle, Point point){
		double [][] rotationArray = {{Math.round(Math.cos(Math.toRadians(angle))),-Math.round((Math.sin(Math.toRadians(angle)))),0},{Math.round(Math.sin(Math.toRadians(angle))),Math.round(Math.cos(Math.toRadians(angle))),0},{0,0,1}};
		return this.transform(point, rotationArray);
	}
	
	public void rotate(double angle){
		double [][] rotationArray = {{Math.cos(Math.toRadians(angle)),-(Math.sin(Math.toRadians(angle))),0},{Math.sin(Math.toRadians(angle)),Math.cos(Math.toRadians(angle)),0},{0,0,1}};
		System.out.println(rotationArray[0][0] + " " + rotationArray[0][1] + " " + rotationArray[0][2]);
		System.out.println(rotationArray[1][0] + " " + rotationArray[1][1] + " " + rotationArray[1][2]);
		System.out.println(rotationArray[2][0] + " " + rotationArray[2][1] + " " + rotationArray[2][2]);
		operationArray = this.multiplyMatrix(rotationArray, operationArray);
	}
	
	public Point scale(double xPercent, double yPercent, Point point){
		double [][] scaleArray = {{(double)(xPercent/100),0,0},{0,(double)(yPercent/100),0},{0,0,1}};
		return this.transform(point, scaleArray);
	}
	
	public void scale(double xpercent, double ypercent){
		double [][] scaleArray = {{(double)(xpercent/100),0,0},{0,(double)(ypercent/100),0},{0,0,1}};
		operationArray = this.multiplyMatrix(scaleArray, operationArray);
	}
	
	//Multiplies 3x3 Matrix -> Untested
	public double [][] multiplyMatrix(double [][] a, double [][] b){
		double [][] result = new double[3][3];
		for(int i = 0; i<3; i++){
			for(int j = 0; j < 3; j++){
				for(int k=0; k < 3; k++) {
					result[i][j] = result[i][j] + a[i][k] * b[k][j];
				}
			}
		}
		System.out.println(result[0][0] + " " + result[0][1] + " " + result[0][2]);
		System.out.println(result[1][0] + " " + result[1][1] + " " + result[1][2]);
		System.out.println(result[2][0] + " " + result[2][1] + " " + result[2][2]);
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
		
		double newxValue = (operationArray[0][0] * middlepoint.getxCoordinate() + operationArray[0][1] * middlepoint.getyCoordinate() + operationArray[0][2]);
		double newyValue = (operationArray[1][0] * middlepoint.getxCoordinate() + operationArray[1][1] * middlepoint.getyCoordinate() + operationArray[1][2]);
		//System.out.println("Transform Values are: " + newxValue +" " +newyValue);
		return new Point((int)newxValue, (int)newyValue);
	}
	

}
