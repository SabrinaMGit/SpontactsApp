package cityact.app.chat.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Conversation {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private Integer ownerId;

    private Date createdDate;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "conversations")
    private Set<User> users = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy="conversation", cascade = CascadeType.ALL)
    List<Message> messages = new ArrayList<>();

    protected Conversation() {}

    public Conversation(String title, Date createdDate) {
        this.title= title;
        this.createdDate = createdDate;
    }

    public Set<User> getUsers() {
        return users;
    }

    public Integer getId() {
      return id;
    }

    public String getTitle() {
      return title;
    }

    public void setId(Integer id) {
      this.id = id;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
      }

    public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
         return String.format(
                "Conversation[id=%d, title=%s, date=%s ownerId=%s]",
               id, title, createdDate, ownerId);
    }
}
