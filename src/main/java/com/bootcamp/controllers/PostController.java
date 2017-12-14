package com.bootcamp.controllers;

import com.bootcamp.commons.ws.usecasepost.DemandeWS;
import com.bootcamp.commons.ws.usecasepost.PostWS;

import com.bootcamp.entities.Post;
import com.bootcamp.services.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ibrahim on 11/29/17.
 */
@RestController("PostController")
@RequestMapping("/posts")
@Api(value = "Post API", description = "Post API")
public class PostController {

    @Autowired
    PostService postService;

   /* @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value=" Get all posts",notes="Get all the posts")
    public ResponseEntity<List<PostWS>> getAll() throws Exception{
        List<PostWS> posts = postService.getAll();
        return new ResponseEntity<List<PostWS>>(posts,HttpStatus.OK);

    }*/
   @RequestMapping(method = RequestMethod.GET)
   @ApiOperation(value=" create  one post ",notes="Get particular post by it id")
    public ResponseEntity<DemandeWS> createPost(@RequestBody Post post) throws Exception{
       postService.createPost( post );
       DemandeWS demandeWS = postService.getDemandeWS( post );
       return new ResponseEntity<DemandeWS>( demandeWS,HttpStatus.OK );
   }

    @RequestMapping(value="/{postId}",method = RequestMethod.GET)
    @ApiOperation(value=" Get one post",notes="Get particular post by it id")
    public ResponseEntity<PostWS> getPostWS(@PathVariable int postId) throws Exception{
        PostWS postws = postService.getPostWS(postId);
        return new ResponseEntity<>(postws,HttpStatus.OK);

    }
}
