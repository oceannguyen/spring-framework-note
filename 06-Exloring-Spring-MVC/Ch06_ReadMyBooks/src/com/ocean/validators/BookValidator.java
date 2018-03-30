package com.ocean.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ocean.dao.model.Book;

@Component
public class BookValidator implements Validator {

	@Override
	public boolean supports(Class<?> bookClass) {
		return bookClass.equals(Book.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Book book = (Book) obj;
		if (book.getBookName().length() < 5) {
			errors.rejectValue("bookName", "bookName.required", "Please Enter the book Name");
		}

		if (book.getAuthor().length() <= 0) {
			errors.rejectValue("author", "authorName.required", "Please Enter Author's Name");
		}

		if (book.getDescription().length() <= 0) {
			errors.rejectValue("description", "description.required", "Please enter book description");
		} else if (book.getDescription().length() < 0 || book.getDescription().length() > 40) {
			errors.rejectValue("description", "description.length",
					"Please enter description of minimum 10 and maximum 40 characters");
		}

		if (book.getISBN() <= 150l) {
			errors.rejectValue("ISBN", "ISBN.required", "Please Enter Correct ISBN number");
		}

		if (book.getPrice() <= 0) {
			errors.rejectValue("price", "price.incorrect", "Please enter a Correct correct price");
		}

		if (book.getPublication().length() <= 0) {
			errors.rejectValue("publication", "publication.required", "Please enter publication ");

		}

	}

}
