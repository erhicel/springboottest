package com.apiexample.com.apiexample.controler.rest.cache;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.apiexample.model.api.PostApiResponse;
import com.apiexample.service.PostService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

	@Autowired
	PostService postService;

	@Test
	public void thepostsMustBeInCache() {
		postService.postListExternal();
		int totalInitPosts = postService.findAllDB().size();
		assertTrue(!postService.findAllDB().isEmpty());
		postService.postListExternal();
		PostApiResponse postApiResponse = new PostApiResponse();
		postApiResponse.setMessage("MESSAGE TEEEEEST");
		postApiResponse.setUpperName("UPPERNAME TEEEEEST");
		postApiResponse.setUserId("USERID TEEEEEST");
		postService.savePostApiResponse(postApiResponse);
		postService.postListExternal();
		assertTrue(totalInitPosts + 1 == postService.findAllDB().size());
	}

}
