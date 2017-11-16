package com.apiexample.converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.apiexample.model.api.AlbumApiResponse;
import com.apiexample.model.api.PhotoApi;
import com.apiexample.model.extern.Photo;

@Component
public class AlbumConverter {

	public AlbumApiResponse convertToAlbumApiResponse(List<Photo> photos) {

		AlbumApiResponse albumApiResponse = new AlbumApiResponse();

		for (Photo photo : photos) {
			if (albumApiResponse.getAlbums() == null) {
				albumApiResponse.setAlbums(new HashMap<>());
			}
			if (albumApiResponse.getAlbums().containsKey(photo.getAlbumId())) {
				albumApiResponse.getAlbums().get(photo.getAlbumId()).add(convertToPhotoApi(photo));
			} else {
				// albumApiResponse.getAlbums().put(photo.getAlbumId(),
				// Arrays.asList(convertToPhotoApi(photo)));
				// OTRA FORMA MAS FEA DE CREAR UNA LISTA CON UN OBJETO
				albumApiResponse.getAlbums().put(photo.getAlbumId(), new ArrayList<>());
				albumApiResponse.getAlbums().get(photo.getAlbumId()).add(convertToPhotoApi(photo));
			}
		}

		return albumApiResponse;
	}

	private PhotoApi convertToPhotoApi(Photo photo) {
		PhotoApi photoApi = new PhotoApi();
		photoApi.setId(photo.getId());
		photoApi.setThumbnailUrl(photo.getThumbnailUrl());
		photoApi.setTitle(photo.getTitle().toUpperCase());
		photoApi.setUrl(photo.getUrl().toUpperCase());
		return photoApi;
	}

}
