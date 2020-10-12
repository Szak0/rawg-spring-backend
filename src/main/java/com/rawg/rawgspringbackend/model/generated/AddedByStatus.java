package com.rawg.rawgspringbackend.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddedByStatus{

	@JsonProperty("owned")
	private int owned;

	@JsonProperty("beaten")
	private int beaten;

	@JsonProperty("dropped")
	private int dropped;

	@JsonProperty("yet")
	private int yet;

	@JsonProperty("playing")
	private int playing;

	@JsonProperty("toplay")
	private int toplay;

	public void setOwned(int owned){
		this.owned = owned;
	}

	public int getOwned(){
		return owned;
	}

	public void setBeaten(int beaten){
		this.beaten = beaten;
	}

	public int getBeaten(){
		return beaten;
	}

	public void setDropped(int dropped){
		this.dropped = dropped;
	}

	public int getDropped(){
		return dropped;
	}

	public void setYet(int yet){
		this.yet = yet;
	}

	public int getYet(){
		return yet;
	}

	public void setPlaying(int playing){
		this.playing = playing;
	}

	public int getPlaying(){
		return playing;
	}

	public void setToplay(int toplay){
		this.toplay = toplay;
	}

	public int getToplay(){
		return toplay;
	}

	@Override
 	public String toString(){
		return 
			"AddedByStatus{" + 
			"owned = '" + owned + '\'' + 
			",beaten = '" + beaten + '\'' + 
			",dropped = '" + dropped + '\'' + 
			",yet = '" + yet + '\'' + 
			",playing = '" + playing + '\'' + 
			",toplay = '" + toplay + '\'' + 
			"}";
		}
}