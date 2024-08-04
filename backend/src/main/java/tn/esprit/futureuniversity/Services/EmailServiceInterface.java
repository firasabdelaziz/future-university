package tn.esprit.futureuniversity.Services;

public interface EmailServiceInterface {
    void sendPasswordResetEmail(String email, String resetToken);
    void sendVerificationEmail(String email, String verificationToken);
}
