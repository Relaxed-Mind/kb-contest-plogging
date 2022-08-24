package my.plogging.Controller;


import lombok.RequiredArgsConstructor;
import my.plogging.DTO.*;
import my.plogging.Service.UserService;
import my.plogging.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/join")
    public Map userJoin(@RequestBody User user){
        return userService.join(user);
    } //임시 -> DTO로 받기

//    @GetMapping("/{userId}/address")
//    public UserFindAddressResponseDTO findUserAddress(@PathVariable Long userId){
//        return userService.findUserAddress(userId);
//    }

    @GetMapping("/{userId}/profiles")
    public UserProfileResponseDTO getProfile(@PathVariable Long userId){
        return userService.getUserProfile(userId);
    }

    @PostMapping("/member")
    public Map userSave(@RequestBody UserSaveRequestDTO dto){
        return userService.saveUser(dto);
    }

    @GetMapping("/member")
    public Map userCheck(@RequestParam Long userId) {
        return userService.checkUser(userId);
    }

    @GetMapping("/signup")
    public Map nickNameCheck(@RequestParam String nickName) {
        return userService.checkNickName(nickName);
    }
}
