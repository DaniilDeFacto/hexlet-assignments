package exercise.controller.users;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import exercise.model.Post;
import exercise.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// BEGIN
@SpringBootApplication
@RestController
@RequestMapping("/api")
public class PostsController {
    private List<Post> posts = Data.getPosts();

    @GetMapping("/users/{id}/posts")
    public ResponseEntity<List<Post>> index(@PathVariable int id,
                                            @RequestParam(defaultValue = "10") Integer limit,
                                            @RequestParam(defaultValue = "1") Long page) {
        var result = posts.stream()
                .filter(post -> post.getUserId() == id)
                .skip((page - 1) * limit)
                .limit(limit)
                .toList();
        return ResponseEntity.ok()
                .body(result);
    }

    @PostMapping("users/{id}/posts")
    public ResponseEntity<Post> create(@PathVariable int id,
                                       @RequestBody Post post) {
        post.setUserId(id);
        posts.add(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }
}
// END
