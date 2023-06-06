package pl.karolkoduje.restapiodmateuszdabrowski.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.karolkoduje.restapiodmateuszdabrowski.model.Comment;
import pl.karolkoduje.restapiodmateuszdabrowski.model.Post;
import pl.karolkoduje.restapiodmateuszdabrowski.repository.CommentRepository;
import pl.karolkoduje.restapiodmateuszdabrowski.repository.PostRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private static final int PAGE_SIZE = 5;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public List<Post> getPosts(int page, Sort.Direction sort) {
//        return postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE, Sort.by(Sort.Order.by("id"), Sort.Order.by("post"))));
//        return postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE, Sort.by(Sort.Order.asc("id"))));
        return postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id")));
    }

    public Post getPost(long id) {
        return postRepository.findById(id).orElseThrow();
    }

    public List<Post> getPostsWithComments(int page, Sort.Direction sort) {
        List<Post> allPosts = postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE, Sort.by(sort,"id")));
        List<Long> ids = allPosts.stream()
                .map(Post::getId)
                .toList();
        List<Comment> comments = commentRepository.findAllByPostIdIn(ids);
        allPosts.forEach(post -> post.setComment(extractComments(comments, post.getId())));
        return allPosts;
    }

    private List<Comment> extractComments(List<Comment> comments, long id) {
        return comments.stream()
                .filter(comment -> comment.getPostId() == id)
                .toList();
    }

    public Post addPost(Post post) {
        return postRepository.save(post);
    }
}
