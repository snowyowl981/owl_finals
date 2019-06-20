package org.owl.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PostDao {
	
	//글 등록
	static final String ADD_POST = "INSERT post(userId,name,content) VALUES(?,?,?)";
	
	//글 목록
	static final String LIST_POSTS = "SELECT postId, userId, name, content, sweet FROM post ORDER BY postId desc LIMIT ?,?";
	
	//좋아요
	static final String LIKE_POST = "UPDATE post SET sweet = sweet+1 WHERE postId = ?";
	
	//수정
	static final String UPDATE_POST = "UPDATE post SET content=? WHERE postId=?";
	
	//삭제
	static final String DELETE_POST = "DELETE FROM post WHERE postId = ?";
	
	//글 갯수
	static final String COUNT_POSTS = "select count(postId) from post";
	
	//글 가져오기
	static final String GET_POST = "SELECT postId, userId, name, content FROM post WHERE postId = ?";
	
	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	RowMapper<Post> postRowMapper = new BeanPropertyRowMapper<>(Post.class);
	
	//글 등록
	public int addPost(Post post) {
		return jdbcTemplate.update(ADD_POST, post.getUserId(), post.getName(),
				post.getContent());
	}
	
	//글 목록
	public List<Post> listPosts(int offset, int count) {
		return jdbcTemplate.query(LIST_POSTS, postRowMapper, offset,count);
	}
	
	//좋아요
	public int likePost(String postId) {
		return jdbcTemplate.update(LIKE_POST, postId);
	}
	
	//수정
	public void updatePost(Post post) {
		jdbcTemplate.update(UPDATE_POST, post.getContent(),post.getPostId());
	}
	
	//삭제
	public void deletePost(String postId) {
		jdbcTemplate.update(DELETE_POST, postId);
	}
	
	//글 갯수
	public int getPostCount() {
		return jdbcTemplate.queryForObject(COUNT_POSTS, Integer.class);
	}

	//글 가져오기
	public Post getPost(String postId) {
		return jdbcTemplate.queryForObject(GET_POST, postRowMapper, postId);
	}
}