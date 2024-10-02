package com.yong.kernelunit;

import com.yong.kernelunit.policy.AnnotationBasedMethodScanPolicy;
import com.yong.kernelunit.policy.CompositeMethodScanPolicy;
import com.yong.kernelunit.policy.NameBasedMethodScanPolicy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MethodScannerTest {
    @Test
    void 전달받은_패키지_하위_클래스의_테스트메서드를_스캔한다() {
        // arrange
        MethodScanner scanner = new MethodScanner("com.yong.kernelunit.scan",
                new CompositeMethodScanPolicy(
                        new NameBasedMethodScanPolicy(),
                        new AnnotationBasedMethodScanPolicy()
        ));

        // act
        ScannedPackage scannedPackage = scanner.scan();

        // assert
        assertThat(scannedPackage.classCount()).isEqualTo(2);
        assertThat(scannedPackage.methodCount()).isEqualTo(7);
    }
}
