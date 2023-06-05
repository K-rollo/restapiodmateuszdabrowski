package pl.karolkoduje.restapiodmateuszdabrowski.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.karolkoduje.restapiodmateuszdabrowski.repository.PostRepository;

@Service
@RequiredArgsConstructor
public class PostService {

    private PostRepository postRepository;


}
