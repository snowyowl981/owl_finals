package org.owl.post;


public class Post {

	String postId;
	String userId;
	String name;
	String content;
	String sweet;
	String cdate;
	
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSweet() {
		return sweet;
	}
	public void setSweet(String sweet) {
		this.sweet = sweet;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	
	/**
	 * \n를 <br/> 로 바꾼다. 글을 볼때 띄워쓰기를 할수있다
	 */
	public String getContentHtml() {
		if (content != null)
			return content.replace("\n", "<br/>");
		return null;
	}
	
	@Override
	public String toString() {
		return "ArticleService [postId=" + postId + ", userId=" + userId + ", name=" + name + ", content=" + content
				+ ", sweet=" + sweet + ", cdate=" + cdate + "]\n";
	}
	
}
