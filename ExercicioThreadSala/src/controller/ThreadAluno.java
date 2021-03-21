package controller;

import java.util.concurrent.Semaphore;

public class ThreadAluno extends Thread {
	private int id;
	private int velocidade;
	private static int distancia = 200;
	private Semaphore semaforo;

	public ThreadAluno(int id, int velocidade, Semaphore semaforo) {
		this.id = id;
		this.velocidade = velocidade;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		andar();
		abrirPorta();
	}

	private void andar() {
		int distanciaPercorrida = 0;
		while (distanciaPercorrida < distancia) {
			distanciaPercorrida += velocidade;
			if (distanciaPercorrida > 200) {
				distanciaPercorrida = 200;
				System.out.println("Aluno #" + id + " percorreu " + distanciaPercorrida + " m");
			} else {
				System.out.println("Aluno #" + id + " percorreu " + distanciaPercorrida + " m");
			}
		}
	}

	private synchronized void abrirPorta() {
		try {
			semaforo.acquire();
			int tempo = (int) (Math.random() * 2) + 1;
			System.out.println("Aluno #" + id + " está abrindo a porta");
			sleep(tempo);
			System.out.println("Aluno #" + id + " entrou na sala");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}

	}

}
