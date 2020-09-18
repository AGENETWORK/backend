package com.example.agen;

public class Sample {
	private final long id;
	private final String content;

	public Sample(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}
