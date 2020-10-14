package com.rawg.rawgspringbackend.model.generated.game;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParentPlatformsItem{

	@JsonProperty("platform")
	private Platform platform;

	public void setPlatform(Platform platform){
		this.platform = platform;
	}

	public Platform getPlatform(){
		return platform;
	}

	@Override
 	public String toString(){
		return 
			"ParentPlatformsItem{" + 
			"platform = '" + platform + '\'' + 
			"}";
		}
}