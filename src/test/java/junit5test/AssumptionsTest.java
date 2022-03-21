package junit5test;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

public class AssumptionsTest {

    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1,5,6})
    void outroNome(int TheParam){
        Assumptions.assumeTrue(TheParam > 4);
        System.out.println("TheParam = " + TheParam);
    }
    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1,3,6})
    void intValues(int TheParam) {
        Assumptions.assumeTrue(TheParam > 4);
        System.out.println("TheParam = " + TheParam);
    }

    @ParameterizedTest
    @CsvSource(value = {"10, 10","5, 5"})
    void testeDeAssumptions(int Param1, int Param2){
        int soma = Param1 + Param2;
        Assumptions.assumeTrue(soma == 10);
        System.out.println("O resultado ocorreu como o esperado");
    }

}
