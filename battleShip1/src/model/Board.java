package model;

public class Board {
	int[][] board;
	Ship[] ships;

	public Board() {
		this.board = new int[10][10];
		this.ships = new Ship[5];
		this.ships[0] = new Ship(2);
		this.ships[1] = new Ship(3);
		this.ships[2] = new Ship(3);
		this.ships[3] = new Ship(4);
		this.ships[4] = new Ship(5);
	}
	

	/**
	 * Coloca un barco de manera vertical en el tablero en la posicion deseada
	 * @param barco, Ship que se va a colocar en el tablero
	 * @param posicionX, int posicion en el eje x
	 * @param posicionY, int posicion en el eje y
	 * @return true, si se coloco el barco
	 * 			false, si no
	 */
	public boolean putBarco(Ship barco, int posicionX, int posicionY) {
		boolean despejado = true;
		boolean completado = false;
		
		if(posicionX >= 0 && posicionX < 10 && posicionY >= 0 && posicionY <= 10-barco.getSize()) {
			for(int i = posicionY ; i < posicionY+barco.getSize() ; i++) {
				if(board[i][posicionX] != 0) {
					despejado = false;
				}
			}
			if(despejado) {
				for(int i = posicionY ; i < posicionY + barco.getSize() ; i++) {
					board[i][posicionX] = barco.getSize();
					barco.setPosicion(posicionX, i);
				}
				completado = true;
			}
		}
		return completado;
	}
	
	public void deleteBarco(Ship barco) {
		for(int i = 0 ; i < barco.getSize() ; i++) {
			board[barco.getPosicion()[i][1]][barco.getPosicion()[i][0]] = 0;
		}
		barco.reiniciarCantidadPosicion();
	}
	
	public boolean turnBarco(Ship barco) {
		boolean despejado = true;
		boolean completado = false;
		
		if(barco.isVertical()) {
			if(barco.getPosicion()[0][0] <= 10-barco.getSize()) {
				for(int i = barco.getPosicion()[0][0]+1 ; i < barco.getPosicion()[0][0] + barco.getSize() ; i++) {
					if(board[barco.getPosicion()[0][1]][i] != 0) {
						despejado = false;
					}
				}
				if(despejado) {
					barco.reiniciarCantidadPosicion();
					for(int i = barco.getPosicion()[0][1] ; i < barco.getPosicion()[0][1] + barco.getSize() ; i++) {
						board[i][barco.getPosicion()[0][0]] = 0;
					}
					
					for(int i = barco.getPosicion()[0][0] ; i < barco.getPosicion()[0][0] + barco.getSize() ; i++) {
						board[barco.getPosicion()[0][1]][i] = barco.getSize();
						barco.setPosicion(i, barco.getPosicion()[0][1]);
					}
					barco.setVertical(false);
					completado = true;
				}
			}	
		}
		else {
			this.deleteBarco(barco);
			for(int i = barco.getPosicion()[0][1] ; i < barco.getPosicion()[0][1] + barco.getSize() ; i++) {
				board[i][barco.getPosicion()[0][0]] = barco.getSize();
				barco.setPosicion(barco.getPosicion()[0][0], i);
				
			}
			barco.setVertical(true);
		}
		

		return completado;
	}
	
    public int[][] getBoard() {
		return board;
	}


	public void setBoard(int[][] board) {
		this.board = board;
	}


	public Ship[] getShips() {
		return ships;
	}


	public void setShips(Ship[] ships) {
		this.ships = ships;
	}


	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("    0   1   2   3   4   5   6   7   8   9\n");
        sb.append("  +---+---+---+---+---+---+---+---+---+---+\n");
        for (int i = 0; i < 10; i++) { 
            sb.append(i + " "); 
            for (int j = 0; j < 10; j++) {
                sb.append("| " + board[i][j] + " "); 
            }
            sb.append("|\n"); 
            sb.append("  +---+---+---+---+---+---+---+---+---+---+\n"); 
        }
        return sb.toString();
    }
}
