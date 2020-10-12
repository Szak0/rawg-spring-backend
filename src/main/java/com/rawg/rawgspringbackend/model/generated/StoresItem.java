package com.rawg.rawgspringbackend.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StoresItem{

	@JsonProperty("url_ru")
	private String urlRu;

	@JsonProperty("url_en")
	private String urlEn;

	@JsonProperty("id")
	private int id;

	@JsonProperty("store")
	private Store store;

	public void setUrlRu(String urlRu){
		this.urlRu = urlRu;
	}

	public String getUrlRu(){
		return urlRu;
	}

	public void setUrlEn(String urlEn){
		this.urlEn = urlEn;
	}

	public String getUrlEn(){
		return urlEn;
	}

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

	@Override
 	public String toString(){
		return 
			"StoresItem{" + 
			"url_ru = '" + urlRu + '\'' + 
			",url_en = '" + urlEn + '\'' + 
			",id = '" + id + '\'' + 
			",store = '" + store + '\'' + 
			"}";
		}
}