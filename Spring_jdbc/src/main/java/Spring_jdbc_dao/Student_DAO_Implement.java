package Spring_jdbc_dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import Spring_jdbc_entity.Student;
@Component("studentDao")

public class Student_DAO_Implement implements Student_DAO {
	private JdbcTemplate jdbct;

	@Override
	public int insert(Student student) {
        String query="insert into student(id,name,city) values(?,?,?)";

        int r=this.jdbct.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}
	
	@Override
	public int change(Student student) {
		//Updating the data
		String query="update student set name=?,city=? where id=?";
		int r = this.jdbct.update(query,student.getName(),student.getCity(),student.getId());
		
		return r;
		
	}
	
	@Override
	public int delete(int studentId) {
		//delete operation
		String query ="delete from student where id=?";
		int r = this.jdbct.update(query,studentId);
		
		return r;
	}
	//Select operation for Single object
	@Override
	public Student getStudent(int StudentId) {
		String query="select *from student where id=?";
		RowMapper<Student>rowMApper=new RowMapperImpl();
		Student student=this.jdbct.queryForObject(query, rowMApper,StudentId);
		
		return student;
	}
	//Select operation for multiple object

	
	@Override
	public List<Student> getAllStudents() {
		String query="select *from student";
		List<Student>students=this.jdbct.query(query, new RowMapperImpl());
		
		return students;
	}


	public JdbcTemplate getJdbct() {
		return jdbct;
	}

	@Autowired
	public void setJdbct(JdbcTemplate jdbct) {
		this.jdbct = jdbct;
	}

	
	
	
	

	
}
