package com.example.socialmediaapp.converters;

import com.example.socialmediaapp.dto.UserProfileDto;
import com.example.socialmediaapp.entities.User;
import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserProfileDtoConverter implements Converter<User, UserProfileDto> {
    @Override
    public @NonNull UserProfileDto convert(User source) {
        return new UserProfileDto(
                source.getFirstName(),
                source.getLastName(),
                source.getProfile().getBio(),
                source.getProfile().getDob(),
                source.getProfile().getGender()
        );
    }
}
