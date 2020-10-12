package com.rawg.rawgspringbackend.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequirementsRu{

	@JsonProperty("minimum")
	private String minimum;

	@JsonProperty("recommended")
	private String recommended;

	public void setMinimum(String minimum){
		this.minimum = minimum;
	}

	public String getMinimum(){
		return minimum;
	}

	public void setRecommended(String recommended){
		this.recommended = recommended;
	}

	public String getRecommended(){
		return recommended;
	}

	@Override
 	public String toString(){
		return 
			"RequirementsRu{" + 
			"minimum = '" + minimum + '\'' + 
			",recommended = '" + recommended + '\'' + 
			"}";
		}
}