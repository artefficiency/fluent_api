package tech.artefficiency.fluent_api.part_3.builder;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
public class Entity {
    private int           id;
    private String        name;
    private LocalDateTime timestamp;
    private boolean       active;
}