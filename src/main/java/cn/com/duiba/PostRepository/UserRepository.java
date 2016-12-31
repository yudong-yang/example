package cn.com.duiba.PostRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cn.com.duiba.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> ,CrudRepository<Users, Long>{
	
	public List<Users> findAll();
	
	@Query("select distinct(name) from Users ")
	public List<String> findname();
	
}
