package com.yong.kernelunit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class EachTestRunnerTest {
    @Test
    void 전달받은_클래스의_메서드를_실행시킨다() {
        // arrange
        EachTestRunner runner = new EachTestRunner(Dummy.class, "method1");

        // act
        runner.run();

        // assert
        assertThat(runner.wasRun()).isEqualTo(true);
    }

    @Test
    void 존재하지않는_메서드를_전달하면_예외를_일으킨다() {
        // arrange
        EachTestRunner runner = new EachTestRunner(Dummy.class, "method123");

        // act assert
        assertThatThrownBy(() -> runner.run()).isInstanceOf(KernelUnitFailureException.class);
    }

    @Test
    void 메서드가_실패하면_예외를_일으킨다() {
        // arrange
        EachTestRunner runner = new EachTestRunner(Dummy.class, "method2");

        // act assert
        assertThatThrownBy(() -> runner.run()).isInstanceOf(KernelUnitFailureException.class);
    }

    public static class Dummy {
        void method1(){
            System.out.println("hello kernel");
        }

        public void method2(){
            throw new RuntimeException("실패했다ㅠㅠ");
        }
    }
}
