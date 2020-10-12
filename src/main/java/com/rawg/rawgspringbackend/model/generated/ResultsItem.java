package com.rawg.rawgspringbackend.model.generated;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultsItem{

	@JsonProperty("added")
	private int added;

	@JsonProperty("rating")
	private double rating;

	@JsonProperty("metacritic")
	private int metacritic;

	@JsonProperty("playtime")
	private int playtime;

	@JsonProperty("short_screenshots")
	private List<ShortScreenshotsItem> shortScreenshots;

	@JsonProperty("platforms")
	private List<PlatformsItem> platforms;

	@JsonProperty("user_game")
	private Object userGame;

	@JsonProperty("rating_top")
	private int ratingTop;

	@JsonProperty("reviews_text_count")
	private int reviewsTextCount;

	@JsonProperty("ratings")
	private List<RatingsItem> ratings;

	@JsonProperty("genres")
	private List<GenresItem> genres;

	@JsonProperty("saturated_color")
	private String saturatedColor;

	@JsonProperty("id")
	private int id;

	@JsonProperty("added_by_status")
	private AddedByStatus addedByStatus;

	@JsonProperty("parent_platforms")
	private List<ParentPlatformsItem> parentPlatforms;

	@JsonProperty("ratings_count")
	private int ratingsCount;

	@JsonProperty("slug")
	private String slug;

	@JsonProperty("released")
	private String released;

	@JsonProperty("suggestions_count")
	private int suggestionsCount;

	@JsonProperty("stores")
	private List<StoresItem> stores;

	@JsonProperty("tags")
	private List<TagsItem> tags;

	@JsonProperty("background_image")
	private String backgroundImage;

	@JsonProperty("tba")
	private boolean tba;

	@JsonProperty("dominant_color")
	private String dominantColor;

	@JsonProperty("name")
	private String name;

	@JsonProperty("clip")
	private Clip clip;

	@JsonProperty("reviews_count")
	private int reviewsCount;

	public void setAdded(int added){
		this.added = added;
	}

	public int getAdded(){
		return added;
	}

	public void setRating(double rating){
		this.rating = rating;
	}

	public double getRating(){
		return rating;
	}

	public void setMetacritic(int metacritic){
		this.metacritic = metacritic;
	}

	public int getMetacritic(){
		return metacritic;
	}

	public void setPlaytime(int playtime){
		this.playtime = playtime;
	}

	public int getPlaytime(){
		return playtime;
	}

	public void setShortScreenshots(List<ShortScreenshotsItem> shortScreenshots){
		this.shortScreenshots = shortScreenshots;
	}

	public List<ShortScreenshotsItem> getShortScreenshots(){
		return shortScreenshots;
	}

	public void setPlatforms(List<PlatformsItem> platforms){
		this.platforms = platforms;
	}

	public List<PlatformsItem> getPlatforms(){
		return platforms;
	}

	public void setUserGame(Object userGame){
		this.userGame = userGame;
	}

	public Object getUserGame(){
		return userGame;
	}

	public void setRatingTop(int ratingTop){
		this.ratingTop = ratingTop;
	}

	public int getRatingTop(){
		return ratingTop;
	}

	public void setReviewsTextCount(int reviewsTextCount){
		this.reviewsTextCount = reviewsTextCount;
	}

	public int getReviewsTextCount(){
		return reviewsTextCount;
	}

	public void setRatings(List<RatingsItem> ratings){
		this.ratings = ratings;
	}

	public List<RatingsItem> getRatings(){
		return ratings;
	}

	public void setGenres(List<GenresItem> genres){
		this.genres = genres;
	}

	public List<GenresItem> getGenres(){
		return genres;
	}

	public void setSaturatedColor(String saturatedColor){
		this.saturatedColor = saturatedColor;
	}

	public String getSaturatedColor(){
		return saturatedColor;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setAddedByStatus(AddedByStatus addedByStatus){
		this.addedByStatus = addedByStatus;
	}

	public AddedByStatus getAddedByStatus(){
		return addedByStatus;
	}

	public void setParentPlatforms(List<ParentPlatformsItem> parentPlatforms){
		this.parentPlatforms = parentPlatforms;
	}

	public List<ParentPlatformsItem> getParentPlatforms(){
		return parentPlatforms;
	}

	public void setRatingsCount(int ratingsCount){
		this.ratingsCount = ratingsCount;
	}

	public int getRatingsCount(){
		return ratingsCount;
	}

	public void setSlug(String slug){
		this.slug = slug;
	}

	public String getSlug(){
		return slug;
	}

	public void setReleased(String released){
		this.released = released;
	}

	public String getReleased(){
		return released;
	}

	public void setSuggestionsCount(int suggestionsCount){
		this.suggestionsCount = suggestionsCount;
	}

	public int getSuggestionsCount(){
		return suggestionsCount;
	}

	public void setStores(List<StoresItem> stores){
		this.stores = stores;
	}

	public List<StoresItem> getStores(){
		return stores;
	}

	public void setTags(List<TagsItem> tags){
		this.tags = tags;
	}

	public List<TagsItem> getTags(){
		return tags;
	}

	public void setBackgroundImage(String backgroundImage){
		this.backgroundImage = backgroundImage;
	}

	public String getBackgroundImage(){
		return backgroundImage;
	}

	public void setTba(boolean tba){
		this.tba = tba;
	}

	public boolean isTba(){
		return tba;
	}

	public void setDominantColor(String dominantColor){
		this.dominantColor = dominantColor;
	}

	public String getDominantColor(){
		return dominantColor;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setClip(Clip clip){
		this.clip = clip;
	}

	public Clip getClip(){
		return clip;
	}

	public void setReviewsCount(int reviewsCount){
		this.reviewsCount = reviewsCount;
	}

	public int getReviewsCount(){
		return reviewsCount;
	}

	@Override
 	public String toString(){
		return 
			"ResultsItem{" + 
			"added = '" + added + '\'' + 
			",rating = '" + rating + '\'' + 
			",metacritic = '" + metacritic + '\'' + 
			",playtime = '" + playtime + '\'' + 
			",short_screenshots = '" + shortScreenshots + '\'' + 
			",platforms = '" + platforms + '\'' + 
			",user_game = '" + userGame + '\'' + 
			",rating_top = '" + ratingTop + '\'' + 
			",reviews_text_count = '" + reviewsTextCount + '\'' + 
			",ratings = '" + ratings + '\'' + 
			",genres = '" + genres + '\'' + 
			",saturated_color = '" + saturatedColor + '\'' + 
			",id = '" + id + '\'' + 
			",added_by_status = '" + addedByStatus + '\'' + 
			",parent_platforms = '" + parentPlatforms + '\'' + 
			",ratings_count = '" + ratingsCount + '\'' + 
			",slug = '" + slug + '\'' + 
			",released = '" + released + '\'' + 
			",suggestions_count = '" + suggestionsCount + '\'' + 
			",stores = '" + stores + '\'' + 
			",tags = '" + tags + '\'' + 
			",background_image = '" + backgroundImage + '\'' + 
			",tba = '" + tba + '\'' + 
			",dominant_color = '" + dominantColor + '\'' + 
			",name = '" + name + '\'' + 
			",clip = '" + clip + '\'' + 
			",reviews_count = '" + reviewsCount + '\'' + 
			"}";
		}
}