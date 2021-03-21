package application;

import java.util.concurrent.Semaphore;

import controller.ThreadAluno;

public class Programa {
	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		
		for(int x = 1; x <= 4; x++) {
			int velocidade = (int) (Math.random() * 6) + 4;
			Thread t = new ThreadAluno(x, velocidade, semaforo);
			t.start();
		}
		
	}
}
