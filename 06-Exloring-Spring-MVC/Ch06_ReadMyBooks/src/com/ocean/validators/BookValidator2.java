package com.ocean.validators;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ocean.dao.model.Book;

@Component
@Primary
public class BookValidator2 implements Validator {

	@Override
	public boolean supports(Class<?> bookClass) {
		return bookClass.equals(Book.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Book book = (Book) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookName", "bookName.required");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "authorName.required");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "description.required");
		
		if(book.getDescription().length() < 10 || book.getDescription().length() > 40) {
			errors.rejectValue("description", "description.length");
		}
		
		if(book.getISBN() <= 150L) {
			errors.rejectValue("ISBN", "ISBN.required");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "price.incorrect");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publication", "publication.required");
	}

}
