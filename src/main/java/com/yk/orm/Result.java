package com.yk.orm;

import java.io.Serializable;

/**
 * @ClassName: Result 
 * @Description: the result
 * @author: Administrator
 * @date: 2016年12月13日 上午10:27:48
 */
public class Result implements Serializable {
    private static final long serialVersionUID = 6288374846131788743L;

    /**
     * 信息
     */
    private String message;

    /**
     * 状态码
     */
    private int statusCode;

    /**
     * 是否成功
     */
    private boolean success;
    
    /**
     * 返回结果数据
     */
  	private Object resultData;
  	
  	 /**
     * 手机端返回结果数据
     */
  	private Object returnData;
  	
  	/**
     * 手机端返回结果状态吗
     */
  	private Object status;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getResultData() {
		return resultData;
	}

	public void setResultData(Object resultData) {
		this.resultData = resultData;
	}
	
	/**
	 * 
	 */
	public Result(){
		
	}

	/**
	 * @param message
	 * @param statusCode
	 * @param success
	 * @param resultData
	 */
	public Result(boolean success, int statusCode, String message, Object resultData){
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.success = success;
		this.resultData = resultData;
	}

	public Object getReturnData() {
		return returnData;
	}

	public void setReturnData(Object returnData) {
		this.returnData = returnData;
	}

	public Object getStatus() {
		return status;
	}

	public void setStatus(Object status) {
		this.status = status;
	}
	
}
