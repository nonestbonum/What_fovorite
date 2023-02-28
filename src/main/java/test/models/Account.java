package test.models;


import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account_table")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @OneToOne(mappedBy = "account",cascade = CascadeType.ALL)
    private Form form;

    private String FIO;

    @Column(unique = true)
    private String email;

    private String password;

    private String birthday;

    private String activationCode;

    private boolean isActivated;
}
