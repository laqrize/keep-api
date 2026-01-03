package pl.ros.keepapi.labels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pl.ros.commons.dtos.AbstractDto;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class LabelDto extends AbstractDto {
    private Long id;
    private String name;
}
