package com.yong.kernelunit;

import com.yong.kernelunit.policy.NameBasedMethodScanPolicy;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class MethodScanner {
    private final String basePackage;
    private final MethodScanPolicy methodScanPolicy;

    public MethodScanner(String basePackage) {
        this(basePackage, new NameBasedMethodScanPolicy());
    }

    public MethodScanner(String basePackage, MethodScanPolicy methodScanPolicy) {
        this.basePackage = basePackage;
        this.methodScanPolicy = methodScanPolicy;
    }

    public ScannedPackage scan() {
        var reflections = new Reflections(basePackage, Scanners.SubTypes.filterResultsBy(v -> true));
        Set<Class<?>> allClasses = reflections.getSubTypesOf(Object.class);

        List<ScannedClass> classes = allClasses.stream().map(e -> {
            List<String> methodNames = Arrays.stream(e.getDeclaredMethods())
                    .filter(m -> methodScanPolicy.isSatisfied(m))
                    .map(Method::getName).toList();
            return new ScannedClass(e, methodNames);
        }).toList();

        return new ScannedPackage(classes);
    }
}
