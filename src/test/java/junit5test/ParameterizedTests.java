package junit5test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParameterizedTests {

    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1,3,6})
    void intValues(int TheParam) {
        System.out.println("TheParam = " + TheParam);
    }
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"Renato", "de Oliveira", "Campos"})
    void stringValues(String TheParam) {
        System.out.println("TheParam = " + TheParam);
    }

    @ParameterizedTest
    @CsvSource(value = {"Renato, Campos" , "Maria, Rocha" , "Orlando, Pai"})
    void csvSource(String param1, String param2) {
        System.out.println("param = " + param1 + ", param2 = " + param2);
    }

    @DisplayName("Teste sobre métodos parametrizados")
    @ParameterizedTest
    @CsvSource(value = {"Renato, 40, true,", "Maria, 80, false", "Orlando, 77, true"})
    void intStringBoolean(String param1, int param2, boolean param3) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }

    @ParameterizedTest
    @CsvSource(value = {"Renato, 'Tim'", "Maria, 'Princesa'"})
    void stringComVirgula (String param1, String param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"Renato?Campos", "Maria?Rocha"}, delimiter = '?')
    void stringComPerimetro(String param1, String param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvFileSource(files = {"C:\\Users\\RenatoCampos\\IdeaProjects\\junit5-tutorial\\src\\test\\resources\\params\\shoppinglist.csv"}, numLinesToSkip = 1)
    void stringDoubleStringToString(String nome, double price,
                                    int qtd, String unmedida, String local) {
        System.out.println("nome = " + nome + ", price = " + price + ", qtd = " + qtd + ", unmedida = " + unmedida + ", local = " + local);
    }

    @ParameterizedTest
    @MethodSource(value = "sourceString")



    void praticandoMethodSource(String parametro1 ){
        System.out.println("parametro1 = " + parametro1);
    }

    @ParameterizedTest
    @MethodSource(value = "sourceStream")
    void praticandoMethod_Stream(String parametro){
        System.out.println("parametro = " + parametro);
    }

    @ParameterizedTest
    @MethodSource(value = "sourceListStringDouble")
    void methodSourceStringDoubleList(String param1, double param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    List<String> sourceString() {
        //processing done here
        return Arrays.asList("Tomate", "Batata", "Cebola");
    }

    Stream<String> sourceStream(){
        //processando dados aqui
        return Stream.of("banana", "Pera", "Maça");
    }

    List<Arguments> sourceListStringDouble() {
        return Arrays.asList(arguments("Tomato", 2.0),
                arguments("Maça", 6.5));
    }

}
