package br.nemo.ufes.scap.Domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class Secretario extends Pessoa {	

}
