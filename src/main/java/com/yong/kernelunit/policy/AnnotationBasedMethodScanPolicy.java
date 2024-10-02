package com.yong.kernelunit.policy;

import com.yong.kernelunit.KernelUnit;
import com.yong.kernelunit.MethodScanPolicy;

import java.lang.reflect.Method;

public class AnnotationBasedMethodScanPolicy implements MethodScanPolicy {
    @Override
    public boolean isSatisfied(Method method) {
        return method.getAnnotation(KernelUnit.class) != null;
    }
}
