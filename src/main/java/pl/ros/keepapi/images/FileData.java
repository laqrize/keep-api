package pl.ros.keepapi.images;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileData {
    private InputStream content;
    private String filename;
    private String contentType;
    private Long size;

    public static FileData of(FileDto dto, String filename) {
        return FileData.builder()
                .content(new ByteArrayInputStream(dto.getContent()))
                .filename(filename)
                .contentType(dto.getContentType())
                .size((long) dto.getContent().length)
                .build();
    }
}
