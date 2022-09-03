package com.deliver.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment {
  @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private int pin;
  private String name;
  private String cardNo;
  private String expiry;
  private String address;
  private String mobNo;
  private String city;
  private String state;
}
