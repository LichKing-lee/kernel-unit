package com.yong.kernelunit.policy;

import com.yong.kernelunit.MethodScanPolicy;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class CompositeMethodScanPolicy implements MethodScanPolicy {
    private List<MethodScanPolicy> policies;

    public CompositeMethodScanPolicy(MethodScanPolicy... policies) {
        this.policies = Arrays.stream(policies).toList();
    }

    @Override
    public boolean isSatisfied(Method method) {
        return policies.stream().anyMatch(policy -> policy.isSatisfied(method));
    }
}
