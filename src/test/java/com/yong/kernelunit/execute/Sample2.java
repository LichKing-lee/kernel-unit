package com.yong.kernelunit.execute;

import com.yong.kernelunit.KernelUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Sample2 {
    @KernelUnit
    public void method1() {
        assertThat(1+5).isEqualTo(6);
    }

    @KernelUnit
    public void method2() {
        assertThat(1+5).isEqualTo(7);
    }
}
