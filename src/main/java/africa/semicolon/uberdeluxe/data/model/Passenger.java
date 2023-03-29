package africa.semicolon.uberdeluxe.data.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String phoneNumber;
    @Enumerated(value=EnumType.STRING)
    private Gender gender;
    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JsonUnwrapped
    private AppUser userDetails;

}
