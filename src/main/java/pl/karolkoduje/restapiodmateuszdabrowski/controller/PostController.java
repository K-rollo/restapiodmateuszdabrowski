package pl.karolkoduje.restapiodmateuszdabrowski.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.karolkoduje.restapiodmateuszdabrowski.model.Post;
import pl.karolkoduje.restapiodmateuszdabrowski.service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private PostService postService;

    @GetMapping("/posts")
    public List<Post> getPosts() {
        throw new IllegalArgumentException("Not implemented yet");

    }

    @GetMapping("/posts/{id}")
    public Post getSinglePost(@PathVariable long id) {
        throw new IllegalArgumentException("Not implemented yet");

    }
}
