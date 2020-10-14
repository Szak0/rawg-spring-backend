package com.rawg.rawgspringbackend.model.generated.game;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PublishersItem{

	@JsonProperty("games_count")
	private int gamesCount;

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private int id;

	@JsonProperty("image_background")
	private String imageBackground;

	@JsonProperty("slug")
	private String slug;

	public void setGamesCount(int gamesCount){
		this.gamesCount = gamesCount;
	}

	public int getGamesCount(){
		return gamesCount;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setImageBackground(String imageBackground){
		this.imageBackground = imageBackground;
	}

	public String getImageBackground(){
		return imageBackground;
	}

	public void setSlug(String slug){
		this.slug = slug;
	}

	public String getSlug(){
		return slug;
	}

	@Override
 	public String toString(){
		return 
			"PublishersItem{" + 
			"games_count = '" + gamesCount + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",image_background = '" + imageBackground + '\'' + 
			",slug = '" + slug + '\'' + 
			"}";
		}
}