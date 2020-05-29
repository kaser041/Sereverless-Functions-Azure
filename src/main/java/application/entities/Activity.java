package application.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Activity {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private String id;
    private String name;
    private String description;
    private String date;
    private String user;

    public static Activity create() {
        return create("", "", "", "","");
    }
}
