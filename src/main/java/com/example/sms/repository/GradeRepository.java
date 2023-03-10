package com.example.sms.repository;

import com.example.sms.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing {@link Grade} entities.
 * Extends {@link JpaRepository} to provide standard CRUD operations,
 * pagination, and sorting capabilities for Grade objects.
 *
 * This interface leverages Spring Data JPA's convention-over-configuration
 * to automatically generate query implementations based on method names.
 */
@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {

    /**
     * Finds all grades associated with a specific student ID.
     * Spring Data JPA automatically constructs the query to fetch grades
     * where the 'student' field's 'id' matches the provided studentId.
     *
     * @param studentId The unique identifier of the student whose grades are to be retrieved.
     * @return A {@link List} of {@link Grade} objects belonging to the specified student.
     *         Returns an empty list if no grades are found for the student.
     */
    List<Grade> findByStudent_Id(Long studentId);

    // Example of other potential custom query methods:
    //
    // /**
    //  * Finds all grades for a specific student and subject.
    //  * @param studentId The ID of the student.
    //  * @param subject The subject name.
    //  * @return A list of grades matching the criteria.
    //  */
    // List<Grade> findByStudent_IdAndSubject(Long studentId, String subject);
    //
    // /**
    //  * Finds all grades for a specific student, ordered by subject name ascending.
    //  * @param studentId The ID of the student.
    //  * @return A list of grades for the student, sorted by subject.
    //  */
    // List<Grade> findByStudent_IdOrderBySubjectAsc(Long studentId);
}