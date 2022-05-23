public class PasswordServiceEncryption
{
    private PasswordHasher passwordHasher;

    public PasswordServiceEncryption(PasswordHasher passwordHasher)
    {
        this.passwordHasher = passwordHasher;
    }

    void hashPassword(String password)
    {
        System.out.println(this.passwordHasher.hashPassword(password));
    }

    private Decryptable decryptable;

    public PasswordServiceEncryption(Decryptable decryptable)
    {
        this.decryptable = decryptable;
    }
    void decodePasswordFromHash(String hash){
        System.out.println(this.decryptable.decodePasswordFromHash(hash));
    }

    public static void main(String[] args) {
        //PasswordHasher passwordHasher = new Base64Hasher();
        //PasswordService passwordService = new PasswordService(passwordHasher);
        //passwordService.hashPassword("abcdde");


        //Hashing
        PasswordHasher passwordHasher = new MD5Hasher();
        PasswordServiceEncryption passwordService = new PasswordServiceEncryption(passwordHasher);
        passwordService.hashPassword("Nirupamvas");


        //Decryption
        Decryptable decryptable = new Base64Hasher();
        PasswordServiceEncryption passwordService1 = new PasswordServiceEncryption(decryptable);
        passwordService1.decodePasswordFromHash("Nirupamvas");

        //Save password
        PasswordSaver passwordSaver = new PasswordSaver();
        passwordSaver.savePassword();


        Base64 base64 = new Base64();
        base64.generateHash("abc");
        System.out.println(base64.hash);

        Hashed hashed = new Base64();
        hashed.generateHash("pqrst");
        System.out.println(hashed.hash);
    }
}