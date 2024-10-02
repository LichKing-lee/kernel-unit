package com.yong.kernelunit;

import java.util.List;

public record ScannedClass(
        Class<?> clazz,
        List<String> methodNames
) {}
