package dev.alfrendosilalahi.spring.data.jpa.projections.user;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<UserDTO> userDTOList = userRepository.findAllBy().stream()
                .map(userProjections -> UserDTO.builder()
                        .username(userProjections.getUsername())
                        .email(userProjections.getEmail())
                        .address(userProjections.getAddress())
                        .build())
                .toList();
        return ResponseEntity.ok(userDTOList);
    }

}
