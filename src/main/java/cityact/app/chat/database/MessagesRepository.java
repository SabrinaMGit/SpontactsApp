
package cityact.app.chat.database;

import cityact.app.chat.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessagesRepository extends JpaRepository<Message,Integer> {

  Message findAllById(Integer id);
  List<Message> findByPostedBy(Integer posted_by);
  List<Message> findByConversationId(Integer conversation_id);
}
