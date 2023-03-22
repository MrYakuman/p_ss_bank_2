package com.bank.history.Mapper;

import com.bank.history.DTO.HistoryDTO;
import com.bank.history.Entity.History;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HistoryMapper {
    HistoryMapper INSTANCE = Mappers.getMapper(HistoryMapper.class);

    HistoryDTO toDTO(History history);
}
