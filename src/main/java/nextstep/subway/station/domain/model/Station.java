package nextstep.subway.station.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import nextstep.subway.common.domain.model.BaseEntity;

@Getter
@Entity
public class Station extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(
        name = "NAME",
        nullable = false,
        unique = true,
        length = 50
    )
    private String name;

    protected Station() {
    }

    public Station(String name) {
        this.name = name;
    }

    public boolean matchId(long id) {
        return this.id == id;
    }
}
