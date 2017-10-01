package br.nemo.ufes.scap.Domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Professor extends Pessoa {	

}