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
@Table(name = "mock2")
public class Mock2
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mock2_id", nullable = false, unique = true)
    private Integer mock2Id;

    @Setter
    @Column(name = "mock2_name", nullable = false)
    private String mock2Name;

    @Setter
    @Column(name = "mock2_number", nullable = false)
    private int mock2Number;

    public Mock2(int mock2Number, String mock2Name) {
        this.mock2Number = mock2Number;
        this.mock2Name = mock2Name;
    }
}
