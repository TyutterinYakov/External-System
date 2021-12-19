package register.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import register.domain.MarriageCertificate;

@Repository
public interface MarriageDao extends JpaRepository<MarriageCertificate, Long>{
	List<MarriageCertificate> findByNumber(String number);
	
	List<MarriageCertificate> findByNum(@Param("number") String number);
	@Query("select mc from MarriageCertificate mc where mc.number = :number")
	List<MarriageCertificate> findSomething(@Param("number") String number);
}
