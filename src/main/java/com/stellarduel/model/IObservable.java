package com.stellarduel.model;

public interface IObservable {
    void ajouterObservateur(IObservateur o);
    void notifierObservateurs();
}