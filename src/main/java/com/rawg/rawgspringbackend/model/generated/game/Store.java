package com.rawg.rawgspringbackend.model.generated.game;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Store{

	@JsonProperty("games_count")
	private int gamesCount;

	@JsonProperty("domain")
	private String domain;

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

	public void setDomain(String domain){
		this.domain = domain;
	}

	public String getDomain(){
		return domain;
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
			"Store{" + 
			"games_count = '" + gamesCount + '\'' + 
			",domain = '" + domain + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",image_background = '" + imageBackground + '\'' + 
			",slug = '" + slug + '\'' + 
			"}";
		}
}