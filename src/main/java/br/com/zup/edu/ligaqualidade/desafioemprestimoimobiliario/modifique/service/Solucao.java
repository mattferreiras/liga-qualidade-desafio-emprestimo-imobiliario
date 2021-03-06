package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.service;

import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.use_case.LoanUseCase;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.use_case.ProponentUseCase;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.use_case.ProposalUseCase;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class Solucao {

    private final LoanUseCase loanUseCase;
    private final ProposalUseCase proposalUseCase;
    private final ProponentUseCase proponentUseCase;

    public Solucao(LoanUseCase loanUseCase, ProposalUseCase proposalUseCase, ProponentUseCase proponentUseCase) {
        this.loanUseCase = loanUseCase;
        this.proposalUseCase = proposalUseCase;
        this.proponentUseCase = proponentUseCase;
    }

    public static String processMessages(List<String> messages) {
        for (String message : messages) {
            List<String> data = Arrays.asList(message.split(","));
            final String eventSchema = data.get(1);
            final String eventAction = data.get(2);


        }

        return "";
    }
}