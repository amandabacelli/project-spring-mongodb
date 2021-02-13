package com.abacelli.springmongodb.services;

import com.abacelli.springmongodb.domain.Post;
import com.abacelli.springmongodb.repositories.PostRepository;
import com.abacelli.springmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Post not found"));
    }

    public List<Post> findByTitle(String title) {
        return repository.searchTitle(title);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000); //acrescentar 1 dia e transformar em milisegundos para considerar o dia ate meia noite
        return repository.fullSearch(text, minDate, maxDate);
    }
}
