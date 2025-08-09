package com.codegnan.model;

public class Instructor {
	
	 	private int instructor_id; 
	    private String name;
	    private String email;
	    private String password;
	    
	    
		/**
		 * @param instructor_id
		 * @param name
		 * @param email
		 * @param password
		 */
		public Instructor(int instructor_id, String name, String email, String password) {
			super();
			this.instructor_id = instructor_id;
			this.name = name;
			this.email = email;
			this.password = password;
		}
		/**
		 * 
		 */
		public Instructor() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		public int getInstructor_id() {
			return instructor_id;
		}
		public void setInstructor_id(int instructor_id) {
			this.instructor_id = instructor_id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		
		@Override
		public String toString() {
			return "Instructor [instructor_id=" + instructor_id + ", name=" + name + ", email=" + email + ", password="
					+ password + "]";
		}
}
	    
		
	
