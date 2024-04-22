package com.example.CompanyB.ManufacturingModule.Controller;

import com.example.CompanyB.ManufacturingModule.Model.Post;
import com.example.CompanyB.ManufacturingModule.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PostController {
    @Autowired
    PostRepository repo;

    @GetMapping("/allPosts")
    @CrossOrigin
    public List<Post> getAllPosts()
    {
        return repo.findAll();
    }

}
