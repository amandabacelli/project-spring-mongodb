package com.abacelli.springmongodb.config;

import com.abacelli.springmongodb.domain.Post;
import com.abacelli.springmongodb.domain.User;
import com.abacelli.springmongodb.domain.dto.AuthorDTO;
import com.abacelli.springmongodb.domain.dto.CommentDTO;
import com.abacelli.springmongodb.repositories.PostRepository;
import com.abacelli.springmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User amanda = new User(null, "Maria", "amanda@email.com");
        User thiago = new User(null, "Alex", "thiago@email.com");
        User anna = new User(null, "Anna", "anna@email.com");

        userRepository.saveAll(Arrays.asList(amanda, thiago, anna));

        Post post1 = new Post(null, sdf.parse("13/02/2021"), "Estudando", "em pleno carnaval", new AuthorDTO(amanda));
        Post post2 = new Post(null, sdf.parse("01/02/2021"), "Carnaval 2021", "o que fazer no carnaval em plena pandemia?", new AuthorDTO(amanda));

        CommentDTO c1 = new CommentDTO("vou limpar a casa", sdf.parse("13/02/2021"), new AuthorDTO(thiago));
        CommentDTO c2 = new CommentDTO("boa sorte", sdf.parse("14/02/2021"), new AuthorDTO(anna));
        CommentDTO c3 = new CommentDTO("to na mesma", sdf.parse("13/02/2021"), new AuthorDTO(thiago));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().add(c3);

        postRepository.saveAll(Arrays.asList(post1, post2));

        amanda.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(amanda);


    }
}
