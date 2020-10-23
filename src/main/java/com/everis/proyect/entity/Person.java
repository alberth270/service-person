package com.everis.proyect.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "persons")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Person implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String documento;
  private boolean fingerprint;
  private boolean blacklist;

  private static final long serialVersionUID = 1L;
}
