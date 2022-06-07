package gft.exceptions;

public class SistemaPoliticoException extends RuntimeException{
	

	private static final long serialVersionUID = -870640033211505872L;

		private String message;



		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public SistemaPoliticoException(String message) {
			super(message);
			this.message = message;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	

	}



