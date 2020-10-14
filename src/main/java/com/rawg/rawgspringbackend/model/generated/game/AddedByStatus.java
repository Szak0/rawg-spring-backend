package com.rawg.rawgspringbackend.model.generated.game;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddedByStatus{

	@JsonProperty("owned")
	private int owned;

	@JsonProperty("beaten")
	private int beaten;

	public void setOwned(int owned){
		this.owned = owned;
	}

	public int getOwned(){
		return owned;
	}

	public void setBeaten(int beaten){
		this.beaten = beaten;
	}

	public int getBeaten(){
		return beaten;
	}

	@Override
 	public String toString(){
		return 
			"AddedByStatus{" + 
			"owned = '" + owned + '\'' + 
			",beaten = '" + beaten + '\'' + 
			"}";
		}
}