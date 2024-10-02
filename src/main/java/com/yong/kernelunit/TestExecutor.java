package com.yong.kernelunit;

public class TestExecutor {
    private final MethodScanner methodScanner;

    public TestExecutor(MethodScanner methodScanner) {
        this.methodScanner = methodScanner;
    }

    public TestExecutor(String basePackage) {
        this.methodScanner = new MethodScanner(basePackage);
    }

    public TestResult execute() {
        ScannedPackage scannedPackage = methodScanner.scan();

        int success = 0;
        int failure = 0;
        for(ScannedClass scannedClass : scannedPackage.scannedClasses()) {
            for(String methodName : scannedClass.methodNames()) {
                try {
                    new EachTestRunner(scannedClass.clazz(), methodName).run();
                    success++;
                } catch(KernelUnitFailureException e) {
                    failure++;
                }
            }
        }

        return new TestResult(success, failure);
    }
}
