package Spring_jdbc;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import Spring_jdbc_dao.Student_DAO;
import Spring_jdbc_entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Program Started" );
        ApplicationContext context=new AnnotationConfigApplicationContext(jdbc_configue.class);
        JdbcTemplate temp=context.getBean("jdbcTemplate",JdbcTemplate.class);
        
        //insert query
        String query="insert into student(id,name,city) values(?,?,?)";
        //fire query
        int result = temp.update(query,126,"Mohd shuaib","dehradun");
        System.out.println("number of record inserted "+result);
        
        Student_DAO student_dao=context.getBean("studentDao",Student_DAO.class);
       //------- Insetion-----------//
//        Student student=new Student();
//        student.setId(13);
//        student.setName("Mayank");
//        student.setCity("Durgapur");
//        int result=student_dao.insert(student);
//        System.out.println("Student added "+result);
        
        //----------Update--------
//        Student student=new Student();
//        student.setId(222);
//        student.setName("Anuj verma");
//        student.setCity("Dhampur");
//        int result = student_dao.change(student);
//        System.out.println("Data updated successfully "+result);
        //Delete
//        Scanner obj=new Scanner(System.in);
//        System.out.println("Enter the id for which you want to delete the data");
//        int id=obj.nextInt();
//        int delete = student_dao.delete(id);
//        System.out.println("Successfully deleted "+delete);
      	//Select operation for Single object

//        Student student = student_dao.getStudent(456);
//        System.out.println(student_dao.getStudent(222));
//        System.out.println(student_dao.getStudent(1113));
//
//        System.out.println(student);
    	//Select operation for multiple object
        
       List<Student>students= student_dao.getAllStudents();
       for(Student s:students)
       {
    	   System.out.println(s);
       }
        

        
    }
}
