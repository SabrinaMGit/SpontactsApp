package cityact.app.chat.model;

import javax.persistence.*;

@Entity(name="push_notification")
public class PushNotification {

	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Integer id;

	    private Integer userId;

	    private String endpoint;

	    private String p256dh;

	    private String auth;

	    protected PushNotification() {}

	    public PushNotification(String endpoint, Integer userId, String p256dh, String auth) {
	       this.userId = userId;
	       this.auth = auth;
	       this.endpoint = endpoint;
	       this.p256dh = p256dh;
	    }

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
		}

		public String getEndpoint() {
			return endpoint;
		}

		public void setEndpoint(String endpoint) {
			this.endpoint = endpoint;
		}

		public String getP256dh() {
			return p256dh;
		}

		public void setP256dh(String p256dh) {
			this.p256dh = p256dh;
		}

		public String getAuth() {
			return auth;
		}

		public void setAuth(String auth) {
			this.auth = auth;
		}

		@Override
		public String toString() {
			return "PushNotification [id=" + id + ", userId=" + userId + ", endpoint=" + endpoint + ", p256dh=" + p256dh
					+ ", auth=" + auth + "]";
		}
}
