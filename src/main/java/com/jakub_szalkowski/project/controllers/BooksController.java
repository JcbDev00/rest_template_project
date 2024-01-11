package com.jakub_szalkowski.project.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.jakub_szalkowski.project.controllers.models.Book;


@Controller
@RequestMapping("/books")
public class BooksController {

 
      @RequestMapping("/list")
      public ModelAndView books() 
      {
        String uri = "http://localhost:8080/books/api/list";
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Book[]> response = restTemplate.getForEntity(uri, Book[].class);
        Book[] arr = response.getBody();
        
        List<Book> bookList = Arrays.asList(arr);
        
        return new ModelAndView("allBooks", "books", bookList);
      }

      @RequestMapping("/add") 
      public ModelAndView addNewBook() {
        return new ModelAndView("newBook", "form", new Book());
      } 

      @RequestMapping("/edit/{id}") 
      public ModelAndView edit(@PathVariable long id) {
        

    String uri = "http://localhost:8080/books/api/edit/{id}";
    RestTemplate restTemplate = new RestTemplate();

    Map<String, String> params = new HashMap<String, String> ();
    params.put("id", Long.toString(id));
    Book book = restTemplate.getForObject(uri,Book.class, params);

    return new ModelAndView("editBook", "form", book);

      }
      

      @RequestMapping("/save")
      public String save(Book book) 
      {
        String uri = "http://localhost:8080/books/api/save";
        RestTemplate restTemplate = new RestTemplate();
    
        restTemplate.postForObject(uri, book, Book.class);

        return ("redirect:/books/list");
      }

      @RequestMapping("/delete/{id}")
      public String delete(@PathVariable long id) {

        String uri = "http://localhost:8080/books/api/delete/{id}";
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> params = new HashMap<String, String>();
        params.put("id", Long.toString(id));

        restTemplate.delete(uri, params);

        return ("redirect:/books/list");
      }

        }
