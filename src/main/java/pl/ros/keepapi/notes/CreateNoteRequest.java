package pl.ros.keepapi.notes;

import java.util.List;

public record CreateNoteRequest(String title, String content, List<String> images /*base64*/){

}
