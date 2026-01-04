package pl.ros.keepapi.labels;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Feign client for label-svc.
 * Uses Eureka service discovery to resolve the service location.
 * 
 * To use this client in a service:
 * 1. Add @EnableFeignClients(basePackages = "pl.ros.keepapi") to your main class
 * 2. Inject LabelApi where needed
 */
@FeignClient(name = "label-svc", path = "/labels")
public interface LabelApi {

    @GetMapping
    List<LabelDto> getAll();

    @GetMapping("/{id}")
    LabelDto getById(@PathVariable("id") Long id);

    @PostMapping
    ResponseEntity<LabelDto> create(@RequestBody LabelDto dto);

    @PutMapping("/{id}")
    ResponseEntity<LabelDto> update(@PathVariable("id") Long id, @RequestBody LabelDto dto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id);

    /**
     * Find labels by a list of IDs.
     * Used by note-svc to resolve labels for notes.
     * 
     * NOTE: You need to add this endpoint to LabelsController in label-svc:
     * 
     * @PostMapping("/by-ids")
     * public List<LabelDto> findByIds(@RequestBody List<Long> ids) {
     *     return service.findByIds(ids);
     * }
     */
    @PostMapping("/by-ids")
    List<LabelDto> findByIds(@RequestBody List<Long> ids);
}
