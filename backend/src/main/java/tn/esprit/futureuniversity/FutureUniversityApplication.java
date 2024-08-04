package tn.esprit.futureuniversity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableScheduling
@EntityScan("tn.esprit.futureuniversity.Entities")

public class FutureUniversityApplication {

    public static void main(String[] args) {
        SpringApplication.run(FutureUniversityApplication.class, args);
    }

}
