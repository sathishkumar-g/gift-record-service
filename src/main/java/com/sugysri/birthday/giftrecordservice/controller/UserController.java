/*
 * package com.sugysri.birthday.giftrecordservice.controller;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.CrossOrigin; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.sugysri.birthday.giftrecordservice.models.UserDTO; import
 * com.sugysri.birthday.giftrecordservice.service.UserService;
 * 
 * @RestController
 * 
 * @CrossOrigin(origins = "*",allowedHeaders = "*")
 * 
 * @RequestMapping("/user") public class UserController {
 * 
 * @Autowired private UserService userService;
 * 
 * @PostMapping(path="/authenticate", consumes = "application/json", produces =
 * "application/json") public UserDTO getuserRecord(@RequestBody UserDTO
 * userDetails) { return userService.getUserRecord(userDetails); }
 * 
 * @PostMapping(path = "/register", consumes = "application/json", produces =
 * "application/json") public UserDTO addGiftRecord(@RequestBody UserDTO user) {
 * return userService.addUserRecord(user); } }
 */