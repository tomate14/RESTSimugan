package com.example.restproyect.states;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.restproyect.states.objetosinternos.feedlot.VariacionFeedLot;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "VariacionFeedLot" })
public class Feedlot implements Serializable{

	@JsonProperty("VariacionFeedLot")
	private List<VariacionFeedLot> variacionFeedLot = null;
	
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

	public List<VariacionFeedLot> getVariacionFeedLot() {
		return variacionFeedLot;
	}

	public void setVariacionFeedLot(List<VariacionFeedLot> variacionFeedLot) {
		this.variacionFeedLot = variacionFeedLot;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	@Override
	public String toString() {
		return "Feedlot [variacionFeedLot=" + variacionFeedLot + ", additionalProperties=" + additionalProperties + "]";
	}
	
	

}