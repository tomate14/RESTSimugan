package com.example.restproyect.mocks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.example.restproyect.dto.Documento;

public class Mockgrid {
	
	private ExecutorService pool;
	private int nodosDisponibles;
	public static final int CANTIDAD_NODOS = 4;
	
	
	
	public Mockgrid() {
		super();
		this.pool = Executors.newFixedThreadPool(CANTIDAD_NODOS);
		this.nodosDisponibles = CANTIDAD_NODOS;
	}
	
	public synchronized boolean ocuparNodo() {
		if(nodosDisponibles > 0) {
			nodosDisponibles--;
			return true;
		}
		return false;
	}
	
	public synchronized boolean liberarNodo() {
		if(nodosDisponibles < CANTIDAD_NODOS) {
			nodosDisponibles++;
			return true;
		}
		return false;
	}
	
	public double getWorkload() {
		return nodosDisponibles / CANTIDAD_NODOS;
	}
	
	public void procesarSimulacion(Documento documento) {
		if(this.ocuparNodo()) {
			MockSimulacion simulacion = new MockSimulacion(documento,this);
			pool.submit(simulacion);
		}
		
	}
	
	public int getNodosDisponibles() {
		return nodosDisponibles;
	}
	public void setNodosDisponibles(int nodosDisponibles) {
		this.nodosDisponibles = nodosDisponibles;
	}
	
	

}