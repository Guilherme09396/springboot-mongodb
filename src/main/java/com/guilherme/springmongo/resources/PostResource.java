package com.guilherme.springmongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guilherme.springmongo.domain.Post;
import com.guilherme.springmongo.resources.util.URL;
import com.guilherme.springmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = service.findById(id);
		return ResponseEntity.ok(post);
	}
	
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(name = "title", defaultValue = "") String text) {
		text = URL.decodeUrl(text);
		List<Post> posts = service.findByTitle(text);
		return ResponseEntity.ok(posts);
	}
	
	@GetMapping(value = "/fullsearch")
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(name = "title", defaultValue = "") String text,
			@RequestParam(name = "maxDate", defaultValue = "") String maxDate,
			@RequestParam(name = "minDate", defaultValue = "") String minDate) {
		text = URL.decodeUrl(text);
		Date max = URL.convertDate(maxDate, new Date());
		Date min = URL.convertDate(minDate, new Date(0L));
		List<Post> posts = service.fullSearch(text, min, max);
		return ResponseEntity.ok(posts);
	}
}
