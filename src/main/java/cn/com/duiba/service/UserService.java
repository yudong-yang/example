package cn.com.duiba.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import cn.com.duiba.entity.Users;

@Service
public class UserService {

	 @Autowired
 private JdbcTemplate jdbcTemplate;
	 /**
	  * 查询操作
	  * @return
	  */
	 public List<Users> getList(){
	        String sql = "SELECT ID,NAME,PASSWORD FROM USERS";
	        return (List<Users>) jdbcTemplate.query(sql, new RowMapper<Users>(){
	            @Override
	            public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
	            	Users users = new Users();
	            	users.setId(rs.getInt("ID"));
	                users.setName(rs.getString("NAME"));
	                users.setPassword(rs.getString("PASSWORD"));
	                return users;
	            }
	        });
	    } 
	 
	 
	 @SuppressWarnings("deprecation")
	public int cuontnum(){
	 return jdbcTemplate.queryForInt("SELECT COUNT(*) FROM USERS");
	 }
	 
	 public List<Users> getListPage(int id){
	        String sql = "SELECT ID,NAME,PASSWORD FROM USERS LIMIT ?,10";
	        final Object[] params = new Object[] {(id-1)*10};
	        return (List<Users>) jdbcTemplate.query(sql,params ,new RowMapper<Users>(){
	            @Override
	            public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
	            	Users users = new Users();
	            	users.setId(rs.getInt("ID"));
	                users.setName(rs.getString("NAME"));
	                users.setPassword(rs.getString("PASSWORD"));
	                return users;
	            }
	        });
	    } 
	 
	 
	 public Users selectById(int id){
		    String sql = "select * from users where id=?";
		    final  Users users = new Users();
		    final Object[] params = new Object[] {id};
		    jdbcTemplate.query(sql, params, new RowCallbackHandler(){
		                        public void processRow(ResultSet rs) throws SQLException {
		        	            	users.setId(rs.getInt("id"));
		        	                users.setName(rs.getString("name"));
		        	                users.setPassword(rs.getString("password"));
		                        }                    
		    });        
		    return users;
		}
	/**
	 * 插入操作
	 * @param user
	 */
	 public void insert(Users user){
	        jdbcTemplate.update("insert into USERS values(?,?,?)",  
	        	     new Object[]{user.getId(),user.getName(),user.getPassword() }); 
	    } 
	 
	 /**
		 * 删除操作
		 * @param user
		 */
	 public void delete(int id){
		 jdbcTemplate.update("delete from Users where id=?",new Object[]{ id });
	    } 
	 
		/**
		 * 插入操作
		 * @param user
		 */
		 public void updata(Users user){
		        jdbcTemplate.update("update USERS  set NAME= ?,PASSWORD= ? where id=?",  
		        	     new Object[]{user.getName(),user.getPassword(),user.getId() }); 
		    }
	 
}
