package customexception;

public class InvalidChoiceException extends RuntimeException{
	
	private String message;
	//public constructor to access in another package like(sdbms)
	public InvalidChoiceException(String message){
		this.message=message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}