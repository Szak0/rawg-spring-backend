package com.rawg.rawgspringbackend.model.generated;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class YearsItem{

	@JsonProperty("filter")
	private String filter;

	@JsonProperty("nofollow")
	private boolean nofollow;

	@JsonProperty("decade")
	private int decade;

	@JsonProperty("count")
	private int count;

	@JsonProperty("from")
	private int from;

	@JsonProperty("to")
	private int to;

	@JsonProperty("years")
	private List<YearsItem> years;

	@JsonProperty("year")
	private int year;

	public void setFilter(String filter){
		this.filter = filter;
	}

	public String getFilter(){
		return filter;
	}

	public void setNofollow(boolean nofollow){
		this.nofollow = nofollow;
	}

	public boolean isNofollow(){
		return nofollow;
	}

	public void setDecade(int decade){
		this.decade = decade;
	}

	public int getDecade(){
		return decade;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setFrom(int from){
		this.from = from;
	}

	public int getFrom(){
		return from;
	}

	public void setTo(int to){
		this.to = to;
	}

	public int getTo(){
		return to;
	}

	public void setYears(List<YearsItem> years){
		this.years = years;
	}

	public List<YearsItem> getYears(){
		return years;
	}

	public void setYear(int year){
		this.year = year;
	}

	public int getYear(){
		return year;
	}

	@Override
 	public String toString(){
		return 
			"YearsItem{" + 
			"filter = '" + filter + '\'' + 
			",nofollow = '" + nofollow + '\'' + 
			",decade = '" + decade + '\'' + 
			",count = '" + count + '\'' + 
			",from = '" + from + '\'' + 
			",to = '" + to + '\'' + 
			",years = '" + years + '\'' + 
			",year = '" + year + '\'' + 
			"}";
		}
}