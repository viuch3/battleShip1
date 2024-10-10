package model;

public class Ship {
	int size;
	boolean isVertical;
	int[][] posicion;
	int cantidadPosicion;
	
	public Ship(int size) {
		this.size = size;
		this.isVertical = true;
		this.posicion = new int[size][2];
		this.cantidadPosicion = 0;
	}

	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public boolean isVertical() {
		return isVertical;
	}

	public void setVertical(boolean isVertical) {
		this.isVertical = isVertical;
	}

	public int[][] getPosicion() {
		return posicion;
	}
	
	public void reiniciarCantidadPosicion() {
		this.cantidadPosicion = 0;
	}

	public void setPosicion(int x, int y) {
		this.posicion[cantidadPosicion][0] = x;
		this.posicion[cantidadPosicion][1] = y;
		cantidadPosicion++;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<size ; i++) {
			sb.append(posicion[i][0]+","+posicion[i][1]);
			sb.append("\n");
		}
		return sb.toString();
	}
	
	
	
	
	
}
