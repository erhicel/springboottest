package com.apiexample.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apiexample.converter.PostConverter;
import com.apiexample.exception.PostNotFoundException;
import com.apiexample.model.api.PostApiResponse;
import com.apiexample.model.extern.PostResponse;
import com.apiexample.repository.PostRepository;

@Service
@CacheConfig(cacheNames = "posts")
public class PostService {

	@Autowired
	private PostConverter postConverter;

	@Autowired
	private MolestiaService molestiaService;

	@Autowired
	PostRepository postRepository;

	public PostApiResponse postApiCallExample() {
		RestTemplate restTemplate = new RestTemplate();
		PostResponse postResponse = restTemplate
				.getForObject(URI.create("https://jsonplaceholder.typicode.com/posts/1"), PostResponse.class);
		return postConverter.convert(postResponse);
	}

	@Cacheable
	public List<PostApiResponse> postListExternal() {
		System.out.println("////////////////////");
		System.out.println("////////////////////");
		System.out.println("////////////////////");
		System.out.println("////////////////////");
		System.out.println("////////////////////");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<PostResponse[]> postResponseEntity = restTemplate
				.getForEntity(URI.create("https://jsonplaceholder.typicode.com/posts"), PostResponse[].class);
		List<PostResponse> postResponseList = Arrays.asList(postResponseEntity.getBody());
		molestiaService.saveMolestiaPost(postResponseList);
		return convertToPostApiResponse(postResponseList);
	}

	/*
	 * Version java8 return postResponseList.stream().map(postResponse ->
	 * postConverter.convert(postResponse)) .collect(Collectors.toList());
	 */
	public List<PostApiResponse> convertToPostApiResponse(List<PostResponse> postResponseList) {
		List<PostApiResponse> postApiResponseList = new ArrayList<PostApiResponse>();
		for (PostResponse postResponse : postResponseList) {
			postApiResponseList.add(postConverter.convert(postResponse));
		}
		return postApiResponseList;

	}

	public List<PostApiResponse> findAllDB() {
		return (List<PostApiResponse>) postRepository.findAll();
	}

	@CacheEvict(cacheNames = "posts", allEntries = true)
	public PostApiResponse savePostApiResponse(PostApiResponse postApiResponse) {

		return postRepository.save(postApiResponse);
	}

	public PostApiResponse findOne(Integer number) {

		PostApiResponse postDB = postRepository.findOne(number.longValue());

		if (postDB == null) {
			throw new PostNotFoundException(number.longValue(), "post not found");
		}

		return postDB;
	}

	public void deleteOne(Integer number) {

		postRepository.delete(number.longValue());
	}

}
