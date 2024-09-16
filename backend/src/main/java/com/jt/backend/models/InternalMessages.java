package com.jt.backend.models;

import lombok.Getter;
import lombok.Setter;

public class InternalMessages {
	
	@Getter
	@Setter
	/*0:ERROR
	 *1:OK
	 *2:TODO */
	private int id;
	
	@Getter
	@Setter
	private String message;
	
	@Getter
	@Setter
	private Object additionalInfo;

	public InternalMessages(int id,String message,Object additionalInfo) {
		this.id=id;
		this.message=message;
		this.additionalInfo=additionalInfo;
	}
	public InternalMessages() {
		this.id=1;
		this.message="OK";
		this.additionalInfo=null;
	}
}
