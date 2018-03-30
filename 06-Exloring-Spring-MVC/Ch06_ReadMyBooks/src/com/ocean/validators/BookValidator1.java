package com.ocean.validators;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ocean.dao.model.Book;

@Component
//@Primary
public class BookValidator1 implements Validator {

	@Override
	public boolean supports(Class<?> bookClass) {
		return bookClass.equals(Book.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Book book = (Book) obj;
		if (book.getBookName().length() < 5) {
			errors.rejectValue("bookName", "bookName.required");
		}

		if (book.getAuthor().length() <= 0) {
			errors.rejectValue("author", "authorName.required");
		}

		if (book.getDescription().length() <= 0) {
			errors.rejectValue("description", "description.required");
		}

		if (book.getDescription().length() < 0 || book.getDescription().length() > 40) {
			errors.rejectValue("description", "description.length");
		}

		if (book.getISBN() <= 150l) {
			errors.rejectValue("ISBN", "ISBN.required");
		}

		if (book.getPrice() <= 0) {
			errors.rejectValue("price", "price.incorrect");
		}

		if (book.getPublication().length() <= 0) {
			errors.rejectValue("publication", "publication.required");
		}
	}

}
