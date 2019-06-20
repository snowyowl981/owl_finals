package org.owl.post;

public class Post {
	String postId;
	String content;
	String userId;
	String name;
	String cdate;
	String sweet;
	/**
	 * @return the postId
	 */
	public String getPostId() {
		return postId;
	}
	/**
	 * @param postId the postId to set
	 */
	public void setPostId(String postId) {
		this.postId = postId;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the cdate
	 */
	public String getCdate() {
		return cdate;
	}
	/**
	 * @param cdate the cdate to set
	 */
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	/**
	 * @return the sweet
	 */
	public String getSweet() {
		return sweet;
	}
	/**
	 * @param sweet the sweet to set
	 */
	public void setSweet(String sweet) {
		this.sweet = sweet;
	}
	
	public String getContentHtml() {
		if (content != null)
			return content.replace("\n", "<br/>");
		return null;
	}
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", content=" + content + ", userId=" + userId + ", name="
				+ name + ", cdate=" + cdate + ", sweet=" + sweet + "]";
	}
}
