package junit5test;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

public class MiscTest {

    @Test
    @Timeout(5)
    void timeOut() throws InterruptedException {
        System.out.println("Este é um teste com TimeOut");
        Thread.sleep(5000);
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class NestedClass {

        @BeforeAll
        void beforeAllTest(){
            System.out.println("BeforeAll em Nested Method");
        }

        @Test
        void nestedTestMethod(){
            System.out.println("Nested Test Method");
        }
    }
    @Test
    @Timeout(90)
    @DisplayName("Custom Annotation")
    @Tag("available")
    void customAnnotationInterface(){
        System.out.println("Esta não é uma interface padronizada");
    }

    @MyAnnotations
    void customAnnotationInterface2(){
        System.out.println("Esta já é uma interface padronizada");
    }


}
