package algorithms;
import objects.Matrix;

public class MatrixOperations {
	
	private Matrix matrix;
	private double[][] operationArray = new double[3][3];
	
	
	public MatrixOperations(Matrix matrix){
		this.resetToIdentityMatrix();
		this.matrix = matrix;
	}
	
	public void slide(int x, int y){
		double [][] slideArray = {{1,0,0},{0,1,0},{x,y,1}};
	}
	
	public void rotate(double angle, int point){
		double [][] rotationArray = {{Math.cos(angle),-Math.sin(angle),0},{Math.sin(angle),Math.cos(angle),0},{0,0,1}};
		
	}
	
	public void scale(int xPercent, int yPercent){
		double [][] scaleArray = {{(double)(xPercent/100),0,0},{0,(double)(yPercent/100),0},{0,0,1}};
	}
	
	// Offsets between 1 and Matrix Width or Matrix Height
	public void setNewDrawingMatrix(int xOffset, int yOffset){
		//TODO: If Offsets are in range
		
		for(int i = 0; i < matrix.getWidth(); i++){
			for(int j = 0; j < matrix.getHeight(); j++){
				int x = i - xOffset;
				int y = yOffset - j;
				int z = 0;
				multiplyAndDraw(x, y, z);				
			}
		}
	}
	
	
	
	private void multiplyAndDraw(int x, int y, int z){
		
//multiply matrix		
		if (x < matrix.getWidth() && y < matrix.getHeight() && y >= 0 && x >= 0) {
			matrix.setPoint(x, y);
		}
		
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
	
	

}