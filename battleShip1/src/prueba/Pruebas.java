package prueba;

import org.junit.jupiter.api.Test;

import model.Board;

class Pruebas {

	@Test
	void test() {
		Board tablero1 = new Board();
		
		assert(tablero1.putBarco(tablero1.getShips()[0], 0, 0) == true);
		assert(tablero1.turnBarco(tablero1.getShips()[0]) == true);
		
		assert(tablero1.putBarco(tablero1.getShips()[1], 1, 1) == true);
		
	}

}
