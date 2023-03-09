package com.example.sms.repository;

import com.example.sms.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing {@link Student} entities.
 * Extends {@link JpaRepository} to provide standard CRUD operations
 * (Create, Read, Update, Delete) and pagination/sorting capabilities
 * out-of-the-box for the {@link Student} entity with a Long ID.
 *
 * This interface also defines custom query methods for searching students
 * by name or email, supporting case-insensitive matching and pagination,
 * aligning with the project's search and pagination requirements.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    /**
     * Finds a page of students whose name or email contains the given keyword,
     * ignoring case. This method is crucial for implementing the search
     * functionality combined with pagination in the Student Management System.
     *
     * Spring Data JPA automatically generates the query based on the method name:
     * - `findBy`: Initiates a select query.
     * - `NameContainingIgnoreCase`: Matches the 'name' field, ignoring case, if it contains the keyword.
     * - `Or`: Logical OR operator.
     * - `EmailContainingIgnoreCase`: Matches the 'email' field, ignoring case, if it contains the keyword.
     * - `Pageable pageable`: Enables pagination and sorting for the results.
     *
     * @param keyword The search term to be matched against both the student's name and email.
     * @param pageable Pagination information (page number, page size, sort order).
     * @return A {@link Page} of {@link Student} entities that match the search criteria.
     */
    Page<Student> findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String keyword, Pageable pageable);

    /**
     * Finds a student by their email address.
     * This can be useful for ensuring unique email addresses or for retrieving a student
     * based on their email, which is often a unique identifier.
     *
     * @param email The email address to search for.
     * @return An {@link java.util.Optional} containing the found {@link Student} if present, or empty otherwise.
     */
    java.util.Optional<Student> findByEmail(String email);
}