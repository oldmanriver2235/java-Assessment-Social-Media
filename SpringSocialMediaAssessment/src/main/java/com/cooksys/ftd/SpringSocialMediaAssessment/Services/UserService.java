package com.cooksys.ftd.SpringSocialMediaAssessment.Services;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.cooksys.ftd.SpringSocialMediaAssessment.Entity.Profile;
import com.cooksys.ftd.SpringSocialMediaAssessment.Entity.Tweet;
import com.cooksys.ftd.SpringSocialMediaAssessment.Entity.User;
import com.cooksys.ftd.SpringSocialMediaAssessment.Entity.UserCredentials;
import com.cooksys.ftd.SpringSocialMediaAssessment.Exceptions.PasswordMismatch;
import com.cooksys.ftd.SpringSocialMediaAssessment.Exceptions.UnableToAddUser;
import com.cooksys.ftd.SpringSocialMediaAssessment.Exceptions.UserNotFound;
import com.cooksys.ftd.SpringSocialMediaAssessment.Repositories.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return this.userRepository.findAll();

	}

	public User addUsers(User user) throws UnableToAddUser {
		return this.userRepository.save(user);
	}

	public User getUser(String username) throws UserNotFound {
		User user = userRepository.findUserByUserCredentialsUsername(username);
		if (user == null) {
			throw new UserNotFound();
		} else {
			return user;
		}
	}

	public User patchUsers(String username, UserCredentials userCredentials, Profile updatedProfile)
			throws UserNotFound, PasswordMismatch {
		if (!username.equals(userCredentials.getUsername())) {
			User userToUpdate = userRepository.findUserByUserCredentialsUsername(username);
			if (userToUpdate.getUserCredentials().getPassword().equals(userCredentials.getPassword())) {
				userToUpdate.setProfile(updatedProfile);
				return this.userRepository.save(userToUpdate);
			} else {
				throw new PasswordMismatch();
			}
		}
		throw new UserNotFound();
	}

	public User deleteUsers(String username, User user) throws UserNotFound {
		User deleteMe = userRepository.findByUserCredentialsUsername(username);
		if (deleteMe == null) {
			throw new UserNotFound();
		} else if (!deleteMe.getUserCredentials().getUsername().equals(user.getUserCredentials().getUsername())
				|| !deleteMe.getUserCredentials().getPassword().equals(user.getUserCredentials().getPassword())) {
			throw new UserNotFound();
		} else {
			deleteMe.setActive(false);
			return deleteMe;
		}

	}

	public void followUsers(String username, UserCredentials userCredentials) throws PasswordMismatch {
		User followRequestor = this.userRepository.findByUserCredentialsUsername(userCredentials.getUsername());
		if (followRequestor.getUserCredentials().getPassword().equals(userCredentials.getPassword())) {
			User followAcceptor = this.userRepository.findByUserCredentialsUsername(username);
			followAcceptor.getFollowers().add(followRequestor);
			followRequestor.getFollowing().add(followAcceptor);
			this.userRepository.save(followAcceptor);
			this.userRepository.save(followRequestor);
		} else {
			throw new PasswordMismatch();
		}
	}

	public void unfollowUsers(String username, UserCredentials userCredentials) throws PasswordMismatch {
		User unfollowRequestor = this.userRepository.findByUserCredentialsUsername(userCredentials.getUsername());
		if (unfollowRequestor.getUserCredentials().getPassword().equals(userCredentials.getPassword())) {
			User unfollowedUser = this.userRepository.findUserByUserCredentialsUsername(username);
			unfollowedUser.getFollowers().remove(unfollowRequestor);
			unfollowRequestor.getFollowing().remove(unfollowedUser);
			this.userRepository.save(unfollowRequestor);
			this.userRepository.save(unfollowedUser);

		} else {
			throw new PasswordMismatch();
		}

	}

	public Set<Tweet> getTweets(String username, User user) throws UserNotFound {
		User tweetGetter = this.userRepository.findByUserCredentialsUsername(username);
		if (!tweetGetter.getUserCredentials().getUsername().equals(user.getUserCredentials().getUsername())
				|| user.isActive() == false) {
			throw new UserNotFound();
		} else {
			return tweetGetter.getTweets();
		}

	}

	public Set<Tweet> getMentionedTweets(String username, User user) throws UserNotFound {
		User mentionGetter = this.userRepository.findByUserCredentialsUsername(username);
		if (!mentionGetter.getUserCredentials().getUsername().equals(user.getUserCredentials().getUsername())
				|| user.isActive() == false) {
			throw new UserNotFound();
		} else {
			return mentionGetter.getMentions();
		}
	}

	public Set<User> getUserFollowers(String username, User user) throws UserNotFound {
		User followersGetter = this.userRepository.findByUserCredentialsUsername(username);
		if (!followersGetter.getUserCredentials().getUsername().equals(user.getUserCredentials().getUsername())
				|| user.isActive() == false) {
			throw new UserNotFound();
		} else {
			return followersGetter.getFollowers();
		}
	}

	public Set<User> getUserFollowed(String username, User user) throws UserNotFound {
		User followedGetter = this.userRepository.findByUserCredentialsUsername(username);
		if (!followedGetter.getUserCredentials().getUsername().equals(user.getUserCredentials().getUsername())
				|| user.isActive() == false) {
			throw new UserNotFound();
		} else {
			return followedGetter.getFollowing();
		}
	}

	public boolean usernameExists(String username, User user) {
		User doIExist = userRepository.findUserByUserCredentialsUsername(username);
		if (doIExist.getUserCredentials().getUsername().equals(user.getUserCredentials().getUsername())) {
			return true;
		} else {
			return false;
		}

	}

}
