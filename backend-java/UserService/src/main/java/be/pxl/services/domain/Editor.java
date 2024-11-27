package be.pxl.services.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "editors")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Editor {

    @Id
    @GeneratedValue
    private Long id;

    @ElementCollection
    private List<Long> posts = new ArrayList<>();

    private String name;
    private String email;
}
