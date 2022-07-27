package account.repository;

import account.model.LogEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogEventRepository extends CrudRepository<LogEvent, Long> {
}