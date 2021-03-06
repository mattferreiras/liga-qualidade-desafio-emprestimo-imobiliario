package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.domain;

public class ProposalCreatedEvent extends Event<ProposalCreatedEvent> {

    private String eventId;
    private String timestamp;
    private String proposalId;
    private String proposalLoanValue;
    private String proposalNumberMonthlyInstallments;

    public ProposalCreatedEvent(String eventId, String timestamp, String proposalId, String proposalLoanValue, String proposalNumberMonthlyInstallments) {
        this.eventId = eventId;
        this.timestamp = timestamp;
        this.proposalId = proposalId;
        this.proposalLoanValue = proposalLoanValue;
        this.proposalNumberMonthlyInstallments = proposalNumberMonthlyInstallments;
    }

    @Override
    ProposalCreatedEvent buildEvent() {
        return this;
    }

    public String getEventId() {
        return eventId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getProposalId() {
        return proposalId;
    }

    public String getProposalLoanValue() {
        return proposalLoanValue;
    }

    public String getProposalNumberMonthlyInstallments() {
        return proposalNumberMonthlyInstallments;
    }
}
