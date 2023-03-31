package com.bank.profile.controller;

import com.bank.profile.dto.ProfileDTO;
import com.bank.profile.entity.Profile;
import com.bank.profile.entity.audit.Audit;
import com.bank.profile.entity.audit.OperationType;
import com.bank.profile.exception.ArgumentNotValidException;
import com.bank.profile.mappers.ProfileMapper;
import com.bank.profile.service.serviceInterface.AuditService;
import com.bank.profile.service.serviceInterface.ProfileService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.core.annotation.Timed;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@Slf4j
@RequestMapping("/profiles")
@Tag(name = "ProfileController", description = "REST контролер для сущности Profile (банковский профиль), а так же связанных с Profile сущностями: Passport (паспорт) и ActualRegistration (адрес регистрации по паспорту).")
public class ProfileController {
    private final ProfileService profileService;
    private final AuditService auditService;
    private final ObjectMapper objectMapper;

    @Autowired
    public ProfileController(ProfileService profileService, AuditService auditService, ObjectMapper objectMapper) {
        this.profileService = profileService;
        this.auditService = auditService;
        this.objectMapper = objectMapper;
    }

    @Timed("gettingAllProfiles")
    @GetMapping("/")
    @Operation(
            summary = "Получение всех объектов Profile в формате ProfileDTO.",
            description = "Получение всех объектов ProfileDTO, в том числе связанных сущностей PassportDTO и ActualRegistrationDTO. В методе через stream.api каждый объект Profile приводится к ProfileDTO."
    )
    public ResponseEntity<List<ProfileDTO>> getAllProfile() {
        List<ProfileDTO> allProfileDTO;

        allProfileDTO = profileService
                .getAllProfile()
                .stream()
                .map(ProfileMapper.INSTANCE::toProfileDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(allProfileDTO, HttpStatus.FOUND);
    }

    @Timed
    @GetMapping("/{id}")
    @Operation(
            summary = "Получение конкретного объекта Profile в формате ProfileDTO, через его id.",
            description = "Получение объекта ProfileDTO, в том числе связанных сущностей PassportDTO и ActualRegistrationDTO, через profile.id."
    )
    public ResponseEntity<ProfileDTO> getProfile(@PathVariable Long id) {
        ProfileDTO profileDTO = ProfileMapper
                .INSTANCE
                .toProfileDTO(profileService.findProfileById(id));

        return new ResponseEntity<>(profileDTO, HttpStatus.FOUND);
    }

    @Timed
    @PostMapping("/")
    @Operation(
            summary = "Сохранение в бд нового объекта Profile.",
            description = "Сохранение в бд нового объекта Profile, а так же создание и сохранение объекта Audit."
    )
    public ResponseEntity<ProfileDTO> createProfile(@RequestBody @Valid ProfileDTO profileDTO,
                                                    BindingResult bindingResult) throws JsonProcessingException {
        if (bindingResult.hasErrors()) {
            throw new ArgumentNotValidException(bindingResult);
        }

        Profile profile = ProfileMapper.INSTANCE.toProfile(profileDTO);


        Audit audit = new Audit();
        audit.setEntityType(Profile.class.getName());
        audit.setOperationType(OperationType.SAVE_ENTITY.toString());
        audit.setNewEntityJson(null);
        audit.setEntityJson(objectMapper.writeValueAsString(profile));

        profileService.saveProfile(profile);

        auditService.saveAudit(audit);

        return new ResponseEntity<>(profileDTO, HttpStatus.CREATED);
    }

    @Timed
    @PutMapping("/{id}")
    @Operation(
            summary = "Обновление существующего объекта Profile.",
            description = "Обновление существующего объекта Profile, а так же создание и сохранение объекта Audit."
    )
    public ResponseEntity<ProfileDTO> editProfile(@PathVariable Long id,
                                                  @RequestBody @Valid ProfileDTO profileDTO,
                                                  BindingResult bindingResult) throws JsonProcessingException {
        if (bindingResult.hasErrors()) {
            throw new ArgumentNotValidException(bindingResult);
        }

        Profile profile = ProfileMapper.INSTANCE.toProfile(profileDTO);
        profile.setId(id);

        //        Создаем объект audit;
        Audit audit = new Audit();

        audit.setEntityType(Profile.class.getName());
        audit.setOperationType(OperationType.UPDATE_ENTITY.toString());

        //Присваиваем audit текущую версию profile, через запрос к бд;
        audit.setEntityJson(
                objectMapper.writeValueAsString(
                        profileService.findProfileById(id)));

        //Присваиваем audit обновленную версию profile, полученную в метод editProfile;
        audit.setNewEntityJson(
                objectMapper.writeValueAsString(profile));


        profileService.editProfile(id, profile);

        auditService.saveAudit(audit);

        return new ResponseEntity<>(profileDTO, HttpStatus.OK);
    }

    @Timed
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Удаление существующего объекта Profile.",
            description = "Удаление существующего объекта Profile, а так же создание и сохранение объекта Audit."
    )
    public ResponseEntity<HttpStatus> deleteProfile(@PathVariable Long id) {

        Audit audit = new Audit();
        audit.setEntityType(Profile.class.getName());
        audit.setOperationType(OperationType.DELETE_ENTITY.toString());
        audit.setNewEntityJson("new entity json");
        audit.setEntityJson("entity json");

        profileService.deleteProfile(id);
        auditService.saveAudit(audit);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
