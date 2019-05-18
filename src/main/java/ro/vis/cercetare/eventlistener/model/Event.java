package ro.vis.cercetare.eventlistener.model;

import lombok.*;

import java.util.Map;

@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Event {
    private String event;
    private String entityType;
    private String entityId;
    private String targetEntityType;
    private String targetEntityId;
    private Map<String, Object> properties;
}
