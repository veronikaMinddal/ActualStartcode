package org.example.dto;

import org.example.model.Mock1;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class Mock1Dto
{
    private Integer id;
    private String mock1Name;
    private int mock1Number;

    public Mock1Dto(Mock1 mock1) {
        this.id = mock1.getId();
        this.mock1Name = mock1.getMock1String();
        this.mock1Number = mock1.getMock1Number();
    }

    public static List<Mock1Dto> toMock1DtoList(List<Mock1> mock1s) {
        return List.of(mock1s.stream().map(Mock1Dto::new).toArray(Mock1Dto[]::new));
    }
}
