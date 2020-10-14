package com.rawg.rawgspringbackend.model.generated.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rawg.rawgspringbackend.model.generated.Games;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidEndpoint extends Games {

	public InvalidEndpoint(String detail) {
		this.detail = detail;
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	@JsonProperty("detail")
	private String detail;

	public void setDetail(String detail){
		this.detail = detail;
	}

	public String getDetail(){
		return detail;
	}

	@Override
 	public String toString(){
		return 
			"InvalidEndpoint{" +
			"detail = '" + detail + '\'' + 
			"}";
		}
}