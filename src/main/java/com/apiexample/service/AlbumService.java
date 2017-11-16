package com.apiexample.service;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apiexample.converter.AlbumConverter;
import com.apiexample.model.api.AlbumApiResponse;
import com.apiexample.model.extern.Photo;

@Service
public class AlbumService {

	@Autowired
	public AlbumConverter albumConverter;

	public AlbumApiResponse albumResponseList() {

		// getForEntity para listas
		// getForObject para objetos
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Photo[]> albumResponseEntity = restTemplate
				.getForEntity(URI.create("http://jsonplaceholder.typicode.com/photos"), Photo[].class);
		List<Photo> albumResponseList = Arrays.asList(albumResponseEntity.getBody());

		return albumConverter.convertToAlbumApiResponse(albumResponseList);
	}

}
