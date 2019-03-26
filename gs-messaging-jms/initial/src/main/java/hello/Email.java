package hello;

public class Email {

	private String to;
	private String body;

	public Email() {
		// TODO Auto-generated constructor stub
	}

	public Email(String to, String body) {
		super();
		this.to = to;
		this.body = body;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Email [to=" + to + ", body=" + body + "]";
	}

}
