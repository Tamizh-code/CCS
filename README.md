# Cryptography and Network Security Lab - Java Programs

This package contains separate runnable programs based on the 10 experiments in the uploaded CCS record.

## Requirements
- JDK 8 or later (JDK 17 recommended)
- Windows, Linux, or macOS terminal

Check Java:
```bash
java -version
javac -version
```

## Run an experiment
1. Open a terminal in the required experiment folder.
2. Compile the source file:
   `javac FileName.java`
3. Run the class:
   `java ClassName`

Each experiment is independent. No external libraries are required.

## Experiment list
| Folder | Experiment | File / run class |
|---|---|---|
| 01a-caesar-cipher | Caesar cipher | CaesarCipher.java / CaesarCipher |
| 01b-playfair-cipher | Playfair cipher | PlayfairCipher.java / PlayfairCipher |
| 01c-hill-cipher | Hill cipher | HillCipher.java / HillCipher |
| 02a-rail-fence | Rail Fence cipher | RailFenceCipher.java / RailFenceCipher |
| 02b-row-column | Row and Column Transformation | RowColumnTransposition.java / RowColumnTransposition |
| 03-des | DES algorithm | DESExample.java / DESExample |
| 04-aes | AES algorithm | AESExample.java / AESExample |
| 05-rsa | RSA algorithm | RSAExample.java / RSAExample |
| 06-diffie-hellman | Diffie-Hellman key exchange | DiffieHellman.java / DiffieHellman |
| 07-sha1 | SHA-1 digest | SHA1Digest.java / SHA1Digest |
| 08-md5 | MD5 digest | MD5Digest.java / MD5Digest |
| 09-digital-signature | Digital signature (DSA) | DigitalSignature.java / DigitalSignature |
| 10-intrusion-detection | IDS demonstration | SimpleIDS.java / SimpleIDS |

## Run all experiments (Windows PowerShell)
From the package root:
```powershell
Get-ChildItem -Recurse -Filter *.java | ForEach-Object {
    $dir = $_.DirectoryName
    $name = $_.BaseName
    Push-Location $dir
    javac "$($_.Name)"
    if ($LASTEXITCODE -eq 0) { java $name }
    Pop-Location
}
```
Some programs ask for input. Enter the requested value when prompted.

## Notes about the record
- Experiment 5 in the record is written in HTML and JavaScript. This package provides the same RSA demonstration as a standalone Java console program.
- Experiment 10 in the record demonstrates Snort. A Java IDS teaching demo is included so it can run as a Java program. The `SNORT_GUIDE.md` file also explains the Snort demonstration described in the record.
- The cipher implementations are educational demonstrations. Caesar, Playfair, Hill, Rail Fence, row/column transposition, and DES are not suitable for protecting real information.
- SHA-1 and MD5 are obsolete for security-sensitive hashing. Use SHA-256 or stronger for real applications.
- The AES program uses AES/GCM with a randomly generated nonce. This is safer than the AES/ECB mode shown in the record, while still demonstrating AES encryption and decryption.
- The RSA program uses Java's RSA implementation with OAEP padding. This is safer than textbook RSA.

## Folder layout
Every experiment folder contains its own `.java` file and a short `README.md` with exact compile and run commands.
