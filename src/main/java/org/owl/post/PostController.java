package org.owl.post;

import java.util.List;

import org.owl.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class PostController {
	
	@Autowired
	PostDao postDao;
	
	/* 디폴트맵핑을 해주었으므로 맵핑을 안해도 된다
	@RequestMapping("/main")
	public String main() {
		return "main";
	}
	*/
	
	//글 목록
	@GetMapping("/post/list")
	public void postList(@RequestParam(value = "page", defaultValue = "1") int page,
			Model model) {
		// 페이지당 행의 수와 페이지의 시작점
				final int COUNT = 50;
		int offset = (page - 1) * COUNT;
		
		List<Post> postList = postDao.listPosts(offset, COUNT);
		int totalCount = postDao.getPostCount();
		model.addAttribute("totalCount",totalCount);
		model.addAttribute("postList", postList);
	}
	
	//글 쓰기
	@PostMapping("/post/add")
	public String postAdd(Post post,
			@SessionAttribute("USER") User user) {
		post.setUserId(user.getUserId());
		post.setName(user.getName());
		
		postDao.addPost(post);
		return "redirect:/app/post/list";
}
	
	//좋아요
	@GetMapping("/post/sweet")
	public String postLike(@RequestParam("postId") String postId, 
			@SessionAttribute("USER") User user) {
		postDao.likePost(postId);
		return "redirect:/app/post/list";
	}
	
	//글 보기
	@GetMapping("/post/view")
	public String postView(@RequestParam("postId") String postId, Model model) {
		Post post = postDao.getPost(postId);
		model.addAttribute("post",post);
		return "post/view";
	}
	
	//글 수정
	@PostMapping("/post/update")
	public String postUpdate(Post post, @RequestParam("postId") String postId,
			@SessionAttribute("USER") User user) {
		post.setPostId(postId);
		postDao.updatePost(post);
		return "redirect:/app/post/list";
	}
	
	//글 수정 화면
	@GetMapping("/post/edit")
	public String updateForm(@RequestParam("postId") String postId, Model model,
			@SessionAttribute("USER") User user) {
		Post post = postDao.getPost(postId);
		model.addAttribute("post",post);
		return "post/edit";
	}
	
	//글 삭제
	@GetMapping("/post/delete")
	public String deletePost(@RequestParam("postId") String postId,
			@SessionAttribute("USER") User user) {
		postDao.deletePost(postId);
		return "redirect:/app/post/list";
	}
	
}