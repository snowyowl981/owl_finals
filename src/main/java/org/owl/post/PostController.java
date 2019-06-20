package org.owl.post;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.owl.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {

	@Autowired
	PostDao postDao;
	/**
	 * 글 목록
	 */
	@GetMapping("/post/list")
	public void PostList(
			@RequestParam(value = "page", defaultValue = "1") int page,
			Model model) {

		// 페이지당 행의 수와 페이지의 시작점
		final int COUNT = 50;
		int offset = (page - 1) * COUNT;

		List<Post> postList = postDao.listPosts(offset, COUNT);
		int totalCount = postDao.getPostsCount();
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("PostList", postList);
	}

	/**
	 * 글 보기
	 */
	@GetMapping("/post/view")
	public void PostView(@RequestParam("postId") String postId,
			Model model) {
		Post post = postDao.getPost(postId);
		model.addAttribute("Post", post);
	}

	/**
	 * 글 등록 화면
	 */
	@GetMapping("/post/addForm")
	public String PostAddForm(HttpSession session) {
		Object memberObj = session.getAttribute("USER");
		if (memberObj == null)
			// 세션에 MEMBER가 없을 경우 로그인 화면으로
			return "login/loginForm";

		return "post/addForm";
	}

	/**
	 * 글 등록
	 */
	@PostMapping("/post/add")
	public String postAdd(Post post, User user
			) {
		post.setUserId(user.getuserId());
		post.setName(user.getName());
		
		postDao.addPost(post);
		return "redirect:/app/post/list";
	}
	
	@GetMapping("/post/sweet")
	public String postLike(@RequestParam("postId") String postId, User user) {
		postDao.likePost(postId);
		return "redirect:/app/post/list";
}
}