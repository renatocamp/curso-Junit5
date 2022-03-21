package junit5test;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

public class RepeatingTests {

    @RepeatedTest(5)
    void primeiroTesteASerRepetido(){
        System.out.println("Estamos repetindo o teste");
    }

    @RepeatedTest(value = 3, name = "Executando o teste :{currentRepetition}." +
                    "Total de: {totalRepetitions}")
    void secondRepeatedMethod(){
        System.out.println("Repetindo um novo teste");
    }

    @RepeatedTest(3)
    void terceiroMetodo(RepetitionInfo repetitionInfo){
        System.out.println("Este código será executado em cada repetição");
        Assumptions.assumingThat(repetitionInfo.getCurrentRepetition() == 3,
                () -> System.out.println("Este código será executado apenas na repetição 3"));
    }
}
