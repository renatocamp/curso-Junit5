package junit5test;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PrimeiroTestClasse {

    @BeforeAll
    void beforeAll(){
        System.out.println("Antes de tudo, execute este bloco de código");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("Antes de cada teste, execute o código deste bloco");
    }
    @AfterAll
    void afterAll(){
        System.out.println("Depois de executar tudo, execute este bloco de código");
    }

    @AfterEach
    void afterEach(){
        System.out.println("Depois de cada teste, execute este bloco de comando");
    }


    @Test
    //Estrutura para criar um método
    //modificador de acesso - tipo de retorno - nomedoMetodo(parametros)
    void primeiroMetodo(){
        System.out.println("Este é um primeiro teste");
    }
    @Test
    @DisplayName("BR12134 - TC2 - Este é o segundo método")
    void segundoMetodo(){
        System.out.println("Este é o segundo método");
    }

}
