package com.project.repository;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.entity.Activity;

@Repository
public class ActivityRepository implements CrudRepository<Activity, Integer> {

	Logger logger = LoggerFactory.getLogger(ActivityRepository.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Activity save(Activity activity) {
		String sqlFindMaxId = "SELECT MAX(id)+1 from PROJECT_ACTIVITY";

		Long nextId = jdbcTemplate.queryForObject(sqlFindMaxId, Long.class);

		if (nextId == null) {
			nextId = 1L;
		}
		logger.info("\n\n\n Next Id=" + nextId);
		logger.info("Set new activity---------------------------------");

		Object[] args = { nextId, activity.getType(), activity.getCreateDate()};
		String insertSql = "INSERT INTO PROJECT_ACTIVITY (ID, TYPE, DATE_CREATED) VALUES(?,?,?)";

		jdbcTemplate.update(insertSql, args);

		return activity;
	
	}

	@Override
	public <S extends Activity> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Activity> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Activity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Activity> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Activity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Activity> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
