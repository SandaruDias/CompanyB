//package com.example.CompanyB.ManufacturingModule.Controller;
//
//import com.example.CompanyB.ManufacturingModule.DataTransferObject.Post;
//import com.example.CompanyB.ManufacturingModule.Repository.PostRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//@RestController
//public class PostController {
//    @Autowired
//    PostRepository repo;
//
//    @GetMapping("/allPosts")
//    @CrossOrigin
//    public List<Post> getAllPosts()
//    {
//        return repo.findAll();
//    }
//
//
//
//
//
//}
package com.example.CompanyB.ManufacturingModule.Controller;

import com.example.CompanyB.ManufacturingModule.DataTransferObject.Post;
import com.example.CompanyB.ManufacturingModule.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @PostMapping("/addExp")
    public void addExp (@RequestBody Post post) {
        postRepository.save(post);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return ResponseEntity.ok(posts);
    }


}

