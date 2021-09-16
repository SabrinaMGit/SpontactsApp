package cityact.app.chat.services;

import cityact.app.chat.database.UsersRepository;
import cityact.app.chat.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

   @Autowired
   UsersRepository userRepo;

   public UserDetails loadUserByUsername(String username) {
	 User dbUser =  (User) userRepo.findUserByUsername(username);
	 return new org.springframework.security.core.userdetails.User(username, dbUser.getPassword(), new ArrayList<>());
   }

}
