package com.rawg.rawgspringbackend.model.generated;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Filters{

	@JsonProperty("years")
	private List<YearsItem> years;

	public void setYears(List<YearsItem> years){
		this.years = years;
	}

	public List<YearsItem> getYears(){
		return years;
	}

	@Override
 	public String toString(){
		return 
			"Filters{" + 
			"years = '" + years + '\'' + 
			"}";
		}
}