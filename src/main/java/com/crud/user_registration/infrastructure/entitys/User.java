package com.crud.user_registration.infrastructure.entitys;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "email", unique = true)
    private String  email;

    @Column(name = "nome")
    private String nome;
}
