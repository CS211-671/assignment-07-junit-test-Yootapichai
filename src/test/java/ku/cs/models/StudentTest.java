package ku.cs.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void testConstructorWithScore() {
        Student s1 = new Student("61xxxxx", "jack", 75.5);
        assertEquals("61xxxxx", s1.getId());
        assertEquals("jack", s1.getName());
        assertEquals(75.5, s1.getScore());
    }

    @Test
    void testConstructorWithoutScore() {
        Student s1 = new Student("61xxxxx", "jack");
        assertEquals("61xxxxx", s1.getId());
        assertEquals("jack", s1.getName());
        assertEquals(0, s1.getScore());
    }

    @Test
    @DisplayName("Test name change with valid name")
    void testChangeNameValid() {
        Student s1 = new Student("61xxxxx", "jack");
        s1.changeName("John");
        assertEquals("John", s1.getName());
    }

    @Test
    @DisplayName("Test name change with invalid name")
    void testChangeNameInvalid() {
        Student s1 = new Student("61xxxxx", "jack");
        s1.changeName("   ");
        assertEquals("jack", s1.getName());
    }

    @Test
    @DisplayName("Test adding positive score")
    void testAddScorePositive() {
        Student s1 = new Student("61xxxxx", "jack");
        s1.addScore(40.5);
        assertEquals(40.5, s1.getScore());
        s1.addScore(10);
        assertEquals(50.5, s1.getScore());
    }

    @Test
    @DisplayName("Test adding zero or negative score")
    void testAddScoreZeroOrNegative() {
        Student s1 = new Student("61xxxxx", "jack");
        s1.addScore(-5);
        assertEquals(0, s1.getScore());
        s1.addScore(0);
        assertEquals(0, s1.getScore());
    }

    @Test
    @DisplayName("Test grade calculation")
    void testGrade() {
        Student s1 = new Student("61xxxxx", "jack");
        s1.addScore(85);
        assertEquals("A", s1.grade());

        s1 = new Student("61xxxxx", "jack", 75);
        assertEquals("B", s1.grade());

        s1 = new Student("61xxxxx", "jack", 65);
        assertEquals("C", s1.grade());

        s1 = new Student("61xxxxx", "jack", 55);
        assertEquals("F", s1.grade());
    }

    @Test
    @DisplayName("Test ID matching")
    void testIsId() {
        Student s1 = new Student("61xxxxx", "jack");
        assertTrue(s1.isId("61xxxxx"));
        assertFalse(s1.isId("wrong_id"));
    }

    @Test
    @DisplayName("Test getting ID")
    void testGetId() {
        Student s1 = new Student("61xxxxx", "jack");
        assertEquals("61xxxxx", s1.getId());
    }

    @Test
    @DisplayName("Test getting name")
    void testGetName() {
        Student s1 = new Student("61xxxxx", "jack");
        assertEquals("jack", s1.getName());
    }

    @Test
    @DisplayName("Test getting score")
    void testGetScore() {
        Student s1 = new Student("61xxxxx", "jack");
        assertEquals(0, s1.getScore());
        s1.addScore(60);
        assertEquals(60, s1.getScore());
    }

    @Test
    @DisplayName("Test toString method")
    void testToString() {
        Student s1 = new Student("61xxxxx", "jack", 85.5);
        assertEquals("{id: '61xxxxx', name: 'jack', score: 85.5}", s1.toString());
    }
}
