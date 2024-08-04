package tn.esprit.futureuniversity.Entities;

import lombok.*;
import tn.esprit.futureuniversity.Enums.MessageType;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {
    private String content;
    private String sender;
    private MessageType type;
    // Getters and setters
}