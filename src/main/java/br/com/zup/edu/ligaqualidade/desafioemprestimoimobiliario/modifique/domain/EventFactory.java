package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.domain;

import java.util.Arrays;

public class EventFactory<T extends Event> {

    private final String eventSchema;
    private final String eventAction;

    EventFactory(String eventSchema, String eventAction) {
        this.eventSchema = eventSchema;
        this.eventAction = eventAction;
    }

    public T buildEvent() {
        EventEnum.findByAttrs(this.eventSchema, this.eventAction);
        return null;
    }
}

enum EventEnum {
    PROPOSAL_CREATED("proposal", "created"),
    PROPOSAL_UPDATED("proposal", "updated"),
    PROPOSAL_DELETED("proposal", "deleted"),
    WARRANTY_ADDED("warranty", "added"),
    WARRANTY_UPDATED("warranty", "updated"),
    WARRANTY_REMOVED("warranty", "removed"),
    PROPONENT_ADDED("proponent", "added");

    private String eventSchema;
    private String eventAction;

    EventEnum(String eventSchema, String eventAction) {
        this.eventSchema = eventSchema;
        this.eventAction = eventAction;
    }

    public String getEventSchema() {
        return eventSchema;
    }

    public String getEventAction() {
        return eventAction;
    }

    public static EventEnum findByAttrs(String eventSchema, String eventAction) {
        return Arrays.stream(EventEnum.values())
                .filter(event -> event.getEventSchema().equalsIgnoreCase(eventSchema) && event.getEventAction().equalsIgnoreCase(eventAction))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }
}
