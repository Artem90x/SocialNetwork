package skillbox.javapro11.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponse extends ResponseData{

    private long id;

    private Long time;

    @JsonProperty(value = "author_id")
    private long authorId;

    @JsonProperty(value = "recipient_id")
    private int recipientId;

    @JsonProperty(value = "message_text")
    private String messageText;

    @JsonProperty(value = "read_status")
    private String readStatus;
}
