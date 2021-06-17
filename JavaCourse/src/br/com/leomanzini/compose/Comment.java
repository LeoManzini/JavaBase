package br.com.leomanzini.compose;

public class Comment {
	private String text;
	
	public Comment() {
	}
	
	public Comment (String text) {
		setText(text);
	}
	
	public String getText() {
		return this.text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
}
