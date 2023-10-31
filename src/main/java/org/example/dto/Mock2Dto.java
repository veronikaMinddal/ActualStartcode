package org.example.dto;

import org.example.model.Mock2;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@EqualsAndHashCode
@Getter
public class Mock2Dto
{
    private String mock2Name;
    private Integer mock2Integer;

    public Mock2Dto(Mock2 mock2) {
        this.mock2Name = mock2.getMock2Name();
        this.mock2Integer = mock2.getMock2Number();
    }

    public static List<Mock2Dto> toMock2DtoList(List<Mock2> mock2s) {
        return List.of(mock2s.stream().map(Mock2Dto::new).toArray(Mock2Dto[]::new));
    }
}