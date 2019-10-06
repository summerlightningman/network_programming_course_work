/**
 * @author Baranov DA
 * @version 1.99
 */
package com.socialdima.Socialdima.repository;

import com.socialdima.Socialdima.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * interface for image
 * generates automatically
 */
public interface ImageRepository extends JpaRepository<Image, Integer> {
    Image findPathById(Integer id);
}
