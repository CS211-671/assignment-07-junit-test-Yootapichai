package ku.cs.models;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {

    @Test
    void testAddNewStudentWithoutScore() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("61xxxxx", "jack");

        ArrayList<Student> students = studentList.getStudents();
        assertEquals(1, students.size());

        Student student = students.get(0);
        assertEquals("61xxxxx", student.getId());
        assertEquals("jack", student.getName());
        assertEquals(0, student.getScore());
    }

    @Test
    void testAddNewStudentWithScore() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("61yyyyy", "john", 75.5);

        ArrayList<Student> students = studentList.getStudents();
        assertEquals(1, students.size());

        Student student = students.get(0);
        assertEquals("61yyyyy", student.getId());
        assertEquals("john", student.getName());
        assertEquals(75.5, student.getScore());
    }

    @Test
    void testAddExistingStudent() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("61xxxxx", "jack");
        studentList.addNewStudent("61xxxxx", "jack", 90);

        ArrayList<Student> students = studentList.getStudents();
        assertEquals(1, students.size()); // นักเรียนที่มีอยู่แล้วไม่ควรถูกเพิ่มอีก
    }

    @Test
    void testAddNewStudentWithEmptyIdOrName() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("", "jack");
        studentList.addNewStudent("61xxxxx", "");

        assertEquals(0, studentList.getStudents().size()); // ไม่ควรมีนักเรียนถูกเพิ่ม
    }

    @Test
    void testFindStudentById() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("61xxxxx", "jack");

        Student foundStudent = studentList.findStudentById("61xxxxx");
        assertNotNull(foundStudent);
        assertEquals("jack", foundStudent.getName());

        assertNull(studentList.findStudentById("unknown_id")); // นักเรียนที่มี ID นี้ไม่ควรมีอยู่
    }

    @Test
    void testGiveScoreToId() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("61xxxxx", "jack");
        studentList.giveScoreToId("61xxxxx", 30);

        Student foundStudent = studentList.findStudentById("61xxxxx");
        assertEquals(30, foundStudent.getScore());
    }

    @Test
    void testGiveScoreToNonExistingId() {
        StudentList studentList = new StudentList();
        studentList.giveScoreToId("unknown_id", 30);

        // ไม่ควรมีข้อยกเว้นเกิดขึ้น และรายการควรยังคงว่างอยู่
        assertEquals(0, studentList.getStudents().size());
    }

    @Test
    void testViewGradeOfId() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("61xxxxx", "jack", 85);
        assertEquals("A", studentList.viewGradeOfId("61xxxxx"));

        assertNull(studentList.viewGradeOfId("unknown_id")); // ID ที่ไม่รู้จักควรส่งคืนค่า null
    }

    @Test
    void testGetStudents() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("61xxxxx", "jack");
        studentList.addNewStudent("61yyyyy", "john", 90);

        ArrayList<Student> students = studentList.getStudents();
        assertEquals(2, students.size());

        assertEquals("jack", students.get(0).getName());
        assertEquals("john", students.get(1).getName());
    }
}
