package com.project.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.h2.engine.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.project.entity.Activity;
import com.project.entity.ActivityType;

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

		Object[] args = { nextId, activity.getActivityType().toString(), activity.getCreateDate(),
				activity.getUserId() };
		String insertSql = "INSERT INTO PROJECT_ACTIVITY (ID, TYPE, DATE_CREATED, USER_ID) VALUES(?,?,?,?)";

		jdbcTemplate.update(insertSql, args);

		return activity;

	}

	public List<Activity> findAllByUserId(Activity activity) {

		logger.info("Find Activity for user-------------------------");
		List<Activity> activityList = new LinkedList<>();

		String sqlFindActivity = "SELECT * from PROJECT_ACTIVITY where USER_ID = ? order by DATE_CREATED desc";
		Object[] args = { activity.getUserId() };

		jdbcTemplate.query(sqlFindActivity, args, new ResultSetExtractor<List<Activity>>() {

			@Override
			public List<Activity> extractData(ResultSet rs) throws SQLException, DataAccessException {
				logger.info("overriding result set ----------------------------");

				Activity activityResult = null;

				while (rs.next()) {
					Long uid = rs.getLong("Id");
					String type = rs.getString("TYPE");
					Date dateCreated = rs.getTimestamp("DATE_CREATED");

					activityResult = new Activity();
					activityResult.setId(uid);
					logger.info((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(dateCreated));
					activityResult.setCreateDate(dateCreated);
					activityResult.setActivityType(ActivityType.valueOf(type));

					activityList.add(activityResult);
					//return activityList;
				}

				return activityList;
			}
		});

		return activityList;
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
