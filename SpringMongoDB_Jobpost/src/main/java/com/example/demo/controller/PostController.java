package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepository repo;

    @ApiIgnore // Removes all the predefined requests
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");  // This redirects to this swagger-ui.html
    }

    @GetMapping("/allposts")
    public List<Post> getAllPosts() {
        return repo.findAll();
    }

    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text) {
        return repo.findAll();
    }

    @PostMapping("/post")
    // @RequestBody is used to accept the data
    public String addPost(@RequestBody Post post) {
        repo.save(post);
        return "Posted Successfully";
    }

    @PutMapping("/posting")
    public String updatePost(@RequestBody Post update) {
        repo.save(update);
        return "Updated Successfully";
    }

    @DeleteMapping("/del/{exp}")
    public String deletePost(@PathVariable("exp") int exp) {
        Post a = repo.findAll().get(exp);
        repo.delete(a);
        return "Deleted Successfully";
    }

}
