package dmacc.repository;

import java.util.List;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import dmacc.beans.Student;

@Repository
@Transactional  //framework will automatically inject code to execute its methods within JDBC transactions
public class StudentDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;  //jdbcTemplate auto created and injected
	
	public StudentDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Student> list() {
	    String sql = "SELECT * FROM studentparking";
	    List<Student> listStudents = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Student.class));
	    return listStudents;
	}
	
	public void save(Student student) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate).withTableName("studentparking").usingColumns("firstname", "lastname", "make", "model", "color", "platenumber");

		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(student);
		insertActor.execute(param);
    }
  
    public Student get(int id) {
    	String sql = "SELECT * FROM studentparking WHERE id = ?";
    	Object[] args = {id};
    	Student student = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Student.class));
		return student;
    }
  
    public void update(Student student) {
    	String sql = "UPDATE studentparking SET firstname=:firstname, lastname=:lastname, make=:make, model=:model, color=:color, platenumber=:platenumber WHERE id=:id";
    	BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(student);
    	NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
    	template.update(sql, param);
    }
  
    public void delete(int id) {
    	String sql = "DELETE FROM studentparking WHERE id = ?";
    	jdbcTemplate.update(sql, id);
    	
    	
    }

}
