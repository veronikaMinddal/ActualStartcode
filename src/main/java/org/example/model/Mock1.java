package org.example.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "mock1")
public class Mock1
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mock1_id", nullable = false, unique = true)
    private Integer id;

    @Setter
    @Column(name = "mock1_name", nullable = false, unique = true)
    private String mock1String;

    @Setter
    @Column(name = "mock1_number", nullable = false)
    private Integer mock1Number;

    public Mock1(String mock1String, Integer mock1Number) {
        this.mock1String = mock1String;
        this.mock1Number = mock1Number;
    }

    public boolean validateNewMock1()
    {
        return mock1String != null && mock1Number != null;
    }
}
