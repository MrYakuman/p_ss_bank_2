package com.bank.publicinfo.controller;

import com.bank.publicinfo.dto.AtmDTO;
import com.bank.publicinfo.entity.Atm;
import com.bank.publicinfo.exception.AtmNotCreatedException;
import com.bank.publicinfo.exception.AtmNotFoundException;
import com.bank.publicinfo.exception.AtmNotUpdatedException;
import com.bank.publicinfo.mapper.AtmMapper;
import com.bank.publicinfo.service.AtmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Контроллер банкомата. Принимает стандартные запросы "get/all", "get/id", "post", "put", "delete/id"
 * Обрабатывает исключения связанные с переданным id и ошибками передачи данных в валидируемых полях.
 */
@RestController
@RequestMapping("/atm")
@Slf4j
public class AtmController {

    private AtmService atmService;

    private AtmMapper atmMapper;

    public AtmController(AtmService atmService, AtmMapper atmMapper) {
        this.atmService = atmService;
        this.atmMapper = atmMapper;
    }

    /**
     * Метод получает запрос на получение всех банкоматов.
     * Достает из БД список сущностей.
     * Конвертирует список сущностей в список DTO.
     * Возвращает ответ клиенту в виде responseEntity
     * @return
     */
    @GetMapping()
    public ResponseEntity<List<AtmDTO>> getAllAtm() {
        log.info("Пришел запрос на получение данных о всех банкоматах");
        return ResponseEntity.ok(atmService.getAllAtm().stream()
                .map(a -> atmMapper.convertToAtmDTO(a)).collect(Collectors.toList()));
    }

    /**
     * Метод получает запрос на данные банкомата по его id.
     * Проверяет наличие в БД.
     * Возвращает responseEntity или сообщение об ошибке.
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<AtmDTO> getAtmById(@PathVariable("id") long id) {
        log.info("Пришел запрос на получение данных о банкомате по id " +id);
        return ResponseEntity.ok(atmMapper.convertToAtmDTO(atmService.getAtmById(id)));
    }

    /**
     * Метод получает запрос на создание нового банкомата.
     * Валидирует поля
     * Если поля не проходят валидацию, формирует и отправляет сообщение об ошибке.
     * Если поля проходят валидацию, создает новую сущность в БД,
     * Отправляет клиенту responseEntity с данными созданной сущности.
     * @param atmDTO
     * @param bindingResult
     * @return
     */
    @PostMapping
    public ResponseEntity<AtmDTO> postAtm(@RequestBody @Valid AtmDTO atmDTO, BindingResult bindingResult) {
        log.info("Пришел пост-запрос на создание новой сущности банкомат");
        if(bindingResult.hasErrors()) {
            StringBuilder stringBuilder = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError error : errors) {
                stringBuilder.append(error.getField()).append(" - ")
                        .append(error.getDefaultMessage()).append(";");
            }
            log.error("Поля пост-запроса не прошли валидацию");
            throw new AtmNotCreatedException(stringBuilder.toString());
        }
        log.info("Поля пост-запроса прошли валидацию");
        return ResponseEntity.ok(
                    atmMapper.convertToAtmDTO(
                            atmService.save(
                                    atmMapper.convertToAtm(atmDTO)
                            )
                    )
        );
    }


    /**
     * Метод получает запрос на изменение данных банкомата по его id.
     * Валидирует поля
     * Если поля не проходят валидацию, формирует и отправляет сообщение об ошибке.
     * Если поля проходят валидацию, изменяет данные сущности в БД,
     * Отправляет клиенту responseEntity с данными сущности после ее изменения.
     * @param atmDTO
     * @param bindingResult
     * @return
     */
    @PutMapping
    public ResponseEntity<AtmDTO> putAtm(@RequestBody  @Valid AtmDTO atmDTO, BindingResult bindingResult) {
        log.info("Пришел пут-запрос на изменение сущности банкомат");
        if(bindingResult.hasErrors()) {
            StringBuilder stringBuilder = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError error : errors) {
                stringBuilder.append(error.getField()).append(" - ")
                        .append(error.getDefaultMessage()).append(";");
            }
            log.error("Поля пут-запроса не прошли валидацию");
            throw new AtmNotUpdatedException(stringBuilder.toString());
        }
        log.info("Поля пут-запроса прошли валидацию");

        return ResponseEntity.ok(
                atmMapper.convertToAtmDTO(
                        atmService.save(
                                atmMapper.convertToAtm(atmDTO)
                        )
                )
        );
    }
    /**
     * Метод получает запрос на удаление данных банкомата по его id.
     * Проверяет наличие в БД банкомата с переданным id.
     * Возвращает responseEntity или сообщение об ошибке.
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<AtmDTO> deleteAtmById(@PathVariable("id") long id) {
        log.info("Пришел запрос на удаление сущности банкомат по id " + id);
        Atm del = atmService.getAtmById(id);
        if (del == null) {
            log.error("В БД отсудствует сущность с id" + id);
            throw new AtmNotFoundException("Atm with this id wasn't found");
        }
        atmService.deleteAtmById(id);
        log.info("Удаление прошло успешно");
        return ResponseEntity.ok(atmMapper.convertToAtmDTO(del));
    }
}
