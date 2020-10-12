package com.rawg.rawgspringbackend.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RatingsItem{

	@JsonProperty("count")
	private int count;

	@JsonProperty("id")
	private int id;

	@JsonProperty("title")
	private String title;

	@JsonProperty("percent")
	private double percent;

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setPercent(double percent){
		this.percent = percent;
	}

	public double getPercent(){
		return percent;
	}

	@Override
 	public String toString(){
		return 
			"RatingsItem{" + 
			"count = '" + count + '\'' + 
			",id = '" + id + '\'' + 
			",title = '" + title + '\'' + 
			",percent = '" + percent + '\'' + 
			"}";
		}
}