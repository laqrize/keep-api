package pl.ros.keepapi.images;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Feign client for file-svc.
 * Uses Eureka service discovery to resolve the service location.
 * 
 * To use this client in a service:
 * 1. Add @EnableFeignClients(basePackages = "pl.ros.keepapi") to your main class
 * 2. Inject FileApi where needed
 */
@FeignClient(name = "file-svc", path = "/api/files")
public interface FileApi {

    @GetMapping("/{id}")
    FileDto getById(@PathVariable("id") String id);

    @PostMapping
    ResponseEntity<FileDto> create(@RequestBody FileDto dto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") String id);

    /**
     * Find files by a list of IDs.
     * Used by note-svc to resolve images for notes.
     */
    @PostMapping("/by-ids")
    List<FileDto> findByIds(@RequestBody List<String> ids);

    /**
     * Download file content.
     * Returns the file as a byte array with content type header.
     */
    @GetMapping("/{id}/download")
    ResponseEntity<byte[]> download(@PathVariable("id") String id);
}


