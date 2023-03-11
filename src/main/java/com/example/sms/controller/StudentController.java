package com.example.sms.controller;

import com.example.sms.model.Student;
import com.example.sms.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Controller for managing student-related web requests in the Student Management System.
 * Handles CRUD operations, search, pagination, and sorting for students.
 * It interacts with the StudentService to perform business logic and data retrieval.
 */
@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    /**
     * Constructs a StudentController with the necessary StudentService.
     * Spring's @Autowired handles dependency injection