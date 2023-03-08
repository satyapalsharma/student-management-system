package com.example.sms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a Student entity in the Student Management System.
 * This class maps to the 'students' table in the database.
 *
 * Uses Lombok annotations for boilerplate code reduction (getters, setters, constructors, toString).
 * Custom equals/hashCode are provided to ensure proper entity comparison based on the ID,
 * which is crucial for JPA entities.
 */
@Entity
@Table(name = "students")
@Getter // Generates all getter methods
@Setter // Generates all setter methods
@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates a constructor with all fields
@ToString(exclude = {"grades"}) // Generates a toString method, excluding 'grades' to prevent infinite recursion
public class Student {

    /**
     * Unique identifier for the student.
     * Marked as the primary key and configured for auto-incrementing.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The first name of the student.
     * Cannot be null.
     */
    @Column(name = "first_name", nullable = false)
    private String firstName;

    /**
     * The last name of the student.
     * Cannot be null.
     */
    @Column(name = "last_name", nullable = false)
    private String lastName;

    /**
     * The email address of the student.
     * Must be unique and cannot be null.
     */
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    /**
     * The date of birth of the student.
     */
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    /**
     * The date when the student enrolled in the system.
     */
    @Column(name = "enrollment_date")
    private LocalDate enrollmentDate;

    /**
     * A list of grades associated with this student.
     * This is a one-to-many relationship where a student can have multiple grades.
     * - `mappedBy = "student"`: Indicates that the 'student' field in the Grade entity owns the relationship.
     * - `cascade = CascadeType.ALL`: All operations (persist, merge, remove, refresh, detach) on Student
     *   will cascade to its associated Grade entities.
     * - `orphanRemoval = true`: If a Grade is removed from the 'grades' list, it will be deleted from the database.
     * - `fetch = FetchType.LAZY`: Grades will be loaded only when they are explicitly accessed,
     *   improving performance by avoiding unnecessary data loading.
     * Initialized to an empty ArrayList to prevent NullPointerExceptions when adding grades.
     */
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Grade> grades = new ArrayList<>();

    /**
     * Custom constructor for creating a new Student without an ID (for persistence).
     *
     * @param firstName The first name of the student.
     * @param lastName The last name of the student.
     * @param email The email address of the student.
     * @param dateOfBirth The date of birth of the student.
     * @param enrollmentDate The enrollment date of the student.
     */
    public Student(String firstName, String lastName, String email, LocalDate dateOfBirth, LocalDate enrollmentDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.enrollmentDate = enrollmentDate;
    }

    /**
     * Helper method to add a grade to the student's list of grades.
     * Manages the bidirectional relationship by setting the student on the grade object.
     *
     * @param grade The Grade object to add.
     */
    public void addGrade(Grade grade) {
        grades.add(grade);
        grade.setStudent(this);
    }

    /**
     * Helper method to remove a grade from the student's list of grades.
     * Manages the bidirectional relationship by nullifying the student on the grade object.
     *
     * @param grade The Grade object to remove.
     */
    public void removeGrade(Grade grade) {
        grades.remove(grade);
        grade.setStudent(null);
    }

    /**
     * Overrides the default equals method to compare Student objects based on their ID.
     * This is crucial for JPA entities, especially when entities are managed by a persistence context.
     * It handles both transient (new) entities (where ID is null) and persisted entities.
     *
     * @param o The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        // For entities, equality is typically based on the ID.
        // If the ID is null, it means the entity has not yet been persisted,
        // so we rely on object identity or other business keys if available.
        // For production, it's safer to compare IDs only if both are non-null.
        // If one ID is null and the other isn't, they are not equal.
        // If both IDs are null, they are considered different entities unless other business keys are used.
        return id != null && Objects.equals(id, student.id);
    }

    /**
     * Overrides the default hashCode method to generate a hash code based on the Student's ID.
     * Consistent with the equals method, this ensures that entities behave correctly in collections
     * like HashMaps and HashSets.
     *
     * @return The hash code for this Student object.
     */
    @Override
    public int hashCode() {
        // If ID is null (transient entity), return a constant or 0.
        // Once persisted, the ID will be used.
        return id != null ? Objects.hash(id) : 0;
    }
}