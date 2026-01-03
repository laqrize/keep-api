package pl.ros.keepapi.notes;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record AttachLabelsRequest(@NotNull List<Long> labelIds) {
}
