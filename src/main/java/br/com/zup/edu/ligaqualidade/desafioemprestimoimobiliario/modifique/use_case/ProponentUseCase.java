package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.use_case;

import org.springframework.stereotype.Component;

@Component
public class ProponentUseCase {

    public boolean applyToBeOfAgeRule(int age) {
        return age >= 18;
    }

    public boolean applyInvoiceRule(int age, double invoice, double loanValue) {
        return InvoiceRuleEnum.findByAge(age).applyInvoiceRuleByAge(invoice, loanValue);
    }
}

enum InvoiceRuleEnum {

    YOUNG {
        @Override
        boolean applyInvoiceRuleByAge(double invoice, double loanValue) {
            return (invoice / 4 >= loanValue);
        }
    },
    ADULT {
        @Override
        boolean applyInvoiceRuleByAge(double invoice, double loanValue) {
            return (invoice / 3 >= loanValue);
        }
    },
    AGED {
        @Override
        boolean applyInvoiceRuleByAge(double invoice, double loanValue) {
            return (invoice / 2 >= loanValue);
        }
    };

    public static InvoiceRuleEnum findByAge(int age) {
        if (age >= 18 && age <= 24) {
            return YOUNG;
        } else if (age > 24 && age <= 50) {
            return ADULT;
        } else {
            return AGED;
        }
    }

    abstract boolean applyInvoiceRuleByAge(double invoice, double loanValue);
}