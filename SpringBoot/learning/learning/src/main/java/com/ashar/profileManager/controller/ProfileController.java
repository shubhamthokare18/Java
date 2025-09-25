package com.ashar.profileManager.controller;

import com.ashar.profileManager.dto.ProfileDto;
import com.ashar.profileManager.entity.Profile;
import com.ashar.profileManager.service.ProfileService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/profile-manager")
public class ProfileController {

    private final ProfileService profileService;

    //constructor Injection
    ProfileController(ProfileService profileService){
        this.profileService = profileService;
    }

    @Operation(description = "It's returning Prifile Object",summary = "We are adding Profile Objects to database")
    @PostMapping("/profile")
    public ResponseEntity<Profile> addProfile(@RequestBody ProfileDto profileDto){
        log.info("creating profile");
        return profileService.addProfile(profileDto);
    }

    @PostMapping("/profile/all")
    public ResponseEntity<List<Profile>> addAllProfiles(@RequestBody List<ProfileDto> profileDtos){
        log.info("creating all profiles");
        return profileService.addAllProfiles(profileDtos);
    }

    @GetMapping("/profile/all")
    public ResponseEntity<List<Profile>> getAllProfiles(){
        log.info("getting all profiles");
        return profileService.getAllProfiles();
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable int id){
        log.info("getting profile by id : {}",id);
        return profileService.getProfileById(id);
    }

    @GetMapping("/profile/name/{name}")
    public ResponseEntity<Profile> getProfileByUsername(@PathVariable String name){
        log.info("getting profile by name : {}",name);
        return profileService.getProfileByUsername(name);
    }


    @PutMapping("/profile/{id}")
    public ResponseEntity<Profile> updateProfileById(@PathVariable int id, @RequestBody Profile profile){
        return profileService.updateProfileById(id,profile);
    }

    @PutMapping("/profile")
    public ResponseEntity<Integer> updateUsernameAndPassword(@RequestParam int id, @RequestParam String username, @RequestParam String password){
        return profileService.updateUsernameAndPasswordById(id,username,password);
    }

    @DeleteMapping("/profile/{id}")
    public ResponseEntity<Profile> deleteProfileById(@PathVariable("id") int id){
        return profileService.deleteProfileById(id);
    }
}
