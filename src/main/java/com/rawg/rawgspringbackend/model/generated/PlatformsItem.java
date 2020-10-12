package com.rawg.rawgspringbackend.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlatformsItem{

	@JsonProperty("requirements_ru")
	private RequirementsRu requirementsRu;

	@JsonProperty("requirements_en")
	private RequirementsEn requirementsEn;

	@JsonProperty("released_at")
	private String releasedAt;

	@JsonProperty("platform")
	private Platform platform;

	public void setRequirementsRu(RequirementsRu requirementsRu){
		this.requirementsRu = requirementsRu;
	}

	public RequirementsRu getRequirementsRu(){
		return requirementsRu;
	}

	public void setRequirementsEn(RequirementsEn requirementsEn){
		this.requirementsEn = requirementsEn;
	}

	public RequirementsEn getRequirementsEn(){
		return requirementsEn;
	}

	public void setReleasedAt(String releasedAt){
		this.releasedAt = releasedAt;
	}

	public String getReleasedAt(){
		return releasedAt;
	}

	public void setPlatform(Platform platform){
		this.platform = platform;
	}

	public Platform getPlatform(){
		return platform;
	}

	@Override
 	public String toString(){
		return 
			"PlatformsItem{" + 
			"requirements_ru = '" + requirementsRu + '\'' + 
			",requirements_en = '" + requirementsEn + '\'' + 
			",released_at = '" + releasedAt + '\'' + 
			",platform = '" + platform + '\'' + 
			"}";
		}
}