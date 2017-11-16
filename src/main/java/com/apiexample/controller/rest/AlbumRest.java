package com.apiexample.controller.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiexample.model.api.AlbumApiResponse;
import com.apiexample.service.AlbumService;

@RestController
@RequestMapping(value = "/rest")
public class AlbumRest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AlbumService albumService;

	@GetMapping("/albums")
	public AlbumApiResponse albums() {
		AlbumApiResponse result = albumService.albumResponseList();
		logger.info(result.toString());
		return result;
	}

}
