package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.use_case;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
class ProponentUseCaseTest {

    @InjectMocks
    private ProponentUseCase useCase;

    @ParameterizedTest
    @MethodSource("applyToBeOfAgeRule_genTrueValues")
    void applyToBeOfAgeRule_shouldReturnTrue(int age) {
        Assertions.assertTrue(useCase.applyToBeOfAgeRule(age));
    }

    @ParameterizedTest
    @MethodSource("applyToBeOfAgeRule_genFalseValues")
    void applyToBeOfAgeRule_shouldReturnFalse(int age) {
        Assertions.assertFalse(useCase.applyToBeOfAgeRule(age));
    }

    @ParameterizedTest
    @MethodSource("applyInvoiceRule_genTrueValues")
    void applyInvoiceRule_shouldReturnTrue(int age, double invoice, double installmentValue) {
        Assertions.assertTrue(useCase.applyInvoiceRule(age, invoice, installmentValue));
    }

    @ParameterizedTest
    @MethodSource("applyInvoiceRule_genFalseValues")
    void applyInvoiceRule_shouldReturnFalse(int age, double invoice, double installmentValue) {
        Assertions.assertFalse(useCase.applyInvoiceRule(age, invoice, installmentValue));
    }

    private static Stream<Arguments> applyToBeOfAgeRule_genTrueValues() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(18))
                .add(Arguments.of(20))
                .add(Arguments.of(55))
                .add(Arguments.of(98))
                .add(Arguments.of(32))
                .build();
    }

    private static Stream<Arguments> applyToBeOfAgeRule_genFalseValues() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(1))
                .add(Arguments.of(2))
                .add(Arguments.of(10))
                .add(Arguments.of(17))
                .add(Arguments.of(9))
                .build();
    }

    private static Stream<Arguments> applyInvoiceRule_genTrueValues() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(18, 8000.00, 2000.00))
                .add(Arguments.of(24, 10000.00, 1500.00))
                .add(Arguments.of(55, 100000.00, 30000.00))
                .add(Arguments.of(25, 4000.00, 500.00))
                .add(Arguments.of(50, 100000.00, 30000.00))
                .build();
    }

    private static Stream<Arguments> applyInvoiceRule_genFalseValues() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(18, 8000.00, 2001.00))
                .add(Arguments.of(24, 10000.00, 2501.00))
                .add(Arguments.of(55, 100000.00, 300000.00))
                .add(Arguments.of(25, 4000.00, 1334.00))
                .add(Arguments.of(50, 100000.00, 33334.00))
                .build();
    }
}