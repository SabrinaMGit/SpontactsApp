package cityact.app.chat.database;

import cityact.app.chat.model.Conversation;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ConversationsRepository extends JpaRepository<Conversation,Integer> {

	Conversation findAllById(Integer id);
}
