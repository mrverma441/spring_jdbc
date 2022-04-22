package Spring_jdbc_dao;

import java.util.List;

import Spring_jdbc_entity.Student;

public interface Student_DAO {

	public int insert(Student student);
	public int change(Student student);
	public int delete(int studentId);
	public Student getStudent(int StudentId);
	public List<Student> getAllStudents();
	
	
}
