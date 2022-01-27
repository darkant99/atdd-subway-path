package nextstep.subway.line.domain.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;
import nextstep.subway.line.domain.model.Line;
import nextstep.subway.station.domain.dto.StationResponse;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LineResponse {
    private final Long id;
    private final String name;
    private final String color;
    private final List<StationResponse> stations;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    @Builder
    private LineResponse(Long id, String name, String color, List<StationResponse> stations, LocalDateTime createdDate,
                        LocalDateTime modifiedDate) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.stations = stations;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public static LineResponse notWithStationsFrom(Line line) {
        return builder()
            .id(line.getId())
            .name(line.getName())
            .color(line.getColor())
            .createdDate(line.getCreatedDate())
            .modifiedDate(line.getModifiedDate())
            .build();
    }

    public static LineResponse withStationsFrom(Line line) {
        List<StationResponse> stations =
            line.getStations()
                .stream()
                .map(StationResponse::from)
                .collect(Collectors.toList());

        return builder()
            .id(line.getId())
            .name(line.getName())
            .color(line.getColor())
            .stations(stations)
            .createdDate(line.getCreatedDate())
            .modifiedDate(line.getModifiedDate())
            .build();
    }
}

