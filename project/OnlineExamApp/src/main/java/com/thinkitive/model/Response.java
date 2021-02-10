package com.thinkitive.model;

public class Response {
	
	
	
		private int question;
		private String answer;
		public int getQuestion() {
			return question;
		}
		public void setQuestion(int question) {
			this.question = question;
		}
		public String getAnswer() {
			return answer;
		}
		public void setAnswer(String answer) {
			this.answer = answer;
		}
		@Override
		public String toString() {
			return "Response [question=" + question + ", answer=" + answer + "]";
		}
		public Response(int question, String answer) {
			super();
			this.question = question;
			this.answer = answer;
		}
		
}
