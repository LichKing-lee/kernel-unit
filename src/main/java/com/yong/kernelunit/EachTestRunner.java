package com.yong.kernelunit;

import java.lang.reflect.Method;

public class EachTestRunner {
    private final Class<?> clazz;
    private final String methodName;
    private boolean wanRun;

    public EachTestRunner(Class<?> clazz, String methodName) {
        this.clazz = clazz;
        this.methodName = methodName;
        this.wanRun = false;
    }

    public void run() {
        try {
            Object object = this.clazz.getDeclaredConstructor().newInstance();
            Method method = this.clazz.getDeclaredMethod(methodName);
            method.setAccessible(true);
            method.invoke(object);
            this.wanRun = true;
        } catch(Exception e) {
            throw new KernelUnitFailureException(this.clazz, this.methodName, e);
        }
    }

    public boolean wasRun() {
        return this.wanRun;
    }
}
