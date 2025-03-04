package com.GED.DocuGed.event;


import com.GED.DocuGed.entity.UserEntity;
import com.GED.DocuGed.enumeration.EventType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter@AllArgsConstructor

public class UserEvent {
    private UserEntity user;
    private EventType type;
    private Map<?, ?> data;
}
