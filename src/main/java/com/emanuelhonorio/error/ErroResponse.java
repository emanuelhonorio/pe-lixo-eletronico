package com.emanuelhonorio.error;

import java.io.Serializable;

public class ErroResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private int status;
	private String message;
	private Long timestamp;

	public ErroResponse(int status, String message, Long timestamp) {
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

}
