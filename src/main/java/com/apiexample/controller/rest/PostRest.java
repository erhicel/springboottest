package com.apiexample.controller.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiexample.model.api.PostApiResponse;
import com.apiexample.service.MolestiaService;
import com.apiexample.service.PostService;

@RestController
@RequestMapping(value = "/rest")
public class PostRest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public PostService postService;

	@Autowired
	public MolestiaService molestiaService;

	@GetMapping("/postexample/1")
	public PostApiResponse postApiCall() {
		return postService.postApiCallExample();
	}

	// @RequestMapping(method = RequestMethod.GET)
	// public @ResponseBody item getitem(@RequestParam("data") String itemid){
	//
	// item i = itemDao.findOne(itemid);
	// String Itemname=i.getItemname();
	// String price= i.getPrice();
	// return i;
	// }

	@GetMapping("/posts")
	public List<PostApiResponse> postListDB() {
		return postService.findAllDB();
	}

	@GetMapping("/postsexternal")
	public List<PostApiResponse> postExternal() {
		logger.trace("lalalala");
		logger.debug("lalalala");
		logger.info("lalalala");
		logger.warn("lalalala");
		logger.error("lalalala");

		return postService.postListExternal();
	}

	@PostMapping("/posts")
	public PostApiResponse savePost(@RequestBody PostApiResponse postApiResponse) {
		postApiResponse.setMessage("create." + postApiResponse.getMessage().toUpperCase());

		return postService.savePostApiResponse(postApiResponse);
	}

	@PutMapping("/posts")
	public PostApiResponse updatePost(@RequestBody PostApiResponse postApiResponse) {
		postApiResponse.setMessage("update." + postApiResponse.getMessage().toUpperCase());
		return postService.savePostApiResponse(postApiResponse);
	}

	/// posts/25
	@GetMapping("/posts/{number}")
	public PostApiResponse readPost(@PathVariable("number") Integer number) {
		return postService.findOne(number);
	}

	@DeleteMapping("/posts/{number}")
	public ResponseEntity<String> deletePost(@PathVariable("number") Integer number) {
		postService.deleteOne(number);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
