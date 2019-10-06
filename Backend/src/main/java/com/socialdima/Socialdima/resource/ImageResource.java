/**
 * @author Baranov DA
 * @version 1.99
 */
package com.socialdima.Socialdima.resource;


import com.socialdima.Socialdima.model.Image;
import com.socialdima.Socialdima.repository.ImageRepository;
import com.socialdima.Socialdima.repository.UserRepository;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Controller for DB-table image
 */
@RestController
@RequestMapping(value = "/image")
public class ImageResource {
    @Autowired
    ImageRepository imageRepository;

    /**
     * if path = "/image"
     *
     * @return data of all images
     */
    @GetMapping
    public List<Image> getAll() {
        return imageRepository.findAll();
    }

    /**
     * if path = "/findLast"
     *
     * @return last Id of images
     */
    @GetMapping("/findlast")
    public Integer getLastId() {
        List<Image> imgs = imageRepository.findAll();
        Image image = imgs.get(imgs.size() - 1);
        return image.getId();
    }

    /**
     * if path = "image/{id}"
     *
     * @param id - id of message
     * @return data of image with this id
     */
    @GetMapping("/{id}")
    public @ResponseBody
    ResponseEntity getAvatar(@PathVariable Integer id) throws IOException {

        ResponseEntity respEntity = null;
        String name = imageRepository.findPathById(id).getPath();
        byte[] reportBytes = null;
        File result = new File("images/" + name);

        if (result.exists()) {
            InputStream inputStream = new FileInputStream("images/" + name);
            String type = result.toURL().openConnection().guessContentTypeFromName(name);

            byte[] out = IOUtils.toByteArray(inputStream);

            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.add("content-disposition", "attachment; filename=" + name);
            responseHeaders.add("Content-Type", type);

            respEntity = new ResponseEntity(out, responseHeaders, HttpStatus.OK);
        } else {
            respEntity = new ResponseEntity("File Not Found", HttpStatus.OK);
        }
        return respEntity;
    }


    /**
     * if path = "image/delete/{id}" - deletes image with this is
     *
     * @param id - id image
     */
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        imageRepository.deleteById(id);
    }

    /**
     * if path = "image/add" - add image
     *
     * @param image - object with image data
     * @return data of all images
     */
    @PostMapping("/add")
    public List<Image> add(@RequestBody final Image image) {
        imageRepository.save(image);
        return imageRepository.findAll();
    }

    @PostMapping("/upload")
    @CrossOrigin(origins = "http://localhost:4200")
    public @ResponseBody
    String provideUploadInfo(@RequestParam("name") String name,
                             @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File("images/" + name)));
                stream.write(bytes);
                stream.close();
                Calendar calendar = new GregorianCalendar();

                Image image = new Image();
                image.setPath(name);
                image.setPublished(calendar);
                this.imageRepository.save(image);

                return name + " загружен успешно!";
            } catch (Exception e) {
                return name + "не загружен, так как " + e.getMessage();
            }
        } else {
            return "Не удалось загрузить " + name + " потому что файл пустой.";
        }
    }
}
