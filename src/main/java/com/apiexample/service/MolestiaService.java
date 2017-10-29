package com.apiexample.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiexample.converter.PostConverter;
import com.apiexample.model.api.PostApiResponse;
import com.apiexample.model.extern.PostResponse;
import com.apiexample.repository.PostRepository;

@Service
public class MolestiaService {

	@Autowired
	PostRepository postRepository;

	@Autowired
	private PostConverter postConverter;

	public void saveMolestiaPost(List<PostResponse> postResponseList) {
		List<PostResponse> postMolestiaList = new ArrayList<>();
		for (PostResponse postResponse : postResponseList) {
			if (postResponse.getBody().contains("molestias")) {
				postMolestiaList.add(postResponse);
			}
		}
		if (!postMolestiaList.isEmpty()) {
			List<PostApiResponse> postApiResponses = postMolestiaList.stream()
					.map(postResponse -> postConverter.convert(postResponse)).collect(Collectors.toList());
			for (PostApiResponse postApiResponse : postApiResponses) {
				if (postRepository.findByUserIdAndMessageAndUpperName(postApiResponse.getUserId(),
						postApiResponse.getMessage(), postApiResponse.getUpperName()) == null) {
					postRepository.save(postApiResponse);
				} else {
					System.out.println("ya existia en la base de datos " + postApiResponse.toString());
				}
			}
		}

	}
}
