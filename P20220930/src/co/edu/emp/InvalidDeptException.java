package co.edu.emp;

public class InvalidDeptException extends RuntimeException{
	InvalidDeptException(){}
	
	InvalidDeptException(String msg){
		super(msg);
	}
}
