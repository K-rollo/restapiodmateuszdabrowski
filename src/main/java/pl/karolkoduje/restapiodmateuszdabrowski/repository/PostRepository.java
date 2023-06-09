package pl.karolkoduje.restapiodmateuszdabrowski.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.karolkoduje.restapiodmateuszdabrowski.model.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

//    List<Post> findAllByTitle(String title);    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation

    @Query("Select p From Post p left join fetch p.comment") //gives all posts even without comments
    List<Post> findAllPosts(Pageable page);
}
