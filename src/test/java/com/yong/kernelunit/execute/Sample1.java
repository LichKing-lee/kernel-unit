package com.yong.kernelunit.execute;

import com.yong.kernelunit.KernelUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Sample1 {
    @KernelUnit
    void method1() {
        assertThat(1+5).isEqualTo(6);
    }

    @KernelUnit
    void method2() {
        assertThat(1+5).isEqualTo(7);
    }

    @KernelUnit
    void method3() {
        assertThat(2+5).isEqualTo(7);
    }
}
