package com.rawg.rawgspringbackend.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Clips{

	@JsonProperty("320")
	private String jsonMember320;

	@JsonProperty("640")
	private String jsonMember640;

	@JsonProperty("full")
	private String full;

	public void setJsonMember320(String jsonMember320){
		this.jsonMember320 = jsonMember320;
	}

	public String getJsonMember320(){
		return jsonMember320;
	}

	public void setJsonMember640(String jsonMember640){
		this.jsonMember640 = jsonMember640;
	}

	public String getJsonMember640(){
		return jsonMember640;
	}

	public void setFull(String full){
		this.full = full;
	}

	public String getFull(){
		return full;
	}

	@Override
 	public String toString(){
		return 
			"Clips{" + 
			"320 = '" + jsonMember320 + '\'' + 
			",640 = '" + jsonMember640 + '\'' + 
			",full = '" + full + '\'' + 
			"}";
		}
}