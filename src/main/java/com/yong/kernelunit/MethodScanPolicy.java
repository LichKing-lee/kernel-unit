package com.yong.kernelunit;

import java.lang.reflect.Method;

public interface MethodScanPolicy {
    boolean isSatisfied(Method method);
}
