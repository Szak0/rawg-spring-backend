package com.rawg.rawgspringbackend.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequirementsEn{

	@JsonProperty("minimum")
	private String minimum;

	public void setMinimum(String minimum){
		this.minimum = minimum;
	}

	public String getMinimum(){
		return minimum;
	}

	@Override
 	public String toString(){
		return 
			"RequirementsEn{" + 
			"minimum = '" + minimum + '\'' + 
			"}";
		}
}