package com.rawg.rawgspringbackend.model.generated.game;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlatformsItem{

	@JsonProperty("requirements")
	private Requirements requirements;

	@JsonProperty("released_at")
	private String releasedAt;

	@JsonProperty("platform")
	private Platform platform;

	public void setRequirements(Requirements requirements){
		this.requirements = requirements;
	}

	public Requirements getRequirements(){
		return requirements;
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
			"requirements = '" + requirements + '\'' + 
			",released_at = '" + releasedAt + '\'' + 
			",platform = '" + platform + '\'' + 
			"}";
		}
}