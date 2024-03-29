package cityact.app.chat.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User implements Validatable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    private String email;

    @Lob
    private byte[] image;

    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
   /* @JoinTable(
        name = "conv_user",
        joinColumns = { @JoinColumn(name = "user_id") },
        inverseJoinColumns = { @JoinColumn(name = "conversation_id") }
    )*/
    Set<Conversation> conversations = new HashSet<>();

    protected User() {}

    public User(String username, String password, String email) {
        this.username= username;
        this.password= password;
        this.email = email;
    }

    public Set<Conversation> getConversations() {
        return conversations;
    }

    public Integer getId() {
      return id;
    }

    public String getEmail() {
      return email;
    }

    public String getPassword() {
      return password;
    }

    public String getUsername() {
      return username;
    }

    public void setConversations(Set<Conversation> conversations) {
        this.conversations = conversations;
      }

    public void setId(Integer id) {
      this.id = id;
    }

    public void setPassword(String password) {
      this.password = password;
    }

    public void setUsername(String username) {
      this.username = username;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

    @Override
    public String toString() {
         return String.format(
                "User[id=%d, username='%s', password='%s', email=%s, image=%s]",
               id, username, password, email, image);
    }
}
