package com.Kstore.demo.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Kstore.demo.pojo.product.Platform;

public interface PlatformRepo extends JpaRepository<Platform, Integer> {

	List<Platform> findByNameContaining(String name);

}
