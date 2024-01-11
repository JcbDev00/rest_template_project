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

import com.jakub_szalkowski.project.controllers.models.Expense;

@Controller
@RequestMapping("/expenses")
public class ExpensesController {


      @RequestMapping("/list")
      public ModelAndView expenses() 
      {
        String uri = "http://localhost:8080/expenses/api/list";
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Expense[]> response = restTemplate.getForEntity(uri, Expense[].class);
        Expense[] arr = response.getBody();
        
        List<Expense> expensesList = Arrays.asList(arr);
        
        return new ModelAndView("allExpenses", "expenses", expensesList);
      }

      @RequestMapping("/add") 
      public ModelAndView addNewExpense() {
        return new ModelAndView("newExpense", "form", new Expense());
      } 

      @RequestMapping("/edit/{id}") 
      public ModelAndView edit(@PathVariable long id) {
        

    String uri = "http://localhost:8080/expenses/api/edit/{id}";
    RestTemplate restTemplate = new RestTemplate();

    Map<String, String> params = new HashMap<String, String> ();
    params.put("id", Long.toString(id));
    Expense expense = restTemplate.getForObject(uri,Expense.class, params);

    return new ModelAndView("editExpense", "form", expense);

      }
      

      @RequestMapping("/save")
      public String save(Expense expense) 
      {
        String uri = "http://localhost:8080/expenses/api/save";
        RestTemplate restTemplate = new RestTemplate();
    
        restTemplate.postForObject(uri, expense, Expense.class);

        return ("redirect:/expenses/list");
      }

      @RequestMapping("/delete/{id}")
      public String delete(@PathVariable long id) {

        String uri = "http://localhost:8080/expenses/api/delete/{id}";
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> params = new HashMap<String, String>();
        params.put("id", Long.toString(id));

        restTemplate.delete(uri, params);

        return ("redirect:/expenses/list");
      }

        }