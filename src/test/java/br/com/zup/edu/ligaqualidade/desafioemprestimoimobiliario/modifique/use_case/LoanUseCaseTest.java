package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.use_case;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LoanUseCaseTest {

    @InjectMocks
    private LoanUseCase useCase;

    @ParameterizedTest
    @MethodSource("generateTrueValues")
    void applyLoanValueRule_shouldReturnTrue(double value) {

        Assertions.assertTrue(useCase.applyLoanValueRule(value));
    }

    @ParameterizedTest
    @MethodSource("generateFalseValues")
    void applyLoanValueRule_shouldReturnFalse(double value) {

        Assertions.assertFalse(useCase.applyLoanValueRule(value));
    }

    private static Stream<Arguments> generateTrueValues() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(30000.00))
                .add(Arguments.of(40000.00))
                .add(Arguments.of(95000.00))
                .add(Arguments.of(100000.00))
                .add(Arguments.of(210000.00))
                .build();
    }

    private static Stream<Arguments> generateFalseValues() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(1.00))
                .add(Arguments.of(2.00))
                .add(Arguments.of(800000000.00))
                .add(Arguments.of(100000000.00))
                .add(Arguments.of(999999999.00))
                .build();
    }

}