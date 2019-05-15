package com.uns.template.service.upload;

import com.uns.template.authorization.model.Account;
import com.uns.template.repository.authorization.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * created by kmluns
 **/
@Service
public class ImageUploadService {

    @Autowired
    Environment environment;

    @Autowired
    ServletContext servletContext;

    @Autowired
    private AccountRepository accountRepository;

    public boolean storeImageFile(Account account, MultipartFile file) {

        if (!fileValidation(file)) {
            return false;
        }

        try {
//            Organization organization = organizationRepository.findOne(id);
//
//            if (organization.getOrganizationImage() != null && !organization.getOrganizationImage().equals("default.ico")) {
//                deleteExistentImage(organization.getOrganizationImage());
//            }

//            BufferedImage image = ImageIO.read(file.getInputStream());
//            ImageIO.write(image, findExtension(file.getOriginalFilename()),
//                    new File(environment.getProperty("image-dir") + organization.getId()));


//            organization.setOrganizationImage(organization.getId());
//            organizationRepository.save(organization);



            BufferedImage image = ImageIO.read(file.getInputStream());
//            ImageIO.write(image, findExtension(file.getOriginalFilename()),
//                    new File(environment.getProperty("image-dir") + account.getId()));

            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(account, account.getPassword(), account.getAuthorities()));

            return true;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean fileValidation(MultipartFile file) {

        List<String> ext = new ArrayList<>();
        ext.add("jpg");
        ext.add("gif");
        ext.add("jpeg");
        ext.add("png");

        if (Long.parseLong(environment.getProperty("image-size-limit")) <= file.getSize()) {
            return false;
        }

        if (!ext.contains(findExtension(file.getOriginalFilename()))) {
            return false;
        }

        return true;
    }

    private void deleteExistentImage(String image) {
        File file = new File(environment.getProperty("image-dir") + image);
        file.delete();
    }

    private String findExtension(String name) {
        String[] extension = name.split("\\.");
        return extension[extension.length-2].toString();
    }
}
