package com.yong.kernelunit;

public class KernelUnitFailureException extends RuntimeException {
    public KernelUnitFailureException(Class<?> clazz, String methodName, Exception cause) {
        super(String.format("class: %s method: %s", clazz.getName(), methodName), cause);
    }
}
