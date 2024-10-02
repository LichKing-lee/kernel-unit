package com.yong.kernelunit;

import java.util.List;

public record ScannedPackage(
        List<ScannedClass> scannedClasses
) {
    public int classCount() {
        return scannedClasses.size();
    }

    public int methodCount() {
        return (int) scannedClasses.stream().mapToLong(e -> e.methodNames().size()).sum();
    }
}
