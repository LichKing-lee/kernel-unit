package com.yong.kernelunit;

import com.yong.kernelunit.policy.AnnotationBasedMethodScanPolicy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestExecutorTest {
    @Test
    void 스캔한_메서드를_실행시키고_결과를_알려준다() {
        // arrange
        TestExecutor executor = new TestExecutor(
                new MethodScanner("com.yong.kernelunit.execute", new AnnotationBasedMethodScanPolicy())
        );

        // act
        TestResult testResult = executor.execute();

        // assert
        assertThat(testResult.success()).isEqualTo(3);
        assertThat(testResult.failure()).isEqualTo(2);
    }
}
