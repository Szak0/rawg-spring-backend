package com.rawg.rawgspringbackend.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShortScreenshotsItem{

	@JsonProperty("image")
	private String image;

	@JsonProperty("id")
	private int id;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"ShortScreenshotsItem{" + 
			"image = '" + image + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}