package br.com.dio.persistence.dao;

import lombok.AllArgsConstructor;


import java.sql.Connection;
import java.sql.SQLException;
import java.time.OffsetDateTime;
import static br.com.dio.persistence.Converter.OffSetDateTimeConverter.toTimeStamp;

@AllArgsConstructor
public class BlockDAO {
    private final Connection connection;

    public void block(final Long cardid, final String reason) throws SQLException{
        var sql = "INSERT INTO BLOCKS (blocked_at,blocked_reason, card_id) VALUES (?,?,?,?);";
        try(var statement = connection.prepareStatement(sql)){
            var i = 1;
            statement.setTimestamp(i ++,toTimeStamp(OffsetDateTime.now()));
            statement.setString(i ++, reason);
            statement.setLong(i, cardid);
            statement.executeUpdate();
        }
    }

    public void unblock(final Long cardid, final String reason) throws SQLException{
        var sql = "UPDATE BLOCKS SET unblocked_at = ?, unblock_reason = ? WHERE card_id = ? AND unblock_reason IS NULL;";
        try(var statement = connection.prepareStatement(sql)){
            var i = 1;
            statement.setTimestamp(i ++,toTimeStamp(OffsetDateTime.now()));
            statement.setString(i ++, reason);
            statement.setLong(i, cardid);
            statement.executeUpdate();
        }
    }
}
