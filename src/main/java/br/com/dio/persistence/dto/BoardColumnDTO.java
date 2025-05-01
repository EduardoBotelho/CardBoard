package br.com.dio.persistence.dto;


public record BoardColumnDTO(Long id,
                             String name,
                             br.com.dio.persistence.entity.BoardColumnKindEnum kind,
                             int cardsAmount) {
}
