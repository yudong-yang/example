package cn.com.duiba.PostRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.com.duiba.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	
	

}
