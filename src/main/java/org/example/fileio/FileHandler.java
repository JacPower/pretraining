package org.example.fileio;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {

    private static final String FILE_PATH = "demo-file.txt";
    private static final String BINARY_FILE = "demo-binary.dat";



    public static void demonstrateFileOperations() {
        demonstrateFileWriting();
        demonstrateFileReading();
        demonstrateBufferedIO();
        demonstrateBinaryIO();
        demonstrateFileOperationsNIO();
    }



    private static void demonstrateFileWriting() {
        System.out.println("\n>>> File Writing (FileWriter):");
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write("Hello, Java File I/O!\n");
            writer.write("This is a demonstration of file handling.\n");
            writer.write("Working with files is essential in Java.\n");
            System.out.println("✓ File written successfully: " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }



    private static void demonstrateFileReading() {
        System.out.println("\n>>> File Reading (FileReader):");
        try (FileReader reader = new FileReader(FILE_PATH)) {
            int character;
            System.out.print("Content: ");
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }



    private static void demonstrateBufferedIO() {
        System.out.println("\n>>> Buffered I/O (BufferedWriter/Reader):");

        // Writing with BufferedWriter
        try (BufferedWriter buffWriter = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            buffWriter.newLine();
            buffWriter.write("Added using BufferedWriter for better performance!");
            System.out.println("✓ Buffered writing completed");
        } catch (IOException e) {
            System.err.println("Error in buffered writing: " + e.getMessage());
        }

        // Reading with BufferedReader
        try (BufferedReader buffReader = new BufferedReader(new FileReader(FILE_PATH))) {
            System.out.println("\nReading line by line:");
            String line;
            int lineNumber = 1;
            while ((line = buffReader.readLine()) != null) {
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }
        } catch (IOException e) {
            System.err.println("Error in buffered reading: " + e.getMessage());
        }
    }



    private static void demonstrateBinaryIO() {
        System.out.println("\n>>> Binary File I/O (DataOutputStream/DataInputStream):");

        // Writing binary data
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(BINARY_FILE))) {
            dos.writeInt(100);
            dos.writeDouble(3.14159);
            dos.writeBoolean(true);
            dos.writeUTF("Binary Data");
            System.out.println("✓ Binary data written");
        } catch (IOException e) {
            System.err.println("Error writing binary: " + e.getMessage());
        }

        // Reading binary data
        try (DataInputStream dis = new DataInputStream(new FileInputStream(BINARY_FILE))) {
            int intValue = dis.readInt();
            double doubleValue = dis.readDouble();
            boolean boolValue = dis.readBoolean();
            String stringValue = dis.readUTF();

            System.out.println("Read from binary file:");
            System.out.println("  Int: " + intValue);
            System.out.println("  Double: " + doubleValue);
            System.out.println("  Boolean: " + boolValue);
            System.out.println("  String: " + stringValue);
        } catch (IOException e) {
            System.err.println("Error reading binary: " + e.getMessage());
        }
    }



    private static void demonstrateFileOperationsNIO() {
        System.out.println("\n>>> NIO (New I/O) Operations:");

        try {
            // Create a file using NIO
            Path nioPath = Paths.get("nio-demo.txt");
            String content = "This is NIO (New I/O) API demonstration\nFaster and more efficient!";
            Files.write(nioPath, content.getBytes());
            System.out.println("✓ File created using NIO");

            // Read using NIO
            String readContent = new String(Files.readAllBytes(nioPath));
            System.out.println("Content read using NIO:\n" + readContent);

            // File info
            System.out.println("\nFile Info:");
            System.out.println("  Exists: " + Files.exists(nioPath));
            System.out.println("  Size: " + Files.size(nioPath) + " bytes");
            System.out.println("  Readable: " + Files.isReadable(nioPath));
            System.out.println("  Writable: " + Files.isWritable(nioPath));

            // Cleanup
            Files.deleteIfExists(nioPath);
            Files.deleteIfExists(Paths.get(FILE_PATH));
            Files.deleteIfExists(Paths.get(BINARY_FILE));
            System.out.println("\n✓ Cleanup completed");

        } catch (IOException e) {
            System.err.println("NIO Error: " + e.getMessage());
        }
    }
}

