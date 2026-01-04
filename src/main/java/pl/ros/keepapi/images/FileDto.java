package pl.ros.keepapi.images;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pl.ros.commons.dtos.AbstractCustomDto;
import pl.ros.keepapi.enums.StorageLocation;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class FileDto extends AbstractCustomDto<String> {
    private String id;
    private String imagePath;
    private byte[] content;
//    @JsonIgnore
    private StorageLocation storageLocation;
//    @JsonIgnore
    private String contentType;
//    @JsonIgnore
    private Long size;
    private String filename;
}
