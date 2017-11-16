package com.apiexample.model.api;

import java.util.List;
import java.util.Map;

public class AlbumApiResponse {

	private Map<Long, List<PhotoApi>> albums;

	public Map<Long, List<PhotoApi>> getAlbums() {
		return albums;
	}

	public void setAlbums(Map<Long, List<PhotoApi>> albums) {
		this.albums = albums;
	}

	public int getTotal() {
		return albums.size();
	}
}
