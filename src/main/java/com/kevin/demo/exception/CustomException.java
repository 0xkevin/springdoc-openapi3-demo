package com.kevin.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author kevin
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomException extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 异常消息
	 */
	private String message;
}
