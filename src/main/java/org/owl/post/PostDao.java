package org.owl.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PostDao {

	static final String LIST_POST = "select postId, title, userId, name, left(cdate,16) cdate from post order by postId desc limit ?,?";

	static final String COUNT_POST = "select count(postId) from post";

	static final String GET_POST = "select postId, content, userId, name, left(cdate,16) cdate, udate from post where postId=?";

	static final String ADD_POST = "insert post(title,content,userId,name) values(?,?,?,?)";
	
	static final String LIKE_POST = "UPDATE post SET sweet = sweet+1 WHERE postId = ?";
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	RowMapper<Post> postRowMapper = new BeanPropertyRowMapper<>(
			Post.class);

	/**
	 * 글목록
	 */
	public List<Post> listPosts(int offset, int count) {
		return jdbcTemplate.query(LIST_POST, postRowMapper, offset,
				count);
	}

	/**
	 * 글 목록 건수
	 */
	public int getPostsCount() {
		return jdbcTemplate.queryForObject(COUNT_POST, Integer.class);
	}

	/**
	 * 글조회
	 */
	public Post getPost(String postId) {
		return jdbcTemplate.queryForObject(GET_POST, postRowMapper,
				postId);
	}

	/**
	 * 글등록
	 */
	public int addPost(Post post) {
		return jdbcTemplate.update(ADD_POST,
				post.getContent(), post.getUserId(), post.getName());
	}
	
	public int likePost(String postId) {
		return jdbcTemplate.update(LIKE_POST, postId);
}
	
}