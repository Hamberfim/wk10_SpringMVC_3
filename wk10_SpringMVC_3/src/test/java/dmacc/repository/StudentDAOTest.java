package dmacc.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import dmacc.beans.Student;

class StudentDAOTest {
	private StudentDAO dao;

	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:mysql://localhost:3306/students?useSSL=false");
		datasource.setUsername("root");
		datasource.setPassword("M6zdcR64&7");
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		
		dao = new StudentDAO(new JdbcTemplate(datasource));
	}

	@Test
	void testList() {
		List<Student> listStudent = dao.list();
		assertFalse(listStudent.isEmpty());
	}

	@Test
	void testSave() {
		Student student = new Student("Gene", "Buttermaker", "Yugo", "Ciao", "blue", "LXR141");
		dao.save(student);
	}

	@Test
	void testGet() {
		int id = 2;
		Student student =dao.get(id);
		assertNotNull(student);
	}

	@Test
	void testUpdate() {
		Student student = new Student();
		student.setId(8);
		student.setFirstname("Garry");
		student.setLastname("Kemitzer");
		student.setMake("Yugo");
		student.setModel("Ciao");
		student.setColor("Cream");
		student.setPlatenumber("LXR141");
		
		dao.update(student);
	}

	@Test
	void testDelete() {
		int id  = 7;
		dao.delete(id);
	}

}
