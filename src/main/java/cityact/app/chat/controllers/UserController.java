package cityact.app.chat.controllers;

import cityact.app.chat.advices.ControllerAdvice;
import cityact.app.chat.model.User;
import cityact.app.chat.model.UserDTO;
import cityact.app.chat.model.UserInfo;
import cityact.app.chat.model.ValidationResponse;
import cityact.app.chat.services.UserService;
import cityact.app.chat.services.encryption.EncryptionService;
import cityact.app.chat.services.validation.ValidationStrategy;
import cityact.app.chat.utils.JwtUtil;
import cityact.app.chat.utils.SystemMessages;
import cityact.app.chat.utils.SystemMessages.ValidationTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/user")
public class UserController {

    Logger log = Logger.getLogger(UserController.class.getName());

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
    private ValidationStrategy validationStrategy;

    @Autowired
    @Qualifier("md5")
    private EncryptionService md5Hashing;

	@ControllerAdvice
    @RequestMapping(value = "/auth", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> userAuth(@RequestBody UserInfo userInfo) throws Exception {
       ValidationResponse validationResponse = validationStrategy.provideValidation(ValidationTypes.USER_EXISTENCE, userInfo);
       if (!validationResponse.isSuccess()) {
           return new ResponseEntity<>(validationResponse.getErrorMessage(), HttpStatus.UNAUTHORIZED);
       }
       String hashedPassword = md5Hashing.encrypt(userInfo.getPassword(), false);
       jwtTokenUtil.authenticate(userInfo.getUsername(), hashedPassword);
       final UserDetails userDetails = userDetailsService.loadUserByUsername(userInfo.getUsername());
	   final String token = jwtTokenUtil.generateToken(userDetails);
	   User user = userService.searchForUserByUsername(userInfo.getUsername());
	   UserDTO userDTO = new UserDTO.UserBuilder()
		             .withUserId(user.getId())
		             .withUsername(userInfo.getUsername())
		             .withToken(token)
                     .withEmail(user.getEmail())
		             .withImage(user.getImage())
		             .build();
       return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @ControllerAdvice
    @RequestMapping(value = "/registerUser", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> register(@RequestBody UserInfo userInfo) throws Exception {
    	String hashedPassword = md5Hashing.encrypt(userInfo.getPassword(), false);
        ValidationResponse validationResponse = validationStrategy.provideValidation(ValidationTypes.REGISTRATION_CHECK, userInfo);
        if (validationResponse.isSuccess()) {
          log.info(SystemMessages.USER_NOT_EXIST);
          userService.createNewUser(userInfo, hashedPassword);
          return new ResponseEntity<>(SystemMessages.USER_CREATED, HttpStatus.OK);
        }
        return new ResponseEntity<>(validationResponse.getErrorMessage(), HttpStatus.FOUND);
    }

    @ControllerAdvice
    @GetMapping("/getUsers")
    public ResponseEntity<?> getUsersMatchingInput(@RequestParam("name") String inputName,
    		                                       @RequestHeader(value="Authorization") String authHeader) {
    	List<UserDTO> listOfUsers = new ArrayList<>();
        String username = jwtTokenUtil.getUsernameFromToken(authHeader.substring(7));
    	if (!inputName.isEmpty()) {
    		for (User user : userService.searchForUsersMatchingString(inputName)) {
        		if (!user.getUsername().equals(username)) {
                    listOfUsers.add(new UserDTO.UserBuilder()
                            .withUserId(user.getId())
                            .withUsername(user.getUsername())
                            .withImage(user.getImage())
                            .build());
                }
             }
    	}
        return new ResponseEntity<>(listOfUsers, HttpStatus.OK);
    }

    @ControllerAdvice
    @RequestMapping(value = "/updateProfileImage", method = RequestMethod.POST)
    public ResponseEntity<?> updateProfileImage(@RequestParam("imageFile") MultipartFile file,
    		                                    @RequestParam("username") String username) {
      ValidationResponse validationResponse = validationStrategy.provideValidation(ValidationTypes.USER_EXISTENCE, null, username);
      if (!validationResponse.isSuccess()) {
    	  return new ResponseEntity<>(validationResponse.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
      }
      if (file.isEmpty()) {
    	  return new ResponseEntity<>(SystemMessages.IMAGE_FILE_UPLOAD_ERROR, HttpStatus.NO_CONTENT);
      }
      if (file.getSize() > 64000) {
         return new ResponseEntity<>(SystemMessages.IMAGE_FILE_UPLOAD_SIZE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
      }
      try {
    	  User user = userService.updateProfileImage(username, file.getBytes());
    	  UserDTO userDTO = new UserDTO.UserBuilder()
		    			  .withUserId(user.getId())
		    			  .withUsername(user.getUsername())
		    			  .withImage(user.getImage())
		    			  .build();
          return new ResponseEntity<>(userDTO, HttpStatus.OK);
      } catch (IOException e) {
          log.warning(e.getMessage());
          return new ResponseEntity<>(SystemMessages.IMAGE_FILE_UPLOAD_EXCEPTION, HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }
}
