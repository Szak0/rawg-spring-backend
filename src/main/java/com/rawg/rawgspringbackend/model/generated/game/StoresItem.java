package com.rawg.rawgspringbackend.model.generated.game;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StoresItem{

	@JsonProperty("id")
	private int id;

	@JsonProperty("store")
	private Store store;

	@JsonProperty("url")
	private String url;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setStore(Store store){
		this.store = store;
	}

	public Store getStore(){
		return store;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"StoresItem{" + 
			"id = '" + id + '\'' + 
			",store = '" + store + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}