package Spring_jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import Spring_jdbc_dao.Student_DAO;
import Spring_jdbc_dao.Student_DAO_Implement;

@Configuration
@ComponentScan(basePackages = {"Spring_jdbc_dao"})
public class jdbc_configue {
	
@Bean(name={"ds"})
public DataSource getDataSource()
{

	DriverManagerDataSource ds=new DriverManagerDataSource();
	ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
	ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
	ds.setUsername("root");
	ds.setPassword("7534050774");
	return ds;
	
}
@Bean(name={"jdbcTemplate"})
public JdbcTemplate getTemplate()
{
	JdbcTemplate jdbcTemplate = new JdbcTemplate();
	jdbcTemplate.setDataSource(getDataSource());
	
	return jdbcTemplate;
}
//@Bean(name= {"studentDao"})
//public Student_DAO getStudentDao()
//{
//	Student_DAO_Implement studentdao=new Student_DAO_Implement();
//	studentdao.setJdbct(getTemplate());
//	return studentdao;
//}
//	
}
