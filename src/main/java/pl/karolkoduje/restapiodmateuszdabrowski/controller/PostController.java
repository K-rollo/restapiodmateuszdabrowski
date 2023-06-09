package pl.karolkoduje.restapiodmateuszdabrowski.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import pl.karolkoduje.restapiodmateuszdabrowski.model.Post;
import pl.karolkoduje.restapiodmateuszdabrowski.service.PostDto;
import pl.karolkoduje.restapiodmateuszdabrowski.service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public List<PostDto> getPosts(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        int pageNumber = (page != null && page > 0 ? page : 0);
        Sort.Direction sortDirection = (sort != null ? sort : Sort.Direction.ASC);
        return PostDtoMapper.mapToPostDtos(postService.getPosts(pageNumber, sortDirection));
    }

    @GetMapping("/posts/comments")
    public List<Post> getPostsWithComments(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        int pageNumber = (page != null && page > 0 ? page : 0);
        Sort.Direction sortDirection = (sort != null ? sort : Sort.Direction.ASC);
        return postService.getPostsWithComments(pageNumber, sortDirection);
    }
    @GetMapping("/posts/{id}")
    public Post getSinglePost(@PathVariable long id) {
        return postService.getPost(id);
    }

    @PostMapping("/posts")
    public Post addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }
}
