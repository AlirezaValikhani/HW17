package com.example.hw17servlet.secondPartOfServlet;

import com.example.hw17servlet.secondPartOfServlet.entity.Person;
import com.example.hw17servlet.secondPartOfServlet.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "PersonServlet", value = "/Person-servlet")
public class PersonServlet extends HttpServlet {
    PersonService personService = new PersonService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Person person = personService.findById(id);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(person.getFullName());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jasonString = new String(request.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        var objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(jasonString,Person.class);
        personService.add(person);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jasonString = new String(req.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        var objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(jasonString,Person.class);
        personService.update(person);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jasonString = new String(req.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        var objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(jasonString,Person.class);
        personService.delete(person);
    }
}
