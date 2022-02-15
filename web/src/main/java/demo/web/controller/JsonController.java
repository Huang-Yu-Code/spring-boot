package demo.web.controller;

import demo.web.entity.Json;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 项目: spring-boot
 * 时间: 2021/10/22 0:39
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@RestController
@RequestMapping("/json")
public class JsonController {

    private static final ConcurrentMap<String, Json> MAP = new ConcurrentHashMap<>();

    @PostMapping("")
    public Object add(HttpServletRequest request, @Validated @RequestBody Json json) throws URISyntaxException {
        String id = UUID.randomUUID().toString();
        json.setId(id);
        MAP.put(id, json);
        String uri = request.getRequestURI();
        String location = String.format("%s/%s", uri, id);
        return ResponseEntity.created(new URI(location)).build();
    }

    @GetMapping("")
    public Object getAll() {
        return ResponseEntity.ok().body(MAP.values());
    }

    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        return ResponseEntity.ok().body(MAP.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id,@Validated @RequestBody Json json) {
        json.setId(id);
        MAP.put(id,json);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        MAP.remove(id);
        return ResponseEntity.noContent().build();
    }
}
