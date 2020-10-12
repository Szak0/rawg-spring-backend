package com.rawg.rawgspringbackend.model.generated;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Games{

	@JsonProperty("next")
	private String next;

	@JsonProperty("nofollow")
	private boolean nofollow;

	@JsonProperty("noindex")
	private boolean noindex;

	@JsonProperty("nofollow_collections")
	private List<String> nofollowCollections;

	@JsonProperty("previous")
	private Object previous;

	@JsonProperty("count")
	private int count;

	@JsonProperty("description")
	private String description;

	@JsonProperty("seo_h1")
	private String seoH1;

	@JsonProperty("filters")
	private Filters filters;

	@JsonProperty("seo_title")
	private String seoTitle;

	@JsonProperty("seo_description")
	private String seoDescription;

	@JsonProperty("results")
	private List<ResultsItem> results;

	@JsonProperty("seo_keywords")
	private String seoKeywords;

	public void setNext(String next){
		this.next = next;
	}

	public String getNext(){
		return next;
	}

	public void setNofollow(boolean nofollow){
		this.nofollow = nofollow;
	}

	public boolean isNofollow(){
		return nofollow;
	}

	public void setNoindex(boolean noindex){
		this.noindex = noindex;
	}

	public boolean isNoindex(){
		return noindex;
	}

	public void setNofollowCollections(List<String> nofollowCollections){
		this.nofollowCollections = nofollowCollections;
	}

	public List<String> getNofollowCollections(){
		return nofollowCollections;
	}

	public void setPrevious(Object previous){
		this.previous = previous;
	}

	public Object getPrevious(){
		return previous;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setSeoH1(String seoH1){
		this.seoH1 = seoH1;
	}

	public String getSeoH1(){
		return seoH1;
	}

	public void setFilters(Filters filters){
		this.filters = filters;
	}

	public Filters getFilters(){
		return filters;
	}

	public void setSeoTitle(String seoTitle){
		this.seoTitle = seoTitle;
	}

	public String getSeoTitle(){
		return seoTitle;
	}

	public void setSeoDescription(String seoDescription){
		this.seoDescription = seoDescription;
	}

	public String getSeoDescription(){
		return seoDescription;
	}

	public void setResults(List<ResultsItem> results){
		this.results = results;
	}

	public List<ResultsItem> getResults(){
		return results;
	}

	public void setSeoKeywords(String seoKeywords){
		this.seoKeywords = seoKeywords;
	}

	public String getSeoKeywords(){
		return seoKeywords;
	}

	@Override
 	public String toString(){
		return 
			"Games{" + 
			"next = '" + next + '\'' + 
			",nofollow = '" + nofollow + '\'' + 
			",noindex = '" + noindex + '\'' + 
			",nofollow_collections = '" + nofollowCollections + '\'' + 
			",previous = '" + previous + '\'' + 
			",count = '" + count + '\'' + 
			",description = '" + description + '\'' + 
			",seo_h1 = '" + seoH1 + '\'' + 
			",filters = '" + filters + '\'' + 
			",seo_title = '" + seoTitle + '\'' + 
			",seo_description = '" + seoDescription + '\'' + 
			",results = '" + results + '\'' + 
			",seo_keywords = '" + seoKeywords + '\'' + 
			"}";
		}
}