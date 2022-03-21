package junit5test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class DisableEEnableTests {
    @Test
    @Disabled("Desabilitado para demonstração")
    void primeiroTest(){
        System.out.println("Primeiro teste");
    }

    @Test
    @DisabledOnOs(value = OS.WINDOWS, disabledReason = "Desabilitado por demonstração DisableOnOs")
    void segundoTest(){
        System.out.println("segundoTest");
    }
    @Test
   // @DisabledIfSystemProperty()
    void terceiroTest(){
        System.out.println("Terceiro test");
    }
    @Test
    @DisabledIf (value = "provider", disabledReason = "Desabilitado para demonstração de @DisabledIf annotation")
    void quartoTest(){
        System.out.println("Quarto teste");
    }
    @Test
    void quintoTest(){
        System.out.println("Quinto Teste");
    }

    boolean provider (){
        return LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.SUNDAY);
    }

    @Test
    @EnabledIf(value = "providerDois", disabledReason = "Fins de teste")
    void abilitaOTestIf(){
        System.out.println("So exucuta quando a condição for verdadeira");
    }

    boolean providerDois(){
        LocalDateTime.now();
        return false;
    }
}
