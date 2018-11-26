package com.example.restproyect.states;



import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.example.restproyect.Documento;
import com.example.restproyect.states.objetosinternos.recursosforrajeros.ForrajeroVariacion;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ForrajeroVariaciones"
})
public class RecursoForrajero implements Serializable{

    @JsonProperty("ForrajeroVariaciones")
    private List<ForrajeroVariacion> forrajeroVariaciones = null;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    
	public RecursoForrajero(List<ForrajeroVariacion> forrajeroVariaciones, Map<String, Object> additionalProperties) {
		super();
		this.forrajeroVariaciones = forrajeroVariaciones;
		this.additionalProperties = additionalProperties;
	}

	@Override
	public String toString() {
		return "RecursoForrajero [forrajeroVariaciones=" + forrajeroVariaciones + ", additionalProperties="
				+ additionalProperties + "]";
	}

	private String getMonth(int valorMes) {
		switch(valorMes) {
			case 0: 
				return "January";
			case 1: 
				return "February";
			case 2: 
				return "March";
			case 3: 
				return "April";
			case 4: 
				return "May";
			case 5: 
				return "June";
			case 6: 
				return "July";
			case 7: 
				return "August";
			case 8: 
				return "September";
			case 9: 
				return "October";
			case 10: 
				return "November";
			case 11: 
				return "December";
		}
		
		return "";
	}
	public HashMap<Integer, Documento> generarEscenarios(HashMap<Integer, Documento> escenarios) {
		
		HashMap<Integer, Documento> newEscenarios = new HashMap<>();
		
		//Por cada escenario que entre. Los escenarios arrancan en 1
		for(int indexEscenarios = 0; indexEscenarios < escenarios.size(); indexEscenarios++) {
			//Generar para ese escenario, la variacion correspondiente
			for(int indexForrajeros = 0; indexForrajeros < forrajeroVariaciones.size(); indexForrajeros++) {
				this.forrajeroVariaciones.get(indexForrajeros).setUltimoValor();
				Document newDocument = escenarios.get(indexEscenarios+1).getDocumento();
				
				Documento doc = new Documento(newDocument);			
				Document insertDoc = doc.clonarDocumento();
				doc.setDocumento(insertDoc);
				
				//Para cada tag dentro del tag <escenario> Busco los tags que tienen las variaciones
				NodeList node = doc.getDocumento().getChildNodes().item(0).getChildNodes();		
				

				for(int j=0; j < node.getLength(); j++) {
					/*
					 * indice par es un text dentro de los tags, solo 
					 * se trabaja con los elementos impares
					 * que son los TAGS
					 */
					
					if(j%2 != 0) {
						Element nodo = (Element) node.item(j);
						if(nodo.getNodeName().equals("pastureType")) {
							//Obtengo la pastura a variar
							NodeList nodePastura = nodo.getChildNodes();
							//Formula para obtener la pastura que va a variar
							Element nodoPastura = (Element) nodePastura.item(indexForrajeros*2+1);
							
							//Obtengo los hijos de la pastura
							NodeList nodePasturaIndex = nodoPastura.getChildNodes();
							
							//Parametro que va a variar pastureAccumRateMean
							Element  nodoPasturaIndex = (Element) nodePasturaIndex.item(1);
							
							for(int month = 0; month < 12; month ++) {
								nodoPasturaIndex.setAttribute(this.getMonth(month), 
										          String.valueOf(forrajeroVariaciones.get(indexForrajeros).next()));
							}
							
							
						}
						
					}
					
				}
				newEscenarios.put(newEscenarios.size()+1,doc);
			}
			
		}
		
		
		return newEscenarios;
	}

    
    
}