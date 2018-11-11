package com.example.restproyect.states;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "leftoverVariaciones", "triggerVariaciones" })

public class Ensilaje implements Serializable{

	@JsonProperty("leftoverVariaciones")
	public List<String> leftoverVariaciones = null;
	
	@JsonProperty("triggerVariaciones")
	public List<String> triggerVariaciones = null;
	
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

	
	public List<String> getLeftoverVariaciones() {
		return leftoverVariaciones;
	}

	public void setLeftoverVariaciones(List<String> leftoverVariaciones) {
		this.leftoverVariaciones = leftoverVariaciones;
	}

	public List<String> getTriggerVariaciones() {
		return triggerVariaciones;
	}

	public void setTriggerVariaciones(List<String> triggerVariaciones) {
		this.triggerVariaciones = triggerVariaciones;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	@Override
	public String toString() {
		return "Ensilaje [leftoverVariaciones=" + leftoverVariaciones + ", triggerVariaciones=" + triggerVariaciones
				+ ", additionalProperties=" + additionalProperties + "]";
	}
	
	

}