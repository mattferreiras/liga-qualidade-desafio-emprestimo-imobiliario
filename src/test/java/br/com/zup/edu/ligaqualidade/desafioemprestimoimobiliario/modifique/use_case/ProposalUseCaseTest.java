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
class ProposalUseCaseTest {

    @InjectMocks
    private ProposalUseCase useCase;

    @ParameterizedTest
    @MethodSource("applyMinProponentsRule_genTrueValues")
    void applyMinProponentsRule_shouldReturnTrue(int proponentsQuantity) {
        Assertions.assertTrue(useCase.applyMinProponentsRule(proponentsQuantity));
    }

    @ParameterizedTest
    @MethodSource("applyMinProponentsRule_genFalseValues")
    void applyMinProponentsRule_shouldReturnFalse(int proponentsQuantity) {
        Assertions.assertFalse(useCase.applyMinProponentsRule(proponentsQuantity));
    }

    @ParameterizedTest
    @MethodSource("applyWarrantyQuantityRule_genTrueValues")
    void applyWarrantyQuantityRule_shouldReturnTrue(int warrantyQuantity) {
        Assertions.assertTrue(useCase.applyWarrantyQuantityRule(warrantyQuantity));
    }

    @ParameterizedTest
    @MethodSource("applyWarrantyQuantityRule_genFalseValues")
    void applyWarrantyQuantityRule_shouldReturnFalse(int warrantyQuantity) {
        Assertions.assertFalse(useCase.applyWarrantyQuantityRule(warrantyQuantity));
    }

    @ParameterizedTest
    @MethodSource("applyWarrantyStatesRule_genTrueValues")
    void applyWarrantyStatesRule_shouldReturnTrue(String state) {
        Assertions.assertTrue(useCase.applyWarrantyStatesRule(state));
    }

    @ParameterizedTest
    @MethodSource("applyWarrantyStatesRule_genFalseValues")
    void applyWarrantyStatesRule_shouldReturnFalse(String state) {
        Assertions.assertFalse(useCase.applyWarrantyStatesRule(state));
    }

    private static Stream<Arguments> applyMinProponentsRule_genTrueValues() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(2))
                .add(Arguments.of(3))
                .add(Arguments.of(25))
                .add(Arguments.of(10))
                .add(Arguments.of(99))
                .build();
    }

    private static Stream<Arguments> applyMinProponentsRule_genFalseValues() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(1))
                .add(Arguments.of(0))
                .add(Arguments.of(-1))
                .add(Arguments.of(-30))
                .add(Arguments.of(-1000))
                .build();
    }

    private static Stream<Arguments> applyWarrantyQuantityRule_genTrueValues() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(1))
                .add(Arguments.of(2))
                .add(Arguments.of(3))
                .add(Arguments.of(25))
                .add(Arguments.of(99))
                .build();
    }

    private static Stream<Arguments> applyWarrantyQuantityRule_genFalseValues() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(0))
                .add(Arguments.of(-15))
                .add(Arguments.of(-1))
                .add(Arguments.of(-30))
                .add(Arguments.of(-1000))
                .build();
    }

    private static Stream<Arguments> applyWarrantyStatesRule_genTrueValues() {
        return Stream.<Arguments>builder()
                .add(Arguments.of("MG"))
                .add(Arguments.of("SP"))
                .add(Arguments.of("AC"))
                .add(Arguments.of("AM"))
                .add(Arguments.of("PA"))
                .build();
    }

    private static Stream<Arguments> applyWarrantyStatesRule_genFalseValues() {
        return Stream.<Arguments>builder()
                .add(null)
                .add(Arguments.of("PR"))
                .add(Arguments.of("SC"))
                .add(Arguments.of("RS"))
                .build();
    }

}