package pl.ros.keepapi.notes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pl.ros.commons.dtos.AbstractCustomDto;
import pl.ros.keepapi.images.FileDto;
import pl.ros.keepapi.labels.LabelDto;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper=false)
public class NoteDto extends AbstractCustomDto<String> {
    private String id;
    private String title;
    private String content;
    private List<LabelDto> labels;
    private List<FileDto> images;

    public List<Long> getLabelIds() {
        if (labels == null) {
            return new ArrayList<>();
        }
        return labels.stream()
                .map(LabelDto::getId)
                .toList();
    }

    @SuppressWarnings("unchecked")
    public void setLabelIds(List<Long> labelIds) {
        if (labelIds == null) {
            this.labels = new ArrayList<>();
            return;
        }
        this.labels = (List<LabelDto>) labelIds.stream()
                .map(id -> LabelDto.builder().id(id).build())
                .toList();
    }


    public List<String> getImagesIds() {
        if (images == null) {
            return new ArrayList<>();
        }
        return images.stream()
                .map(FileDto::getId)
                .toList();
    }

    @SuppressWarnings("unchecked")
    public void setImagesIds(List<String> imagesIds) {
        if (imagesIds == null) {
            this.images = new ArrayList<>();
            return;
        }
        this.images = (List<FileDto>) imagesIds.stream()
                .map(id -> FileDto.builder().id(id).build())
                .toList();
    }

}