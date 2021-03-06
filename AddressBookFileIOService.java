package com.bridgelabz.addressbook;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class AddressBookFileIOService {
	private static final String ADDRESS_BOOK_FILE_NAME = "F:/ContactPerson-File.txt";

	/**
	 * @param contactPerson
	 */
	public void writeContactPerson(ContactPerson contactPerson) {
		StringBuffer contactPersonBuffer = new StringBuffer();
		try {
			String contactPersonData = contactPerson.toString().concat("\n");
			contactPersonBuffer.append(contactPersonData);
			Files.write(Paths.get(ADDRESS_BOOK_FILE_NAME), contactPersonBuffer.toString().getBytes());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void readDataFromFile() {
		ContactPerson contactPerson = new ContactPerson();
		try {
			Files.lines(new File(ADDRESS_BOOK_FILE_NAME).toPath()).map(line -> line.trim())
					.forEach(line -> System.out.println(line));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
