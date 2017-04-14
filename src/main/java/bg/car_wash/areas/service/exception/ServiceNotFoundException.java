package bg.car_wash.areas.service.exception;

/**
 * Created by ivanof on 14.04.17.
 */
public class ServiceNotFoundException extends RuntimeException {
	private String message;

	private int code;

	public ServiceNotFoundException(String message, int code) {
		this.setMessage(message);
		this.setCode(code);
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
