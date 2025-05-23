package br.com.dio.service;

import br.com.dio.persistence.dao.BoardColumnDAO;
import br.com.dio.persistence.dao.BoardDao;
import br.com.dio.persistence.entity.BoardEntity;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;


@RequiredArgsConstructor
public class BoardsService {

    private final Connection connection;

    public BoardEntity insert(final BoardEntity entity) throws SQLException {
        var dao = new BoardDao(connection);
        var boardColumnDAO = new BoardColumnDAO(connection);
        try{
            dao.insert(entity);
            var columns = entity.getBoardColumns().stream().map(c -> {
                c.setBoard(entity);
                return c;
            }).toList();
            for (var column :  columns){
                boardColumnDAO.insert(column);
            }
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
        return entity;
    }

    public boolean delete(final Long id) throws SQLException {
        var dao = new BoardDao(connection);
        try{
            if (!dao.exists(id)) {
                return false;
            }
            dao.delete(id);
            connection.commit();
            return true;
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
    }

}

