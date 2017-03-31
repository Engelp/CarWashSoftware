package bg.car_wash.areas.user.serviceImpl;

import bg.car_wash.areas.user.exception.UserNotFoundException;
import bg.car_wash.configurations.Errors;
import bg.car_wash.areas.user.entity.User;
import bg.car_wash.areas.user.models.bindingModels.user.UserLoginBindingModel;
import bg.car_wash.areas.user.models.viewModels.user.UserSessionViewModel;
import bg.car_wash.areas.user.repositories.UserRepository;
import bg.car_wash.areas.user.services.UserService;
import bg.car_wash.utils.parser.interfaces.ModelParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelParser modelParser;

	@Override
	public void createUser(User user) {
		this.userRepository.save(user);
	}

	@Override
	public UserSessionViewModel getUserByFullNameAndPassword(UserLoginBindingModel userLoginBindingModel) {
		User user = this.modelParser.convert(userLoginBindingModel, User.class);
		User loggedUser = this.userRepository.findUserByEmailAndPassword(user.getEmail(), user.getPassword());

		return this.modelParser.convert(loggedUser, UserSessionViewModel.class);
	}

	@Override
	public List<User> findAllUsers() {
		List<User> users = this.userRepository.findAll();
		return users;
	}

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepository.findOneByUsername(username);
		if (user == null) {
			throw  new UserNotFoundException();
//			throw new UsernameNotFoundException(Errors.INVALID_CREDENTIALS);
		}

		return user;
	}
}
