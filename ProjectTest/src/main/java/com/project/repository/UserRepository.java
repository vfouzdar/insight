package com.project.repository;




import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.project.entity.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public class UserRepository implements CrudRepository<User, Integer> {

	Logger logger = LoggerFactory.getLogger(UserRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
	public User userExist(User user){
		logger.info("Find user with  emailId=" + user.getEmailId());
		
		String[] args = {user.getEmailId()};
		
		user = jdbcTemplate.query("Select * from PROJECTTESTUSER where email_Id = :emailId", args, new ResultSetExtractor<User>() {
					@Override
					public User extractData(ResultSet rs) throws SQLException, DataAccessException {
						logger.info("Number of Users found =" + rs.getFetchSize());
						User user2 =null;
						while(rs.next()) {
							   Long uid = rs.getLong("Id");
							   String fname = rs.getString("First_Name");
							   String lname = rs.getString("Last_Name");
							   String address= rs.getString("Address");
							   String emailId= rs.getString("EMAIL_ID");
							   int age = rs.getInt("age");
						logger.info("User details are ---------------------" + fname + lname + address + emailId +age);	
							   user2 = new User();
							   user2.setAddress(address);
							   user2.setAge(age);
							   user2.setEmailId(emailId);
							   user2.setFirstName(fname);
							   user2.setId(uid);
							   user2.setLastName(lname);
							   
							}// end of while
						return user2;
					}// end of extractData
		});
		return user;
	}

	@Override
	public User save(User user) {
		
		String sqlFindMaxId = "SELECT MAX(id)+1 from PROJECTTESTUSER" ;
		
		Long nextId = jdbcTemplate.queryForObject(sqlFindMaxId, Long.class);
		
		if(nextId == null){
			nextId = 1L;
		}
		logger.info("\n\n\n Next Id=" + nextId);
		
		String[] args = {user.getAddress(), user.getAge().toString(), user.getEmailId(), user.getFirstName(), user.getLastName(), nextId.toString()};
		String insertSql = "INSERT INTO PROJECTTESTUSER (ADDRESS,AGE,EMAIL_ID,FIRST_NAME,LAST_NAME, ID) VALUES(?,?,?,?,?,?)";
		
		jdbcTemplate.update(insertSql, args);
		
		
		
		return user;
	}


	@Override
	public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Optional<User> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Iterable<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Iterable<User> findAllById(Iterable<Integer> ids) {
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
	public void delete(User entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAll(Iterable<? extends User> entities) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}


}

