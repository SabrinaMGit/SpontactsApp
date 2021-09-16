package cityact.app.chat.model;

import cityact.app.chat.converters.MessageTextConverter;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Convert(converter = MessageTextConverter.class)
    private String text;

    private Integer postedBy;

    private Date createdDate;

    @ManyToOne
    private Conversation conversation;

    protected Message() {}

    public Message(String text, Integer postedBy, Date createdDate) {
        this.text= text;
        this.postedBy= postedBy;
        this.createdDate = createdDate;
    }

    public Integer getId() {
      return id;
    }

    public Integer getPostedBy() {
      return postedBy;
    }

    public String getText() {
      return text;
    }

    public void setId(Integer id) {
      this.id = id;
    }

    public void setPostedBy(Integer postedBy) {
      this.postedBy = postedBy;
    }

    public void setText(String text) {
      this.text = text;
    }

   @Override
    public String toString() {
         return String.format(
                "Message[id=%d, text=%s, postedBy=%s, date=%s, conversation=%s]",
               id, text, postedBy, createdDate, conversation);
    }

	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
