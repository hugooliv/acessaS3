package github.com.hugooliv.demo.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
@Slf4j
public class UploadS3Job {

    @Value("${file.path}")
    private String path;

    @Value("${file.filename}")
    private String nomeArquivo;

    @Value("${aws.bucketName}")
    private String bucketName;

    @Autowired
    private AmazonS3 amazonS3;

    public void process(String[] args) throws Exception {

        log.info("Inicio...");

        log.info("Uploading ...");

        amazonS3.putObject(new PutObjectRequest(bucketName, nomeArquivo,
                new File(System.getProperty("user.dir") + File.separator + path + File.separator + nomeArquivo)));

        log.info("Fim do upload ...");

    }

}
