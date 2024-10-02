package com.yong.kernelunit.policy;

import com.yong.kernelunit.MethodScanPolicy;

import java.lang.reflect.Method;
import java.util.Arrays;

public class NameBasedMethodScanPolicy implements MethodScanPolicy {
    @Override
    public boolean isSatisfied(Method method) {
        Arrays.asList("");
        return method.getName().startsWith("test");
    }
}
