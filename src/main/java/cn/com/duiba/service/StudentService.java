package cn.com.duiba.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.com.duiba.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

/**
 * Student Service
 *
 */
@Service
public class StudentService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Student> getList() {
		String sql = "SELECT id,name,age,birthday,china,math,english,history,sumScore,avgScore  FROM STUDENT";
		return (List<Student>) jdbcTemplate.query(sql, new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setAge(rs.getInt("age"));
				stu.setBirthday(rs.getDate("birthday"));
				stu.setChina(rs.getDouble("china"));
				stu.setMath(rs.getDouble("math"));
				stu.setEnglish(rs.getDouble("english"));
				stu.setHistory(rs.getDouble("history"));
				stu.setSumScore(rs.getDouble("sumScore"));
				stu.setAvgScore(rs.getDouble("avgScore"));
				return stu;
			}

		});
	}

	/**
	 * 插入操作
	 * 
	 * @param Student
	 */
	public void insert(Student student) {
		jdbcTemplate.update("insert into STUDENT values(?,?,?,?,?,?,?,?,?,?)",
				new Object[] { null, student.getName(), student.getAge(), student.getBirthday(),
						student.getChina(), student.getMath(), student.getEnglish(), student.getHistory(),
						student.getSumScore(), student.getAvgScore() });
	}

	/**
	 * 删除操作
	 * 
	 * @param Student
	 */
	public void delete(int id) {
		jdbcTemplate.update("delete from STUDENT where id=?", new Object[] { id });
	}

	
	  public Date getdate(){
		    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		    Date date;
			try {
				date = sdf.parse("1994-4-4");
				return date;
			} catch (ParseException e) {
				e.printStackTrace();
			}   
			return null;
		    }
		    
		    public Double avgScore(double china, double english , double math ,double history){
		    	double avgScore = (china+english+math+history)/4;
				return avgScore;	
		    }
		    public Double sumScore(double china, double english , double math ,double history){
		    	double sumScore = (china+english+math+history);
				return sumScore;	
		    }
		    
}
