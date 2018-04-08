package com.liwj.asem.remote;

/**
 * mailto:xiaobenma020@gmail.com
 */
public class MethodNotSupportException extends Exception {
    public MethodNotSupportException(String methodName) {
        super("Method " + methodName + " not support!");
    }
}
