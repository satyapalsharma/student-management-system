package com.example.sms.service;

import com.example.sms.exception.ResourceNotFoundException;
import com.example.sms.model.Student;
import com.example.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for managing Student entities.
 * This class encapsulates the business logic for student operations,
 * interacting with the StudentRepository for data persistence.
 */
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    /**
     * Constructs a new StudentService with the given StudentRepository.
     * Spring's dependency injection automatically provides the StudentRepository instance.
     *
     * @param studentRepository The repository for Student entities.
     */
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * Retrieves all students from the database.
     *
     * @return A list of all Student entities.
     */
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    /**
     * Retrieves a student by their unique identifier.
     *
     * @param id The ID of the student to retrieve.
     * @return An Optional containing the Student if found, or an empty Optional if not.
     */
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    /**
     * Saves a new student or updates an existing one in the database.
     * If the student object has an ID, it attempts to update; otherwise, it creates a new student.
     *
     * @param student The Student entity to save.
     * @return The saved Student entity, potentially with an updated ID if it was a new student.
     */
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    /**
     * Updates an existing student's details.
     *
     * @param id The ID of the student to update.
     * @param studentDetails A Student object containing the updated details.
     * @return The updated Student entity.
     * @throws ResourceNotFoundException if no student with the given ID is found.
     */
    public Student updateStudent(Long id, Student studentDetails) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

        // Update fields
        existingStudent.setFirstName(studentDetails.getFirstName());
        existingStudent.setLastName(studentDetails.getLastName());
        existingStudent.setEmail(studentDetails.getEmail());

        // Save the updated student
        return studentRepository.save(existingStudent);
    }

    /**
     * Deletes a student from the database by their ID.
     *
     * @param id The ID of the student to delete.
     * @throws ResourceNotFoundException if no student with the given ID is found.
     */
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        studentRepository.delete(student);
    }

    /**
     * Retrieves a paginated and sorted list of students.
     * This method is used for displaying students with pagination and sorting capabilities.
     *
     * @param pageable An object containing pagination (page number, page size) and sorting information.
     * @return A Page of Student entities.
     */
    public Page<Student> getStudentsPaginatedAndSorted(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    /**
     * Searches for students whose first name, last name, or email contains the given keyword,
     * with pagination and sorting. The search is case-insensitive.
     *
     * @param keyword The search term to look for in student names or email.
     * @param pageable An object containing pagination (page number, page size) and sorting information.
     * @return A Page of Student entities matching the search criteria.
     */
    public Page<Student> searchStudents(String keyword, Pageable pageable) {
        // The repository method `findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase`
        // is expected to be defined in StudentRepository.
        return studentRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
                keyword, keyword, keyword, pageable);
    }
}