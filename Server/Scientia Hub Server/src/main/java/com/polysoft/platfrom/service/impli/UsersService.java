package com.polysoft.platfrom.service.impli;

import com.polysoft.platfrom.entity.ArticlesTags;
import com.polysoft.platfrom.entity.Interests;
import com.polysoft.platfrom.entity.Users;
import com.polysoft.platfrom.exception.TagNotFoundException;
import com.polysoft.platfrom.exception.UserAlreadyExistException;
import com.polysoft.platfrom.exception.UserNotFoundException;
import com.polysoft.platfrom.repository.ArticlesTagsRepository;
import com.polysoft.platfrom.repository.InterestsRepository;
import com.polysoft.platfrom.repository.UsersRepository;
import com.polysoft.platfrom.service.IUsers;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersService implements IUsers {

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private InterestsRepository interestsRepository;

    @Autowired
    private ArticlesTagsRepository articlesTagsRepository;



    @Override
    public Users registerUser(Users users) throws UserAlreadyExistException {
        return userRepository.save(users);
    }

    @Override
    public Users updateUser(Users users){ return userRepository.save(users);}

    @Override
    public void deleteUser(Users users){ userRepository.delete(users);}

    @Override
    public Users getUserByUserName(String userName) throws UserNotFoundException {
        Optional<Users> user = userRepository.findByUserName(userName);

        if (user.isEmpty()){
            throw new UserNotFoundException("Users with username :" + userName + " does not exists");
        }
        return user.get();
    }


    @Override
    public void addNewTag(Long userId,String Tag) throws UserNotFoundException, TagNotFoundException {
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        Interests tag = interestsRepository.findByTag(Tag)
                .orElseThrow(() -> new TagNotFoundException(Tag));

        ArticlesTags newUserTag = new ArticlesTags(user, tag);
        articlesTagsRepository.save(newUserTag);

    }

}
