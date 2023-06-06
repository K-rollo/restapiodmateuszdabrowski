package pl.karolkoduje.restapiodmateuszdabrowski.controller;

import pl.karolkoduje.restapiodmateuszdabrowski.model.Post;
import pl.karolkoduje.restapiodmateuszdabrowski.service.PostDto;

import java.util.List;

public class PostDtoMapper {

    private PostDtoMapper(){}

    public static List<PostDto> mapToPostDtos(List<Post> posts) {
        return posts.stream()
                .map(post -> mapsToPostDto(post))
                .toList();
    }

    public static PostDto mapsToPostDto(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .created(post.getCreated())
                .build();


    }
}
