package com.example.restproyect.colaprioridad;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.example.restproyect.dto.Paquete;

@Component
public class ColaPaquete {
	
	private HashMap<Integer,Paquete> paquetes;

	public ColaPaquete() {
		super();
		this.paquetes = new HashMap<Integer, Paquete>();
	}	
	
	public void addPaquete(Paquete nuevoPaquete){
		this.paquetes.put(nuevoPaquete.getIdPaquete(), nuevoPaquete);
	}
	
	public HashMap<Integer, Paquete> getPaquetes() {
		return paquetes;
	}

	public void setPaquetes(HashMap<Integer, Paquete> paquetes) {
		this.paquetes = paquetes;
	}

	public Paquete getPaquete(int idPaquete) {
		return this.paquetes.get(idPaquete);
	}
	
	public void setPaquete(Paquete paquete) {
		System.out.println("Probando el set del paquete");
	}
	
	public ArrayList<Paquete> getPaquetesPorUsuario(int idUsuario){
		ArrayList<Paquete> paquetesUsuario = new ArrayList<Paquete>();
		
		this.paquetes.forEach((idPaquete, paquete)->{
			if(paquete.getIdUsuario() == idUsuario) {
				paquetesUsuario.add(paquete);
			}
		});
		
		return paquetesUsuario;
	}
	
	public String getCantidadDocumentosProcesados() {
		int cantidad = 0;
		for(Integer indexPaquete: this.paquetes.keySet()) {
			cantidad = cantidad+this.paquetes.get(indexPaquete).getCantidadProcesados();
		}
		return String.valueOf(cantidad);
	}

	public boolean hasTodosCompletos() {
		for(Integer indexPaquete: this.paquetes.keySet()) {
			if(!this.paquetes.get(indexPaquete).isCompleto()) {
				return false;
			}
		}
		return true;
	}
}
