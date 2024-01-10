package exercise.service;

import exercise.model.User;
import exercise.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    // BEGIN
    public Mono<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    public Mono<User> create(User data) {
        return userRepository.save(data);
    }

    public Mono<User> update(Long userId, User data) {
        return userRepository.findById(userId)
                .flatMap(user -> {
                    user.setEmail(data.getEmail());
                    user.setFirstName(data.getFirstName());
                    user.setLastName(data.getLastName());
                    return userRepository.save(user);
                });
    }

    public Mono<Void> delete(Long userId) {
        return userRepository.deleteById(userId);
    }
    // END
}
