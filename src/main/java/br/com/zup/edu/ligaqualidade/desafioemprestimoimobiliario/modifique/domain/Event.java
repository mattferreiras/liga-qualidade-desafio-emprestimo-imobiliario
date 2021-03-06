package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.domain;

public abstract class Event<T> {

    abstract T buildEvent();
}
