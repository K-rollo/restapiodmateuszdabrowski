package pl.karolkoduje.restapiodmateuszdabrowski.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", unique = true, nullable = false)
    private long id;
//    private long id = System.nanoTime();
    private String title;
    private String content;
    private LocalDateTime created;
    @OneToMany
    @JoinColumn(name = "postId")
    private List<Comment> comment;
}
//spring.datasource.url=jdbc:h2:mem:testdb
//        spring.datasource.username=karol
//        spring.datasource.password=password