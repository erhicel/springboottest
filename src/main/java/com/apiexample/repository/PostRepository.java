package com.apiexample.repository;

import org.springframework.data.repository.CrudRepository;

import com.apiexample.model.api.PostApiResponse;

public interface PostRepository extends CrudRepository<PostApiResponse, Long> {

	public PostApiResponse findByUserIdAndMessageAndUpperName(String userId, String message, String upperName);
}
