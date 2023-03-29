package africa.semicolon.uberdeluxe.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.boot.jaxb.mapping.marshall.FetchTypeMarshalling;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private AppUser userDetails;
    private String employeeId;

}
