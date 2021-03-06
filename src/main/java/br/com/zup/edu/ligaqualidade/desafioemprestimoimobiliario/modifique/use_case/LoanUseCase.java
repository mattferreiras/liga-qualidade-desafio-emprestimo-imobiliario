package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.use_case;

import org.springframework.stereotype.Component;

@Component
public class LoanUseCase {

    public boolean applyLoanValueRule(double value) {
        return (value >= 30000.00 && value <= 3000000.00);
    }

    public boolean applyExpirationDateRule(int days) {
        return (days >= 730 && days <= 5475);
    }

}
