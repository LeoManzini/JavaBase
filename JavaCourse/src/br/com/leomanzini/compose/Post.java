package br.com.leomanzini.compose;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
	
	private static final SimpleDateFormat dateMask = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private String title;
	private String content;
	private int likes;
	
	private List<Comment> comments = new ArrayList<>();
	
	public Post() {
	}
	
	public Post(Date moment, String title, String content, int likes) {
		setMoment(moment);
		setTitle(title);
		setContent(content);
		setLikes(likes);
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void addComments(Comment comments) {
		this.comments.add(comments);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(title + "\n");
		sb.append(likes + " Likes - " + dateMask.format(moment) + "\n");
		sb.append(content + "\n");
		sb.append("Comments: \n");
		
		for(Comment c : comments) {
			sb.append(c.getText() + "\n");
		}
		
		return sb.toString();
	}
}
