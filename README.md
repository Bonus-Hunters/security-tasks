# Security Tasks - Encryption & Decryption Algorithms

A comprehensive Java implementation of classical and modern encryption/decryption algorithms developed for the Computer and Network Security course at the Faculty of Computer and Information Sciences, Ain Shams University.

## 🔐 Implemented Algorithms

This repository includes implementations of the following cryptographic algorithms:

### Classical Ciphers
1. **Caesar Cipher** - A simple substitution cipher that shifts letters by a fixed number of positions
2. **Monoalphabetic Cipher** - A substitution cipher with a fixed substitution for each letter
3. **Playfair Cipher** - A digraph substitution cipher using a 5×5 key square
4. **Hill Cipher** - A polyalphabetic cipher using matrix multiplication
5. **Railfence Cipher** - A transposition cipher that arranges plaintext in a rail-like pattern
6. **Columnar Cipher** - A transposition cipher that rearranges plaintext based on column permutations

### Advanced Ciphers
7. **AutoKey Cipher** - An extension of the Vigenère cipher that uses the plaintext as part of the key
8. **Repeating Key Cipher** - A polyalphabetic cipher using a repeating key (Vigenère)

### Modern Encryption Algorithms
9. **AES (Advanced Encryption Standard)** - A symmetric block cipher using 128, 192, or 256-bit keys
10. **DES (Data Encryption Standard)** - A symmetric block cipher using 56-bit keys
11. **ElGamal** - A public-key cryptosystem based on the discrete logarithm problem
12. **Diffie-Hellman Key Exchange** - A method for securely establishing shared keys over an insecure channel

## 📁 Project Structure

```
security-tasks/
├── pom.xml                          # Maven configuration file
├── README.md                        # This file
└── src/
    ├── main/java/
    │   ├── org/example/
    │   │   └── Main.java           # Main entry point
    │   └── Security/               # All algorithm implementations
    │       ├── AES.java
    │       ├── AutoKey.java
    │       ├── CaeserCipher.java
    │       ├── ColumnarCipher.java
    │       ├── DES.java
    │       ├── DiffieHellman.java
    │       ├── ElGamal.java
    │       ├── HillCipher.java
    │       ├── MonoalphabeticCipher.java
    │       ├── PlayfairCipher.java
    │       ├── Railfence.java
    │       └── RepeatingKey.java
    └── test/java/                   # Unit tests for each algorithm
        ├── AESTest.java
        ├── AutoKeyTest.java
        ├── CaeserCipherTest.java
        ├── ColumnarCipherTest.java
        ├── DESTest.java
        ├── DiffieHellmanTest.java
        ├── ElgamalTest.java
        ├── HillCipherTest.java
        ├── MonoalphabeticCipherTest.java
        ├── PlayfairCipherTest.java
        ├── RailfenceTest.java
        └── RepeatingKeyTest.java
```

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 17 or higher
- Maven 3.6.0 or higher
- Git (optional, for cloning the repository)

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/Bonus-Hunters/security-tasks.git
   cd security-tasks
   ```

2. **Build the project**:
   ```bash
   mvn clean compile
   ```

## 🏗️ Building and Running

### Compile the project:
```bash
mvn clean compile
```

### Run tests:
```bash
mvn test
```

### Run a specific test class:
```bash
mvn test -Dtest=CaeserCipherTest
```

### Generate project documentation:
```bash
mvn javadoc:javadoc
```

## 💻 Usage Examples

Each algorithm class provides `encrypt()` and `decrypt()` methods with specific parameters:

### Caesar Cipher
```java
CaeserCipher cipher = new CaeserCipher();
String encrypted = cipher.encrypt("HELLO", 3);
String decrypted = cipher.decrypt(encrypted, 3);
```

### Playfair Cipher
```java
PlayfairCipher cipher = new PlayfairCipher();
String encrypted = cipher.encrypt("HELLO", "SECRET");
String decrypted = cipher.decrypt(encrypted, "SECRET");
```

### AES Encryption
```java
AES aes = new AES();
String encrypted = aes.encrypt("Hello, World!", "MySecretKey123456");
String decrypted = aes.decrypt(encrypted, "MySecretKey123456");
```

### DES Encryption
```java
DES des = new DES();
String encrypted = des.encrypt("Hello!!!!", "MySecret");
String decrypted = des.decrypt(encrypted, "MySecret");
```

### Diffie-Hellman Key Exchange
```java
DiffieHellman dh = new DiffieHellman();
// Alice and Bob establish a shared secret key
long aliceShared = dh.calculateSharedSecret(alicePrivate, bobPublic, p);
long bobShared = dh.calculateSharedSecret(bobPrivate, alicePublic, p);
```

### ElGamal Encryption
```java
ElGamal elGamal = new ElGamal();
long[] encrypted = elGamal.encrypt(message, p, g, publicKey);
long decrypted = elGamal.decrypt(encrypted, p, privateKey);
```

Some algorithms provide an Analyze method to find the secret key used for encryption.

## 🧪 Testing

The project includes comprehensive unit tests for all implemented algorithms using JUnit 5. To run all tests:

```bash
mvn test
```

Tests are located in `src/test/java/` and cover:
- Encryption and decryption correctness
- Edge cases and special inputs
- Algorithm-specific requirements

## 📝 Notes

- Classical ciphers (Caesar, Playfair, Hill, etc.) typically work with uppercase alphabetic characters
- Modern encryption algorithms (AES, DES) support various character sets and typically use Base64 encoding for output
- Some algorithms may have specific key requirements (length, format, etc.) - refer to individual class documentation
- All implementations are for educational purposes and should not be used for production security

## 📄 License

This project is provided for educational purposes as part of the Computer and Network Security course at Ain Shams University.

