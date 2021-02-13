package com.abacelli.springmongodb.repositories;

import com.abacelli.springmongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }") //buscar por pelo titulo utilizando o primeiro parametro do metodo ?0 e ignorando letras maiusculas/minusculas 'i'
    List<Post> searchTitle(String title);

    List<Post> findByTitleContainingIgnoreCase(String title); //utilizando as querys do springboot

    //buscar entre datas e por um texto em qlqr parte do post
    @Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
