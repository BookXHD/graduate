package com.tzg.xhd.tbooking.common;

public class AnswerGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Answer genSuccessAnswer(String message, Object data){
        Answer answer = new Answer();
        answer.setMessage(message);
        answer = genSuccessAnswer(data);
        return answer;
    }

    public static Answer genSuccessAnswer(Object data){
        Answer answer = new Answer();
        answer.setSuccess(true);
        answer.setMessage(DEFAULT_SUCCESS_MESSAGE);
        answer.setData(data);
        return answer;
    }

    public static Answer genSuccessAnswer(String message){
        Answer answer = new Answer();
        answer.setSuccess(true);
        answer.setMessage(message);
        return answer;
    }

    public static Answer genFailAnswer(String message){
        Answer answer = new Answer();
        answer.setSuccess(false);
        answer.setMessage(message);
        return answer;
    }
}
