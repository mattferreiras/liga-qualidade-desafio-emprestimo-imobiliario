package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.use_case;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ProposalUseCase {

    public boolean applyMinProponentsRule(int proponentsQuantity) {
        return proponentsQuantity >= 2;
    }

    public boolean applyWarrantyQuantityRule(int warrantyQuantity) {
        return warrantyQuantity >= 1;
    }

    public boolean applyWarrantyValueRule(double loanValue, double... warrantyValues) {
        if (null == warrantyValues) {
            return false;
        }

        double sum = 0.0;
        for (double value : warrantyValues) {
            sum += value;
        }

        return sum * 2 >= loanValue;
    }

    public boolean applyWarrantyStatesRule(String state) {
        if (null == state) {
            return false;
        }

        final String[] badStates = { "PR", "SC", "RS" };

        return Arrays.stream(badStates).noneMatch(state::contains);
    }

}
