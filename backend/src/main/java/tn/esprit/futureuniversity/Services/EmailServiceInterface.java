package tn.esprit.futureuniversity.Services;

import tn.esprit.futureuniversity.Entities.Course;

public interface EmailServiceInterface {
    void sendPasswordResetEmail(String email, String resetToken);
    void sendVerificationEmail(String email, String verificationToken);

}
