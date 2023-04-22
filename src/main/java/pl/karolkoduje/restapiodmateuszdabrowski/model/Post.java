package pl.karolkoduje.restapiodmateuszdabrowski.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Post {
    @Id
    private long id;
    private String title;
    private String content;
    private LocalDateTime dateStamp;
}
//spring.datasource.url=jdbc:h2:mem:testdb
//        spring.datasource.username=karol
//        spring.datasource.password=password