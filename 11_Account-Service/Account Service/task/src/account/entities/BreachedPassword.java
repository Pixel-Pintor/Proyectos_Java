package account.entities;

import lombok.*;

import javax.persistence.*;

@Entity(name = "breached_passwords")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BreachedPassword {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String password;
}
